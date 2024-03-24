package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import gestionHotel.*;
import fichiers.*;
public class LoginPage extends MyFrame implements ActionListener{
	private MyTitlePanel tp ;
	private MyLabeledTextField ltf ;
	private JLabel l2 ;
	private JPasswordField t2 ;
	private MyButton b0 , b1 ;
	private List<GestionnaireHotel> lgh = new ArrayList<GestionnaireHotel>() ;
	
	public LoginPage() {
		JPanel p0 = new JPanel();
		p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
		
		tp = new MyTitlePanel("Login Page");
		
		ltf = new MyLabeledTextField("Username", 250,250);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l2 = new JLabel("Password");
		l2.setFont(new Font("ARIAL",Font.PLAIN,15));
		l2.setPreferredSize(new Dimension(250,30));
		t2 = new JPasswordField();
		t2.setPreferredSize(new Dimension(250,30));
		p2.add(l2);p2.add(t2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		b0 = new MyButton("Se connecter");
		b1 =new MyButton("Quitter");
		b0.setPreferredSize(new Dimension(200,30));
		b1.setPreferredSize(new Dimension(200,30));
		b0.addActionListener(this);
		b1.addActionListener(this);
		p3.add(b0);p3.add(b1);
		
		
		p0.add(tp);p0.add(ltf);p0.add(p2);
		p0.add(p3);
		
		this.setContentPane(p0);
		this.setVisible(true);
		
	}

	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			System.exit(0);
		}else if(e.getSource()== b0) {
			String Username = ltf.getText();
			String Password = t2.getText();
			if(verifierGestionnaire(Username, Password)) {
				this.dispose();
				new OptionsPage();
			}else {
				JOptionPane.showMessageDialog(null,"Username or Password are incorrect",null,JOptionPane.ERROR_MESSAGE);
				reset();
			}
		}
	}
	
	public boolean verifierGestionnaire(String Username , String Password) {
		lgh = InitializeGestionnaireObjectFromFile.initialiser("Les Gestionnaires d'hotel.txt");
		for(GestionnaireHotel g : lgh) {
			if(g.getUsername().equals(Username) && g.getPassword().equals(Password)) {
				return true ;
			}
		}
		return false ;
		
	}
	
	public void reset() {
		ltf.setText("");
		t2.setText("");
	}
	
}