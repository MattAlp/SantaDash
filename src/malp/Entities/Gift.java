package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Gift extends Entity{
	private int type;
	public Gift(int x, int y, int type) {
		super(ResourceManager.getGift(type), x, y, false);
		this.type = type;
	}

	@Override
	public void update() {
		ResourceManager.getGift(type).getImage(0).rotate(5);
		this.x -= 8;
		
	}

	@Override
	public void collisionEvent() {
		GameEngine.getEngine().add(new PickupFlash(this.x, this.y));
		ResourceManager.getCoinSound().play(); //the coin sound and pickup sound are identical
		GameEngine.getEngine().powerUp();
		this.x = GameEngine.CLEANUP_X;
	}

}
