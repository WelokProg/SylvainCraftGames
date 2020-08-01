package ca.probisk.scg.tasks;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import ca.probisk.scg.Main;
import ca.probisk.scg.states.State;

public class SwitchSwap extends BukkitRunnable {
	
	private Main main;
	private Player player;
	private Player firstPlayerTarget;
	private int timer = 15;
	
	public SwitchSwap(Main main, Player firstPlayer, Player secondPlayer) {
		this.main = main;
		this.player = firstPlayer;
		this.firstPlayerTarget = secondPlayer;
	}

	@Override
	public void run() {
		
		if(main.isState(State.END) || main.isState(State.WAINTING)) {
			timer = 0;
			main.setState(State.WAINTING);
			return;
		}
		
		else if(timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1)
		{
			player.sendMessage("Le switch s'effectura dans "+timer+"s");
			firstPlayerTarget.sendMessage("Le switch s'effectura dans "+timer+"s");
		}
		
		else if(timer == 0 && main.isState(State.PLAYING))
		{
			Location swap1 = player.getLocation();
			Location swap2 = firstPlayerTarget.getLocation();
			player.teleport(swap2);
			firstPlayerTarget.teleport(swap1);
			timer = 15;
		}
		
		timer--;
		
  }
}
