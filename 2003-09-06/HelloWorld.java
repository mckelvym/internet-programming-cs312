// java compiler command is "javac example.java"
// javainterpreter is "java example"

// hello world applet

import java.awt.*;
import java.applet.*; // for every applet

public class HelloWorld extends Applet
{
	//Color c;
	// overriding the init method that has already been written
	//public void init()// does initializations (allocations, etc)
	//{
	//	c=new Color(0.2,0.3,0.4);
	//}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.pink);
		g.drawRect(20,30,100,50);
		g.setColor(Color.blue);
		g.drawString("Hello World",35,70);
	}
}

