package malp.Entities;

import java.util.Random;
import java.util.Scanner;

import org.newdawn.slick.GameContainer;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;

public class EntitySpawner {
	private int m_MissileTickCount = 0;
	private final int m_MinimumMissileTick = 1500;
	private final int m_MaximumMissileTick = 2500;
	
	private int m_CoinTickCount = 0;
	private final int m_MinimumCoinTick = 1000;
	private final int m_MaximumCoinTick = 1750;
	
	private int m_LaserTickCount = 0;
	private final int m_MinimumLaserTick = 1000;
	private final int m_MaximumLaserTick = 2000;
	
	private int m_MinisharkTickCount = 0;
	private final int m_MinimumMinisharkTick = 3500;
	private final int m_MaximumMinisharkTick = 4000;
	
	private int m_ObjectTickCount = 0;
	private final int m_MinimumObjectTick = 500;
	private final int m_MaximumObjectTick = 3000;
	
	private int m_GiftTickCount = 0;
	private final int m_MinimumGiftTick = 3000;
	private final int m_MaximumGiftTick = 5000;
	
	private Random m_Random;
	
	public EntitySpawner()
	{
		m_Random = new Random();
	}
	
	public void update(GameContainer gc, int delta)
	{
		m_MissileTickCount += delta;
		m_CoinTickCount += delta;
		m_LaserTickCount += delta;
		m_MinisharkTickCount += delta;
		m_ObjectTickCount += delta;
		m_GiftTickCount += delta;
		
		int checkMissileTick = m_Random.nextInt((m_MaximumMissileTick - m_MinimumMissileTick) + 1) + m_MinimumMissileTick;
		int checkCoinTick = m_Random.nextInt((m_MaximumCoinTick - m_MinimumCoinTick) + 1) + m_MinimumCoinTick;
		int checkLaserTick = m_Random.nextInt((m_MaximumLaserTick - m_MinimumLaserTick) + 1) + m_MinimumLaserTick;
		int checkMinisharkTick = m_Random.nextInt((m_MaximumMinisharkTick - m_MinimumMinisharkTick) + 1) + m_MinimumMinisharkTick;
		int checkObjectTick = m_Random.nextInt((m_MaximumObjectTick - m_MinimumObjectTick) + 1) + m_MinimumObjectTick;
		int checkGiftTick = m_Random.nextInt((m_MaximumGiftTick - m_MinimumGiftTick) + 1) + m_MinimumGiftTick;
		
		
		if (m_GiftTickCount > checkGiftTick)
		{
			m_GiftTickCount -= checkGiftTick;
			if (m_Random.nextInt(100) <= 80)
			{
				GameEngine.getEngine().add(new Gift(gc.getWidth(), m_Random.nextInt(gc.getHeight()), m_Random.nextInt(3) + 1));
			}
			else
			{
				GameEngine.getEngine().add(new EvilGift(gc.getWidth(), m_Random.nextInt(gc.getHeight())));
			}
		}
		
		if (m_ObjectTickCount > checkObjectTick)
		{
			m_ObjectTickCount -= checkObjectTick;
			if (m_Random.nextBoolean())
			{
				GameEngine.getEngine().add(new Chimney(gc.getWidth(), gc.getHeight() - ResourceManager.getChimney().getImage(0).getHeight()));
			}
			else
			{
				GameEngine.getEngine().add(new Tree(gc.getWidth(), gc.getHeight() - ResourceManager.getTree().getImage(0).getHeight()));
			}
			
		}
		if (m_MissileTickCount > checkMissileTick)
		{
			int missilePattern = m_Random.nextInt(100);
			if (missilePattern <= 75)
			{
				m_MissileTickCount -= checkMissileTick;
				GameEngine.getEngine().add(new MissileWarning(gc.getWidth() - ResourceManager.getWarningFlash().getImage(0).getWidth(), m_Random.nextInt(gc.getHeight() - ResourceManager.getWarningFlash().getImage(0).getHeight())));
			}
			else if (missilePattern <= 90)
			{
				m_MissileTickCount -= checkMissileTick;
				int missileDistance = m_Random.nextInt(gc.getHeight() - ResourceManager.getWarningFlash().getImage(0).getHeight());
				for (int i = 0; i < 300; i += 100)
				{
					GameEngine.getEngine().add(new MissileWarning(gc.getWidth() + i - ResourceManager.getWarningFlash().getImage(0).getWidth(), missileDistance));
				}
			}
			else if (missilePattern <= 100)
			{
				m_MissileTickCount -= checkMissileTick;
				int missileHeight = m_Random.nextInt(gc.getHeight() - ResourceManager.getWarningFlash().getImage(0).getHeight());
				for (int i = 0; i < 150; i += 50)
				{
					GameEngine.getEngine().add(new MissileWarning(gc.getWidth() - ResourceManager.getWarningFlash().getImage(0).getWidth(), missileHeight + i));
				}
			}
			
		}
		
		if (m_MinisharkTickCount > checkMinisharkTick)
		{
			int minisharkPattern = m_Random.nextInt(100);
			if (minisharkPattern <= 75)
			{
				m_MinisharkTickCount -= checkMinisharkTick;
				GameEngine.getEngine().add(new MinisharkWarning(gc.getWidth() - ResourceManager.getWarningFlash().getImage(0).getWidth(), m_Random.nextInt(gc.getHeight() - ResourceManager.getWarningFlash().getImage(0).getHeight())));
			}
			else if (minisharkPattern <= 90)
			{
				m_MinisharkTickCount -= checkMinisharkTick;
				int minisharkDistance = m_Random.nextInt(gc.getHeight() - ResourceManager.getWarningFlash().getImage(0).getHeight());
				for (int i = 0; i < 150; i += 50)
				{
					GameEngine.getEngine().add(new MinisharkWarning(gc.getWidth() + i - ResourceManager.getWarningFlash().getImage(0).getWidth(), minisharkDistance));
				}
			}
			else if (minisharkPattern <= 100)
			{
				m_MinisharkTickCount -= checkMinisharkTick;
				int minisharkHeight = m_Random.nextInt(gc.getHeight() - ResourceManager.getWarningFlash().getImage(0).getHeight());
				for (int i = 0; i < 150; i += 50)
				{
					GameEngine.getEngine().add(new MinisharkWarning(gc.getWidth() - ResourceManager.getWarningFlash().getImage(0).getWidth(), minisharkHeight + i));
				}
			}
			
		}
		
		if (m_LaserTickCount > checkLaserTick)
		{
			m_LaserTickCount -= checkLaserTick;
			GameEngine.getEngine().add(new Laser(gc.getWidth(), m_Random.nextInt(gc.getHeight() - ResourceManager.getLaser().getImage(0).getHeight() - 100) + 50));
		}
		
		if (m_CoinTickCount > checkCoinTick)
		{
			m_CoinTickCount -= checkCoinTick;
			int coinHeight = m_Random.nextInt(gc.getHeight() - 100) + 50;
			int coinPattern = m_Random.nextInt(100);
			if (coinPattern <= 25)
			{
				for (int i = 0; i < 300; i += 30)
				{
					GameEngine.getEngine().add(new Coin(gc.getWidth() + i, coinHeight));
				}
			}
			else if (coinPattern <= 60)
			{
				for (int i = 0; i < 360; i += 30)
				{
					GameEngine.getEngine().add(new Coin(gc.getWidth() + i, (int) (coinHeight + Math.sin(Math.toRadians(i)) * 35)));
				}
			}
			else if (coinPattern <= 95)
			{
				for (int i = -360; i < 0; i += 30)
				{
					GameEngine.getEngine().add(new Coin(gc.getWidth() - i, (int) (coinHeight + Math.sin(Math.toRadians(i)) * 35)));

				}
			}
			else if (coinPattern <= 100)
			{
				String bitTest = "01111110011111100110111000011011111110\r\n11000000110000110110111100011011000000\r\n11000000110000110110110110011011111110\r\n11000000110000110110110011011000000110\r\n01111110011111100110110001111011111110\r\n00000000000000000000000000000000000000\r\n00000000000000000000000000000000000000";
				Scanner scan = new Scanner(bitTest);
				while (scan.hasNextLine())
				{
					String testLine = scan.nextLine();
					for (int i = 0; i < testLine.length(); i++)
					{
						if (testLine.charAt(i) == '1')
						{
							GameEngine.getEngine().add(new Coin(gc.getWidth() + i * 20, coinHeight));
						}
					}
					coinHeight += 20;
				}
				scan.close();
			}
			
		}
	}
}
