package Spring.Test.model;

import lombok.Data;

@Data
public class Indirizzo {
	private String nazione;
	private String citta;
	private String cap;

	public Indirizzo(String nazione,
					 String citta,
					 String cap) {
		this.nazione = nazione;
		this.citta = citta;
		this.cap = cap;
	}
}
