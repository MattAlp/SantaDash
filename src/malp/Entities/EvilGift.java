package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class EvilGift extends Entity{

	public EvilGift(int x, int y) {
		super(ResourceManager.getEvilGift(), x, y, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		ResourceManager.getEvilGift().getImage(0).rotate(5);
		this.x -= 8;
		
	}

	@Override
	public void collisionEvent() {
		GameEngine.getEngine().add(new Explosion(this.x, this.y));
		GameEngine.getEngine().killSanta();
		this.x = GameEngine.CLEANUP_X;
	}

}
