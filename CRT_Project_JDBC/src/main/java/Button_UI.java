import java.awt.*; // Step 1: Import Java Package


public class Button_UI extends Frame{ // Step 2: Adding Frame package for UI development
	
	Button_UI(){ // Step 3: Creating a constructor of same name as the class name
		Button b = new Button("Home"); // Creating a object of Button class
		b.setBounds(30, 100, 80, 30); // Setting the width, height and other parameters
		add(b);
		
		setSize(300,300); // Setting the Frame Size (Frame should be bigger than the dimension of the button)
		setLayout(null);
		setVisible(true);
	}

public static void main(String[] args) {
		new Button_UI();
	}
}
