package michelangelodicello.BE_U2_W2_ProgettoViaggi.service;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Viaggio;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.payload.ViaggioPayload;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository repository;

    public List<Viaggio> getAll() {
        return repository.findAll();
    }

    public Viaggio getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
    }

    public Viaggio save(ViaggioPayload payload) {
        Viaggio v = new Viaggio();
        v.setDestinazione(payload.getDestinazione());
        v.setData(payload.getData());
        v.setStato(payload.getStato());
        return repository.save(v);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Viaggio cambiaStato(Long id, String nuovoStato) {
        Viaggio viaggio = getById(id);
        viaggio.setStato(nuovoStato.toUpperCase());
        return repository.save(viaggio);

    }
}