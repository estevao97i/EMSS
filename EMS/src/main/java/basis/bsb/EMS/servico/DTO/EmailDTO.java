package basis.bsb.EMS.servico.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmailDTO implements Serializable {

    private String assunto;
    private String destinatario;
    private String corpo;
    private List<String> copias = new ArrayList<>();
}
