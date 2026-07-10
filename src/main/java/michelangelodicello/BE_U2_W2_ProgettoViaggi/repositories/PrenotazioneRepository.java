package michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.dipendente.id = :dipendenteId AND p.viaggio.data = :dataViaggio")
    boolean existsByDipendenteIdAndViaggioData(@Param("dipendenteId") Long dipendenteId, @Param("dataViaggio") LocalDate dataViaggio);
}

