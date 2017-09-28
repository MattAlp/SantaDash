package malp.Entities;

import java.util.Random;

import malp.SantaDash.ResourceManager;

public class Santa extends Entity{
	
	private int doubleScore = 0;
	private int doubleCoins = 0;
	public Santa()
	{
		super(ResourceManager.getSanta(), 160, 0, false);
	}

	@Override
	public void update() {
		doubleScore--;
		doubleCoins--;
		if (doubleScore < 0)
		{
			doubleScore = 0;
		}
		if (doubleCoins < 0)
		{
			doubleCoins = 0;
		}
		
	}
	
	public void reset()
	{
		doubleCoins = 0;
		doubleScore = 0;
	}
	
	public int getScoreMultiplier()
	{
		if (doubleScore > 0)
		{
			return 2;
		}
		else
		{
			return 1;
		}
	}
	
	public int getCoinMultiplier()
	{
		if (doubleCoins > 0)
		{
			return 2;
		}
		else
		{
			return 1;
		}
	}
	
	public void powerUp()
	{
		Random rnd = new Random();
		if (rnd.nextBoolean())
		{
			doubleScore += 1000;
		}
		else
		{
			doubleCoins += 1000;
		}
	}
	
	@Override
	public void collisionEvent() {
		//Santa will never collide with himself.
		
	}
}
