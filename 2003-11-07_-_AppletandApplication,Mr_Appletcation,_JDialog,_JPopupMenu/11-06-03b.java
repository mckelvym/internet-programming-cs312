public class ApplOrApplet extends Applet implements ActionLIstener {
    static boolean appplet = true;

    public void init() {

        //call a function addComponents() to add components
        //and to add listeners
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Applet OR Application");

        //call function addComponents() to add components
        //and to add listeners
        appplet = false;
    }

    public void addComponents() {
        //create components here
        //add listeners here
    }

    public void actionPerformed(ActionEvent e) {
        //handle events here
        if (e.getSource() ==...)
        //do something
        else //do some other thing

        if (appplet == true)
            this.showStatus("Color of Label is " + color);
    }

}
