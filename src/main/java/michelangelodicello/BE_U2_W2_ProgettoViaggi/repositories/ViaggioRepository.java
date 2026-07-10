package michelangelodicello.BE_U2_W2_ProgettoViaggi.repositories;

import michelangelodicello.BE_U2_W2_ProgettoViaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
