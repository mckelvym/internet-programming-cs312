// mark mckelvy
// internet programming
// september 23, 2003

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
    Font[] fonts;
    Color c;
    String[] myString = {"Times New Roman", "Courier New", "Tahoma", "Arial", "Comic Sans MS",
            "Trebuchet MS", "Verdana", "Courier", "Georgia", "Lucida Sans Console"};
    int i;

    public void init() {
        //initialize thread
        myThread = new Thread(this);
        fonts = new Font[10];
        if (myThread != null) {
            myThread.start();// calling thread's start method
        }
    }

    public void run() {
        // how long to run clock
        i = 0;
        for (i = 0; i <= 9; i++) {
            fonts[i] = new Font(myString[i], Font.BOLD, 25);
        }
        i = 5;
        while (true) {
            myDate = new Date();
            fonts[i] = new Font(myString[i], Font.BOLD, 25);
            System.out.println(myString[i]);
            if (i == 9) {
                i = 0;
            }
            i++;
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
    }
}
