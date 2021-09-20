package basis.bsb.EMS.repositorio;

import basis.bsb.EMS.dominio.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepositori extends JpaRepository <Situacao,Long>{
}
