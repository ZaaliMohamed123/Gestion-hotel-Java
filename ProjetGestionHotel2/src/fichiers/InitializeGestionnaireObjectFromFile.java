package fichiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import gestionHotel.*;

public class InitializeGestionnaireObjectFromFile {
	
	public static List<GestionnaireHotel> initialiser(String filePath){
		List<GestionnaireHotel> lgh = new ArrayList<GestionnaireHotel>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line ;
			while((line = reader.readLine()) != null){
				GestionnaireHotel g = parseGestionnaireFromString(line);
				lgh.add(g);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lgh ;
	}
	
	private static GestionnaireHotel parseGestionnaireFromString(String line) {
		String[] parts = line.split(",");
		String Username = parts[0].substring(parts[0].indexOf(':')+1);
		String Password = parts[1].substring(parts[1].indexOf(':')+1,parts[1].indexOf(']'));
		
		return new GestionnaireHotel(Username , Password);
	}
	
}