package ca.probisk.scg;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import ca.probisk.scg.arenas.Arena;
import ca.probisk.scg.arenas.ArenaListeners;
import ca.probisk.scg.arenas.ArenaManager;
import ca.probisk.scg.listeners.SCGListeners;
import ca.probisk.scg.states.State;
import ca.probisk.scg.tasks.SwitchSwap;

public class Main extends JavaPlugin {
	
	private ArenaManager arenaManager = new ArenaManager();
	private File arenaFile;
	private YamlConfiguration arenaConfig;
	private State state;
	private SCGListeners listeners;
	
	@Override
	public void onEnable() {
		
		setState(State.WAINTING);
		
		getCommand("createarena").setExecutor(this);
		getCommand("accept").setExecutor(this);
		getServer().getPluginManager().registerEvents(new ArenaListeners(this), this);
		getServer().getPluginManager().registerEvents(new SCGListeners(this), this);
		
		// creation du fichier arenas.yml
		
		if(!getDataFolder().exists())
		{
			getDataFolder().mkdir();
		}
		
		arenaFile = new File(getDataFolder() + File.separator + "arenas.yml");
		
		if(!arenaFile.exists())
		{
			try {
				arenaFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);
		
		//charger les arenes du fichier arenas.yml
		
		ConfigurationSection arenaSection = arenaConfig.getConfigurationSection("arenas.switch");
		
		for(String string : arenaSection.getKeys(false)) {
			
			String loc1 = arenaSection.getString(string + ".loc1");
			String loc2 = arenaSection.getString(string + ".loc2");
			Arena arena = new Arena(parseStringToLoc(loc1), parseStringToLoc(loc2));
			arenaManager.addArena(arena);
			
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
		
		//  /duel <player> |duel un autre joueur
		//  /duel <accept/deny> |accepter ou refuser une demande de duel
		
		Player player = (Player) sender;
		
		// -> /duel |info
		if(args.length == 0 && command.getName().equalsIgnoreCase("/createarena")) {
			
			player.sendMessage("Info: /createarena <Game> <loc1> <loc2>");
			player.sendMessage("Ex: /createarena Switch 10,4,5 <- [loc1] 20,4,8 <- [loc2]");
			
			return true;
		}
		
		if(label.equalsIgnoreCase("createarena") && sender instanceof Player && this.isState(State.WAINTING)) {
			
			//créer une arene switch 
			if(args[0].equalsIgnoreCase("switch")) {
				
				Location loc1 = parseStringToLoc(args[1]);
				Location loc2 = parseStringToLoc(args[2]);
				Arena arena = new Arena(loc1, loc2);
				String arenaName = "arena-" + new Random().nextInt(9999);
				
				//sauvgarder cette arene
				arenaConfig.set("arenas.switch."+arenaName+".loc1", args[1]);
				arenaConfig.set("arenas.switch."+arenaName+".loc2", args[2]);
				try {
					arenaConfig.save(arenaFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				arenaManager.addArena(arena);
				
				player.sendMessage("Vous venez de créé l'arène "+arenaName+" !");
				
			}
			
				return true;
				
			}
		
		else if(label.equalsIgnoreCase("accept") && sender instanceof Player && this.isState(State.WAINTING)) {
			
			if(listeners.getPlayers().containsKey(player)) {
				
				player.sendMessage("Ok, le duel se lance !");
				
				Player firstPlayerTarget = listeners.getPlayers().get(player);
				firstPlayerTarget.sendMessage("Ok, le duel se lance !");
				
				//teleport
				this.setState(State.PLAYING);
				arenaManager.joinArena(player, firstPlayerTarget);
				SwitchSwap Swap = new SwitchSwap(this, player, firstPlayerTarget);
				Swap.runTaskTimer(this, 0, 20);
				
				listeners.getPlayers().remove(player);
				
			}
			else
			{
				player.sendMessage("Vous n'avez aucune demande de duel");
			}
			
		}
		
		return false;
			
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public boolean isState(State state) {
		return this.state == state;
	}
	

	public ArenaManager getArenaManager() {
		return arenaManager;
	}

	public void setArenaManager(ArenaManager arenaManager) {
		this.arenaManager = arenaManager;
	}
	
	public Location parseStringToLoc(String string) {
		
		//entrée 277, 70, 80
		//sotrie Location x: 277 y: 70 z: 80
		String[] parsedLoc = string.split(",");
		double x = Double.valueOf(parsedLoc[0]);
		double y = Double.valueOf(parsedLoc[1]);
		double z = Double.valueOf(parsedLoc[2]);
		
		return new Location(Bukkit.getWorld("world"), x,y,z);
		
	}
	
	public String unparseLocToString(Location loc) {
		
		return loc.getX() + "," + loc.getY() + "," + loc.getZ();
		
	}
	
}
