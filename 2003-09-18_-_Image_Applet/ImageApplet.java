// september 18, 2k3
// write an applet that creates 3 buttons. Allow the user to view an image when button 1
// is clicked, hear a sound when button two is clicked, button 3 won't do jack.

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class ImageApplet extends Applet implements ActionListener
{	
	JButton b1, b2, b3;
	Image i, pic;
	AudioClip a;
	ImageIcon icon;
	
	public void init()
	{
		pic = this.getImage(this.getDocumentBase(), this.getParameter("icon"));
		icon = new ImageIcon(pic);
		// initialize
		b1 = new JButton("Picture", icon);
		b2 = new JButton("Sound");
		b3 = new JButton("Animation");
		// add to container
		this.add(b1);
		this.add(b2);
		this.add(b3);
		// make object listen for events
		b1.addActionListener(this); // listens for events at b1
		b2.addActionListener(this);
		b3.addActionListener(this);

		i = this.getImage(this.getDocumentBase(), this.getParameter("image"));
		a = this.getAudioClip(this.getDocumentBase(), "violin.mid");
	}	

	public void actionPerformed(ActionEvent e){
		if (b1 == e.getSource()){
			repaint();
		}
		else if (b2 == e.getSource()){
			a.loop();
		}
		else if (b3 == e.getSource()){
			// animation
		}
	}
	
	public void update(Graphics g){
		g.drawImage(i, 0, 200, this);
	}
	
	public void paint(Graphics g){
		}
}