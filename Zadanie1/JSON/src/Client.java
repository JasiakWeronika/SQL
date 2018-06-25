
public class Client {
	Long kontaktId;
	Long klientId;
	Long pracownikId;
	String status;
	String kontaktTs;
	// tworzymy klienta
	public Client(Long kontaktId, Long klientId, Long pracownikId, String status, String kontaktTs) {
		this.kontaktId = kontaktId;
		this.klientId = klientId;
		this.pracownikId = pracownikId;
		this.status = status;
		this.kontaktTs = kontaktTs;
	}
	// pobieramy poszczegolne dane
	public Long getKontaktId() {
		return kontaktId;
	}
	public void setKontaktId(long kontaktId) {
		this.kontaktId = kontaktId;
	}
	public Long getKlientId() {
		return klientId;
	}
	public void setKlientId(long klientId) {
		this.klientId = klientId;
	}
	public Long getPracownikId() {
		return pracownikId;
	}
	public void setPracownikId(long pracownikId) {
		this.pracownikId = pracownikId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKontaktTs() {
		return kontaktTs;
	}
	public void setKontaktTs(String kontaktTs) {
		this.kontaktTs = kontaktTs;
	}
	public String toString() {
		return kontaktId + " | " + klientId + " | " + pracownikId + " | " + status + " | " + kontaktTs;
	}
}
