import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Problem62 extends JApplet implements Runnable {
    JButton start, stop;
    JComboBox animation_type;
    JSlider speed;
    Image image[];
    String animations[] = {"Face", "Ear"};
    Thread theThread;
    int tracker;

    public void init() {
        theThread = new Thread();
        start = new JButton("Start");
        stop = new JButton("Stop");
        animation_type = new JComboBox(animations);
        speed = new JSlider(1, 5, 3);
        speed.setSnapToTicks(true);
        speed.setPaintTicks(true);
        speed.setPaintLabels(true);
        speed.setMajorTickSpacing(1);
        image[0] = getImage(this.getDocumentBase(), this.getParameter("pic1"));
        image[1] = getImage(this.getDocumentBase(), this.getParameter("pic2"));
        image[2] = getImage(this.getDocumentBase(), this.getParameter("pic3"));
        image[3] = getImage(this.getDocumentBase(), this.getParameter("pic4"));
        image[4] = getImage(this.getDocumentBase(), this.getParameter("pic5"));
        image[5] = getImage(this.getDocumentBase(), this.getParameter("pic6"));
        this.getContentPane().setLayout(new GridLayout(3, 3));
        this.getContentPane().add(animation_type);
        this.getContentPane().add(start);
        this.getContentPane().add(stop);
        this.getContentPane().add(speed);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == start) {
                    theThread.start();
                }
            }
        });
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == stop) {
                    theThread.destroy();
                }
            }
        });

    }

    public void myPaint() {
        Graphics g = this.getGraphics();
        if (animation_type.getSelectedIndex() == 0) {
            if (tracker == 3) {
                tracker = 0;
            }
            g.drawImage(image[tracker], 0, 0, this);
            tracker++;
            try {
                theThread.sleep(speed.getValue() * 1000);
            } catch (InterruptedException i) {
            }
        } else {
            if (tracker == 5) {
                tracker = 3;
            }
            g.drawImage(image[tracker], 0, 0, this);
            tracker++;
            try {
                theThread.sleep(speed.getValue() * 1000);
            } catch (InterruptedException i) {
            }
        }
    }

    public void run() {
        if (animation_type.getSelectedIndex() == 0) {
            tracker = 0;
        } else {
            tracker = 3;
        }
        myPaint();
    }
}
