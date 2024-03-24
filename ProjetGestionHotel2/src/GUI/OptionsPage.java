package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OptionsPage extends MyFrame implements ActionListener {
	private MyButton b0,b1,b2,b3,b4,b5,b6,b7,b8;
	
	public OptionsPage() {
		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());
		
		
		MyTitlePanel tp = new MyTitlePanel("Options Page");
		tp.setPreferredSize(new Dimension(1000,80));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		b0 = new MyButton("Ajouter une chambre");
		b0.setPreferredSize(new Dimension(500,30));
		b0.setFont(new Font("Arial",Font.PLAIN,20));
		b0.addActionListener(this);
		b1 = new MyButton("Ajouter un Client");
		b1.setPreferredSize(new Dimension(500,30));
		b1.setFont(new Font("Arial",Font.PLAIN,20));
		b1.addActionListener(this);
		b2 = new MyButton("Reserver une chambre à un Client");
		b2.setPreferredSize(new Dimension(500,30));
		b2.setFont(new Font("Arial",Font.PLAIN,20));
		b2.addActionListener(this);
		b3 = new MyButton("Attribuer une Chambre à un Client");
		b3.setPreferredSize(new Dimension(500,30));
		b3.setFont(new Font("Arial",Font.PLAIN,20));
		b3.addActionListener(this);
		b4 = new MyButton("Liberer une Chambre");
		b4.setPreferredSize(new Dimension(500,30));
		b4.setFont(new Font("Arial",Font.PLAIN,20));
		b4.addActionListener(this);
		b5 = new MyButton("Chercher une Chambre");
		b5.setPreferredSize(new Dimension(500,30));
		b5.setFont(new Font("Arial",Font.PLAIN,20));
		b5.addActionListener(this);
		b6 = new MyButton("Afficher un Client dans l'Hotel");
		b6.setPreferredSize(new Dimension(500,30));
		b6.setFont(new Font("Arial",Font.PLAIN,20));
		b6.addActionListener(this);
		b7 = new MyButton("Se déconnecter");
		b7.setPreferredSize(new Dimension(500,30));
		b7.setFont(new Font("Arial",Font.PLAIN,20));
		b7.addActionListener(this);
		b8 = new MyButton("Quitter");
		b8.setPreferredSize(new Dimension(500,30));
		b8.setFont(new Font("Arial",Font.PLAIN,20));
		b8.addActionListener(this);
		p1.add(b0);p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);p1.add(b5);p1.add(b6);p1.add(b7);p1.add(b8);
		
		p0.add(tp,BorderLayout.NORTH);p0.add(p1,BorderLayout.CENTER);
		
		this.setContentPane(p0);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b0) {
			this.dispose();
			new AjouterChambre();
		}else if(e.getSource()==b1) {
			this.dispose();
			new AjouterClient();
		}else if(e.getSource()==b2) {
			this.dispose();
			new ReserverChambre();
		}else if(e.getSource()==b3) {
			this.dispose();
			new AttribuerChambreClient();
		}else if(e.getSource()==b4) {
			this.dispose();
			new LibererChambre();
		}else if(e.getSource()==b5) {
			this.dispose();
			new ChercherChambre();
		}else if(e.getSource()==b6) {
			this.dispose();
			new ChercheClientOccupeChambre();
		}else if(e.getSource()==b7) {
			this.dispose();
			new LoginPage();
		}else if(e.getSource()==b8) {
			System.exit(0);
		}
		
	}
	
	

}
