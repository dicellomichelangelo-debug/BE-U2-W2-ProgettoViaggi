package michelangelodicello.BE_U2_W2_ProgettoViaggi.payload;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioPayload {
    @NotBlank(message = "La destinazione è obbligatoria")
    private String destinazione;

    @NotNull(message = "La data del viaggio è obbligatoria")
    @FutureOrPresent(message = "La data del viaggio non può essere nel passato")
    private LocalDate data;

    @NotBlank(message = "Lo stato del viaggio è obbligatorio")
    private String stato;
}
