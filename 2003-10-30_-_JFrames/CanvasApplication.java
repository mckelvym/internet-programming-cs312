// Mark McKelvy
// Internet Programming 9:30 TR
// October 30, 2003
// Menu Hw

// checkbox menuitem
// tearoff menubar
// submenu, with separators

//application - main method
//create a JFrame , and display a JDialog Box

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.*;

public class CanvasApplication extends JFrame {

    JMenuBar menubar;
    JMenu menu;
    JMenu new_menu;
    JMenuItem i2, s1, s2, s3;
    JCheckBoxMenuItem i3;
    JButton b;
    MyDialog md;
    public String s;
    DrawCanvas colorbook;

    public static void main(String arguments) {
        CanvasApplication mainFrame = new CanvasApplication();
        mainFrame.show();
    }

    public CanvasApplication() {
        super("Color Book"); // same as JFrame MyFrame = new JFrame("MyFrame"); has to be first statement
        setSize(700, 500);
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
        colorbook = new DrawCanvas();
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
        this.getContentPane().add(colorbook);//getContentPane().add(b);


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
    public DrawCanvas face;

    public MyDialog() {
        super();
        tf = new JTextField(10);
        b = new JButton("OK");
        face = new DrawCanvas();
        //getContentPane().setLayout(new GridLayout(2,1));
        getContentPane().add(face);//tf);
        //getContentPane().add(b);
    }
}
/////////////////


class DrawCanvas extends JApplet {

    int temp, int_1 = -1, int_2 = -1, int_3 = -1, int_4 = -1, int_5 = -1, int_6 = -1, int_7 = -1, int_8 = -1, repeat, cap_style, join_style;
    Checkbox eraser, clicky;
    Color b, c;
    JButton clear, start, draw;
    JComboBox fcolor_cmb, shape_cmb, bcolor_cmb, strcap_cmb, strjoin_cmb, style_cmb;
    JLabel l_oldx, l_oldy, l_newx, l_newy, l_ctrlx, l_ctrly, l_width, l_height;
    JPanel subPanel, textPanel, start_clear, slider_pnl, fcolor_pnl, shape_pnl, bcolor_pnl, strcap_pnl, strjoin_pnl, style_pnl, eraser_pnl, pos_pnl;
    JSlider pen_width;
    JTextField textF_1, textF_2, textF_3, textF_4, textF_5, textF_6, textF_7, textF_8, xpos, ypos;
    String[] fcolor_str = {"Blue", "Red", "Black", "White", "Cyan", "Gray", "Orange", "Magenta", "Green", "Yellow"};
    String[] shape_str = {"Rectangle", "Oval", "Arc 2D Open", "Arc 2D Chord", "Arc 2D Pie", "QuadCurve 2D", "CubicCurve 2D", "Line"};
    String[] bcolor_str = {"Blue", "Red", "Black", "White", "Cyan", "Gray", "Orange", "Magenta", "Green", "Yellow"};
    String[] strcap_str = {"Butt", "Round", "Square"};
    String[] strjoin_str = {"Bevel", "Miter", "Round"};
    String[] style_str = {"Oval", "Line"};
    TitledBorder start_clear_t, slider_t, text_t, fcolor_t, shape_t, bcolor_t, strcap_t, strjoin_t, canvas_t, style_t, eraser_t, pos_t;
    TheCanvas canv_pnl; // the canvas
    UIManager the_look;

    public DrawCanvas() {
        try {
            the_look.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException e) {
        } catch (UnsupportedLookAndFeelException e) {
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }
        // create a new JPanel of type TheCanvas, send the forecolor blue, backcolor white
        canv_pnl = new TheCanvas(Color.blue, Color.white);
        // create JPanels
        subPanel = new JPanel();
        subPanel.setBackground(Color.darkGray);
        textPanel = new JPanel();
        fcolor_pnl = new JPanel();
        shape_pnl = new JPanel();
        bcolor_pnl = new JPanel();
        start_clear = new JPanel();
        slider_pnl = new JPanel();
        strcap_pnl = new JPanel();
        strjoin_pnl = new JPanel();
        style_pnl = new JPanel();
        eraser_pnl = new JPanel();
        pos_pnl = new JPanel();
        // create JComboBoxes and pass the strings that will be options to it
        fcolor_cmb = new JComboBox(fcolor_str);
        shape_cmb = new JComboBox(shape_str);
        bcolor_cmb = new JComboBox(bcolor_str);
        strcap_cmb = new JComboBox(strcap_str);
        strjoin_cmb = new JComboBox(strjoin_str);
        style_cmb = new JComboBox(style_str);
        // create JTextFields with a width for 3 characters
        textF_1 = new JTextField(3);
        textF_2 = new JTextField(3);
        textF_3 = new JTextField(3);
        textF_4 = new JTextField(3);
        textF_5 = new JTextField(3);
        textF_6 = new JTextField(3);
        textF_7 = new JTextField(3);
        textF_8 = new JTextField(3);
        xpos = new JTextField(3);
        ypos = new JTextField(3);
        // create JButtons and their captions
        clear = new JButton("Clear");
        start = new JButton("Start");
        draw = new JButton("Set Stroke");
        // create a checkbox for the eraser
        eraser = new Checkbox("Eraser");
        clicky = new Checkbox("Click Pts");
        // create the JSlider with min of 1, max of 10, and default selection 1
        pen_width = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        pen_width.setMajorTickSpacing(1); // major tick spacing is 1
        pen_width.setPaintTicks(true);
        pen_width.setPaintLabels(true);
        pen_width.setSnapToTicks(true);
        // create JLabels for the textfields
        l_oldx = new JLabel("X: ");
        l_oldy = new JLabel("Y: ");
        l_newx = new JLabel("X1: ");
        l_newy = new JLabel("Y1: ");
        l_ctrlx = new JLabel("N/A");
        l_ctrly = new JLabel("N/A");
        l_width = new JLabel("N/A");
        l_height = new JLabel("N/A");
        // set TitledBorders
        start_clear_t = BorderFactory.createTitledBorder("Commands");
        slider_t = BorderFactory.createTitledBorder("Pen Width");
        text_t = BorderFactory.createTitledBorder("Coordinates");
        fcolor_t = BorderFactory.createTitledBorder("Fore Color");
        shape_t = BorderFactory.createTitledBorder("Draw Shape");
        bcolor_t = BorderFactory.createTitledBorder("Back Color");
        canvas_t = BorderFactory.createTitledBorder("Drawing Area");
        strcap_t = BorderFactory.createTitledBorder("Cap Style");
        strjoin_t = BorderFactory.createTitledBorder("Join Style");
        style_t = BorderFactory.createTitledBorder("Pen Style");
        eraser_t = BorderFactory.createTitledBorder("Other");
        pos_t = BorderFactory.createTitledBorder("Mouse Position");
        // set CompoundBorders
        canv_pnl.setBorder(BorderFactory.createCompoundBorder(canvas_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        textPanel.setBorder(BorderFactory.createCompoundBorder(text_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        fcolor_pnl.setBorder(BorderFactory.createCompoundBorder(fcolor_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        shape_pnl.setBorder(BorderFactory.createCompoundBorder(shape_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        bcolor_pnl.setBorder(BorderFactory.createCompoundBorder(bcolor_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        slider_pnl.setBorder(BorderFactory.createCompoundBorder(slider_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        start_clear.setBorder(BorderFactory.createCompoundBorder(start_clear_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        strcap_pnl.setBorder(BorderFactory.createCompoundBorder(strcap_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        strjoin_pnl.setBorder(BorderFactory.createCompoundBorder(strjoin_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        style_pnl.setBorder(BorderFactory.createCompoundBorder(style_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        eraser_pnl.setBorder(BorderFactory.createCompoundBorder(eraser_t, BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        pos_pnl.setBorder(BorderFactory.createCompoundBorder(pos_t, BorderFactory.createEmptyBorder(0, 0, 0, 5)));
        // initialize text fields
        textF_1.setText("0");
        textF_2.setText("0");
        textF_3.setText("0");
        textF_4.setText("0");
        textF_5.setText("0");
        textF_6.setText("0");
        textF_7.setText("0");
        textF_8.setText("0");
        // make text boxes enabled/disabled for startup
        textF_1.enable();
        textF_2.enable();
        textF_3.enable();
        textF_4.enable();
        textF_5.disable();
        textF_6.disable();
        textF_7.disable();
        textF_8.disable();
        xpos.disable();
        ypos.disable();
        // set default of eraser (on/off);
        eraser.setState(false);
        clicky.setState(false);
        clicky.setState(true);
        clicky.setState(false);
        // set default selected items
        fcolor_cmb.setSelectedIndex(0);     // default forecolor selected is blue
        bcolor_cmb.setSelectedIndex(3);     // default backcolor selected is white
        shape_cmb.setSelectedIndex(0);      // default shape selected is rectangle
        strcap_cmb.setSelectedIndex(0);     // default cap style is butt
        strjoin_cmb.setSelectedIndex(0);    // default join style is bevel
        style_cmb.setSelectedIndex(1);      // default pen shape is line
        // create grid with 2 rows and 1 column with border spacing of 0
        this.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
        // create a grid for the buttons box
        start_clear.setLayout(new GridLayout(2, 1, 0, 0));
        eraser_pnl.setLayout(new GridLayout(2, 1, 0, 0));
        // add JPanels to JApplet
        this.getContentPane().add(subPanel);    // top panel
        this.getContentPane().add(canv_pnl);    // drawing panel
        subPanel.add(fcolor_pnl);               // add the fcolor panel
        fcolor_pnl.add(fcolor_cmb);             // add the fcolor combo box to the fcolor panel
        subPanel.add(bcolor_pnl);               // add the bcolor panel
        bcolor_pnl.add(bcolor_cmb);             // add the bcolor combo box to the bcolor panel
        subPanel.add(shape_pnl);                // add the shape panel
        shape_pnl.add(shape_cmb);               // add the shape combo box to the shape panel
        subPanel.add(strcap_pnl);               // add the cap style panel
        strcap_pnl.add(strcap_cmb);             // add the cap style combo box to the cap style panel
        subPanel.add(strjoin_pnl);              // add the join style panel
        strjoin_pnl.add(strjoin_cmb);           // add the join style combo box to the join style panel
        subPanel.add(style_pnl);                // add the pen style panel
        style_pnl.add(style_cmb);               // add the pen style combo box to the pen style panel
        subPanel.add(textPanel);                // add the text fields panel
        textPanel.add(l_oldx);                  // add the first label
        textPanel.add(textF_1);                 // add the first text field
        textPanel.add(l_oldy);                  // add the second label
        textPanel.add(textF_2);                 // add the second text field
        textPanel.add(l_newx);                  // add the third label
        textPanel.add(textF_3);                 // add the third text field
        textPanel.add(l_newy);                  // add the fourth label
        textPanel.add(textF_4);                 // add the fourth text field
        textPanel.add(l_ctrlx);                 // add the fifth label
        textPanel.add(textF_5);                 // add the fifth text field
        textPanel.add(l_ctrly);                 // add the sixth label
        textPanel.add(textF_6);                 // add the sixth text field
        textPanel.add(l_width);                 // add the seventh label
        textPanel.add(textF_7);                 // add the seventh text field
        textPanel.add(l_height);                // add the eigth label
        textPanel.add(textF_8);                 // add the eigth text field
        subPanel.add(start_clear);              // add the command buttons panel
        start_clear.add(start);                 // add the start button to the command buttons panel
        start_clear.add(clear);                 // add the clear button to the command buttons panel
        subPanel.add(slider_pnl);               // add the slider panel
        slider_pnl.add(pen_width);              // add the slider to the slider panel
        slider_pnl.add(draw);                   // add the set stroke button to the slider panel
        subPanel.add(eraser_pnl);               // add the eraser panel
        eraser_pnl.add(eraser);                 // add the eraser checkbox to the eraser panel
        eraser_pnl.add(clicky);                 // add the click to draw checkbox to the eraser panel
        subPanel.add(pos_pnl);                  // add the mouse position panel
        pos_pnl.add(xpos);                      // add the xpos text box to the mouse position panel
        pos_pnl.add(ypos);                      // add the ypos text box to the mouse position panel

        // give the set stroke button an action listener
        // that will send the value of the slider when pressed
        draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == draw) {
                    canv_pnl.theStroke(pen_width.getValue());
                }
            }
        });
        // give the start button an action listener that will check
        // all the text fields, cap style, join style, and shape selected,
        // then send it to the canvas to be drawn.
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == start) {
                    if (!clicky.getState()) {
                        // this is to get the text from the first text box...
                        do {
                            repeat = 1;
                            try {
                                int_1 = Integer.parseInt(textF_1.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        // ...and to repeat until there is a parsable int
                        do {
                            repeat = 1;
                            try {
                                int_2 = Integer.parseInt(textF_2.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_3 = Integer.parseInt(textF_3.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_4 = Integer.parseInt(textF_4.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_5 = Integer.parseInt(textF_5.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_6 = Integer.parseInt(textF_6.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_7 = Integer.parseInt(textF_7.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_8 = Integer.parseInt(textF_8.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                    }
                    // get other parameters like width, height
                    if ((shape_cmb.getSelectedIndex() == 1) || (shape_cmb.getSelectedIndex() == 2) || (shape_cmb.getSelectedIndex() == 3) || (shape_cmb.getSelectedIndex() == 4)) {
                        if (shape_cmb.getSelectedIndex() != 1) {
                            do {
                                repeat = 1;
                                try {
                                    int_3 = Integer.parseInt(textF_3.getText());
                                } catch (NumberFormatException n) {
                                    repeat = 0;
                                }
                            }
                            while (repeat != 1);
                            do {
                                repeat = 1;
                                try {
                                    int_4 = Integer.parseInt(textF_4.getText());
                                } catch (NumberFormatException n) {
                                    repeat = 0;
                                }
                            }
                            while (repeat != 1);

                        }
                        do {
                            repeat = 1;
                            try {
                                int_7 = Integer.parseInt(textF_7.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        }
                        while (repeat != 1);
                        do {
                            repeat = 1;
                            try {
                                int_8 = Integer.parseInt(textF_8.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        }
                        while (repeat != 1);
                        int_1 -= (int_7 / 2);
                        int_2 -= (int_8 / 2);
                    }

                    // this checks the cap style selected
                    switch (strcap_cmb.getSelectedIndex()) {
                        case 0:
                            cap_style = BasicStroke.CAP_BUTT;
                            break;
                        case 1:
                            cap_style = BasicStroke.CAP_ROUND;
                            break;
                        case 2:
                            cap_style = BasicStroke.CAP_SQUARE;
                            break;
                    }
                    // this checks the join style selected
                    switch (strjoin_cmb.getSelectedIndex()) {
                        case 0:
                            join_style = BasicStroke.JOIN_BEVEL;
                            break;
                        case 1:
                            join_style = BasicStroke.JOIN_MITER;
                            break;
                        case 2:
                            join_style = BasicStroke.JOIN_ROUND;
                            break;
                    }
                    // send all the values collected to the canvas
                                /*if(clicky.getState() && (shape_cmb.getSelectedIndex() == 2) || (shape_cmb.getSelectedIndex() == 3) || (shape_cmb.getSelectedIndex() == 3)){
                                    canv_pnl.thePainter(int_1, int_2, int_7, int_8, int_3, int_4, int_5, int_6, shape_cmb.getSelectedIndex(), pen_width.getValue(), cap_style, join_style);
                                }*/
                    canv_pnl.thePainter(int_1, int_2, int_3, int_4, int_5, int_6, int_7, int_8, shape_cmb.getSelectedIndex(), pen_width.getValue(), cap_style, join_style);
                    int_1 = -1;
                    int_2 = -1;
                    int_3 = -1;
                    int_4 = -1;
                    int_5 = -1;
                    int_6 = -1;
                    int_7 = -1;
                    int_8 = -1;
                }
            }
        });
        // give the clear button an action listener that
        // clears all text fields and the background when
        // the button is pressed
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {
                    textF_1.setText("0");
                    textF_2.setText("0");
                    textF_3.setText("0");
                    textF_4.setText("0");
                    textF_5.setText("0");
                    textF_6.setText("0");
                    textF_7.setText("0");
                    textF_8.setText("0");
                    xpos.setText("");
                    ypos.setText("");
                    int_1 = -1;
                    int_2 = -1;
                    int_3 = -1;
                    int_4 = -1;
                    int_5 = -1;
                    int_6 = -1;
                    int_7 = -1;
                    int_8 = -1;
                    // get current selected color
                    switch (bcolor_cmb.getSelectedIndex()) {
                        case 0:
                            c = Color.blue;
                            break;
                        case 1:
                            c = Color.red;
                            break;
                        case 2:
                            c = Color.black;
                            break;
                        case 3:
                            c = Color.white;
                            break;
                        case 4:
                            c = Color.cyan;
                            break;
                        case 5:
                            c = Color.gray;
                            break;
                        case 6:
                            c = Color.orange;
                            break;
                        case 7:
                            c = Color.magenta;
                            break;
                        case 8:
                            c = Color.green;
                            break;
                        case 9:
                            c = Color.yellow;
                            break;
                    }
                    // ensures the background is cleared
                    canv_pnl.setBackground(Color.white);
                    canv_pnl.setBackground(Color.black);
                    // sets the background to the selected color
                    canv_pnl.setBackground(c);
                }
            }
        });
        // give the forecolor combo box and action listener to...
        fcolor_cmb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ...make sure the same forecolor and backcolor are not selected...
                if ((fcolor_cmb.getSelectedIndex() == 9) && (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex())) {
                    bcolor_cmb.setSelectedIndex(8);
                } else if (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex()) {
                    bcolor_cmb.setSelectedIndex((bcolor_cmb.getSelectedIndex()) + 1);
                }
                // ...find the currently selected forecolor...
                switch (fcolor_cmb.getSelectedIndex()) {
                    case 0:
                        c = Color.blue;
                        break;
                    case 1:
                        c = Color.red;
                        break;
                    case 2:
                        c = Color.black;
                        break;
                    case 3:
                        c = Color.white;
                        break;
                    case 4:
                        c = Color.cyan;
                        break;
                    case 5:
                        c = Color.gray;
                        break;
                    case 6:
                        c = Color.orange;
                        break;
                    case 7:
                        c = Color.magenta;
                        break;
                    case 8:
                        c = Color.green;
                        break;
                    case 9:
                        c = Color.yellow;
                        break;
                }
                switch (bcolor_cmb.getSelectedIndex()) {
                    case 0:
                        b = Color.blue;
                        break;
                    case 1:
                        b = Color.red;
                        break;
                    case 2:
                        b = Color.black;
                        break;
                    case 3:
                        b = Color.white;
                        break;
                    case 4:
                        b = Color.cyan;
                        break;
                    case 5:
                        b = Color.gray;
                        break;
                    case 6:
                        b = Color.orange;
                        break;
                    case 7:
                        b = Color.magenta;
                        break;
                    case 8:
                        b = Color.green;
                        break;
                    case 9:
                        b = Color.yellow;
                        break;
                }
                // ...and send that color to the canvas to be used in drawing
                canv_pnl.theColor(c, b);
            }
        });
        // give the backcolor combo box and action listener that will...
        bcolor_cmb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ...make sure the same forecolor and backcolor are not selected...
                if ((fcolor_cmb.getSelectedIndex() == 9) && (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex())) {
                    fcolor_cmb.setSelectedIndex(8);
                } else if (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex()) {
                    fcolor_cmb.setSelectedIndex((fcolor_cmb.getSelectedIndex()) + 1);
                }
                // ...find the currently selected backcolor...
                switch (bcolor_cmb.getSelectedIndex()) {
                    case 0:
                        c = Color.blue;
                        break;
                    case 1:
                        c = Color.red;
                        break;
                    case 2:
                        c = Color.black;
                        break;
                    case 3:
                        c = Color.white;
                        break;
                    case 4:
                        c = Color.cyan;
                        break;
                    case 5:
                        c = Color.gray;
                        break;
                    case 6:
                        c = Color.orange;
                        break;
                    case 7:
                        c = Color.magenta;
                        break;
                    case 8:
                        c = Color.green;
                        break;
                    case 9:
                        c = Color.yellow;
                        break;
                }
                switch (fcolor_cmb.getSelectedIndex()) {
                    case 0:
                        b = Color.blue;
                        break;
                    case 1:
                        b = Color.red;
                        break;
                    case 2:
                        b = Color.black;
                        break;
                    case 3:
                        b = Color.white;
                        break;
                    case 4:
                        b = Color.cyan;
                        break;
                    case 5:
                        b = Color.gray;
                        break;
                    case 6:
                        b = Color.orange;
                        break;
                    case 7:
                        b = Color.magenta;
                        break;
                    case 8:
                        b = Color.green;
                        break;
                    case 9:
                        b = Color.yellow;
                        break;
                }
                // ...and set the canvas background to that color
                canv_pnl.setBackground(c);
                canv_pnl.theColor(b, c);
            }
        });
        // give the shape combo box an action listner that will dynamically
        // change the labels of the text fields and which text fields are
        // enabled according to the shape selected
        shape_cmb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // the rectangle
                if (shape_cmb.getSelectedIndex() == 0) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.disable();
                    textF_8.disable();
                    l_newx.setText("X1: ");
                    l_newy.setText("Y1: ");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("N/A");
                    l_height.setText("N/A");
                }
                // the oval
                if (shape_cmb.getSelectedIndex() == 1) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.disable();
                    textF_4.disable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.enable();
                    textF_8.enable();
                    l_newx.setText("N/A");
                    l_newy.setText("N/A");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("Width: ");
                    l_height.setText("Height: ");
                }
                // the Open Arc
                if (shape_cmb.getSelectedIndex() == 2) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.enable();
                    textF_8.enable();
                    l_newx.setText("Start Angle: ");
                    l_newy.setText("End Angle: ");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("Width: ");
                    l_height.setText("Height: ");
                }
                // the Chord Arc
                if (shape_cmb.getSelectedIndex() == 3) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.enable();
                    textF_8.enable();
                    l_newx.setText("Start Angle: ");
                    l_newy.setText("End Angle: ");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("Width: ");
                    l_height.setText("Height: ");
                }
                // the Pie Arc
                if (shape_cmb.getSelectedIndex() == 4) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.enable();
                    textF_8.enable();
                    l_newx.setText("Start Angle: ");
                    l_newy.setText("End Angle: ");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("Width: ");
                    l_height.setText("Height: ");
                }
                // the QuadCurve
                if (shape_cmb.getSelectedIndex() == 5) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.enable();
                    textF_6.enable();
                    textF_7.disable();
                    textF_8.disable();
                    l_newx.setText("X1: ");
                    l_newy.setText("Y1: ");
                    l_ctrlx.setText("Ctrl X: ");
                    l_ctrly.setText("Ctrl Y: ");
                    l_width.setText("N/A");
                    l_height.setText("N/A");
                }
                // the CubicCurve
                if (shape_cmb.getSelectedIndex() == 6) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.enable();
                    textF_6.enable();
                    textF_7.enable();
                    textF_8.enable();
                    l_newx.setText("X1: ");
                    l_newy.setText("Y1: ");
                    l_ctrlx.setText("Ctrl X: ");
                    l_ctrly.setText("Ctrl Y: ");
                    l_width.setText("Ctrl2 X: ");
                    l_height.setText("Ctrl2 Y: ");
                }
                if (shape_cmb.getSelectedIndex() == 7) {
                    textF_1.enable();
                    textF_2.enable();
                    textF_3.enable();
                    textF_4.enable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.disable();
                    textF_8.disable();
                    l_newx.setText("X1: ");
                    l_newy.setText("Y1: ");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("N/A");
                    l_height.setText("N/A");
                }
            }
        });
        // change the cursor when the user mouses over this component
        fcolor_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == fcolor_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    fcolor_cmb.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        bcolor_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == bcolor_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    bcolor_cmb.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        shape_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == shape_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    shape_cmb.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        strcap_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == strcap_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    strcap_cmb.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        strjoin_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == strjoin_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    strjoin_cmb.setCursor(the_cursor);
                }
            }
        });
        style_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == style_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    style_cmb.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        start_clear.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == start_clear) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    start.setCursor(the_cursor);
                    clear.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        slider_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == slider_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    pen_width.setCursor(the_cursor);
                    draw.setCursor(the_cursor);
                }
            }
        });
        // change the cursor when the user mouses over this component
        eraser_pnl.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (e.getSource() == eraser_pnl) {
                    Cursor the_cursor = new Cursor(Cursor.HAND_CURSOR);
                    eraser.setCursor(the_cursor);
                    clicky.setCursor(the_cursor);
                }
            }
        });
        subPanel.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                if (clicky.getState()) {
                    textF_1.disable();
                    textF_2.disable();
                    textF_3.disable();
                    textF_4.disable();
                    textF_5.disable();
                    textF_6.disable();
                    textF_7.disable();
                    textF_8.disable();
                    l_oldx.setText("N/A");
                    l_oldy.setText("N/A");
                    l_newx.setText("N/A");
                    l_newy.setText("N/A");
                    l_ctrlx.setText("N/A");
                    l_ctrly.setText("N/A");
                    l_width.setText("N/A");
                    l_height.setText("N/A");
                } else {
                    // the rectangle
                    if (shape_cmb.getSelectedIndex() == 0) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.disable();
                        textF_6.disable();
                        textF_7.disable();
                        textF_8.disable();
                        l_newx.setText("X1: ");
                        l_newy.setText("Y1: ");
                        l_ctrlx.setText("N/A");
                        l_ctrly.setText("N/A");
                        l_width.setText("N/A");
                        l_height.setText("N/A");
                    }
                    // the oval
                    if (shape_cmb.getSelectedIndex() == 1) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.disable();
                        textF_4.disable();
                        textF_5.disable();
                        textF_6.disable();
                        textF_7.enable();
                        textF_8.enable();
                        l_newx.setText("N/A");
                        l_newy.setText("N/A");
                        l_ctrlx.setText("N/A");
                        l_ctrly.setText("N/A");
                        l_width.setText("Width: ");
                        l_height.setText("Height: ");
                    }
                    // the Open Arc
                    if (shape_cmb.getSelectedIndex() == 2) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.disable();
                        textF_6.disable();
                        textF_7.enable();
                        textF_8.enable();
                        l_newx.setText("Start Angle: ");
                        l_newy.setText("End Angle: ");
                        l_ctrlx.setText("N/A");
                        l_ctrly.setText("N/A");
                        l_width.setText("Width: ");
                        l_height.setText("Height: ");
                    }
                    // the Chord Arc
                    if (shape_cmb.getSelectedIndex() == 3) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.disable();
                        textF_6.disable();
                        textF_7.enable();
                        textF_8.enable();
                        l_newx.setText("Start Angle: ");
                        l_newy.setText("End Angle: ");
                        l_ctrlx.setText("N/A");
                        l_ctrly.setText("N/A");
                        l_width.setText("Width: ");
                        l_height.setText("Height: ");
                    }
                    // the Pie Arc
                    if (shape_cmb.getSelectedIndex() == 4) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.disable();
                        textF_6.disable();
                        textF_7.enable();
                        textF_8.enable();
                        l_newx.setText("Start Angle: ");
                        l_newy.setText("End Angle: ");
                        l_ctrlx.setText("N/A");
                        l_ctrly.setText("N/A");
                        l_width.setText("Width: ");
                        l_height.setText("Height: ");
                    }
                    // the QuadCurve
                    if (shape_cmb.getSelectedIndex() == 5) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.enable();
                        textF_6.enable();
                        textF_7.disable();
                        textF_8.disable();
                        l_newx.setText("X1: ");
                        l_newy.setText("Y1: ");
                        l_ctrlx.setText("Ctrl X: ");
                        l_ctrly.setText("Ctrl Y: ");
                        l_width.setText("N/A");
                        l_height.setText("N/A");
                    }
                    // the CubicCurve
                    if (shape_cmb.getSelectedIndex() == 6) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.enable();
                        textF_6.enable();
                        textF_7.enable();
                        textF_8.enable();
                        l_newx.setText("X1: ");
                        l_newy.setText("Y1: ");
                        l_ctrlx.setText("Ctrl X: ");
                        l_ctrly.setText("Ctrl Y: ");
                        l_width.setText("Ctrl2 X: ");
                        l_height.setText("Ctrl2 Y: ");
                    }
                    if (shape_cmb.getSelectedIndex() == 7) {
                        textF_1.enable();
                        textF_2.enable();
                        textF_3.enable();
                        textF_4.enable();
                        textF_5.disable();
                        textF_6.disable();
                        textF_7.disable();
                        textF_8.disable();
                        l_newx.setText("X1: ");
                        l_newy.setText("Y1: ");
                        l_ctrlx.setText("N/A");
                        l_ctrly.setText("N/A");
                        l_width.setText("N/A");
                        l_height.setText("N/A");
                    }
                }
            }
        });
    }

    // the drawing canvas class
    class TheCanvas extends JPanel implements MouseListener, MouseMotionListener {
        int old_x, old_y, new_x, new_y, counter, the_stroke;
        Color forecolor, backcolor;

        // default constructor
        public TheCanvas(Color f, Color b) {
            forecolor = f;
            backcolor = b;
            this.addMouseListener(this);        // add a mouselistener to the canvas
            this.addMouseMotionListener(this);  // add a mousemotionlistener to the canvas
            this.setBackground(backcolor);      // set the initial background color
        }

        // the painting function which draws all the shapes
        public void thePainter(int one, int two, int three, int four, int five, int six, int seven, int eight, int shape, int pen_width, int cap, int join) {
            Arc2D open_arc, chord_arc, pie_arc;
            CubicCurve2D cubic_curve;
            QuadCurve2D quad_curve;
            // create a graphics object to draw with
            Graphics g = this.getGraphics();
            // create a graphics2d object to draw shapes
            Graphics2D g2D = (Graphics2D) g;
            // give the drawing tool a stroke (thickness)
            BasicStroke pen_stroke = new BasicStroke(pen_width, cap, join);
            // set the stroke of the drawing tool
            g2D.setStroke(pen_stroke);
            g.setColor(forecolor);
            // draws Rect
            if (shape == 0) {
                g.drawLine(one, two, three, two);
                g.drawLine(one, two, one, four);
                g.drawLine(three, two, three, four);
                g.drawLine(one, four, three, four);
            }
            // draws Oval
            if (shape == 1) {
                g.drawOval(one, two, seven, eight);
            }
            // draws Arc2D Open
            if (shape == 2) {
                open_arc = new Arc2D.Float(one, two, seven, eight, three, four, Arc2D.OPEN);
                g2D.draw(open_arc);
            }
            // draws Arc2D Chord
            if (shape == 3) {
                chord_arc = new Arc2D.Float(one, two, seven, eight, three, four, Arc2D.CHORD);
                g2D.draw(chord_arc);
            }
            // draws Arc2D Pie
            if (shape == 4) {
                pie_arc = new Arc2D.Float(one, two, seven, eight, three, four, Arc2D.PIE);
                g2D.draw(pie_arc);
            }
            // draws QuadCurve2D
            if (shape == 5) {
                quad_curve = new QuadCurve2D.Float(one, two, five, six, three, four);
                g2D.draw(quad_curve);
            }
            // draws CubicCurve2D
            if (shape == 6) {
                cubic_curve = new CubicCurve2D.Float((float) (one), (float) (two), (float) (five), (float) (six), (float) (seven), (float) (eight), (float) (three), (float) (four));
                g2D.draw(cubic_curve);
            }
            // draws a Line
            if (shape == 7) {
                g.drawLine(one, two, three, four);
            }
        }

        // function that sets the forecolor of the drawing tool when sent a color from init
        public void theColor(Color f, Color b) {
            forecolor = f;
            backcolor = b;
        }

        // function that sets the stroke size of the drawing tool when sent a size from init
        public void theStroke(int a_stroke) {
            the_stroke = a_stroke;
        }

        // fuction that sets the backcolor of the canvas when sent a color from init
        // - not used in the program
        public void setBG(Color b) {
            backcolor = b;
            this.setBackground(backcolor);
        }

        // grabs the initial position where the mouse is clicked
        public void mouseClicked(MouseEvent e) {
            old_x = e.getX();
            old_y = e.getY();
        }

        /*
        public int theX(int x){
            return x;
        }
        public int theY(int y){
            return y;
        }*/
        // prevents the "random line drawing" by resetting the values if the mouse is clicked again
        public void mousePressed(MouseEvent e) {
            boolean set2 = false, set3 = false, set4 = false;
            old_x = e.getX();
            old_y = e.getY();
            new_x = e.getX();
            new_y = e.getY();
            switch (shape_cmb.getSelectedIndex()) {
                case 0:
                    set2 = true;
                    set3 = false;
                    set4 = false;
                    break;
                case 1:
                    set2 = false;
                    set3 = false;
                    set4 = false;
                    break;
                case 2:
                    set2 = false;
                    set3 = false;
                    set4 = false;
                    break;
                case 3:
                    set2 = false;
                    set3 = false;
                    set4 = false;
                    break;
                case 4:
                    set2 = false;
                    set3 = false;
                    set4 = false;
                    break;
                case 5:
                    set2 = true;
                    set3 = true;
                    set4 = false;
                    break;
                case 6:
                    set2 = true;
                    set3 = true;
                    set4 = true;
                    break;
                case 7:
                    set2 = true;
                    set3 = false;
                    set4 = false;
                    break;
            }
            if (int_1 == -1) {
                int_1 = old_x;
                int_2 = old_y;
            } else if (set2 && (int_3 == -1)) {
                int_3 = old_x;
                int_4 = old_y;
            } else if (set3 && (int_5 == -1)) {
                int_5 = old_x;
                int_6 = old_y;
            } else if (set4 && (int_7 == -1)) {
                int_7 = old_x;
                int_8 = old_y;
            }
        }

        // draws lines or ovals over the pixels grabbed from previous functions
        public void mouseDragged(MouseEvent e) {
            // give the function a graphics object to draw with
            Graphics g = this.getGraphics();
            // give the function a graphics2d object in order to set a penstroke
            Graphics2D g2D = (Graphics2D) g;
            // set a basicstroke size using the value passed to the canvas
            BasicStroke pen_stroke = new BasicStroke(the_stroke);
            // give the drawing tool a stroke size to draw with
            g2D.setStroke(pen_stroke);
            new_x = e.getX();
            new_y = e.getY();
            if (!eraser.getState() && !clicky.getState()) {
                g.setColor(forecolor);
                // draws either lines or oval, depending on which is chosen in the combo box
                switch (style_cmb.getSelectedIndex()) {
                    case 1:
                        g.drawLine(old_x, old_y, new_x, new_y);
                        break;
                    case 0:
                        g.fillOval(old_x, old_y, pen_width.getValue(), pen_width.getValue());
                        break;
                }
            }
            // the eraser
            else if (!clicky.getState()) {
                g.setColor(backcolor);
                switch (style_cmb.getSelectedIndex()) {
                    case 1:
                        g.drawLine(old_x, old_y, new_x, new_y);
                        break;
                    case 0:
                        g.fillOval(old_x, old_y, pen_width.getValue(), pen_width.getValue());
                        break;
                }
            }
            old_x = new_x;
            old_y = new_y;
            // used to track the mouse position
            if ((new_x >= 0) && (new_x <= 699) && (new_y >= 0) && (new_y <= 249)) {
                xpos.enable();
                ypos.enable();
                xpos.setText(Integer.toString(new_x));
                ypos.setText(Integer.toString(new_y));
            } else {
                xpos.disable();
                ypos.disable();
                xpos.setText("");
                ypos.setText("");
            }
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        // disables mouse position boxes when mouse is lifted
        public void mouseReleased(MouseEvent e) {
            xpos.disable();
            ypos.disable();
            xpos.setText("");
            ypos.setText("");
        }

        // sets the cursor to crosshair when mouse is over canvas
        public void mouseMoved(MouseEvent e) {
            if (e.getSource() == canv_pnl) {
                Cursor the_cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
                this.setCursor(the_cursor);
            }
        }
    }
}
