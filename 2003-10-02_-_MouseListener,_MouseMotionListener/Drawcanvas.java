// gridlayout
// JLabel label = new JLabel
// clear button

// g.setColor(the_canvas.getBackground()); to clear canvas

import java.awt.*;
import java.applet.*;
import javax.swing.plaf.*;
import javax.swing.*;
import java.awt.event.*;

public class Drawcanvas extends Applet implements ActionListener {

    JButton clear;
    JPanel mainPanel, subPanel, fcolor_pnl, shape_pnl, bcolor_pnl, canv_pnl;
    JComboBox fcolor_cmb, shape_cmb, bcolor_cmb;
    TitledBorder fcolor_t, shape_t, bcolor_t, canvas_t;
    ;
    String[] fcolor_str = {"Blue", "Red", "Black", "Green"};
    String[] shape_str = {"Rectangle", "Oval", "", ""};
    String[] bcolor_str = {"Blue", "Red", "Black", "Green"};
    int old_x, old_y, new_x, new_y;
    Canv the_canvas;

    public void init() {
        the_canvas = new Canv();

        fcolor_cmb = new JComboBox(fcolor_str);
        shape_cmb = new JComboBox(shape_str);
        bcolor_cmb = new JComboBox(bcolor_str);

        mainPanel = new JPanel();
        subPanel = new JPanel();
        fcolor_pnl = new JPanel();
        shape_pnl = new JPanel();
        bcolor_pnl = new JPanel();
        canv_pnl = new JPanel();

        this.setLayout(new GridLayout(2, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        fcolor_t = BorderFactory.createTitledBorder("Fore-Color");
        shape_t = BorderFactory.createTitledBorder("Create Shape");
        bcolor_t = BorderFactory.createTitledBorder("Back-Color");
        canvas_t = BorderFactory.createTitledBorder("Canvas");

        canv_pnl.setBorder(createCompoundBorder(canvas_t, BorderFactory.createEmptryBorder(3, 3, 3, 3)));
    /fcolor_pnl.setBorder();

        mainPanel.add(subPanel);
        mainPanel.add(canv_pnl);
        subPanel.add(fcolor_pnl);
        subPanel.add(shape_pnl);
        subPanel.add(bcolor_pnl);

        selection.setBorder(createCompoundBorder(title1, BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        images.setBorder(createCompoundBorder(title2, BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        mainPanel.add(selection);
        mainPanel.add(images);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == combo1.getSelectedItem()) {
            // images.repaint(); // or draw Icons on panel2 using setIcon
            images.setIcon(image[combo1.getSelectedIndex()]);
        }
    }
}

class Canv extends JPanel implements MouseListener, MouseMotionListener {
    int old_x, old_y, new_x, new_y;
    Color the_color;

    public Canv(Color c) {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        the_color = c;
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
