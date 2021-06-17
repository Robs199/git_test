package Spring.Test.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document

public class Studente {
	@Id
	private String id;
	private String nome;
	private String cognome;
	private String email;
	private Sesso sesso;
	private Indirizzo indirizzo;
	@Indexed(unique=true)
	private String codiceFiscale;
    public Studente() {};
	public Studente(String nome,
					String cognome,
					String email,
					Sesso sesso,
					String codiceFiscale,
					Indirizzo indirizzo ) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.indirizzo = indirizzo;
		this.codiceFiscale=codiceFiscale;
	}
}
