package basis.bsb.EMS.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoRepositorio extends JpaRepository<Motivo,Long> {
}
