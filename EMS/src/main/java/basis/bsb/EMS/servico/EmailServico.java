package basis.bsb.EMS.servico;

import basis.bsb.EMS.servico.Config.ApplicationProperties;
import basis.bsb.EMS.servico.DTO.EmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
@Transactional
public class EmailServico {

    private final JavaMailSender javaSenderEmail;
    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public void sendEmail(EmailDTO emailDTO){
        MimeMessage mimeMessage = javaSenderEmail.createMimeMessage();
        MimeMessageHelper mime = new MimeMessageHelper(mimeMessage);

        mime.setTo(emailDTO.getDestinatario());
        mime.setFrom(applicationProperties.getEnderecoRemetente());
        mime.setSubject(emailDTO.getAssunto());

        for(String s : emailDTO.getCopias()){
            mime.addCc(s);
        }

        mime.setText("Patrocinador (id)"+ " ");
        javaSenderEmail.send(mimeMessage);
    }
}
