package malp.States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import malp.Gui.Button;
import malp.Gui.ToggleButton;
import malp.SantaDash.GameEngine;
import malp.SantaDash.SantaDash;
import malp.SantaDash.ResourceManager;

public class MainMenu extends BasicGameState{
	
	public static final int ID = 1;
	private Image logo;
	private float velocityDirection;
	
	private Button startButton;
	private Button tutorialButton;
	private Button leaderboardsButton;
	private Button quitButton;
	
	private ToggleButton musicButton;
	private ToggleButton soundButton;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		logo = new Image("res/Logo.png");
		logo.setFilter(Image.FILTER_NEAREST);
		velocityDirection = 0.03f;
		musicButton = new ToggleButton(gc, ResourceManager.getMusicOn().getScaledCopy(2), ResourceManager.getMusicOff().getScaledCopy(2), 100, 100);
		soundButton = new ToggleButton(gc, ResourceManager.getSoundOn().getScaledCopy(2), ResourceManager.getSoundOff().getScaledCopy(2), 100, 150);
		startButton = new Button(gc, new Image("res/StartSD.png"), new Image("res/HoverSD.png"), 0, 0);
		tutorialButton = new Button(gc, new Image("res/Tutorial.png"), new Image("res/HoverTutorial.png"), 0, 0);
		leaderboardsButton = new Button(gc, new Image("res/Leaderboards.png"), new Image("res/LeaderboardsHover.png"), 0, 0);
		quitButton = new Button(gc, new Image("res/Quit.png"), new Image("res/HoverQuit.png"), 0, 0);
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg)
	{
		gc.setMouseGrabbed(false);
//		try {
//			gc.setMouseCursor("res/Cursor.png", 0, 0);
//		} catch (SlickException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ResourceManager.getMenuMusic().loop();
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.setAntiAlias(true);
		g.setBackground(ResourceManager.getColor());
		g.setFont(gc.getDefaultFont());
		GameEngine.getEngine().drawMountains(gc);
		logo.draw((gc.getWidth() / 2) - (logo.getWidth() / 2), ((gc.getHeight() / 2) - (logo.getHeight() / 2) - 100));
		//playButton.render(gc, g);
		musicButton.render(gc, g);
		soundButton.render(gc, g);
		startButton.render(gc, g);
		tutorialButton.render(gc, g);
		leaderboardsButton.render(gc, g);
		quitButton.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		musicButton.setX(gc.getWidth() - 100);
		musicButton.setY(25);
		
		soundButton.setX(gc.getWidth()  - 50);
		soundButton.setY(25);
		
		startButton.setX((gc.getWidth() / 2) - (startButton.getWidth() / 2));
		startButton.setY((gc.getHeight() / 2) - (startButton.getHeight() / 2));
		
		tutorialButton.setX((gc.getWidth() / 2) - (tutorialButton.getWidth() / 2));
		tutorialButton.setY((gc.getHeight() / 2) - (tutorialButton.getHeight() / 2) + 50);
		
		leaderboardsButton.setX((gc.getWidth() / 2) - (leaderboardsButton.getWidth() / 2));
		leaderboardsButton.setY((gc.getHeight() / 2) - (leaderboardsButton.getHeight() / 2) + 90);
		
		quitButton.setX((gc.getWidth() / 2) - (quitButton.getWidth() / 2));
		quitButton.setY((gc.getHeight() / 2) - (quitButton.getHeight() / 2) + 130);
		
		if (delta > 100)
		{
			delta = 100;
		}
		if (logo.getRotation() > 10 && velocityDirection > 0)
		{
			velocityDirection *= -1;
		}
		if (logo.getRotation() < -10 && velocityDirection < 0)
		{
			velocityDirection *= -1;
		}
		logo.setRotation(logo.getRotation() + velocityDirection * delta);
		if (quitButton.isButtonPressed())
		{
			gc.exit();
		}
		if (leaderboardsButton.isButtonPressed())
		{
			sbg.enterState(SantaDash.LEADERBOARD);
			return;
		}
		if (startButton.isButtonPressed())
		{
			sbg.enterState(SantaDash.PLAY);
			return;
		}
		if (tutorialButton.isButtonPressed())
		{
			sbg.enterState(SantaDash.TUTORIAL);
			return;
		}
		musicButton.toggle();
		if (musicButton.isToggled())
		{
			gc.setMusicVolume(0);
		}
		else
		{
			gc.setMusicVolume(1);
		}
		soundButton.toggle();
		if (soundButton.isToggled())
		{
			gc.setSoundVolume(0);
		}
		else
		{
			gc.setSoundVolume(1);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return SantaDash.MAIN_MENU;
	}

}
