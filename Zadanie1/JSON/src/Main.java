import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		// wczutujemy dane z pliku .json
		JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("statuses.json"));
		// tworzymy liste klientow
		List <Client> clientsLists = new ArrayList<Client>();
		for (Object object : jsonArray) {
			// wczytujemy poszczegolne dane
			JSONObject person = (JSONObject) object;
			Long kontaktId = (Long) person.get("kontakt_id");
			Long klientId = (Long) person.get("klient_id");
			Long pracownikId = (Long) person.get("pracownik_id");
			String status = (String) person.get("status");
			String kontaktTs = (String) person.get("kontakt_ts");
			int data = Integer.parseInt((kontaktTs.replaceAll("-", "")).substring(0, 6));
			// wykluczamy rekordy sprzed lipca 2017 i dodajemy klientów do listy
			if (data >= 201707) {
				clientsLists.add(new Client(kontaktId, klientId, pracownikId, status, kontaktTs));
			}
		}
		// sortujemy klientow wzgledem klient_id i kontakt_ts
		clientsLists.sort(new ClientComparator());
		// przypisujemy do zmiennych separator, znak nowej linii oraz naglowek
		final String delimiter = ",";
		final String newLine = "\n";
		final String fileHeader = "kontakt_id,klient_id,pracownik_id,status,kontakt_ts";
		// tworzymy nowy plik .csv i zapisujemy do niego ograniczone dane
		FileWriter fileWriter = new FileWriter("output.csv");
		fileWriter.append(fileHeader.toString());
		fileWriter.append(newLine);
		for (Client client : clientsLists) {
			fileWriter.append(String.valueOf(client.getKontaktId()));
			fileWriter.append(delimiter);
			fileWriter.append(String.valueOf(client.getKlientId()));
			fileWriter.append(delimiter);
			fileWriter.append(String.valueOf(client.getPracownikId()));
			fileWriter.append(delimiter);
			fileWriter.append(String.valueOf(client.getStatus()));
			fileWriter.append(delimiter);
			fileWriter.append(String.valueOf(client.getKontaktTs()));
            fileWriter.append(newLine);
		}
		fileWriter.flush();
		fileWriter.close();
	}
}
