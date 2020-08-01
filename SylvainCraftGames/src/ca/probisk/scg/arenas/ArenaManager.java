package ca.probisk.scg.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ArenaManager {
	
	private List<Arena> arenas = new ArrayList<>();
	
	public void addArena(Arena arena) {
		
		this.arenas.add(arena);
		
	}
	
	public void joinArena(Player firstPlayer, Player secondPlayer) {
		
		Arena nextArena = getNexArena();
		
		if(nextArena != null) {
			
			nextArena.getPlayers().add(firstPlayer);
			nextArena.getPlayers().add(secondPlayer);
			firstPlayer.teleport(nextArena.getFirstLoc());
			secondPlayer.teleport(nextArena.getSecondLoc());
			firstPlayer.setGameMode(GameMode.SURVIVAL);
			secondPlayer.setGameMode(GameMode.SURVIVAL);
			firstPlayer.getInventory().clear();
			secondPlayer.getInventory().clear();
			nextArena.setStarted();
		}
		else
		{
			
			firstPlayer.sendMessage("Il n'y a aucune arene disponible pour faire un duel");
			secondPlayer.sendMessage("Il n'y a aucune arene disponible pour faire un duel");
			
		}
		
	}
	
	public Arena getArenaByPlayer(Player player) {
		
		for(Arena arena : arenas)
		{
			if(arena.getPlayers().contains(player))
			{
				return arena;
			}
		}
		
		return null;
	}

	private Arena getNexArena() {
		
		for(Arena arena : arenas) {
			
			if(!arena.isStarted()) {
				
				return arena;
			}
			
		}
		
		return null;
	}
	
	public List<Arena> getArenas() {
		return arenas;
		
	}

}
