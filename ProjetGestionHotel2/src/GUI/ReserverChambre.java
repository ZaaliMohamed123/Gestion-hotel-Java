package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;
import gestionHotel.*;
import fichiers.*;

public class ReserverChambre extends MyFrame implements ActionListener{
	private MyLabeledTextField ltf0;
	private MyLabeledTextField  ltf1;
	private MyLabeledTextField  ltf2;
	private MyLabeledTextField  ltf3;
	private MyLabeledTextField  ltf4;
	private MyLabeledTextField  ltf5;
	private MyLabeledTextField  ltf6;
	
	private JComboBox Cjours , Cmois , Cannee ;
	private MyButton b0,b1,b2,b3;
	private Hotel h = new Hotel();
	
	public ReserverChambre() {
		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());

		MyTitlePanel tp = new MyTitlePanel("Reserver une Chambre");
		tp.setPreferredSize(new Dimension(300,70));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		ltf0=new MyLabeledTextField("CIN",250,200);
		ltf1=new MyLabeledTextField("Nom",250,200);
		ltf2=new MyLabeledTextField("Prenom",250,200);
		ltf3=new MyLabeledTextField("Ville",250,200);
		ltf4=new MyLabeledTextField("Pays",250,200);
		ltf5=new MyLabeledTextField("le numero du chambre",250,200);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l0 = new JLabel("Date de Reservation");
		l0.setPreferredSize(new Dimension(200, 30));
		l0.setFont(new Font("Arial",Font.PLAIN,15));
		l0.setForeground(Color.black);
		String[] Jours = TJours() ;
		String[] Mois = TMois() ;
		String[] Annee =TAnnee() ;
		Cjours = new JComboBox(Jours);
		Cjours.setPreferredSize(new Dimension(50,30));
		Cjours.setFont(new Font("Arial",Font.PLAIN,15));
		Cmois = new JComboBox(Mois);
		Cmois.setPreferredSize(new Dimension(100,30));
		Cmois.setFont(new Font("Arial",Font.PLAIN,15));
		Cannee = new JComboBox(Annee);
		Cannee.setPreferredSize(new Dimension(70,30));
		Cannee.setFont(new Font("Arial",Font.PLAIN,15));
		p2.add(l0);p2.add(Cjours);p2.add(Cmois);p2.add(Cannee);
		
		ltf6=new MyLabeledTextField("duree du sejour",250,200);
		p1.add(ltf0);p1.add(ltf1);p1.add(ltf2);p1.add(ltf3);p1.add(ltf4);p1.add(ltf5);p1.add(p2);p1.add(ltf6);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		b0 = new MyButton("Sauvegarder");
		b0.addActionListener(this);
		b1 = new MyButton("Renitialiser");
		b1.addActionListener(this);
		b2 = new MyButton("Retour");
		b2.addActionListener(this);
		b3 = new MyButton("Quitter");
		b3.addActionListener(this);
		p3.add(b0);p3.add(b1);p3.add(b2);p3.add(b3);
		
		p0.add(tp,BorderLayout.NORTH);p0.add(p1,BorderLayout.CENTER);p0.add(p3,BorderLayout.SOUTH);
		this.add(p0);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b0) {
			String CIN = ltf0.getText();
			String Nom = ltf1.getText();
			String Prenom = ltf2.getText();
			String Ville = ltf3.getText();
			String Pays = ltf4.getText();
			
			Client client = new Client(Nom,Prenom,CIN,Ville,Pays);
			
			int numChambre = Integer.parseInt(ltf5.getText());
			
			Chambre chambre = h.ChercherChambre(numChambre);
			
			int jour = Cjours.getSelectedIndex()+1;
			int mois = Cmois.getSelectedIndex()+1;
			int année = Integer.parseInt((String)Cannee.getSelectedItem());
			
			LocalDate dateDebRes = LocalDate.of(année, mois, jour);
			
			int nombreJours = Integer.parseInt(ltf6.getText());
			
			h.ReserverChambre(chambre, client, dateDebRes, nombreJours);
			reset();
			
			}else if(e.getSource()==b1) {
				reset();
			}else if(e.getSource()==b2) {
				this.dispose();
				new OptionsPage();
			}else if(e.getSource()==b3) {
				System.exit(0);
			}
		
	}
	
	public String[] TJours() {
        String[] T = new String[31];
        for (int i = 0; i <= 30; i++) {
            T[i] = String.valueOf(i + 1);
        }
        return T;
    }
	
	 public String[] TMois() {
	        String[] mois = {
	                "Janvier", "Février", "Mars", "Avril",
	                "Mai", "Juin", "Juillet", "Août",
	                "Septembre", "Octobre", "Novembre", "Décembre"
	        };
	        return mois;
	    }
	
	 public String[] TAnnee(){
			String[] T = new String[8];
			for(int i =0 ;i<=7;i++) {
				T[i]=String.valueOf(2023+i);
			}
			return T ;
		}
	 
	public void reset() {
		ltf0.setText("");
		ltf1.setText("");
		ltf2.setText("");
		ltf3.setText("");
		ltf4.setText("");
		ltf5.setText("");
		ltf6.setText("");
		Cjours.setSelectedIndex(0);
		Cmois.setSelectedIndex(0);
		Cannee.setSelectedIndex(0);
	}
	 
	 
	 
	 

}
