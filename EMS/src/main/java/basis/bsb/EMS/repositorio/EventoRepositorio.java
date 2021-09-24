package basis.bsb.EMS.repositorio;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.servico.DTO.EventoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepositorio extends JpaRepository<Evento,Long>, JpaSpecificationExecutor<Evento> {

    boolean existsByDataEvento(LocalDate data);

    @Query("SELECT obj FROM Evento obj ORDER BY obj.dataEvento")
    List<Evento> OrderByDate();

    @Query("SELECT obj FROM Evento obj ORDER BY obj.dataEvento")
    List<Evento> OrderByDateAdiamento(LocalDate date);

    boolean existsByUsuario(Usuario usuario);

    @Query("SELECT obj FROM Evento obj WHERE id")

}
