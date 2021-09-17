package servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String CPF;
    private LocalDate data_nascimento;
    private String email;
    private boolean status;
    private byte[] foto;
    private String telefone;
    private SelectDTO cargo;

}
