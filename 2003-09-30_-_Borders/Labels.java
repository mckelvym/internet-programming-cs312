// gridlayout
// JLabel label = new JLabel
// GridBagLayout

import java.awt.*;
import java.applet.*;
import javax.swing.plaf.*;
import javax.swing.*;
import java.awt.event.*;

public class Labels extends Applet implements ActionListener {

    //JLabel label1, label2, label3, label4;
    JPanel mainPanel, selection, images;
    JComboBox combo1;
    TitledBorder title1, title2;
    String[] str = {"Sports", "Eating Rice", "Sleeping", "Party Animal"};
    ImageIcon[] image;
    int i;

    public void init() {

        for (i = 0; i < 4; i++) {
            //pic[j] = this.getImage(this.getDocumentBase(), this.getParameter(Integer.toString(j)));
            image[i] = new ImageIcon(this.getDocumentBase(), this.getParameter(Integer.toString(i)));
        }
        combo1 = new JComboBox(str);
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
