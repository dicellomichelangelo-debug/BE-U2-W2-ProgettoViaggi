package michelangelodicello.BE_U2_W2_ProgettoViaggi.service;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Dipendente;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.payload.DipendentePayload;
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

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Dipendente save(DipendentePayload payload) {
        Dipendente d = new Dipendente();
        d.setUsername(payload.getUsername());
        d.setNome(payload.getNome());
        d.setCognome(payload.getCognome());
        d.setEmail(payload.getEmail());
        return repository.save(d);
    }

    public Dipendente update(Long id, DipendentePayload payload) {
        Dipendente esistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        esistente.setNome(payload.getNome());
        esistente.setCognome(payload.getCognome());
        esistente.setEmail(payload.getEmail());
        esistente.setUsername(payload.getUsername());
        return repository.save(esistente);
    }

    public Dipendente saveEntityDirectly(Dipendente d) {
        return repository.save(d);
    }
}