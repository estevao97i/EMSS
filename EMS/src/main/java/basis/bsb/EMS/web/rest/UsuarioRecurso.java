package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.dominio.Usuario;
import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id){
        UsuarioDTO usuario = usuarioServico.encontrarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity <List<UsuarioDTO>> buscarTodos(){
        List<UsuarioDTO> listUsuario = usuarioServico.buscarTodos();
    }


}
