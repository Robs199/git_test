package Spring.Test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Spring.Test.model.Indirizzo;
import Spring.Test.model.Sesso;
import Spring.Test.model.Studente;
import Spring.Test.repository.RepoStudente;
import lombok.AllArgsConstructor;

@RestController
public class Control {
	@Autowired
	RepoStudente repo;

	@RequestMapping("inserisci")
	public String inserimento(@RequestParam String nome,String cognome, String email, String nazione, String citta, String cap, String codiceFiscale, Sesso sesso ) {
	    Studente studente = new Studente(nome, cognome,  email, sesso, codiceFiscale, new Indirizzo(nazione, citta, cap));
		repo.save(studente);
       
		return "inserito";
	}
	@RequestMapping("modifica")
	public String modifica(@RequestParam String codiceFiscale, Studente studente, Indirizzo indirizzo) {
		
		if(repo.existsByCodiceFiscale(codiceFiscale)) {
			Studente studenteCercato= repo.findByCodiceFiscale(codiceFiscale);
			studenteCercato.setNome(studente.getNome());
			studenteCercato.setCognome(studente.getCognome());
			studenteCercato.setEmail(studente.getEmail());
			studenteCercato.setSesso(studente.getSesso());
			studenteCercato.setIndirizzo(indirizzo);
			repo.save(studenteCercato);
			
			return "Studente modificato";
		}
		return "Studente non trovato";
	}
	@RequestMapping("elimina")
	public String rimuovi(@RequestParam String codiceFiscale) {
		
		if(repo.existsByCodiceFiscale(codiceFiscale)) {
			repo.delete(repo.findByCodiceFiscale(codiceFiscale)); 
			return "Eliminazione avvenuta";
		}
		return "Studente non trovato";
	}
	@RequestMapping("stampauno")
	public String stampauno(@RequestParam String codiceFiscale) {
		if(repo.existsByCodiceFiscale(codiceFiscale)) {
			return repo.findByCodiceFiscale(codiceFiscale).toString();
		}
		return "Studente non trovato";
	}
	@RequestMapping("stampa")
	public List<Studente> stampa(){
		return repo.findAll();
	}
	
}
