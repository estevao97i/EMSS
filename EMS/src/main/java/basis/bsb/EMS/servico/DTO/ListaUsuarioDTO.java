package basis.bsb.EMS.servico.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaUsuarioDTO implements Serializable {

    private Long id;
    private String nome;
    private SelectDTO cargo;
    private boolean status;
}
