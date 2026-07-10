package michelangelodicello.BE_U2_W2_ProgettoViaggi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dipendenti")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "immagine_profilo")
    private String immagineProfilo;
}
