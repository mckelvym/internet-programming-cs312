import java.awt.*;
import java.applet.*;

public class NewCircle extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.orange);
		g.drawOval(0,0,100,100);
                g.drawOval(1,1,99,99);
                g.drawOval(2,2,98,98);
		g.setColor(Color.blue);
		g.fillOval(2,2,98,98);
                g.setColor(Color.black);
		g.drawString("Hello World",20,55);
	}
}