package basis.bsb.EMS.repositorio;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.servico.DTO.EventoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento,Long> {

    boolean existsByDataEvento(LocalDate dataEvento);

}
