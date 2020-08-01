package ca.probisk.scg.listeners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import ca.probisk.scg.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class SCGListeners implements Listener {
	
	private Main main;
	private Map<Player, Player> players = new HashMap<>();
	private Location button1 = new Location(Bukkit.getWorld("world"), 273, 67, 29);
	private Location sign = new Location(Bukkit.getWorld("world"), 267, 76, 29);
	private Location lobbyspawn = new Location(Bukkit.getWorld("world"), 274.999, 67, 32.500, 180.0f, 0.0f);
	
	public SCGListeners(Main main) {
		this.main = main;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		Action action = e.getAction();
		
		if(e.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK) {
			
			BlockState bs = e.getClickedBlock().getState();
		
			if(bs instanceof Sign && e.getClickedBlock().getLocation().equals(sign)) {
			
			player.teleport(lobbyspawn);
			
		}
		
		else if(e.getClickedBlock().getType().equals(Material.STONE_BUTTON) && e.getClickedBlock().getLocation().equals(button1)) {
			
			Inventory playerlist = Bukkit.createInventory(null, 27, "§8Player list");
			
			if(Bukkit.getServer().getOnlinePlayers().size() == 1) {
				
				player.sendMessage("Il n'y a aucun joueur disponible à duel pour l'instant !");
				return;
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 2) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 3) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 4) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);

				ItemStack player4 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player4M = (SkullMeta) player4.getItemMeta();
				player4M.setOwner(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4.setItemMeta(player4M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				playerlist.setItem(3, player4);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 5) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);

				ItemStack player4 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player4M = (SkullMeta) player4.getItemMeta();
				player4M.setOwner(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4.setItemMeta(player4M);

				ItemStack player5 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player5M = (SkullMeta) player5.getItemMeta();
				player5M.setOwner(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5.setItemMeta(player5M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				playerlist.setItem(3, player4);
				playerlist.setItem(4, player5);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 6) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);

				ItemStack player4 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player4M = (SkullMeta) player4.getItemMeta();
				player4M.setOwner(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4.setItemMeta(player4M);

				ItemStack player5 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player5M = (SkullMeta) player5.getItemMeta();
				player5M.setOwner(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5.setItemMeta(player5M);

				ItemStack player6 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player6M = (SkullMeta) player6.getItemMeta();
				player6M.setOwner(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6.setItemMeta(player6M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				playerlist.setItem(3, player4);
				playerlist.setItem(4, player5);
				playerlist.setItem(5, player6);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 7) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);

				ItemStack player4 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player4M = (SkullMeta) player4.getItemMeta();
				player4M.setOwner(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4.setItemMeta(player4M);

				ItemStack player5 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player5M = (SkullMeta) player5.getItemMeta();
				player5M.setOwner(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5.setItemMeta(player5M);

				ItemStack player6 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player6M = (SkullMeta) player6.getItemMeta();
				player6M.setOwner(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6.setItemMeta(player6M);

				ItemStack player7 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player7M = (SkullMeta) player7.getItemMeta();
				player7M.setOwner(Bukkit.getWorld("world").getPlayers().get(6).getName());
				player7M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(6).getName());
				player7.setItemMeta(player7M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				playerlist.setItem(3, player4);
				playerlist.setItem(4, player5);
				playerlist.setItem(5, player6);
				playerlist.setItem(6, player7);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 8) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);

				ItemStack player4 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player4M = (SkullMeta) player4.getItemMeta();
				player4M.setOwner(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4.setItemMeta(player4M);

				ItemStack player5 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player5M = (SkullMeta) player5.getItemMeta();
				player5M.setOwner(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5.setItemMeta(player5M);

				ItemStack player6 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player6M = (SkullMeta) player6.getItemMeta();
				player6M.setOwner(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6.setItemMeta(player6M);

				ItemStack player7 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player7M = (SkullMeta) player7.getItemMeta();
				player7M.setOwner(Bukkit.getWorld("world").getPlayers().get(6).getName());
				player7M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(6).getName());
				player7.setItemMeta(player7M);

				ItemStack player8 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player8M = (SkullMeta) player8.getItemMeta();
				player8M.setOwner(Bukkit.getWorld("world").getPlayers().get(7).getName());
				player8M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(7).getName());
				player8.setItemMeta(player8M);
				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				playerlist.setItem(3, player4);
				playerlist.setItem(4, player5);
				playerlist.setItem(5, player6);
				playerlist.setItem(6, player7);
				playerlist.setItem(7, player8);
				
			}
			else if(Bukkit.getServer().getOnlinePlayers().size() == 9) {
				
				ItemStack player1 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player1M = (SkullMeta) player1.getItemMeta();
				player1M.setOwner(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(0).getName());
				player1.setItemMeta(player1M);

				ItemStack player2 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player2M = (SkullMeta) player2.getItemMeta();
				player2M.setOwner(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(1).getName());
				player2.setItemMeta(player2M);

				ItemStack player3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player3M = (SkullMeta) player3.getItemMeta();
				player3M.setOwner(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(2).getName());
				player3.setItemMeta(player3M);

				ItemStack player4 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player4M = (SkullMeta) player4.getItemMeta();
				player4M.setOwner(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(3).getName());
				player4.setItemMeta(player4M);

				ItemStack player5 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player5M = (SkullMeta) player5.getItemMeta();
				player5M.setOwner(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(4).getName());
				player5.setItemMeta(player5M);

				ItemStack player6 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player6M = (SkullMeta) player6.getItemMeta();
				player6M.setOwner(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(5).getName());
				player6.setItemMeta(player6M);

				ItemStack player7 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player7M = (SkullMeta) player7.getItemMeta();
				player7M.setOwner(Bukkit.getWorld("world").getPlayers().get(6).getName());
				player7M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(6).getName());
				player7.setItemMeta(player7M);

				ItemStack player8 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player8M = (SkullMeta) player8.getItemMeta();
				player8M.setOwner(Bukkit.getWorld("world").getPlayers().get(7).getName());
				player8M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(7).getName());
				player8.setItemMeta(player8M);

				ItemStack player9 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (byte) 3);
				SkullMeta player9M = (SkullMeta) player9.getItemMeta();
				player9M.setOwner(Bukkit.getWorld("world").getPlayers().get(8).getName());
				player9M.setDisplayName(Bukkit.getWorld("world").getPlayers().get(8).getName());
				player9.setItemMeta(player9M);

				
				playerlist.setItem(0, player1);
				playerlist.setItem(1, player2);
				playerlist.setItem(2, player3);
				playerlist.setItem(3, player4);
				playerlist.setItem(4, player5);
				playerlist.setItem(5, player6);
				playerlist.setItem(6, player7);
				playerlist.setItem(7, player8);
				playerlist.setItem(8, player9);
				
			}
			
			player.openInventory(playerlist);
			
		}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		main.getName();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(player.getOpenInventory().getTitle().equalsIgnoreCase("§8Player list")) {
			
			if(current == null)
			{
				return;
			}
		
			else if(current.getAmount() == 1) {
				String targetName = current.getItemMeta().getDisplayName();
				
				if(Bukkit.getPlayer(targetName) != null) {
					
					Player target = Bukkit.getPlayer(targetName);
					
					if(players.containsKey(target))
					{
						player.sendMessage("Ce joueur est présentement occupé dans un duel");
						return;
					}
					else if(target.getName() == player.getName()) {
					
						player.sendMessage("Vous ne pouvez pas vous duel vous même !");
					
					}
					else
					{
						players.put(target, player);
				
						TextComponent msgaccept = new TextComponent("[Cliquez ici] pour accepter la demande !");
						msgaccept.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Accepter !").create()));
						msgaccept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/accept"));
				
						player.sendMessage("Vous venez de demander en duel "+targetName);
						target.sendMessage("Vous venez de recevoir une demande de duel de "+player.getName());
						target.spigot().sendMessage(msgaccept);
					}
					
				}
				
					event.setCancelled(true);
					player.closeInventory();
					player.getInventory().remove(Material.LEGACY_SKULL_ITEM);
					return;
				
			}
		}
	}
	
	public Map<Player, Player> getPlayers(){
		return players;
	}
	
}
