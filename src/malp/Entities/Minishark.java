package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Minishark extends Entity {

	public Minishark(int x, int y) {
		super(ResourceManager.getMinishark(), x, y, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		this.x -= 10;
		if (GameEngine.getEngine().getSantaCoords()[1] > this.y)
		{
			this.y += 2;
		}
		else if (GameEngine.getEngine().getSantaCoords()[1] < this.y)
		{
			this.y -= 2;
		}
		
	}

	@Override
	public void collisionEvent() {
		GameEngine.getEngine().add(new Explosion(this.x - 20, this.y - 10));
		ResourceManager.getExplosionSound().play();
		this.x = GameEngine.CLEANUP_X;
		GameEngine.getEngine().killSanta();
		
	}

}
