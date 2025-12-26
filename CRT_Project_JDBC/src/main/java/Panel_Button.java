import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Buttons -> Panel -> Frame
public class Panel_Button extends JFrame implements ActionListener{ //->Types of listener -> Key, Action, Mouse, Mouse Motion, Window
	JFrame jf;
	JPanel pp;
	CardLayout cd; // There is also fold layout and card layout is example of frame
	
	Panel_Button(){
		// Creating Object of frame and setting its name
		jf = new JFrame("CardLayout Example");
		
		// Creating Object of Card Layout
		cd = new CardLayout();
		
		// Creating a Main Parent Panel that will contain two child panels.
		pp = new JPanel(); // object of panel 
		
		// Creating two Child Panels.
		JPanel cp1 = new JPanel();
		JPanel cp2 = new JPanel();
		
		// Creating 2 Parent Button and 2 Child Button, one for Alphabet and one for numbers
		// Creating 2 Parent Buttons -> 1. Alphabets , 2. Numbers
		JButton b1 = new JButton("Numbers");
		JButton b2 = new JButton("Alphabets");
		
		// Creating 3 Child Buttons for Numbers(Parent Button)
		JButton b3 = new JButton("1");
		JButton b4 = new JButton("2");
		JButton b5 = new JButton("3");
		
		// Creating 4 Child Buttons for Alphabet(Parent Button)
		JButton b6 = new JButton("A");
		JButton b7 = new JButton("B");
		JButton b8 = new JButton("C");
		JButton b9 = new JButton("D");
		
		// Adding b3,b4 & b5 button to cp1.
		cp1.add(b3);
		cp1.add(b4);
		cp1.add(b5);
		
		// Adding b6 , b7, b8 and b9 in cp2.
		cp2.add(b6);
		cp2.add(b7);
		cp2.add(b8);
		cp2.add(b9);
		
		// Setting the positioning of the components in parent panel(that contains cp1 and cp2) to cardLayout.
		pp.setLayout(cd);
		
		// Adding cp1 and cp2 to Parent panel(pp).
		pp.add(cp1,"Numbers"); // Also passing the parameters 
		pp.add(cp2,"Alphabets");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		// Setting container JFrame's layout to FlowLayout
		jf.setLayout(new FlowLayout());
		
		// Adding two buttons to JFrame, these buttons will remain commonly visible to all panels.
		jf.add(b1);
		jf.add(b2);
		
		// Adding pp to JFrame.
		jf.add(pp);
		
		// Setting Size of Panel
		jf.setSize(300,200);
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		// if "Numbers" button is clicked, open the child Panel with buttons(1,2,3).
		if(ae.getActionCommand() == "Numbers") { // getAction is a predefined method
			cd.show(pp, "Numbers");
		}
		else {
			cd.show(pp, "Alphabets");
		}
	}
	public static void main(String[] args) {
		new Panel_Button();
	}
}
