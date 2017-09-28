package malp.SantaDash;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import malp.Entities.Entity;
import malp.Entities.EntitySpawner;
import malp.Entities.Santa;

public class GameEngine {
	private static final GameEngine INSTANCE = new GameEngine();
	private Santa santa;
	private EntitySpawner entitySpawner;
	private int score = 0;
	private double speed = 1;
	private int foregroundX = 0;
	private int backgroundX = 0;
	private int highScore = 0;
	private int cointCount;
	private final int MAX_SPEED = 3;
	private boolean alive = true;
	public static final int CLEANUP_X = -50;
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Entity> deferredEntities = new ArrayList<Entity>();
	private ArrayList<Entity> garbage = new ArrayList<Entity>();
	
	private GameEngine()
	{
		santa = new Santa();
		highScore = 0;
		entitySpawner = new EntitySpawner();
	}
	
	public static GameEngine getEngine() {
        return INSTANCE;
    }
	
	public int getCoins()
	{
		return cointCount;
	}
	
	public double getSpeed()
	{
		return speed;
	}
	
	public void updateCoins(int netDifference)
	{
		cointCount += netDifference * santa.getCoinMultiplier();
	}
	
	public int getHighScore()
	{
		if (score > highScore)
		{
			highScore = score;
		}
		return highScore;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void resetEngine()
	{
		System.out.println("RESET");
		if (score == highScore)
		{
			LeaderboardHandler.registerScore(highScore);
		}
		alive = true;
		score = 0;
		speed = 1;
		santa.reset();
		entities.clear();
		deferredEntities.clear();
		garbage.clear();
	}
	
	//MA!!! getSantaX getSantaY to avoid creation of redundant Point object
	public int[] getSantaCoords()
	{
		return new int[] {santa.getX(), santa.getY()};
	}
	
	public void update(GameContainer gc, int delta)
	{
		System.out.println("Game Speed:" + speed);
		speed += (double) delta / 100000;
		if (speed >= MAX_SPEED)
		{
			speed = MAX_SPEED;
		}
		score += santa.getScoreMultiplier();
		foregroundX = (foregroundX - 4) % ResourceManager.getForefrontMountains().getWidth();
		backgroundX = (backgroundX - 1) % ResourceManager.getBackgroundMountains().getWidth();
		santa.update();
		for (Entity e: entities)
		{
			e.update();
			if (santa.isCollided(e))
			{
				e.collisionEvent();
			}
		}
		entitySpawner.update(gc, delta / 3);
		System.out.println("Updated entitity spawner with delta of " + delta / 3);
		entities.addAll(deferredEntities);
		deferredEntities.clear();
		
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public void killSanta()
	{
		alive = false;
	}
	public void cleanUp()
	{
		for (Entity e: entities)
		{
			if (e.getX() <= CLEANUP_X)
			{
				garbage.add(e);
			}
		}
		for (Entity e: garbage)
		{
			entities.remove(e);
		}
	}
	
	public void render(GameContainer gc, Graphics g)
	{
		if (santa.getCoinMultiplier() == 2)
		{
			g.drawString("Double Coins!", 0, gc.getHeight() / 5);
		}
		if (santa.getScoreMultiplier() == 2)
		{
			g.drawString("\nDouble Score!", 0, gc.getHeight() / 5);
		}
		drawMountains(gc);
		santa.draw(g);
		for (Entity e: entities)
		{
			e.draw(g);
		}
	}
	
	public void drawMountains(GameContainer gc)
	{
		for (int i = 0; i <= gc.getWidth() / (ResourceManager.getBackgroundMountains().getWidth() + backgroundX); i++)
		{
			ResourceManager.getBackgroundMountains().draw(backgroundX + ResourceManager.getBackgroundMountains().getWidth() * i, gc.getHeight() - ResourceManager.getBackgroundMountains().getHeight());
		}
		for (int i = 0; i <= gc.getWidth() / (ResourceManager.getForefrontMountains().getWidth() + foregroundX); i++)
		{
			ResourceManager.getForefrontMountains().draw(foregroundX + ResourceManager.getForefrontMountains().getWidth() * i, gc.getHeight() - ResourceManager.getForefrontMountains().getHeight());
		}
	}
	
	public void setSantaHeight(int y)
	{
		santa.setY(y);
	}
	
	public void powerUp()
	{
		santa.powerUp();
	}
	
	public void add(Entity entity)
	{
		deferredEntities.add(entity);
	}
	
	public int entityCount()
	{
		return entities.size();
	}
}
