package basis.bsb.EMS.servico.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaUsuarioDTO {

    private Long id;
    private String nome;
    private SelectDTO cargo;
    private boolean status;
}
