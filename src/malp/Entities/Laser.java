package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Laser extends Entity{
	
	public Laser(int x, int y)
	{
		super(ResourceManager.getLaser(), x, y, false);
	}
	
	@Override
	public void update()
	{
		this.x -= 4;
	}

	@Override
	public void collisionEvent() {
		ResourceManager.getLaserSound().play();
		GameEngine.getEngine().killSanta();
	}
}
