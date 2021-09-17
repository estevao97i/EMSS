package basis.bsb.EMS.servico.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.Select;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EventoDTO {
    private Long id;
    private LocalDateTime dataEvento;
    private String justificativaAdiamento;
    private Integer valor;
    private SelectDTO motivo;
    private SelectDTO situacao;
}
