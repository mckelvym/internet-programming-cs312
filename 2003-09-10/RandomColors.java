// Mark McKelvy
// Internet Programming
// 9 11 03

// write an applet that generates random colors on a 4x4 checkerboard.
import java.applet.*;
import java.awt.*;

public class RandomColors extends Applet
{
    //Color[] c;
    Color c;
    int x,y;
    
	/*
	public void init()
    {
        c[i]=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }
	*/
    public void paint(Graphics g)
    {        
        for(x = 0; x < 400; x+=100)
        {
            for(y = 0; y < 400; y+=100)
            {
                c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
                g.drawRect(x,y,100,100);
                g.setColor(c);
                g.fillRect(x,y,100,100);
            }
        }
    }
}