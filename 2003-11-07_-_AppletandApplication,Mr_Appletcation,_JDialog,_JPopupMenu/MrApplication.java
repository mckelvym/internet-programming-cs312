// mark mckelvy
// internet programming 9:30 tr

// make both and application and applet

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class MrApplication extends JApplet {

    ErrDialog theDialog;
    Extra helper;
    Font theFont;
    JApplet applTop, applBottom;
    JButton btnOk;
    JFrame executable;
    JLabel lblName, lblAddress, lblPassword;
    JPasswordField tfPassword;
    JTextField tfName, tfAddress;
    static boolean isApplet = true;
    UIManager look;

    public void init() {
        isApplet = true;
        MrApplication me = new MrApplication(new JFrame());
    }

    public static void main(String[] args) {
        isApplet = false;
        MrApplication me = new MrApplication(new JFrame());
    }

    public MrApplication(JFrame executable) {
        executable.show(true);
        try {
            look.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException e) {
        } catch (UnsupportedLookAndFeelException e) {
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }
        if (!isApplet) {
            executable.setTitle("Random Application");
            executable.setSize(300, 300);
            executable.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        } else {
            showStatus("The Appletcation");
        }
        executable.getContentPane().setLayout(new GridLayout(2, 1));
        // initialize objects
        helper = new Extra();
        lblName = new JLabel("Name: ");
        lblAddress = new JLabel("Address: ");
        lblPassword = new JLabel("Password: ");
        tfName = new JTextField(20);
        tfAddress = new JTextField(30);
        tfPassword = new JPasswordField(5);
        btnOk = new JButton("Ok");
        applTop = new JApplet();
        applBottom = new JApplet();
        theFont = new Font("Comic Sans MS", Font.BOLD, 12);
        tfPassword.setEchoChar('|');
        lblName.setForeground(helper.getA());
        lblAddress.setForeground(helper.getB());
        lblPassword.setForeground(helper.getC());
        tfName.setBackground(Color.yellow);
        tfAddress.setBackground(Color.yellow);
        tfPassword.setBackground(Color.yellow);
        lblName.setFont(theFont);
        lblAddress.setFont(theFont);
        lblPassword.setFont(theFont);
        btnOk.setFont(theFont);
        tfName.setFont(theFont);
        tfAddress.setFont(theFont);
        tfPassword.setFont(theFont);
        // set layout of applets
        applTop.getContentPane().setLayout(new GridLayout(3, 2));
        applBottom.getContentPane().setLayout(new GridLayout(3, 3));
        // create the menu
        executable.getContentPane().add(applTop);
        executable.getContentPane().add(applBottom);
        applTop.getContentPane().add(lblName);
        applTop.getContentPane().add(tfName);
        applTop.getContentPane().add(lblAddress);
        applTop.getContentPane().add(tfAddress);
        applTop.getContentPane().add(lblPassword);
        applTop.getContentPane().add(tfPassword);
        applBottom.getContentPane().add(btnOk);
        // add action listener to the button
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfName.getText().equals("")) {
                    theDialog = new ErrDialog("Name field blank!", "* Name *");
                    theDialog.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            theDialog.hide();
                            theDialog.dispose();
                        }
                    });
                    theDialog.show();
                } else if (tfAddress.getText().equals("")) {
                    theDialog = new ErrDialog("Address field blank!", "* Address *");
                    theDialog.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            theDialog.hide();
                            theDialog.dispose();
                        }
                    });
                    theDialog.show();
                } else if (tfPassword.getText().equals("")) {
                    theDialog = new ErrDialog("Password field blank!", "* Password *");
                    theDialog.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            theDialog.hide();
                            theDialog.dispose();
                        }
                    });
                    theDialog.show();
                } else if (tfPassword.getText().equals("face")) {//show new dialog box
                    newWindow second = new newWindow(tfName.getText(), tfAddress.getText(), tfPassword.getText());
                    second.show(true);
                } else {
                    theDialog = new ErrDialog("Wrong Password!", "* Password *");
                    theDialog.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            theDialog.hide();
                            theDialog.dispose();
                        }
                    });
                    theDialog.show();
                }
            }
        });
    }

    class binaryConvert extends JDialog {

        Font theFont;
        JButton done, toBinary, toBase10;
        JLabel center, lblBinary, lblBase10;
        JTextField binary, base10;
        String theString;

        public binaryConvert() {
            this.setTitle("Binary Converter");
            this.setSize(300, 300);
            center = new JLabel();
            this.setLocationRelativeTo(center);
            done = new JButton("Done");
            toBinary = new JButton("To Binary");
            toBase10 = new JButton("To Base 10");
            binary = new JTextField(20);
            base10 = new JTextField(20);
            lblBinary = new JLabel("Binary: ");
            lblBase10 = new JLabel("Base 10: ");
            theFont = new Font("Comic Sans MS", Font.PLAIN, 10);
            binary.setFont(theFont);
            base10.setFont(theFont);
            theFont = new Font("Comic Sans MS", Font.BOLD, 12);
            lblBinary.setFont(theFont);
            lblBase10.setFont(theFont);
            done.setFont(theFont);
            toBinary.setFont(theFont);
            toBase10.setFont(theFont);
            this.getContentPane().setLayout(new GridLayout(4, 2));
            this.getContentPane().add(lblBinary);
            this.getContentPane().add(binary);
            this.getContentPane().add(lblBase10);
            this.getContentPane().add(base10);
            this.getContentPane().add(toBase10);
            this.getContentPane().add(toBinary);
            this.getContentPane().add(done);
            done.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == done) {
                        dispose();
                    }
                }
            });
            toBinary.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == toBinary) {
                        if (base10.getText().length() == 0) {
                            base10.setText("Must enter a value!");
                            binary.setText("");
                        } else {
                            theString = base10.getText();
                            if (theString != null) {
                                try {
                                    binary.setText(Integer.toBinaryString(Integer.parseInt(theString)));
                                    base10.setText("");
                                } catch (NumberFormatException n) {
                                    base10.setText("Not an Integer!");
                                    binary.setText("");
                                }
                            }
                        }
                    }
                }
            });
            toBase10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == toBase10) {
                        if (binary.getText().length() == 0) {
                            binary.setText("Must enter a value!");
                            base10.setText("");
                        } else {
                            theString = binary.getText();
                            if (theString != null) {

                                int value = 0;
                                int number = 1;
                                int lastIndex = (theString.length() - 1);
                                boolean errString = false;

                                for (int counter = lastIndex; counter >= 0; counter--) {
                                    if (theString.charAt(counter) == '1') {
                                        value += number;
                                    } else if (theString.charAt(counter) != '0') {
                                        errString = true;
                                    }
                                    number *= 2;
                                }
                                if (!errString) {
                                    base10.setText(Integer.toString(value));
                                    binary.setText("");
                                } else {
                                    binary.setText("Not a binary string!");
                                    base10.setText("");
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    class textEditor extends JDialog {

        Font theFont;
        Graphics g;
        GridBagLayout theLayout;
        GridBagConstraints theConstraints;
        JApplet txt;
        JButton btnOk, prntAll, prntTxt;
        JFrame printFrame;
        JTextArea txtArea;
        PrintJob printer;

        public textEditor() {
            this.setTitle("Text Editor");
            this.setSize(500, 500);
            txt = new JApplet();
            printFrame = new JFrame();
            this.getContentPane().add(txt);
            //txt.getContentPane().setLayout(new GridLayout(4,1));
            btnOk = new JButton("Done");
            prntAll = new JButton("Print All");
            prntTxt = new JButton("Print Text");
            theFont = new Font("Comic Sans MS", Font.PLAIN, 12);
            txtArea = new JTextArea();
            txtArea.setLineWrap(true);
            txtArea.setTabSize(4);
            txtArea.setWrapStyleWord(true);
            txtArea.setFont(theFont);
            theFont = new Font("Comic Sans MS", Font.BOLD, 12);
            btnOk.setFont(theFont);
            prntAll.setFont(theFont);
            prntTxt.setFont(theFont);
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnOk) {
                        dispose();
                    }
                }
            });
            prntAll.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == prntAll) {
                        printer = txt.getToolkit().getPrintJob(printFrame, "Printing Page..", null);
                        if (printer != null) {
                            g = printer.getGraphics();
                        }
                        // print everything
                        printAll(g);
                        g.dispose();//send the printJob to the printer queue
                        printer.end();
                    }
                }
            });
            prntTxt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == prntTxt) {
                        printer = txt.getToolkit().getPrintJob(printFrame, "Printing Page..", null);
                        if (printer != null) {
                            g = printer.getGraphics();
                        }
                        g.drawString(txtArea.getText(), 0, 0);
                        g.dispose();
                        printer.end();
                        //g.end();
                    }
                }
            });
            theLayout = new GridBagLayout();
            theConstraints = new GridBagConstraints();
            txt.getContentPane().setLayout(theLayout);
            theConstraints.weighty = 18.0;
            //theConstraints.weightx = 1.0;
            theConstraints.fill = GridBagConstraints.BOTH;
            theConstraints.gridwidth = GridBagConstraints.REMAINDER;
            theLayout.setConstraints(txtArea, theConstraints);
            txt.getContentPane().add(txtArea);

            theConstraints.gridwidth = GridBagConstraints.REMAINDER;
            //theConstraints.weightx = .5;
            theConstraints.weighty = 1.0;
            theLayout.setConstraints(prntAll, theConstraints);
            txt.getContentPane().add(prntAll);

            //theConstraints.weightx = 1.0;
            theConstraints.weighty = 1.0;
            theLayout.setConstraints(prntTxt, theConstraints);
            txt.getContentPane().add(prntTxt);

            theConstraints.gridheight = GridBagConstraints.REMAINDER;
            //theConstraints.weightx = 1.0;
            theConstraints.weighty = 1.0;
            theLayout.setConstraints(btnOk, theConstraints);
            txt.getContentPane().add(btnOk);
        }
    }

    class newWindow extends JFrame {

        Extra helper;
        Font theFont;
        JLabel center, l_name, l_address, l_password, conditional, theName, theAddress, thePassword;
        JButton btnOk;
        JMenuBar theMenuBar;
        JMenu fileMenu, editMenu;
        JMenuItem fileNew, binCon, fileExit, editDefault;
        MenuItem blue, red, black, white;
        PopupMenu popUp;

        public newWindow(String name, String address, String password) {
            super("Confirm Info");
            this.setSize(300, 300);
            center = new JLabel();
            this.setLocation(375, 300);
            this.getContentPane().setLayout(new GridLayout(4, 2));
            // initialize objects
            theName = new JLabel(name);
            theName.setForeground(Color.darkGray);
            theAddress = new JLabel(address);
            theAddress.setForeground(Color.darkGray);
            thePassword = new JLabel(password);
            thePassword.setForeground(Color.darkGray);
            l_name = new JLabel("Your name: ");
            l_name.setForeground(Color.black);
            l_address = new JLabel("Your address: ");
            l_address.setForeground(Color.black);
            l_password = new JLabel("Your password: ");
            l_password.setForeground(Color.black);
            conditional = new JLabel("If correct click ->");
            conditional.setForeground(Color.black);
            btnOk = new JButton("Ok");
            theMenuBar = new JMenuBar();
            fileMenu = new JMenu("File");
            editMenu = new JMenu("Edit");
            fileNew = new JMenuItem("New - Text Editor");
            binCon = new JMenuItem("Binary Converter");
            fileExit = new JMenuItem("Exit");
            editDefault = new JMenuItem("Default Color");
            blue = new MenuItem("Blue");
            red = new MenuItem("Red");
            black = new MenuItem("Black");
            white = new MenuItem("White");
            popUp = new PopupMenu("Colors");
            theFont = new Font("Comic Sans MS", Font.BOLD, 12);
            l_name.setFont(theFont);
            l_address.setFont(theFont);
            l_password.setFont(theFont);
            conditional.setFont(theFont);
            btnOk.setFont(theFont);
            theName.setFont(theFont);
            theAddress.setFont(theFont);
            thePassword.setFont(theFont);
            fileMenu.setFont(theFont);
            editMenu.setFont(theFont);
            fileNew.setFont(theFont);
            binCon.setFont(theFont);
            fileExit.setFont(theFont);
            editDefault.setFont(theFont);
            popUp.setLabel("Forecolors");
            popUp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand() == "White") {
                        if (helper.Get() == 1) {
                            theName.setForeground(Color.white);
                        }
                        if (helper.Get() == 2) {
                            theAddress.setForeground(Color.white);
                        }
                        if (helper.Get() == 3) {
                            thePassword.setForeground(Color.white);
                        }

                    }
                    if (e.getActionCommand() == "Black") {
                        if (helper.Get() == 1) {
                            theName.setForeground(Color.black);
                        }
                        if (helper.Get() == 2) {
                            theAddress.setForeground(Color.black);
                        }
                        if (helper.Get() == 3) {
                            thePassword.setForeground(Color.black);
                        }
                    }
                    if (e.getActionCommand() == "Red") {
                        if (helper.Get() == 1) {
                            theName.setForeground(Color.red);
                        }
                        if (helper.Get() == 2) {
                            theAddress.setForeground(Color.red);
                        }
                        if (helper.Get() == 3) {
                            thePassword.setForeground(Color.red);
                        }
                    }
                    if (e.getActionCommand() == "Blue") {
                        if (helper.Get() == 1) {
                            theName.setForeground(Color.blue);
                        }
                        if (helper.Get() == 2) {
                            theAddress.setForeground(Color.blue);
                        }
                        if (helper.Get() == 3) {
                            thePassword.setForeground(Color.blue);
                        }
                    }

                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }

            });
            // create the menu
            editMenu.add(editDefault);
            fileMenu.add(fileNew);
            fileMenu.addSeparator();
            fileMenu.add(binCon);
            fileMenu.addSeparator();
            fileMenu.add(fileExit);
            fileMenu.addSeparator();
            theMenuBar.add(fileMenu);
            theMenuBar.add(editMenu);
            fileNew.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == fileNew) {
                        textEditor txtEditor = new textEditor();
                        txtEditor.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                dispose();
                            }
                        });
                        txtEditor.show();
                    }
                }
            });
            binCon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == binCon) {
                        binaryConvert binaryConverter = new binaryConvert();
                        binaryConverter.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                dispose();
                            }
                        });
                        binaryConverter.show();
                    }
                }
            });
            fileExit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == fileExit) {
                        dispose();
                    }
                }
            });
            editDefault.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == editDefault) {
                        theName.setForeground(Color.darkGray);
                        theAddress.setForeground(Color.darkGray);
                        thePassword.setForeground(Color.darkGray);
                    }
                }
            });
            popUp.add(black);
            popUp.add(white);
            popUp.add(blue);
            popUp.add(red);
            this.getContentPane().add(popUp);
            //theName.add(popUp);
            //theAddress.add(popUp);
            //thePassword.add(popUp);
            this.setJMenuBar(theMenuBar);
            this.getContentPane().add(l_name);
            this.getContentPane().add(theName);
            this.getContentPane().add(l_address);
            this.getContentPane().add(theAddress);
            this.getContentPane().add(l_password);
            this.getContentPane().add(thePassword);
            this.getContentPane().add(conditional);
            this.getContentPane().add(btnOk);
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnOk) {
                        tfName.setForeground(theName.getForeground());
                        tfAddress.setForeground(theAddress.getForeground());
                        tfPassword.setForeground(thePassword.getForeground());
                        dispose();
                    }
                }
            });
            theName.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        helper = new Extra();
                        helper.Set(1);
                        popUp.show(theName, e.getX(), e.getY());
                    }
                }
            });
            theAddress.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        helper = new Extra();
                        helper.Set(2);
                        popUp.show(theAddress, e.getX(), e.getY());
                    }
                }
            });

            thePassword.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        helper = new Extra();
                        helper.Set(3);
                        popUp.show(thePassword, e.getX(), e.getY());
                    }
                }
            });
        }
    }

    class Extra {
        int label;
        Color A, B, C;

        public void Extra() {
            label = 0;
            A = Color.black;
            B = Color.black;
            C = Color.black;
        }

        public void Set(int picked) {
            label = picked;
        }

        public int Get() {
            return label;
        }

        public void Colors(Color a, Color b, Color c) {
            tfName.setForeground(a);
            tfAddress.setForeground(b);
            tfPassword.setForeground(c);
        }

        public Color getA() {
            return A;
        }

        public Color getB() {
            return B;
        }

        public Color getC() {
            return C;
        }
    }

    class ErrDialog extends JDialog {

        GridBagConstraints theConstraints;
        GridBagLayout theLayout;
        JApplet top, bottom, filler;
        JButton btnOk;
        JLabel theMsg, center;
        Font theFont;

        public ErrDialog(String errMsg, String title) {
            this.setTitle(title);
            this.setSize(200, 200);
            this.setBackground(Color.white);
            center = new JLabel();
            this.setLocationRelativeTo(center);
            top = new JApplet();
            bottom = new JApplet();
            filler = new JApplet();
            btnOk = new JButton("Ok");
            theLayout = new GridBagLayout();
            theConstraints = new GridBagConstraints();
            theMsg = new JLabel(errMsg);
            theFont = new Font("Comic Sans MS", Font.BOLD, 12);
            theMsg.setFont(theFont);
            btnOk.setFont(theFont);
            theMsg.setHorizontalAlignment(SwingConstants.CENTER);
            theMsg.setForeground(Color.red);
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnOk) {
                        dispose();
                    }
                }
            });
            this.getContentPane().setLayout(theLayout);
            //theConstraints.gridwidth = 1;
            //theConstraints.gridheight = 2;
            theConstraints.fill = GridBagConstraints.HORIZONTAL;
            theConstraints.gridheight = GridBagConstraints.RELATIVE;
            theConstraints.gridwidth = GridBagConstraints.REMAINDER;
            theConstraints.weighty = 5.0;
            theLayout.setConstraints(theMsg, theConstraints);
            this.getContentPane().add(theMsg);
            theConstraints.fill = GridBagConstraints.HORIZONTAL;
            theConstraints.gridheight = GridBagConstraints.REMAINDER;
            theConstraints.gridwidth = GridBagConstraints.REMAINDER;
            theConstraints.weighty = 1.0;
            theLayout.setConstraints(btnOk, theConstraints);
            this.getContentPane().add(btnOk);
        }
    }
}
