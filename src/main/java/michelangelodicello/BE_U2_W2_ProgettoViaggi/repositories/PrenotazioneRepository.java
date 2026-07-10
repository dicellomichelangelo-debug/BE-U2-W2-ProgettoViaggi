package michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
}
