import java.awt.*;
import javax.swing.*; // We have to use J keyword

public class Form_UI extends JFrame{
	// WE need 2 Labels , 3 Buttons , 2 Text Field and create your own Frame 
	JFrame jf;
	JLabel l1,l2;
	JTextField tf1,tf2;
	JButton b1,b2,b3;
	
	Form_UI(){
		// Creating Object of Frame
		jf = new JFrame("Flow Layout Example");
		jf.setSize(400,150); // Setting frame size
		
		// Creating Object of Label
		l1 = new JLabel("Enter Name: ");
		l2 = new JLabel("Enter City: ");
		
		// Creating Object of TextField
		tf1 = new JTextField(15); // Default value of text field is 20, but in the question we have to set it as 15
		tf2 = new JTextField(15);
		
		// Creating Object of Buttons
		b1 = new JButton("Clear");
		b2 = new JButton("Submit");
		b3 = new JButton("Exit");
		
		// Setting custom frame
		jf.setLayout(new FlowLayout());
		
		// Adding the Label, TextField and Buttons
		jf.add(l1);
		jf.add(tf1);
		jf.add(l2);
		jf.add(tf2);
		
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		
		jf.setVisible(true);

	}
	public static void main(String[] args) {
		new Form_UI();
	}
}
