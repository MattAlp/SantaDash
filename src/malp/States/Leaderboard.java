package malp.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import malp.SantaDash.GameEngine;
import malp.SantaDash.LeaderboardHandler;
import malp.SantaDash.ResourceManager;
import malp.SantaDash.SantaDash;

public class Leaderboard extends BasicGameState{
	
	private String leaderboardText = "Please wait...";
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}
	
	public void enter(GameContainer gc, StateBasedGame sbg)
	{
		leaderboardText = LeaderboardHandler.getScores();
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(ResourceManager.getColor());
		g.setFont(gc.getDefaultFont());
		GameEngine.getEngine().drawMountains(gc);
		g.setColor(Color.white);
		g.drawString("ALL-TIME LEADERBOARDS:\n" + leaderboardText, gc.getWidth() / 3, gc.getHeight() / 8);
		g.setColor(Color.red);
		g.drawString("Hit the <\"ESCAPE\"> key to\nget back to the main menu.", 0, 0);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE))
		{
			sbg.enterState(SantaDash.MAIN_MENU);
			return;
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return SantaDash.LEADERBOARD;
	}

}
