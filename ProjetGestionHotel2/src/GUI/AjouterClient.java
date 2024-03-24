package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import gestionHotel.*;
import fichiers.*;

public class AjouterClient extends MyFrame implements ActionListener{
	
	private MyLabeledTextField ltf0,ltf1,ltf2,ltf3,ltf4;
	private MyButton b0,b1,b2,b3;
	
	public AjouterClient() {
		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());

		MyTitlePanel tp = new MyTitlePanel("Ajouter un Client");
		tp.setPreferredSize(new Dimension(300,100));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltf0 = new MyLabeledTextField("CIN", 250,250);
		ltf1 = new MyLabeledTextField("Nom", 250,250);
		ltf2 = new MyLabeledTextField("Prenom", 250,250);
		ltf3 = new MyLabeledTextField("Ville", 250,250);
		ltf4 = new MyLabeledTextField("Pays", 250,250);
		p1.add(ltf0);p1.add(ltf1);p1.add(ltf2);p1.add(ltf3);p1.add(ltf4);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		b0 = new MyButton("Sauvegarder");
		b0.addActionListener(this);
		b1 = new MyButton("Renitialiser");
		b1.addActionListener(this);
		b2 = new MyButton("Retour");
		b2.addActionListener(this);
		b3 = new MyButton("Quitter");
		b3.addActionListener(this);
		p2.add(b0);p2.add(b1);p2.add(b2);p2.add(b3);
		
		
		
		p0.add(tp,BorderLayout.NORTH);p0.add(p1,BorderLayout.CENTER);p0.add(p2,BorderLayout.SOUTH);
		this.add(p0);
		
		this.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b0) {
			String CIN = ltf0.getText() ;
			String nom = ltf1.getText();
			String prenom = ltf2.getText();
			String ville = ltf3.getText();
			String pays =ltf4.getText();
			Client client = new Client(nom,prenom,CIN,ville,pays);
			AjouterFile(client);
			reset();
			
		}else if(e.getSource()==b1) {
			reset();
		}else if(e.getSource()==b2) {
			this.dispose();
			new OptionsPage();
		}else {
			System.exit(0);
		}
		
	}
	
	public void reset() {
		ltf0.setText("");
		ltf1.setText("");
		ltf2.setText("");
		ltf3.setText("");
		ltf4.setText("");
		
	}
	public void AjouterFile(Client client) {
		boolean unique = true ;
		List<Client> lc = InitializeClientObjectsToFile.initialiser("Les Clients.txt");
		for(Client c : lc) {
			if(c.getCIN().equals(client.getCIN())) {
				unique = false ;
			}
		}
		if(unique) {
			lc.add(client);
			new WriteClientObjectsToFile(lc);
			JOptionPane.showMessageDialog(null, "Client bien insérée",null,JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Le Client est deja inséree",null,JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	

}
