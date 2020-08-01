package ca.probisk.scg.arenas;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ca.probisk.scg.Main;
import ca.probisk.scg.states.State;
import ca.probisk.scg.tasks.SwitchRespawn;

public class ArenaListeners implements Listener {
	
	private Main main;
	
	public ArenaListeners(Main duel) {
		this.main = duel;
	}
	
	@EventHandler
	public void onKill(PlayerDeathEvent e)
	{
		
		if(e.getEntity() instanceof Player)
		{
			
			Player victim = (Player) e.getEntity();
			Arena arena = main.getArenaManager().getArenaByPlayer(victim);
			
			if(arena != null)
			{
					arena.eliminate(victim);
					main.setState(State.END);
					
						SwitchRespawn respawn = new SwitchRespawn(main, victim);
						respawn.runTaskTimer(main, 0, 20);
					}
				}
			}
			
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		
		Player leaver = e.getPlayer();
		Arena arena = main.getArenaManager().getArenaByPlayer(leaver);
		
		if(arena != null)
		{
			arena.eliminate(leaver);
		}
		
	}
	
}