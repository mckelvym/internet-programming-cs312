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

    JMenuBar mb;
    JMenu menu;
    JMenu new_menu;
    JMenuItem i2, s1, s2, s3;
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
        mb = new JMenuBar();//true);
        menu = new JMenu("File", true);
        new_menu = new JMenu("New");
        i2 = new JMenuItem("Open");
        i3 = new JCheckBoxMenuItem("Exit", true);
        s1 = new JMenuItem("Face");
        s2 = new JMenuItem("Brain");
        s3 = new JMenuItem("Computer");
        new_menu.add(s1);
        //new_menu.addSeparator();
        new_menu.add(s2);
        new_menu.add(s3);
        menu.add(new_menu);    // create menu first, then add menu bar to this.setJMenuBar
        menu.addSeparator();
        menu.add(i2);
        menu.add(i3);
        mb.add(menu);
        this.setJMenuBar(mb);
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
