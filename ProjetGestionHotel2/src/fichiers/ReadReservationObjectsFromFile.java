package fichiers;

import java.util.List;

import gestionHotel.*;

public class ReadReservationObjectsFromFile {
	
	public ReadReservationObjectsFromFile(String filePath) {
		List<Reservation> lr = InitializeReservationObjectFromFile.initialiser(filePath);
		for(Reservation r : lr) {
			System.out.println(r);
		}
	}
}
