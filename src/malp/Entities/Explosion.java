package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Explosion extends Entity{
	public Explosion(int x, int y) {
		super(ResourceManager.getExplosion(), x, y, true);
		ResourceManager.getExplosionSound().play();
	}	

	@Override
	public void update() 
	{
		if(ResourceManager.getExplosion().getFrame() == ResourceManager.getExplosion().getFrameCount() - 1)
		{
			this.x = GameEngine.CLEANUP_X;
		}
	}

	@Override
	public void collisionEvent() {
		
	}

}
