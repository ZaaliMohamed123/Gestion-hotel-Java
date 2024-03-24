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


public class LibererChambre extends MyFrame implements ActionListener{

	private MyLabeledTextField ltf0;
	private MyButton b0,b1,b2,b3;
	private Hotel h = new Hotel();
	
	public LibererChambre() {
		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());

		MyTitlePanel tp = new MyTitlePanel("Liberer une Chambre");
		tp.setPreferredSize(new Dimension(300,70));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		ltf0=new MyLabeledTextField("Entrez le numero du Chambre",250,200);
		p1.add(ltf0);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		b0 = new MyButton("Liberer");
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
			int numChambre = Integer.parseInt(ltf0.getText());
			Chambre chambre = h.ChercherChambre(numChambre);
			h.LibererChambre(numChambre);
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

	public void reset() {
		ltf0.setText("");
	}
}
