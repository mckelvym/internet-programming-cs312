// Mark McKelvy
// Internet Programming 9:30 TR
// October 30, 2003
// Menu Hw

// checkbox menuitem
// tearoff menubar
// submenu, with separators

//application - main method
//create a JFrame , and display a JDialog Box

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrameAppl extends JFrame implements ActionListener {


    JCheckBoxMenuItem i3;
    JButton b;
    MyDialog md;
    public String s;

    public static void main(String[] args) {
        FrameAppl fr = new FrameAppl();//invokes my constr
        fr.setVisible(true);

    }


    public FrameAppl() {
        super("MyFrame"); // same as JFrame MyFrame = new JFrame("MyFrame"); has to be first statement
        setSize(200, 300);
        md = new MyDialog();    // create a new dialog box
        b = new JButton("See");    // add the buttons

        //closing the JFrame when the user clicks on the 'X' button of the Frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(b);
        b.addActionListener(this);
        md.b.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            md.show();
            s = md.tf.getText();
        }
        if (e.getSource() == md.b) {
            md = new MyDialog();
            md.dispose();
        }
        //if(e.getSource()==md.
    }


}

class MyDialog extends JDialog {
    public JTextField tf;
    public JButton b;

    public MyDialog() {
        super();
        tf = new JTextField(10);
        tf.setBackground(Color.blue + Color.red);
        b = new JButton("OK");
        getContentPane().setLayout(new GridLayout(2, 1));
        getContentPane().add(tf);
        getContentPane().add(b);
    }
}


    /*	1. Create a Thread to display an animation that uses atleast
           5 images.

        2. Make the Frame application run with a Dialog Box.

    */
