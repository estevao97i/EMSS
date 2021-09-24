package basis.bsb.EMS.servico.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EventoDTO {

    private Long id;

    @FutureOrPresent (message = "A data nao pode ser anterior a hoje")
    private LocalDate dataEvento;

    private String justificativaAdiamento;

    @NotBlank (message = "Campo obrigatorio!")
    private Integer valor;

    @NotBlank(message = "Campo obrigatorio")
    private SelectDTO situacao;

    @NotBlank
    private MotivoDTO motivo;

    @NotBlank
    private List<UsuarioDTO> usuario;

}
