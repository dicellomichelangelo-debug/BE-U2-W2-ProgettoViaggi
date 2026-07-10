package michelangelodicello.BE_U2_W2_ProgettoViaggi.service;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Dipendente;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Prenotazione;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Viaggio;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories.DipendenteRepository;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories.PrenotazioneRepository;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Prenotazione> getAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione assegnaDipendenteAViaggio(Long dipendenteId, Long viaggioId, String note) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
        if (prenotazioneRepository.existsByDipendenteIdAndViaggioData(dipendenteId, viaggio.getData())) {
            throw new IllegalArgumentException("Il dipendente ha già un viaggio programmato per il giorno: " + viaggio.getData());
        }
        Prenotazione p = new Prenotazione();
        p.setDipendente(dipendente);
        p.setViaggio(viaggio);
        p.setDataRichiesta(LocalDate.now());
        p.setNotePreferenze(note);
        return prenotazioneRepository.save(p);
    }

}