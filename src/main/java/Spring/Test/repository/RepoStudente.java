package Spring.Test.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Spring.Test.model.Studente;

@Repository
public interface RepoStudente extends MongoRepository<Studente, String> {
public Studente findByCodiceFiscale(String codiceFiscale);
public boolean existsByCodiceFiscale(String codiceFiscale);
}
