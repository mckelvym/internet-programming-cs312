java.awt.*;

java.awt.geom.*;

Arc2D open_arc;
open_arc = new Arc2D.Float(250, 50, 100, 50, 0, 90, Arc2D.OPEN);
Arc2D closed_arc;
closed_arc = new Arc2D.Float(250, 50, 100, 50, 0, 90, Arc2D.CHORD);
Arc2D pie_arc;
pie_arc = new Arc2D.Float(250, 50, 100, 50, 0, 90, Arc2D.PIE);

Arc2d;
QuadCurve2D;
CubicCurve2D;
OwnShape;

textField1 (x0, y0);
textField2 (x1, y1);
textField3 (ctrlx1, ctrly1);
// set to false
//l1.setText(string);
JSlider // java.awt.swing.*;

	JTextField tf2;
	tf2 = new JTextField("Y");
	try{
	int x0 = Integer.parseInt(tf2.getText());
	y0
	x1 = 
	y1 = 
	}
	catch(NumberFormatException e){
		tf2.setText("Please Enter only integers");
	}
	
	quadCurve = new QuadCurve2D(x0,y0,ctrlx-,ctroly0ljfldjfodfjoeeuioejfoie);
	g2d.draw(quadCurve);
	
	BasicStroke bs;
bs = new BasicStroke(10 (width), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);

public void piant (Graphics g){
	Graphics2D g2d = (Graphics2D)g;
	g2d.setStroke(bs);
	g2d.draw(pie_arc);
	
	
	
	// Anonymous Inner Classes
button.addActionListener(this); // passing an action listener object (this)
// addActionListener(ActionListenerObject);
button.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){ 
		if(e.getSource()==button){
			/* do something */
		}
	}
});

String shape;
combo.addItemListener(new ItemListener(){
	public void itemStateChanged(ItemEvent e){
		shape=combo.getSelectedItem();
	}
});
if (shape == "Rectangle")
	g.drawRect(x,y, (width), (height));
	else if (shape == "Oval")........
	
	
	JSlider width;
	public void init(){
		width = new JSlider(JSlider.HORIZONTAL(orientation), -505(min), 505(max), 256(value));
		width.setMajorTickSpacing(20);
		width.setMinorTickSpacing(5);
		width.setPaintLabels(true);
		width.addChangeListener(new ChangeListener(){
			public void StateChanged(ChangeEvent e){
				int pen_width = width.getValue();
			}
		});
		this.getContentPane().add(combo);
		this.getContentPane().add(width);