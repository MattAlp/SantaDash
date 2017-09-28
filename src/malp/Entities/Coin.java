package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Coin extends Entity{

	public Coin(int x, int y) {
		super(ResourceManager.getCoin(), x, y, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		this.x -= 4;
		
	}

	@Override
	public void collisionEvent() {
		ResourceManager.getCoinSound().play();
		GameEngine.getEngine().add(new PickupFlash(this.x, this.y));
		GameEngine.getEngine().updateCoins(1);
		this.x = GameEngine.CLEANUP_X;
	}

}
