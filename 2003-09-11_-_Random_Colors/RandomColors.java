// write an applet that generates random colors on a 4x4 checkerboard.
import java.awt.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;

public class RandomColors extends Applet implements Runnable{
	Color c;
        JTextField myText;
        Thread myThread;
        boolean white = true;
        	
	public void init(){
		//initialize thread
		myThread = new Thread(this);
                myText = new JTextField();
                this.setLayout(new GridLayout(1,1));
                this.add(myText);
		if(myThread != null){
			myThread.start();// calling thread's start method
		}
	}
	public void run(){
            //drawpaint();
            thepaint();
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
	}	
	public void stop(){
            if(myThread.isAlive()){
                myThread = null;
            }
	}
	public void thepaint(){
            if(white){
                c = Color.white;
                white = false;
            }
            else{
                c = Color.black;
                white = true;
            }
            myText.setBackground(c);            
	}
}