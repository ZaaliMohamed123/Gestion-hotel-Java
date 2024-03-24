package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class MyLabeledTextField extends JPanel{
	JLabel label ;
	JTextField textField ;

	public MyLabeledTextField(String labeltitle, int TextFieldLength) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		label = new JLabel();
		label.setText(labeltitle);
		label.setFont(new Font("Arial",Font.PLAIN,15));
		label.setForeground(Color.black);
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(TextFieldLength,30));
		textField.setFont(new Font("ARIAL",Font.PLAIN,15));
		textField.setForeground(Color.black);
		textField.setBackground(Color.WHITE);
		textField.setCaretColor(Color.black);
		
		add(label);
		add(textField);
	}

	public MyLabeledTextField(String label, int TextFieldLength, int labelLength) {
		this(label, TextFieldLength);
		((JLabel)this.getComponent(0)).setPreferredSize(new Dimension(labelLength, 30));
	}
	
	public String getText() {
		return ((JTextField)this.getComponent(1)).getText();
	}

	public void setText(String text) {
		((JTextField)this.getComponent(1)).setText(text);
	}

}
