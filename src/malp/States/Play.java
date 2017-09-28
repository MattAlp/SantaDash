package malp.States;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import malp.SantaDash.GameEngine;
import malp.SantaDash.SantaDash;
import malp.SantaDash.ResourceManager;

public class Play extends BasicGameState{
	
	private GameEngine ge;
	private int deltaSum = 0;
	private int cleanupDelta = 0;
	public final int TICK_DELTA = 16;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		ResourceManager.getResourceManager();
		ge = GameEngine.getEngine();
		
	}
	
	
	public void enter(GameContainer gc, StateBasedGame sbg)
	{
		gc.setMouseGrabbed(true);
		ge.resetEngine();
		ResourceManager.getExplosion().restart();
		ResourceManager.getGameMusic().loop();
	}
	
	public void leave(GameContainer gc, StateBasedGame sbg)
	{
		ge.resetEngine();
		ResourceManager.getExplosion().restart();
		ResourceManager.getGameMusic().loop();
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setFont(gc.getDefaultFont());
		g.setBackground(ResourceManager.getColor());
		ge.render(gc, g);
		g.setColor(Color.white);
		g.drawString("FPS: " + gc.getFPS() + "\nEntities: " + Integer.toString(ge.entityCount()) + "\nCoins: " + Integer.toString(ge.getCoins()) + "\nHighscore: " + Integer.toString(ge.getHighScore()) + "\nScore: " + Integer.toString(ge.getScore()), 0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (!ge.isAlive())
		{
			sbg.enterState(SantaDash.MAIN_MENU, new FadeOutTransition(), new FadeInTransition());
			return;
		}
		
		Input input = gc.getInput();
		
		deltaSum += delta;
		cleanupDelta += delta;
		ge.setSantaHeight(input.getMouseY());
//		if (deltaSum > TICK_DELTA / ge.getSpeed())
//		{
//			ge.update(gc, TICK_DELTA);
//			deltaSum -= TICK_DELTA / ge.getSpeed();
//		}
		for (int i = 0; i < deltaSum; i += TICK_DELTA / ge.getSpeed())
		{
			ge.update(gc, TICK_DELTA);
			deltaSum -= TICK_DELTA / ge.getSpeed();
		}
		if (cleanupDelta >= 50)
		{
			cleanupDelta -= 50;
			ge.cleanUp();
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return SantaDash.PLAY;
	}

}
