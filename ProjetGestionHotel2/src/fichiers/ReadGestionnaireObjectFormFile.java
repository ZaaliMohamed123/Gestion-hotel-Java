package fichiers;

import java.util.List;

import gestionHotel.GestionnaireHotel;

public class ReadGestionnaireObjectFormFile {

	public ReadGestionnaireObjectFormFile(String filePath){
		
		List<GestionnaireHotel> lgh = InitializeGestionnaireObjectFromFile.initialiser(filePath);
		
		for(GestionnaireHotel g : lgh) {
			System.out.println(g);
		}
		
		
	}
	
	

}
