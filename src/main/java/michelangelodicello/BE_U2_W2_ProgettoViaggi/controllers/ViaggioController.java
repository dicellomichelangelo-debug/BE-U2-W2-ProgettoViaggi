package michelangelodicello.BE_U2_W2_ProgettoViaggi.controllers;

import jakarta.validation.Valid;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Viaggio;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.payload.ViaggioPayload;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService service;

    @GetMapping
    public List<Viaggio> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Viaggio getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Viaggio create(@Valid @RequestBody ViaggioPayload payload) {
        return service.save(payload);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stato")
    public Viaggio cambiaStato(@PathVariable Long id, @RequestParam String stato) {
        return service.cambiaStato(id, stato);
    }
}