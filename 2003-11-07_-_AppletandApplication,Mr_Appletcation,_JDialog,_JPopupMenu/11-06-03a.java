//add a menuItem called New that opens a new window when the user chooses it.
//Have 2 buttons b1,b2 to either printAll or just printText
//Make this program work both as an applicationa and as an applet


public class PrintApplication extends Applet implements ActionListener{
	JButton b1,b2;
	public static void main(String[] args){
		b1=new JButton("PrintAll");
		b2=new JButton("PrintText");
		JFrame frameForPrint = new JFrame("Print Demo");
		frameForPrint.setSize(200,300);
		frameForPrint.getContentPane().add(b1,BorderLayout.NORTH);
		frameForPrint.getContentPane(b2, BorderLayout.NORTH);
		frameForPrint.show();
		PrintJob printer=this.getToolKit().getPrintJob(frameForPrint,"Printing Page..", null);
		if(printer!=null)
			Graphics g=printer.getGraphics();
		
	}
	
	//constructor if needed
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			this.printAll(g);
			g.dispose();//send the printJob to the printer queue
			g.end();//ending printjob
		}
		else {
			g.drawString("Send this to the printer");
			g.dispose();
			g.end();
		}
	}
		
		
			
		