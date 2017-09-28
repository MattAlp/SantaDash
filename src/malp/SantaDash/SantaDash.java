package malp.SantaDash;
import java.awt.Font;
import java.io.File;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import malp.States.Leaderboard;
import malp.States.MainMenu;
import malp.States.Play;
import malp.States.Tutorial;

public class SantaDash extends StateBasedGame{
	
	public static final String GAME_NAME = "Santa Dash 2";
	public static final int PLAY = 0;
	public static final int MAIN_MENU = 1;
	public static final int LEADERBOARD = 2;
	public static final int TUTORIAL = 3;
	public SantaDash(String gamename)
	{
		super(gamename);
		this.addState(new MainMenu());
		this.addState(new Play());
		this.addState(new Leaderboard());
		this.addState(new Tutorial());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		
		getState(MAIN_MENU).init(gc, this);
		getState(PLAY).init(gc, this);
		getState(LEADERBOARD).init(gc, this);
		getState(TUTORIAL).init(gc, this);
		try {
			//Font awtFont = new Font("Times New Roman", Font.PLAIN, 24);
			Font awtFont = Font.createFont(Font.PLAIN, ResourceLoader.getResourceAsStream("res/0Ubuntu.ttf"));
			awtFont = awtFont.deriveFont(Font.PLAIN, 24);
			UnicodeFont ucFont = new UnicodeFont(awtFont);
			ucFont.getEffects().add(new ColorEffect(new java.awt.Color(255, 255, 255)));
			ucFont.addGlyphs("•");
			ucFont.addAsciiGlyphs();
			ucFont.loadGlyphs();
			gc.setDefaultFont(ucFont);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		enterState(MAIN_MENU);
		return;
	}
	
	public static void main(String[] args)
	{
		//TODO add custom resolution support
		System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath());
		//System.setProperty("org.lwjgl.librarypath", new File(ClassLoader.getSystemClassLoader().getResource("natives").getFile()).getAbsolutePath());
		Input.disableControllers();
		AppGameContainer appgc;
		try{
			DisplayMode dm = Display.getDesktopDisplayMode();
			appgc = new AppGameContainer(new SantaDash(GAME_NAME));
			appgc.setIcon("res/icon.png");
			appgc.setShowFPS(false);
			//appgc.setTargetFrameRate(60);
			//appgc.setMouseGrabbed(true);
			appgc.setDisplayMode(dm.getWidth(), dm.getHeight(), dm.isFullscreenCapable());
			appgc.start();
		}
		catch(SlickException e)	{
			e.printStackTrace();
		}
	}


}
