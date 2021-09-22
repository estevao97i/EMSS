package basis.bsb.EMS.servico.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.email")
@Getter
@Setter
public class ApplicationProperties {

    private String enderecoRemetente;
    private String nomeRemetente;
}
