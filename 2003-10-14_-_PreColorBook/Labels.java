// gridlayout
// JLabel label = new JLabel
// GridBagLayout

import java.awt.*;
import java.applet.*;
import javax.swing.plaf.*;
import javax.swing.*;
import java.awt.event.*;

public class Drawcanvas extends Applet implements MouseListener, MouseMotionListener {

    JPanel mainPanel, fcolor_sel, shape_sel, bcolor_sel, canv;
    JComboBox fcolor_cmb, bcolor_cmb;
    TitledBorder fcolor_t, shape_t, bcolor_t, canvas_t;
    ;
    String[] fcolor = {"Blue", "Red", "Black", "Green"};
    String[] shape = {"Square", "Oval", "...", "..."};
    String[] bcolor = {"
    int old_x, old_y, new_x, new_y;

    public void init() {
        canv.addMouseListener(this);

        fcolor_cmb = new JComboBox(str);
        mainPanel = new JPanel();
        selection = new JPanel();
        images = new JPanel();
        this.setLayout(new GridLayout(4, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        title1 = BorderFactory.createTitledBorder("Hobby");
        selection.setBorder(createCompoundBorder(title1, BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        title2 = BorderFactory.createTitledBorder("Picture");
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

class Canv extends JPanel implements MouseListener {
    this.

    addMouseListener(this);
}
