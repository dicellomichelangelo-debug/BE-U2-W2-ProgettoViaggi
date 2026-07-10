package michelangelodicello.BE_U2_W2_ProgettoViaggi.controllers;

import jakarta.validation.Valid;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Dipendente;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.payload.DipendentePayload;
import michelangelodicello.BE_U2_W2_ProgettoViaggi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService service;

    @GetMapping
    public List<Dipendente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Dipendente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Dipendente create(@Valid @RequestBody DipendentePayload payload) {
        return service.save(payload);
    }

    @PutMapping("/{id}")
    public Dipendente update(@PathVariable Long id, @Valid @RequestBody DipendentePayload payload) {
        return service.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @PostMapping("/{id}/profilo")
    public ResponseEntity<Dipendente> uploadProfilo(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Dipendente d = service.getById(id);


        String fileName = "upload_" + id + "_" + file.getOriginalFilename();
        d.setImmagineProfilo("/images/" + fileName);

        Dipendente dipendenteAggiornato = service.saveEntityDirectly(d);
        return ResponseEntity.ok(dipendenteAggiornato);
    }
}