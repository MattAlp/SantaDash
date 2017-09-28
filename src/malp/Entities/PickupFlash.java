package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class PickupFlash extends Entity{

	public PickupFlash(int x, int y) {
		super(ResourceManager.getPickupFlash(), x, y, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		this.x = GameEngine.CLEANUP_X;
	}

	@Override
	public void collisionEvent() {
		// TODO Auto-generated method stub
		
	}

}
