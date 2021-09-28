package basis.bsb.EMS.servico.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MotivoDTO {

    private Long id;

    @NotBlank
    @Max(value = 30)
    private String titulo;

    @NotBlank
    @Max(150)
    private String descricao;
}
