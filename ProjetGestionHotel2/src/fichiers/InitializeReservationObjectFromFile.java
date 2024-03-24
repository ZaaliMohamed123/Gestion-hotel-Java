package fichiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import gestionHotel.*;

public class InitializeReservationObjectFromFile {
	
	public static List<Reservation> initialiser(String filePath){
		List<Reservation> lr = new ArrayList<Reservation>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line ;
			while((line = reader.readLine())!=null) {
				Reservation r = parseReservationFromString(line);
				lr.add(r);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return lr ;
	}
	
	
	
	 private static Reservation parseReservationFromString(String line) {
	        
	        String[] parts = line.split(", ");
	        
	        String nom = parts[0].substring(parts[0].indexOf(':') + 1);
	        String prenom = parts[1].substring(parts[1].indexOf(':') + 1);
	        String CIN = parts[2].substring(parts[2].indexOf(':') + 1);
	        String ville = parts[3].substring(parts[3].indexOf(':') + 1);
	        String pays = parts[4].substring(parts[4].indexOf(':') + 1, parts[4].indexOf("]"));
	        
	        Client c = new Client(nom,prenom,CIN,ville,pays);
	        
	        int numChambre = Integer.parseInt(parts[5].substring(parts[5].indexOf(':') + 1));
	        String type = parts[6].substring(parts[6].indexOf(':') + 1);
	        String etat = parts[7].substring(parts[7].indexOf(':') + 1);
	        int nombreLits = Integer.parseInt(parts[8].substring(parts[8].indexOf(':') + 1));
	        double prix = Double.parseDouble(parts[9].substring(parts[9].indexOf(':') + 1, parts[9].indexOf(" DH")));
	        
	        Chambre ch = new Chambre(numChambre,type,etat,nombreLits,prix);
	        
	        
	        String[] datedeb = parts[10].split("/");
	        int JourDebRes = Integer.parseInt(datedeb[0].substring(datedeb[0].indexOf('[')+1));
	        int MoisDebRes = Integer.parseInt(datedeb[1].trim());  
	        int AnneeDebRes = Integer.parseInt(datedeb[2].substring(0, datedeb[2].indexOf("]")));

	        LocalDate datedebRes = LocalDate.of(AnneeDebRes, MoisDebRes, JourDebRes);
	    	
	    	String[] datefin = parts[11].split("/");
	    	int JourFinRes = Integer.parseInt(datefin[0].substring(datefin[0].indexOf('[')+1));
	    	int MoisFinRes = Integer.parseInt(datefin[1].trim());  
	    	int AnneeFinRes = Integer.parseInt(datefin[2].substring(0, datefin[2].indexOf("]")));
	    	LocalDate dateFinRes = LocalDate.of(AnneeFinRes,MoisFinRes,JourFinRes);
	    	
	    	int nombreJours = ((int)datedebRes.until(dateFinRes,ChronoUnit.DAYS));//return long needs casting
	    	
	    	return new Reservation(c,ch,datedebRes,nombreJours);
	    }

}
