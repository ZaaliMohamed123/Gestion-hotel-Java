package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		
		this.setSize(1000, 500);
		this.setTitle("Gestion D'Hotel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		
		ImageIcon image = new ImageIcon("Ensam rabat Logo.jpg");
		this.setIconImage(image.getImage());
		
		
		
	}
	

}
