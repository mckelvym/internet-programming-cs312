import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ImageApplet extends Applet implements MouseListener
{	// listener classes, wait for events from the user: 
	// key presses, mouse clicks, etc....once they get an event, 
	// they take it and translate it into an event object and it 
	// is handled in its specific class.
	
	// components = buttons, etc
	Button b;
	Image pic;
	AudioClip a;
	int click;
	public void init()
	{
		click = 0;
		b = new Button("click");
		pic = this.getImage(this.getDocumentBase(), this.getParameter("image"));
		a = this.getAudioClip(this.getDocumentBase(), "violin.mid");
		this.addMouseListener(this); // listens for events at certain components.
		this.add(b); // adding the button to the applet(container)
	}	
	
	public void mouseClicked(MouseEvent e)
	{
		click++;
		if(click == 1) // display image
		{
			repaint(); // calls the paint mehtod in turn does the painting of the image
		}
		else if(click == 2) // play sound
		{
			a.play();
		}
		else if(click > 2)
		{
			click = 0;
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void paint(Graphics g)
	{
		g.drawImage(pic, 0, 0, this);
	}
}