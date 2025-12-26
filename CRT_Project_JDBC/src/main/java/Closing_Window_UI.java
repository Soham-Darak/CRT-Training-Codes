import java.awt.*;
import java.awt.event.*; //Importing the event Package -> awt.event is the entire package

public class Closing_Window_UI extends Frame {
	Closing_Window_UI(){
		
		
		this.addWindowListener(new WindowAdapter()
				{ // Opening a body inside this method
					public void windowClosing(WindowEvent we) { // KeyListner: Interface, KeyAdapter, KeyEvent
						System.exit(0);
					}
				}); // Using a Pre-Defined Method -> Using Adapter call to close the window
		
		
		Label L= new Label("Window Closing Example"); // Predefined Class
		this.add(L);
		
		setTitle("Window");
		setSize(300,350);
		// setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Closing_Window_UI();
	}
}
