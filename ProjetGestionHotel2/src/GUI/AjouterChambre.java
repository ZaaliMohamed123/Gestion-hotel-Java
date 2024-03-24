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

public class AjouterChambre extends MyFrame implements ActionListener{
	
	
	private MyLabeledTextField ltf0 ,ltf2,ltf3 ;
	private JComboBox ltf1;
	private MyButton b0,b1,b2,b3;

	public AjouterChambre() {
		JPanel p0 = new JPanel();
		p0.setLayout(new BorderLayout());

		MyTitlePanel tp = new MyTitlePanel("Ajouter une Chambre");
		tp.setPreferredSize(new Dimension(300,100));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		ltf0 = new MyLabeledTextField("numero de Chambre", 250,250);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l0 = new JLabel("Type");
		l0.setPreferredSize(new Dimension(250, 30));
		l0.setFont(new Font("Arial",Font.PLAIN,15));
		l0.setForeground(Color.black);
		String[] types = {"SIMPLE","DOUBLE"} ;
		ltf1 = new JComboBox(types);
		ltf1.setPreferredSize(new Dimension(250,30));
		ltf1.setFont(new Font("Arial",Font.PLAIN,15));
		p2.add(l0);p2.add(ltf1);
		
		ltf2 = new MyLabeledTextField("nombre de Lits ", 250,250);
		ltf3 = new MyLabeledTextField("Prix ", 250,250);
		
		p1.add(ltf0);p1.add(p2);p1.add(ltf2);p1.add(ltf3);
		
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

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b0) {
			int numChambre = Integer.parseInt(ltf0.getText());
			String type = ((String)ltf1.getSelectedItem()) ;
		    int nombreLits = Integer.parseInt(ltf2.getText());
			double prix = Double.parseDouble(ltf3.getText());
			Chambre chambre = new Chambre(numChambre,type,nombreLits,prix);
			AjouterFile(chambre);
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
		ltf1.setSelectedIndex(0);
		ltf2.setText("");
		ltf3.setText("");
		
	}
	public void AjouterFile(Chambre chambre) {
		boolean unique = true ;
		List<Chambre> lc = InitializeChambreObjectsToFile.intialiser("Les Chambres.txt");
		for(Chambre c : lc) {
			if(c.getNumChambre() == chambre.getNumChambre()) {
				unique = false ;
			}
		}
		if(unique) {
			lc.add(chambre);
			new WriteChambreObjectsToFile(lc);
			JOptionPane.showMessageDialog(null, "Chambre bien insérée",null,JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "La chambre est deja inséree",null,JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
}
