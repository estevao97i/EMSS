package basis.bsb.EMS.repositorio;

import basis.bsb.EMS.dominio.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo,Long> {
}
