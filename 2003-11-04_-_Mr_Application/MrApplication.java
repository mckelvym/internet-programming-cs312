// mark mckelvy
// internet programming 9:30 tr

/*Write an application or applet that will have the following textfields:
    Name, Address, Password. If user does enter data in any one of these textfields,
        show him an alert dialog box with the appropriate message. Dialog should have
        an OK button to dispose. If all the data is correct, show him a second JFrame
        with menus. add icon in dialog box as well */
//First Class

// create a new menu item, that will make a word processor and print all text
// 2 buttons, printall, printtext
// make both and application and applet

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MrApplication extends JFrame {

    JApplet applTop, applBottom;
    JButton btnOk;
    JLabel lblName, lblAddress, lblPassword;
    JPasswordField tfPassword;
    JTextField tfName, tfAddress;
    ErrDialog theDialog;
    Extra helper;

    public static void main(String[] args) {
        MrApplication executable = new MrApplication();
        executable.show(true);
        //executable.setVisible(true);
    }

    public MrApplication() {
        super("Random Application");
        this.setSize(300, 300);
        this.getContentPane().setLayout(new GridLayout(2, 1));
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
        tfPassword.setEchoChar('|');
        lblName.setForeground(helper.getA());
        lblAddress.setForeground(helper.getB());
        lblPassword.setForeground(helper.getC());
        tfName.setBackground(Color.yellow);
        tfAddress.setBackground(Color.yellow);
        tfPassword.setBackground(Color.green);
        // set layout of applets
        applTop.getContentPane().setLayout(new GridLayout(3, 2));
        applBottom.getContentPane().setLayout(new GridLayout(3, 3));
        // create the menu
        this.getContentPane().add(applTop);
        this.getContentPane().add(applBottom);
        applTop.getContentPane().add(lblName);
        applTop.getContentPane().add(tfName);
        applTop.getContentPane().add(lblAddress);
        applTop.getContentPane().add(tfAddress);
        applTop.getContentPane().add(lblPassword);
        applTop.getContentPane().add(tfPassword);
        applBottom.getContentPane().add(btnOk);//, 1);
        //  applBottom.getContentPane().add(applFiller);
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
                } else {//show new dialog box
                    newWindow second = new newWindow(tfName.getText(), tfAddress.getText(), tfPassword.getText());
                    second.show(true);
                    dispose();
                }
            }
        });
        // add a window listener so that when x is pressed, the frame is closed
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class newWindow extends JFrame {

    JLabel l_name, l_address, l_password, conditional, theName, theAddress, thePassword;
    JButton btnOk;
    JMenuBar theMenuBar;
    JMenu fileMenu, editMenu;
    JMenuItem fileExit, editDefault;
    MenuItem blue, red, black, white;
    PopupMenu popUp;
    Extra helper;

    public newWindow(String name, String address, String password) {
        super("Confirm Info");
        this.setSize(300, 300);
        this.getContentPane().setLayout(new GridLayout(4, 2));
        // initialize objects
        theName = new JLabel(name);
        theAddress = new JLabel(address);
        thePassword = new JLabel(password);
        l_name = new JLabel("Your name: ");
        l_address = new JLabel("Your address: ");
        l_password = new JLabel("Your password: ");
        conditional = new JLabel("If correct click ->");
        btnOk = new JButton("Ok");
        theMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        fileExit = new JMenuItem("Exit");
        editDefault = new JMenuItem("Default Color");
        blue = new MenuItem("Blue");
        red = new MenuItem("Red");
        black = new MenuItem("Black");
        white = new MenuItem("White");
        popUp = new PopupMenu("Colors");
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
        fileMenu.addSeparator();
        fileMenu.add(fileExit);
        fileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fileExit) {
                    dispose();
                }
            }
        });
        fileMenu.addSeparator();
        theMenuBar.add(fileMenu);
        theMenuBar.add(editMenu);
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
                    helper.Colors(theName.getForeground(), theAddress.getForeground(), thePassword.getForeground());
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
        A = a;
        B = b;
        C = c;
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
    JButton btnOk;
    JLabel theMsg;
    JApplet top, bottom, filler;

    public ErrDialog(String errMsg, String title) {
        this.setTitle(title);
        this.setSize(200, 200);
        this.setBackground(Color.white);
        top = new JApplet();
        bottom = new JApplet();
        filler = new JApplet();
        btnOk = new JButton("Ok");
        theMsg = new JLabel(errMsg);
        theMsg.setHorizontalAlignment(SwingConstants.CENTER);
        theMsg.setForeground(Color.red);
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnOk) {
                    dispose();
                }
            }
        });
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(top);
        top.getContentPane().add(theMsg);
        this.getContentPane().add(bottom);
        bottom.getContentPane().setLayout(new GridLayout(2, 1));
        bottom.getContentPane().add(filler);
        bottom.getContentPane().add(btnOk);
    }
}

// printer.end();
