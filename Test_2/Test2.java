// mark mckelvy
// internet programming 9:30 tr
// test 2

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;

public class Test2 extends JApplet implements Runnable {
    Thread second;
    AudioClip audio;
    Color c;
    int x1, y1, x2, y2;

    // init method required for JApplet
    public void init() {
        // instantiate a new Thread object and pass it a Runnable object
        second = new Thread(this);
        // set the audio clip using the current directory and the name of the file is found from the html file
        audio = getAudioClip(getDocumentBase(), "audio");
        // starts the Thread by calling its run() function
        second.start();
    }

    public void run() {
        // give random values to the x and y coordinates
        x1 = (int) (Math.random() * 400);
        y1 = (int) (Math.random() * 400);
        x2 = (int) (Math.random() * 400);
        y2 = (int) (Math.random() * 400);
        // call the drawing function
        this.draw();
        // causes the second thread to sleep for a random amount of time, up to one second
        try {
            second.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }
    }

    public void draw() {
        // instantiates a new graphics object
        Graphics g = this.getGraphics();
        // sets the graphics color using random rgb values
        c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        g.setColor(c);
        // draws a line at random x and y coordinates
        g.drawLine(x1, y1, x2, y2);
        // plays the audio clip
        audio.play();
    }
}
