Write an application or applet that will have the following textfields:
	Name, Address, Password. If user does enter data in any one of these textfields,
		show him an alert dialog box with the appropriate message. Dialog should have
		an OK button to dispose. If all the data is correct, show him a second JFrame
		with menus. 
		In the second Frame show a label that displays a popupMenu when the 
		user right clicks the mouse. The popupMenu must have a choice of colors
		for the user to pick. Your label changes color dynamically depending on the
		color choice from the popupMenu.
		//First Class
		
		
		
		
		
		
		
		
		//public void actionPerformed(ActionEvent e){
		if(tfName.getText().equals(""))
			MyDialog alert=new MyDialog("Name has to be filled in", "Name Missing");
		else //check if password is correct
		   MyDialog alert=new MyDialog("Password incorrect", "Password!");
		  
		
		
		}//closing main class
		
		class MyDialog extends JDialog ...{
			public MyDialog(String errMssg, String title){
				super(title);
				JLabel label=new JLabel(errMsg);
				
			
			
			
			
		}
		//second class
		
		JPopupMenu popUp=new JPopupMenu("Colors");
		//add menuItems to the PopupMenu object
		popUp.addActionLIstener(this);
		//adding the popupMenu to the component label
		label.add(popUp); 
		//adding a mouseListener to the JLabel in order to respond to MouseClicks
		label.addMouseListener(this);
		
		
		//responding to a MouseReleased event
		public void mouseReleased(MouseEvent e){
			if(e.isPopupTrigger()){
				popUp.show(label,e.getX(),e.getY());
			}
			
		}
		
		
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="Blue")
				label.setForeground(Color.Blue)
			else if(e.getActionCommand().equals("Red"))
				label.serForeground(Color.Red));
		}
		
		