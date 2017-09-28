package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class MissileWarning extends Entity{
	
	private int ticks = 0;
	
	public MissileWarning(int x, int y) {
		super(ResourceManager.getWarningFlash(), x, y, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		ticks++;
		if ((ticks - 20) % 20 == 0)
		{
			ResourceManager.getWarningSound().play();
		}
		if (ticks >= 100)
		{
			GameEngine.getEngine().add(new Missile(this.x, this.y));
			this.x = GameEngine.CLEANUP_X;
		}
		
	}

	@Override
	public void collisionEvent() {
		// TODO Auto-generated method stub
		
	}

}
