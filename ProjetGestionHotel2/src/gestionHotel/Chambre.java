package gestionHotel;


public class Chambre {
	private int numChambre ;
	private String type ;
	private String etat ;
	private int nombreLits;
	private double prix;
	
	private final String[] types = {"SIMPLE","DOUBLE"} ;
	private final String[] etats = {"LIBRE","OCCUPEE"};
	
	public Chambre() {
		
	}
	
	public Chambre(int numChambre, String type,int nombreLits , double prix) {
		
		this.numChambre = numChambre;
		type = type.toUpperCase();
		for(String i : types) {
			if(i.equals(type)) {
				this.type = type ;
			}
		}
		this.etat = "LIBRE" ;
		this.nombreLits = nombreLits ;
		this.prix = prix;
	}
	
	public Chambre(int numChambre, String type, String etat,int nombreLits , double prix) {
		
		this.numChambre = numChambre;
		type = type.toUpperCase();
		for(String i : types) {
			if(i.equals(type)) {
				this.type = type ;
			}
		}
		etat = etat.toUpperCase();
		for(String i : etats) {
			if(i.equals(etat)) {
				this.etat = etat ;
			}
		}
		
		this.nombreLits = nombreLits ;
		this.prix = prix;
	}
	
	public Chambre(Chambre c) {
		this.numChambre = c.getNumChambre();
		this.type = c.getType() ;
		this.etat = c.getEtat() ;
		this.nombreLits = c.getNombreLits() ;			
		this.prix = c.getPrix();
	}
	
	
	public String toString() {
		return "Chambre[numero :" + numChambre + ", type :" + type + ", état :" + etat + ", nombreLits :" + nombreLits
				+ ", prix :" + prix + " DH ]";
	}
	
	public int getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getNombreLits() {
		return nombreLits;
	}
	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	
}
