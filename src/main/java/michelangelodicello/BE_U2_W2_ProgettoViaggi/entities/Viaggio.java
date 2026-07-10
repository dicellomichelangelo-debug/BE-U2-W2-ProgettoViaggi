package michelangelodicello.BE_U2_W2_ProgettoViaggi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "viaggi")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinazione;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String stato;
}