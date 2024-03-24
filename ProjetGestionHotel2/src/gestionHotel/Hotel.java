package gestionHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fichiers.*;


public class Hotel {
	List<Chambre> ListChambre;
	List<Client> ListClient;
	List<Reservation> ListReservation ;
	List<Reservation> ListOccupation ;
	List<GestionnaireHotel> ListGestionnaireHotel ;
	
	public Hotel() {
		ListChambre = new ArrayList<>();
		ListClient = new ArrayList<>();
		ListReservation = new ArrayList<>();
		ListOccupation = new ArrayList<>();
		ListGestionnaireHotel = new ArrayList<>();
	}

	
	
	public void ajouterChambre(Chambre chambre) {
		ListChambre.add(chambre);
	}
	
	public void ajouterClient(Client client) {
		ListClient.add(client);
	}
	
	public Chambre ChercherChambre(int numChambre) {
		ListChambre = InitializeChambreObjectsToFile.intialiser("Les Chambres.txt"); 
		boolean chambreTrouvee = false;
		for(Chambre chambre : ListChambre) {
			if(chambre.getNumChambre() == numChambre) {
				chambreTrouvee = true;	
				return chambre ;
			}
		}
		if (!chambreTrouvee) {
	        JOptionPane.showMessageDialog(null, "Chambre inexistante", null, JOptionPane.WARNING_MESSAGE);
	    }
		return null;
		
	}
	
	public void ChercherChambreJ(int numChambre) {
	    List<Chambre> ListChambre = InitializeChambreObjectsToFile.intialiser("Les Chambres.txt"); 
	    boolean chambreTrouvee = false;

	    for (Chambre chambre : ListChambre) {
	        if (chambre.getNumChambre() == numChambre) {
	            JOptionPane.showMessageDialog(null, chambre, null, JOptionPane.INFORMATION_MESSAGE);
	            chambreTrouvee = true;
	            break; 
	        }
	    }

	    if (!chambreTrouvee) {
	        JOptionPane.showMessageDialog(null, "Chambre inexistante", null, JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	public Client ChercherClient(String CINClient) {
		ListClient = InitializeClientObjectsToFile.initialiser("Les Clients.txt");
		
		for(Client client : ListClient) {
			if(client.getCIN().equals(CINClient)) {
				return client ;
			}
		}
			JOptionPane.showMessageDialog(null, "Client non existant",null,JOptionPane.WARNING_MESSAGE);

		return null ;
	}
	public Client ChercherClientR(String CINClient) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		for(Reservation r : ListReservation) {
			if(r.getClient().getCIN().equals(CINClient)) {
				return r.getClient();
			}
		}
			JOptionPane.showMessageDialog(null, "Client non existant",null,JOptionPane.WARNING_MESSAGE);

		return null ;
	}
	
	public boolean isChambreAvailable(Chambre chambre, LocalDate DateDArrivée,int nombreJours) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		for(Reservation r : ListReservation) {
			if(r.getChambre().getNumChambre() == chambre.getNumChambre()) {
				LocalDate DateDeDepart = DateDArrivée.plusDays(nombreJours);
				if(((DateDArrivée.isAfter(r.getDateDebutReservation())&& (DateDArrivée.isBefore(r.getDateFinReservation()))))
						|| ((DateDeDepart.isAfter(r.getDateDebutReservation())) &&(DateDeDepart.isBefore(r.getDateFinReservation())))
						|| ((DateDArrivée.isBefore(r.getDateDebutReservation())&&(DateDeDepart.isAfter(r.getDateFinReservation()))))) {
					return false ;
				}
				
			}
		}
		return true ;
	}
	
	public void ReserverChambre(Chambre chambre , Client client , LocalDate DateDArrivée , int nombreJours) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		if(isChambreAvailable(chambre, DateDArrivée,nombreJours)) {
			ListReservation.add(new Reservation(client , chambre , DateDArrivée , nombreJours));
			LocalDate DateDeDepart = DateDArrivée.plusDays(nombreJours);
			JOptionPane.showMessageDialog(null, "Reservation de "+client.getNom()+" "+client.getPrenom()
			+" de "+DateDArrivée+" à "+DateDeDepart +" est ajouté",null,JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null,"Chambre déja reservée",null,JOptionPane.WARNING_MESSAGE);
		}
		new WriteReservationObjectToFile(ListReservation);
	}
	
	public boolean isChambreReserveeforClient(Client client) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		
		for(Reservation r : ListReservation) {
			if(r.getClient().getCIN().equals(client.getCIN())) {
				JOptionPane.showMessageDialog(null, "le client "+client.getNom()+" "+client.getPrenom()
				+" a reservé la chambre de numero "+r.getChambre().getNumChambre(),null,JOptionPane.INFORMATION_MESSAGE);
				return true ;
			}
		}
		JOptionPane.showMessageDialog(null,"le client n'a pas reservée une chambre",null,JOptionPane.WARNING_MESSAGE);
		
		return false ;
	}  
	
	public Chambre returnChambreReserveeParClient(Client client) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		for(Reservation r : ListReservation) {
			if(r.getClient().getCIN().equals(client.getCIN())) {
				return r.getChambre() ;
			}
		}
		return null ;
	}
	
	
	public void AttribuerChambreClient(Client client ) {
		
		if(isChambreReserveeforClient(client)) {
			ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
			Chambre chambre = returnChambreReserveeParClient(client);
			for(Reservation r : ListReservation) {
				if(r.getChambre().getNumChambre() == chambre.getNumChambre()) {
					r.getChambre().setEtat("OCCUPEE");
					JOptionPane.showMessageDialog(null, "Vous pouvez donnez le clé de la chambre "+chambre.getNumChambre()+" au client "+r.getClient().getNom()+" "+r.getClient().getPrenom(), null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			new WriteReservationObjectToFile(ListReservation);
		}
		
	}
	
	public void LibererChambre(int numChambre) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		Chambre chambre = ChercherChambre(numChambre);
		for(Reservation r : ListReservation) {
			if(r.getChambre().getNumChambre() == chambre.getNumChambre()) {
				ListReservation.remove(r);
				JOptionPane.showMessageDialog(null, "La chambre "+chambre.getNumChambre()+" est Libére " ,null, JOptionPane.INFORMATION_MESSAGE);
				new WriteReservationObjectToFile(ListReservation);
				return ;
			}
		}
		
	}
	
	public Client getClientInRoom(int numChambre) {
		ListReservation = InitializeReservationObjectFromFile.initialiser("Les Reservations.txt");
		for(Reservation r : ListReservation) {
			if (r.getChambre().getNumChambre() == numChambre) {
				return r.getClient() ;
			}
		}
		JOptionPane.showMessageDialog(null, "Aucun client occupe cette chambre ",null,JOptionPane.WARNING_MESSAGE);
		
		return null;
	}
	
	
	

	

}
