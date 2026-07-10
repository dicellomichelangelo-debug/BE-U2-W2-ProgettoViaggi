package michelangelodicello.BE_U2_W2_ProgettoViaggi.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrenotazionePayload {
    @NotNull(message = "L'ID del dipendente è obbligatorio")
    private Long dipendenteId;

    @NotNull(message = "L'ID del viaggio è obbligatorio")
    private Long viaggioId;

    private String notePreferenze;
}
