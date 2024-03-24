package gestionHotel;

import java.time.LocalDate;


public class Reservation {
	
	private Client client;
	private Chambre chambre;
	private LocalDate dateDebutReservation;
	private int nombreJours;
	private LocalDate dateFinReservation;
	
	
	public Reservation(Client client, Chambre chambre, LocalDate dateDebutReservation, int nombreJours) {
	
		this.client = client;
		this.chambre = chambre;
		this.dateDebutReservation = dateDebutReservation;
		this.nombreJours = nombreJours;
		this.dateFinReservation = dateDebutReservation.plusDays(nombreJours);
		
	}

	

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Chambre getChambre() {
		return this.chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	

	public int getNombreJours() {
		return nombreJours;
	}

	public void setNombreJours(int nombreJours) {
		this.nombreJours = nombreJours;
	}

	
	
	public LocalDate getDateDebutReservation() {
		return dateDebutReservation;
	}

	public void setDateDebutReservation(LocalDate dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}

	public LocalDate getDateFinReservation() {
		return dateFinReservation;
	}
	
	
	public String toString() {
		return "Reservation { Client [ nom :" + client.getNom() + ", prenom :" + client.getPrenom() +
				", CIN :" + client.getCIN() + ", ville :" + client.getVille() + ", pays :" + client.getPays()+ 
				"] , Chambre[numero :" + chambre.getNumChambre() + 
				", type :" + chambre.getType() + ", état :" + chambre.getEtat() + 
				", nombreLits :" + chambre.getNombreLits() +", prix :" + chambre.getPrix() + 
				" DH ] , Date de debut de Reservation ["+dateDebutReservation.getDayOfMonth()
				+"/"+dateDebutReservation.getMonthValue()+"/"+dateDebutReservation.getYear()+
				"] , Date de fin de Reservation ["+dateFinReservation.getDayOfMonth()+
				"/"+dateFinReservation.getMonthValue()+"/"+dateFinReservation.getYear()+"]"+"}" ;
	}
	
	
}
