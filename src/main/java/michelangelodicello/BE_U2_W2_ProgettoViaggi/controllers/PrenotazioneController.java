package michelangelodicello.BE_U2_W2_ProgettoViaggi.controllers;

import jakarta.validation.Valid;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Prenotazione;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.payload.PrenotazionePayload;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService service;

    @GetMapping
    public List<Prenotazione> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Prenotazione prenota(@Valid @RequestBody PrenotazionePayload payload) {
        return service.assegnaDipendenteAViaggio(
                payload.getDipendenteId(),
                payload.getViaggioId(),
                payload.getNotePreferenze()
        );
    }
}