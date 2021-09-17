package basis.bsb.EMS.dominio;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

    @Entity
    @Getter
    @Setter
    @Table(name="USUARIO")

public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "CPF")

    private String cpf;


    @Column(name = "DT_NASCIMENTO")
    private LocalDate dt_nascimento;

    @Column(name = "E-MAIL")
    private String email;

    @Column(name = "ID_CARGO")
    private Long id_cargo;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "FOTO")
    @Lob
    private byte[] foto;

    @Column(name = "TELEFONE")
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARGO")
    private Cargo cargo;
}

