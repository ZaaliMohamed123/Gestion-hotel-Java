package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class MyButton extends JButton {

	public MyButton(String text) {
		this.setPreferredSize(new Dimension(100,30));
		this.setText(text);
		
		this.setFocusable(false);
		this.setFont(new Font("Arial",Font.PLAIN,15));
		this.setForeground(Color.BLACK);
		this.setBackground(Color.lightGray);
		this.setBorder(BorderFactory.createEtchedBorder());
	}
}
