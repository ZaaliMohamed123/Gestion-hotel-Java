package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class MyTitlePanel extends JPanel{
	
	public MyTitlePanel(String title) {
		JLabel l0 = new JLabel(title);
		l0.setFont(new Font("ARIAL",Font.BOLD,30));
		l0.setForeground(Color.RED);
		this.add(l0);
	}
}
