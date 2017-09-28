package malp.Gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;

public class ToggleButton extends Button {
	
	private boolean m_State;
	private Image m_ToggledImage;
	private Image m_Image;

	public ToggleButton(GUIContext container, Image image, Image toggledImage, int x, int y) {
		super(container, image, image, x, y);
		m_Image = image;
		m_ToggledImage = toggledImage;
		setMouseOverImage(image);
	}

	public void toggle()
	{
		if (isButtonPressed())
		{
			m_State = !m_State;
			if (m_State)
			{
				setNormalImage(m_ToggledImage);
				setMouseOverImage(m_ToggledImage);
			}
			else
			{
				setNormalImage(m_Image);
				setMouseOverImage(m_Image);
			}

		}
	}
	
	public boolean isToggled()
	{
		return m_State;
	}
}
