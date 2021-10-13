package basis.bsb.EMS.servico.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaEventoDTO implements Serializable {

    private Long id;
    private LocalDate dataEvento;
    private SelectDTO situacao;
    private MotivoDTO motivo;
    private List<UsuarioDTO> usuario;
}
