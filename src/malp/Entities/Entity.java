package malp.Entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public abstract class Entity {
	private Animation animation;
	private boolean centered;
	protected int x;
	protected int y;
	
	public Entity(Animation animation, int x, int y, boolean centered)
	{
		this.animation = animation;
		this.x = x;
		this.y = y;
		this.centered = centered;
	}
	
	public Rectangle getBoundingBox()
	{
		if (!centered)
		{
			return new Rectangle(x, y, animation.getCurrentFrame().getWidth(), animation.getCurrentFrame().getHeight());
		}
		else
		{
			return new Rectangle(x - animation.getCurrentFrame().getWidth() / 2, y - animation.getCurrentFrame().getHeight() / 2, animation.getCurrentFrame().getWidth(), animation.getCurrentFrame().getHeight());
		}
	}
	
	abstract public void update();
	
	abstract public void collisionEvent();
	
	public boolean isCollided(Entity other)
	{
		//todo optimize!!!
		Rectangle thisRectangle = new Rectangle(x, y, animation.getCurrentFrame().getWidth(), animation.getCurrentFrame().getHeight());
		Rectangle otherRectangle = new Rectangle(other.x, other.y, other.animation.getCurrentFrame().getWidth(), other.animation.getCurrentFrame().getHeight());
		
		return thisRectangle.intersects(otherRectangle);
	}
	
	public void draw(Graphics g)
	{
		if (!centered)
		{
			animation.draw(x, y);
		}
		else
		{
			animation.draw(x - animation.getCurrentFrame().getWidth() / 2, y - animation.getCurrentFrame().getHeight() / 2);
		}

	}
	
	public int getX() {
		return x;
	}
	
	public int[] getCenter()
	{
		int[] centerCoords = {x + animation.getCurrentFrame().getWidth()/2, y + animation.getCurrentFrame().getHeight()/2};
		return centerCoords;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
