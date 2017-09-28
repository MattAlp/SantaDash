package malp.SantaDash;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class ResourceManager {
	
	private static final ResourceManager INSTANCE = new ResourceManager();
	
	private static Animation LASER;
	private static Animation SANTA;
	private static Animation MISSILE;
	private static Animation COIN;
	private static Animation MINISHARK;
	private static Animation CHIMNEY;
	private static Animation TREE;
	private static Animation EXPLOSION;
	private static Animation PICKUP_FLASH;
	private static Animation WARNING_FLASH;
	private static Animation GIFT_1;
	private static Animation GIFT_2;
	private static Animation GIFT_3;
	private static Animation GIFT_4;
	private static Animation EVIL_GIFT;
	private static Image FOREFROUNT_MOUNTAINS;
	private static Image BACKGROUND_MOUNTAINS;
	private static Image SOUND_ON;
	private static Image SOUND_OFF;
	private static Image MUSIC_ON;
	private static Image MUSIC_OFF;
	
	private static Sound COIN_SOUND;
	private static Sound EXPLOSION_SOUND;
	private static Sound LASER_SOUND;
	private static Sound WARNING_SOUND;
	private static Sound BUTTON_SOUND;
	private static Sound HIT_SOUND;
	
	private static Music MENU_MUSIC;
	private static Music GAME_MUSIC;
	
	private static Color bgColor;
	
	private ResourceManager()
	{
		try
		{
			Image[] loadArray = new Image[2];
			loadArray[0] = new Image("res/Laser1.png");
			loadArray[1] = new Image("res/Laser2.png");
			LASER = new Animation(loadArray, 200);
			loadArray[0] = new Image("res/SantaOne.png");
			loadArray[1] = new Image("res/SantaTwo.png");
			SANTA = new Animation(loadArray, 200);
			loadArray[0] = new Image("res/Missile1.png");
			loadArray[1] = new Image("res/Missile2.png");
			MISSILE = new Animation(loadArray, 200);
			loadArray[0] = new Image("res/Minishark1.png");
			loadArray[1] = new Image("res/Minishark2.png");
			MINISHARK = new Animation(loadArray, 200);
			loadArray = new Image[7];
			loadArray[0] = new Image("res/Coin1.png");
			loadArray[1] = new Image("res/Coin2.png");
			loadArray[2] = new Image("res/Coin3.png");
			loadArray[3] = new Image("res/Coin4.png");
			loadArray[4] = new Image("res/Coin5.png");
			loadArray[5] = new Image("res/Coin6.png");
			loadArray[6] = new Image("res/Coin7.png");
			COIN = new Animation(loadArray, 150);
			
			//EXPLOSION MUST NOT RUN IN SYNC
			Image[] explosionImages = new Image[7];
			explosionImages[0] = new Image("res/Explosion1.png");
			explosionImages[1] = new Image("res/Explosion2.png");
			explosionImages[2] = new Image("res/Explosion3.png");
			explosionImages[3] = new Image("res/Explosion4.png");
			explosionImages[4] = new Image("res/Explosion5.png");
			explosionImages[5] = new Image("res/Explosion6.png");
			explosionImages[6] = new Image("res/Explosion7.png");
 
			EXPLOSION = new Animation(explosionImages, 50);
			EXPLOSION.setLooping(false);
			PICKUP_FLASH = new Animation(new Image[] {new Image("res/PickupFlash.png")}, 150);
			WARNING_FLASH = new Animation(new Image[] {new Image("res/WarningFlash.png"), new Image("res/Flash.png")}, 200);
			CHIMNEY = new Animation(new Image[] {new Image("res/Chimney.png")}, 100);
			TREE = new Animation(new Image[] {new Image("res/Tree.png")}, 100);
			GIFT_1 = new Animation(new Image[] {new Image("res/Gift1.png")}, 100);
			GIFT_2 = new Animation(new Image[] {new Image("res/Gift2.png")}, 100);
			GIFT_3 = new Animation(new Image[] {new Image("res/Gift3.png")}, 100);
			GIFT_4 = new Animation(new Image[] {new Image("res/Gift4.png")}, 100);
			EVIL_GIFT = new Animation(new Image[] {new Image("res/EvilGift.png")}, 100);
			COIN_SOUND = new Sound("res/Coin.wav");
			EXPLOSION_SOUND = new Sound("res/Explosion.ogg"); //TODO use standard file format 
			LASER_SOUND = new Sound("res/Laser.wav");
			WARNING_SOUND = new Sound("res/Warning.wav");
			BUTTON_SOUND = new Sound("res/Button.wav");
			HIT_SOUND = new Sound("res/Hit.wav");
			
			FOREFROUNT_MOUNTAINS = new Image("res/Forefront.png");
			BACKGROUND_MOUNTAINS = new Image("res/BackgroundMountains.png");
			MUSIC_ON = new Image("res/Music.png");
			MUSIC_ON.setFilter(Image.FILTER_NEAREST);
			MUSIC_OFF = new Image("res/MusicOff.png");
			MUSIC_OFF.setFilter(Image.FILTER_NEAREST);
			SOUND_ON = new Image("res/Sound.png");
			SOUND_ON.setFilter(Image.FILTER_NEAREST);
			SOUND_OFF = new Image("res/SoundOff.png");
			SOUND_OFF.setFilter(Image.FILTER_NEAREST);
			
			MENU_MUSIC = new Music("res/MenuMusic.ogg");
			GAME_MUSIC = new Music("res/GameMusic.ogg");
			
			bgColor = new Color(102, 189, 225);
			
		}
		catch(SlickException se)
		{
			System.exit(1);
		}
	}
	
	public static ResourceManager getResourceManager()
	{
		return INSTANCE;
	}
	
	public static Color getColor()
	{
		return bgColor;
	}
	
	public static Image getForefrontMountains()
	{
		return FOREFROUNT_MOUNTAINS;
	}
	
	public static Image getBackgroundMountains()
	{
		return BACKGROUND_MOUNTAINS;
	}
	
	public static Image getSoundOn()
	{
		return SOUND_ON;
	}
	
	public static Image getSoundOff()
	{
		return SOUND_OFF;
	}
	
	public static Image getMusicOn()
	{
		return MUSIC_ON;
	}
	
	public static Image getMusicOff()
	{
		return MUSIC_OFF;
	}
	
	public static Sound getCoinSound(){
		return COIN_SOUND;
	}
	
	public static Sound getExplosionSound(){
		return EXPLOSION_SOUND;
	}
	
	public static Sound getLaserSound(){
		return LASER_SOUND;
	}
	
	public static Sound getWarningSound(){
		return WARNING_SOUND;
	}
	
	public static Sound getButtonSound(){
		return BUTTON_SOUND;
	}
	
	public static Sound getHitSound(){
		return HIT_SOUND;
	}
	
	public static Animation getWarningFlash(){
		return WARNING_FLASH;
	}
	
	public static Animation getExplosion(){
		return EXPLOSION;
	}
	
	public static Animation getLaser() {
		return LASER;
	}
	
	public static Animation getSanta() {
		return SANTA;
	}
	
	public static Animation getMissile() {
		return MISSILE;
	}
	
	public static Animation getCoin()
	{
		return COIN;
	}
	
	public static Animation getMinishark()
	{
		return MINISHARK;
	}
	
	public static Animation getChimney()
	{
		return CHIMNEY;
	}
	
	public static Animation getTree()
	{
		return TREE;
	}
	
	public static Animation getPickupFlash(){
		return PICKUP_FLASH;
	}
	
	public static Animation getGift(int type)
	{
		if (type == 1)
		{
			return GIFT_1;
		}
		else if (type == 2)
		{
			return GIFT_2;
		}
		else if (type == 3)
		{
			return GIFT_3;
		}
		else if (type == 4)
		{
			return GIFT_4;
		}
		else
		{
			return null;
		}
	}
	
	public static Animation getEvilGift()
	{
		return EVIL_GIFT;
	}
	
	public static Music getMenuMusic()
	{
		return MENU_MUSIC;
	}
	
	public static Music getGameMusic()
	{
		return GAME_MUSIC;
	}
}
