package fichiers;

import java.io.*;
import java.util.List;

import gestionHotel.*;

public class WriteReservationObjectToFile {

	public  WriteReservationObjectToFile(List<Reservation> ReservationList){
        String filePath = "Les Reservations.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Reservation r : ReservationList) {
                writer.write(r.toString());
                writer.newLine();
            }
            writer.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
