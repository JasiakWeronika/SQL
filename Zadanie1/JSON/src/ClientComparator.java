import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {
	// sortujemy klientow wzgledem klient_id i kontakt_ts
	@Override
	public int compare(Client o1, Client o2) {
		int comparsion = 0;
		comparsion = o1.getKlientId().compareTo(o2.getKlientId());
		if (comparsion == 0) { 
			comparsion =  o1.getKontaktTs().compareTo(o2.getKontaktTs());
		}							
		return comparsion;
	}	
}
