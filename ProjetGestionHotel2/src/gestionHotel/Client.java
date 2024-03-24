package gestionHotel;

public class Client {
	private String CIN ;
	private String nom ;
	private String prenom ;
	private String ville ;
	private String pays ;
	
	public Client() {
		
	}
	public Client( String nom, String prenom,String CIN , String ville, String pays) {
		
		this.CIN = CIN;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.pays = pays;
	}
	
	public String toString() {
		return "Client [ nom :" + nom + ", prenom :" + prenom +", CIN :" + CIN + ", ville :" + ville + ", pays :" + pays
				+ "]";
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	
	
}
