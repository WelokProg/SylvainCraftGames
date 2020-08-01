package ca.probisk.scg.arenas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena {
	
	private Location loc1;
	private Location loc2;
	private List<Player> players;
	private boolean isStarted;
	private Location spawn = new Location(Bukkit.getWorld("world"), 117.502, 137, 18.576, 179f, 3.1f);
	
	public Arena(Location loc1, Location loc2) {
		
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.players = new ArrayList<>();
		this.isStarted = false;
		
	}
	
	public Location getFirstLoc() {
		
		
		return loc1;
	}
	
	public Location getSecondLoc() {
		
		
		return loc2;
	}
	
	public List<Player> getPlayers() {
		
		
		return players;
	}
	
	public void setStarted() {
		this.isStarted = true;
	}
	
	public boolean isStarted() {
		
		
		return isStarted;
	}

	public void eliminate(Player victim) {
		
		players.remove(victim);
		checkWin();
		
		
		
	}
	
	public void checkWin() {
		
		if(players.size() == 1) {
			
			Player winner = players.get(0);
			Bukkit.broadcastMessage(winner.getName()+" gagne le jeu !");
			winner.teleport(spawn);
			winner.setHealth(20);
			winner.setSaturation(20);
			winner.setFoodLevel(20);
			winner.setGameMode(GameMode.ADVENTURE);
			restart();
			
		}
	}

	public void restart() {
		this.players = new ArrayList<>();
		this.isStarted = false;
	
	}
	
}
