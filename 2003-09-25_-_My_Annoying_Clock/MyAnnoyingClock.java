// mark mckelvy
// internet programming
// October 2, 2003

// animations - without images
/* Thread - process --> creating: uses Thread Class.
    create an array of fonts
*/

import java.awt.*;
import java.applet.*;
import java.util.*;

public class MyAnnoyingClock extends Applet implements Runnable {
    Thread myThread;
    Date myDate;
    Image pic;
    Font[] fonts;
    Color c;
    String[] myString = {"Times New Roman", "Courier New", "Tahoma", "Arial", "Comic Sans MS",
            "Trebuchet MS", "Verdana", "Courier", "Georgia", "Lucida Sans Console"};
    int i, j, counter;

    public void init() {
        //initialize thread
        myThread = new Thread(this);
        fonts = new Font[10];
        pic = new Image[18];
        if (myThread != null) {
            myThread.start();// calling thread's start method
        }
    }

    public void run() {
        // how long to run clock
        for (i = 0; i <= 9; i++) {
            fonts[i] = new Font(myString[i], Font.BOLD, 25);
        }
        pic = this.getImage(this.getDocumentBase(), this.getParameter(Integer.toString(j)));
        i = 5;
        j = 0;
        counter = 0;
        while (true) {
            myDate = new Date();
            fonts[i] = new Font(myString[i], Font.BOLD, 25);
            pic = this.getImage(this.getDocumentBase(), this.getParameter(Integer.toString(j)));
            System.out.println(myString[i]);
            i++;
            if (i == 10) {
                i = 0;
            }
            counter++;
            //creates a new Date object every time while runs.
            // display date
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Oops!");
            }
        }
    }

    public void stop() {
        if (myThread.isAlive()) {
            myThread = null;
        }
    }

    public void paint(Graphics g) {
        //font
        c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        g.setFont(fonts[i]);
        g.setColor(c);
        g.drawString(myDate.toString(), 80, 150);
        if ((counter % 300) == 0) {
            g.drawImage(pic, 80, 250, this);
        }
    }
}
