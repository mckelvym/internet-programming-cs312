// JLabel label = new JLabel


import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.*;

public class Drawcanvas extends JApplet {

    JButton clear, start;
    JLabel l_oldx, l_oldy, l_newx, l_newy, l_ctrlx, l_ctrly, l_width, l_height;
    JSlider pen_width;
    Graphics g;
    Graphics2D g2D = (Graphics2D) g;
    Color c;
    JPanel mainPanel, subPanel, textPanel, start_clear, slider_pnl, fcolor_pnl, shape_pnl, bcolor_pnl, strcap_pnl, strjoin_pnl;
    JComboBox fcolor_cmb, shape_cmb, bcolor_cmb, strcap_cmb, strjoin_cmb;
    TitledBorder start_clear_t, slider_t, text_t, fcolor_t, shape_t, bcolor_t, strcap_t, strjoin_t, canvas_t;
    String[] fcolor_str = {"Blue", "Red", "Black", "White", "Cyan", "Gray", "Orange", "Magenta", "Green", "Yellow"};
    String[] shape_str = {"Rectangle", "Oval", "Arc 2D Open", "Arc 2D Closed", "Arc 2D Pie", "QuadCurve 2D", "CubicCurve 2D"};
    String[] bcolor_str = {"Blue", "Red", "Black", "White", "Cyan", "Gray", "Orange", "Magenta", "Green", "Yellow"};
    String[] strcap_str = {"Butt", "Round", "Square"};
    String[] strjoin_str = {"Bevel", "Miter", "Round"};
    String arc_style;
    int old_x, old_y, new_x, new_y;
    Arc2D open_arc, closed_arc, pie_arc;
    CubicCurve2D cubic_curve;
    QuadCurve2D quad_curve;
    JTextField textF_1, textF_2, textF_3, textF_4, textF_5, textF_6, textF_7, textF_8;
    int int_1, int_2, int_3, int_4, int_5, int_6, int_7, int_8, repeat;
    BasicStroke the_stroke;

    Canv canv_pnl; // Canv

    public void init() {
        canv_pnl = new Canv(Color.blue, Color.white); // create a new canvas // Canv

        /* To construct the shapes
        open_arc = new Arc2D.Float(float x, float y, float w, float h, float start, float extent, Arc2D.OPEN)
        cubic_curve = new CubicCurve2D.Float(float x1, float y1, float ctrlx1, float ctrly1, float ctrlx2, float ctrly2, float x2, float y2)
        quad_curve = new QuadCurve2D.Float(float x1, float y1, float ctrlx, float ctrly, float x2, float y2)
        */
        fcolor_cmb = new JComboBox(fcolor_str);    // create combo boxes
        shape_cmb = new JComboBox(shape_str);
        bcolor_cmb = new JComboBox(bcolor_str);
        strcap_cmb = new JComboBox(strcap_str);
        strjoin_cmb = new JComboBox(strjoin_str);

        mainPanel = new JPanel(); // create new panels
        subPanel = new JPanel();
        textPanel = new JPanel();
        fcolor_pnl = new JPanel();
        shape_pnl = new JPanel();
        bcolor_pnl = new JPanel();
        //canv_pnl = new JPanel();
        start_clear = new JPanel();
        slider_pnl = new JPanel();
        strcap_pnl = new JPanel();
        strjoin_pnl = new JPanel();

        // create text fields
        textF_1 = new JTextField(3);
        textF_2 = new JTextField(3);
        textF_3 = new JTextField(3);
        textF_4 = new JTextField(3);
        textF_5 = new JTextField(3);
        textF_6 = new JTextField(3);
        textF_7 = new JTextField(3);
        textF_8 = new JTextField(3);

        // create labels for text fields
        l_oldx = new JLabel("X: ");
        l_oldy = new JLabel("Y: ");
        l_newx = new JLabel("X1: ");
        l_newy = new JLabel("Y1: ");
        l_ctrlx = new JLabel("N/A");
        l_ctrly = new JLabel("N/A");
        l_width = new JLabel("N/A");
        l_height = new JLabel("N/A");

        // make text boxes enabled/disabled for startup
        textF_5.disable();
        textF_6.disable();
        textF_7.disable();
        textF_8.disable();

        // set default options
        fcolor_cmb.setSelectedIndex(0);
        bcolor_cmb.setSelectedIndex(3);
        shape_cmb.setSelectedIndex(0);
        strcap_cmb.setSelectedIndex(0);
        strjoin_cmb.setSelectedIndex(0);

        // create and caption buttons
        clear = new JButton("Clear");
        start = new JButton("Start");

        // create the JSlider
        pen_width = new JSlider(JSlider.HORIZONTAL, 1, 10, 3);
        pen_width.setMajorTickSpacing(1);
        pen_width.setPaintTicks(true);
        pen_width.setPaintLabels(true);
        pen_width.setSnapToTicks(true);

        this.getContentPane().setLayout(new GridLayout(2, 1, 5, 5)); // create grid with 2 rows and 1 column with border spacing of 5

        start_clear_t = BorderFactory.createTitledBorder("Commands");
        slider_t = BorderFactory.createTitledBorder("Pen Width");
        text_t = BorderFactory.createTitledBorder("Coordinates");
        fcolor_t = BorderFactory.createTitledBorder("Fore Color"); // set border titles
        shape_t = BorderFactory.createTitledBorder("Draw Shape");
        bcolor_t = BorderFactory.createTitledBorder("Back Color");
        canvas_t = BorderFactory.createTitledBorder("Drawing Area");
        strcap_t = BorderFactory.createTitledBorder("Cap Style");
        strjoin_t = BorderFactory.createTitledBorder("Join Style");

        canv_pnl.setBorder(BorderFactory.createCompoundBorder(canvas_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        textPanel.setBorder(BorderFactory.createCompoundBorder(text_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        fcolor_pnl.setBorder(BorderFactory.createCompoundBorder(fcolor_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        shape_pnl.setBorder(BorderFactory.createCompoundBorder(shape_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        bcolor_pnl.setBorder(BorderFactory.createCompoundBorder(bcolor_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        slider_pnl.setBorder(BorderFactory.createCompoundBorder(slider_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        start_clear.setBorder(BorderFactory.createCompoundBorder(start_clear_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        strcap_pnl.setBorder(BorderFactory.createCompoundBorder(strcap_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        strjoin_pnl.setBorder(BorderFactory.createCompoundBorder(strjoin_t, BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        // add panels to japplet
        this.getContentPane().add(subPanel);
        this.getContentPane().add(canv_pnl);
        subPanel.add(fcolor_pnl);
        fcolor_pnl.add(fcolor_cmb);
        subPanel.add(bcolor_pnl);
        bcolor_pnl.add(bcolor_cmb);
        subPanel.add(shape_pnl);
        shape_pnl.add(shape_cmb);
        subPanel.add(strcap_pnl);
        strcap_pnl.add(strcap_cmb);
        subPanel.add(strjoin_pnl);
        strjoin_pnl.add(strjoin_cmb);
        subPanel.add(textPanel);
        textPanel.add(l_oldx);
        textPanel.add(textF_1);
        textPanel.add(l_oldy);
        textPanel.add(textF_2);
        textPanel.add(l_newx);
        textPanel.add(textF_3);
        textPanel.add(l_newy);
        textPanel.add(textF_4);
        textPanel.add(l_ctrlx);
        textPanel.add(textF_5);
        textPanel.add(l_ctrly);
        textPanel.add(textF_6);
        textPanel.add(l_width);
        textPanel.add(textF_7);
        textPanel.add(l_height);
        textPanel.add(textF_8);
        subPanel.add(start_clear);
        start_clear.add(start);
        start_clear.add(clear);
        subPanel.add(slider_pnl);
        slider_pnl.add(pen_width);
        //mainPanel.add(canv_pnl);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == start) {
                    // draws a Rect
                    if (shape_cmb.getSelectedIndex() == 0) {
                        // this is to get the text from the first text box...
                        repeat = 1;
                        do {
                            try {
                                int_1 = Integer.parseInt(textF_1.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        // ...and to repeat until there is a parsable int
                        repeat = 1;
                        do {
                            try {
                                int_2 = Integer.parseInt(textF_2.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        repeat = 1;
                        do {
                            try {
                                int_3 = Integer.parseInt(textF_3.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);
                        repeat = 1;
                        do {
                            try {
                                int_4 = Integer.parseInt(textF_4.getText());
                            } catch (NumberFormatException n) {
                                repeat = 0;
                            }
                        } while (repeat != 1);

                        g.setColor(Color.blue);
                        g.drawRect(int_1, int_2, int_3, int_4);
                    }
                    // draws an Oval
                    if (shape_cmb.getSelectedIndex() == 1) {
                    }
                    // draws Arc2D Open
                    if (shape_cmb.getSelectedIndex() == 2) {
                    }
                    // draws Arc2D Closed
                    if (shape_cmb.getSelectedIndex() == 3) {
                    }
                    // draws Arc2D Pie
                    if (shape_cmb.getSelectedIndex() == 4) {
                    }
                    // draws QuadCurve2D
                    if (shape_cmb.getSelectedIndex() == 5) {
                    }
                    // draws CubicCurve2D
                    if (shape_cmb.getSelectedIndex() == 6) {
                    }
                }
            }
        });

        // clears background when button is pressed
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {
                    textF_1.setText("");
                    textF_2.setText("");
                    textF_3.setText("");
                    textF_4.setText("");
                    textF_5.setText("");
                    textF_6.setText("");
                    textF_7.setText("");
                    textF_8.setText("");
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
                    //canv_pnl.setBackground(Color.white);
                    //canv_pnl.setBG(c);
                }
            }
        });
        // to check if colors are the same
        fcolor_cmb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((fcolor_cmb.getSelectedIndex() == 9) && (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex())) {
                    bcolor_cmb.setSelectedIndex(8);
                } else if (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex()) {
                    bcolor_cmb.setSelectedIndex((bcolor_cmb.getSelectedIndex()) + 1);
                }
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
                canv_pnl.theColor(c);
            }
        });
        bcolor_cmb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((fcolor_cmb.getSelectedIndex() == 9) && (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex())) {
                    fcolor_cmb.setSelectedIndex(8);
                } else if (fcolor_cmb.getSelectedIndex() == bcolor_cmb.getSelectedIndex()) {
                    fcolor_cmb.setSelectedIndex((fcolor_cmb.getSelectedIndex()) + 1);
                }
            }
        });

        // start here
        shape_cmb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                    arc_style = "Arc2D.OPEN";
                }
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
                    arc_style = "Arc2D.CHORD";
                }
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
                    arc_style = "Arc2D.PIE";
                }
                if (shape_cmb.getSelectedIndex() == 6) {
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
                if (shape_cmb.getSelectedIndex() == 5) {
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
            }
        });
    }

    class Canv extends JPanel implements MouseListener, MouseMotionListener {
        int old_x, old_y, new_x, new_y;
        Color the_color, b_color;

        public Canv(Color c, Color d) {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            the_color = c;
            b_color = d;
            this.setBackground(b_color);
        }

        public void theColor(Color c) {
            the_color = c;
        }

        public void setBG(Color c) {
            b_color = c;
            this.setBackground(b_color);
        }

        public void paint(Graphics g) {
            this.setBackground(b_color);
        }

        public void mouseClicked(MouseEvent e) {
            old_x = e.getX();
            old_y = e.getY();
        }

        public void mouseDragged(MouseEvent e) {
            new_x = e.getX();
            new_y = e.getY();
            Graphics g = this.getGraphics();
            g.setColor(the_color);
            g.drawLine(old_x, old_y, new_x, new_y);
            old_x = new_x;
            old_y = new_y;
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
        }
    }
}
