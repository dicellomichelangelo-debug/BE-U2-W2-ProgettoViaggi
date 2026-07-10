package michelangelodicello.BE_U2_W2_ProgettoViaggi.service;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Dipendente;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository repository;

    public List<Dipendente> getAll() {
        return repository.findAll();
    }

    public Dipendente getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
    }

    public Dipendente save(Dipendente d) {
        return repository.save(d);
    }

    public Dipendente update(Long id, Dipendente d) {
        Dipendente esistente = getById(id);
        esistente.setNome(d.getNome());
        esistente.setCognome(d.getCognome());
        esistente.setEmail(d.getEmail());
        esistente.setUsername(d.getUsername());
        return repository.save(esistente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}