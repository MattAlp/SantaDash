package malp.Entities;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class Tree extends Entity{

	public Tree(int x, int y) {
		super(ResourceManager.getTree(), x, y, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		this.x -= 4;
		
	}

	@Override
	public void collisionEvent() {
		// TODO Auto-generated method stub
		ResourceManager.getHitSound().play();
		GameEngine.getEngine().killSanta();
	}

}
