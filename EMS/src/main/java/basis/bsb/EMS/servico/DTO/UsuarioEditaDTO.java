package basis.bsb.EMS.servico.DTO;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEditaDTO {

    @NotBlank
    private String nome;

    private Long id;

    @Past(message = "Não pode ser uma data futura!")
    @NotBlank
    private LocalDate dataNascimento;

    @Email(message="Tem que ser um e-mail vaido!")
    @Size(min = 10, max = 50)
    @NotBlank
    private String email;

    @NotBlank
    private boolean status;

    private byte[] foto;

    @NotBlank(message = "Campo obrigatorio!")
    private String telefone;

    @NotBlank(message = "Campo obrigatorio!")
    private SelectDTO cargo;
}
