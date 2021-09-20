package basis.bsb.EMS.servico.DTO;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {


    @NotBlank(message = "nao pode ser vazio")
    private Long id;

    @CPF(message = "CPF tem q ser valido")
    private String CPF;

    @Past(message = "Não pode ser uma data futura!")
    private LocalDate dataNascimento;

    @Email(message="Tem que ser um e-mail vaido!")
    private String email;

    @NotBlank
    private boolean status;


    private byte[] foto;

    @NotBlank(message = "Campo obrigatorio!")
    private String telefone;

    @NotBlank(message = "Campo obrigatorio!")
    private SelectDTO cargo;

}
