package malp.Gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import malp.SantaDash.ResourceManager;

public class Button extends MouseOverArea {

	public Button(GUIContext container, Image image, Image mouseOverImage, int x, int y) {
		super(container, image, x, y);
		
		setMouseOverImage(mouseOverImage);
		setMouseDownSound(ResourceManager.getButtonSound());
	}
	
	public boolean isButtonPressed()
	{
		if (isMouseOver())
		{
			Input input = container.getInput();
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				return true;
			}
		}
		
		return false;

	}
	

}
