package malp.States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import malp.SantaDash.GameEngine;
import malp.SantaDash.ResourceManager;
import malp.SantaDash.SantaDash;

public class Tutorial extends BasicGameState{
	
	public final String tutorialText = "This game is very, very early in development- expect it to be extremely barebones \nand possibly broken.\n\nWith that in mind, Santa will follow your mouse cursor up and down the screen- avoid \nthe missiles and lasers, collect the coins (which don't do anything just yet), and \nview your score and some other info at the top left corner of the screen.\n\nTo return to the main menu, hit the spacebar or escape key.";
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setFont(gc.getDefaultFont());
		g.setBackground(ResourceManager.getColor());
		GameEngine.getEngine().drawMountains(gc);
		g.setColor(Color.white);
		g.drawString(tutorialText, gc.getWidth() / 8, gc.getHeight() / 10);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_ESCAPE))
		{
			sbg.enterState(SantaDash.MAIN_MENU);
			return;
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return SantaDash.TUTORIAL;
	}

}
