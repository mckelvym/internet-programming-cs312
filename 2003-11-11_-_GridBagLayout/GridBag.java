// mark mckelvy
// internet programming 9:30
// november 12, 2003

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;

public class GridBag extends JApplet {

    JButton b1, b2, b3, b4, b5, badd;
    JTextArea a1, a2, all;
    GridBagLayout layout;
    GridBagConstraints constraints;

    public void init() {
        b1 = new JButton("Clear 1");
        b2 = new JButton("Clear Both");
        b3 = new JButton("Clear 2");
        b4 = new JButton("B4");
        b5 = new JButton("B5");
        badd = new JButton("Add");
        a1 = new JTextArea();
        a2 = new JTextArea();
        all = new JTextArea();
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        this.getContentPane().setLayout(layout);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        layout.setConstraints(b1, constraints);
        this.getContentPane().add(b1);
        constraints.gridx = 1;
        layout.setConstraints(b2, constraints);
        this.getContentPane().add(b2);
        constraints.gridx = 2;
        layout.setConstraints(b3, constraints);
        this.getContentPane().add(b3);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        layout.setConstraints(a1, constraints);
        this.getContentPane().add(a1);
        constraints.gridx = 1;
        constraints.gridheight = 1;
        layout.setConstraints(b4, constraints);
        this.getContentPane().add(b4);
        constraints.gridy = 2;
        layout.setConstraints(b5, constraints);
        this.getContentPane().add(b5);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        layout.setConstraints(a2, constraints);
        this.getContentPane().add(a2);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        layout.setConstraints(badd, constraints);
        this.getContentPane().add(badd);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        constraints.gridheight = 2;
        layout.setConstraints(all, constraints);
        this.getContentPane().add(all);
        a1.setWrapStyleWord(true);
        a1.setTabSize(4);
        a1.setLineWrap(true);
        a2.setWrapStyleWord(true);
        a2.setTabSize(4);
        a2.setLineWrap(true);
        all.setRows(5);
        all.setWrapStyleWord(true);
        all.setTabSize(4);
        all.setLineWrap(true);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    a1.copy();
                    a1.setText("");
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    a1.paste();
                    a2.paste();
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    a2.copy();
                    a2.setText("");
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    a1.selectAll();
                }
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    a2.selectAll();
                }
            }
        });

        badd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == badd) {
                    all.setText(a1.getText() + " " + a2.getText());
                }
            }
        });

    }
}
