package ca.probisk.scg.tasks;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import ca.probisk.scg.Main;

import org.bukkit.entity.Player;

public class SwitchRespawn extends BukkitRunnable {
	
	private Player victim;
	private int timer = 0;
	private Location spawn = new Location(Bukkit.getWorld("world"), 117.502, 137, 18.576, 179f, 3.1f);

	public SwitchRespawn(Main main, Player victim) {
		this.victim = victim;
	}

	@Override
	public void run() {
		
		if(timer == 0)
		{
			victim.spigot().respawn();
			victim.setHealth(20);
			victim.setSaturation(20);
			victim.setFoodLevel(20);
			victim.teleport(spawn);
			victim.setGameMode(GameMode.ADVENTURE);
			
		}
		
		timer--;
		
	}

}
