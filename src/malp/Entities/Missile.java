package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Missile extends Entity{

	public Missile(int x, int y) {
		super(ResourceManager.getMissile(), x, y, false);
	}

	@Override
	public void update() {
		this.x -= 10;
	}

	@Override
	public void collisionEvent() {
		GameEngine.getEngine().add(new Explosion(this.x, this.y));
		ResourceManager.getExplosionSound().play();
		this.x = GameEngine.CLEANUP_X;
		GameEngine.getEngine().killSanta();
	}

}
