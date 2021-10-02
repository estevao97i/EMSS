package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.ListaUsuarioDTO;
import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.UsuarioServico;
import basis.bsb.EMS.servico.filtro.UsuarioFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioServico.encontrarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        List<UsuarioDTO> listUsuario = usuarioServico.buscarTodos();
        return ResponseEntity.ok(listUsuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioServico.salvar(usuarioDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id) {
        usuarioDTO.setId(id);
        usuarioDTO = usuarioServico.editar(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping(value = "/ativa/{id}")
    public ResponseEntity<Void> ativarUsuario(@PathVariable Long id) {
        usuarioServico.ativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/desativa/{id}")
    public ResponseEntity<Void> inativarUsuario(@PathVariable Long id) {
        usuarioServico.inativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "filtro")
    public ResponseEntity<List<UsuarioDTO>> encontrarTodosFiltro(UsuarioFiltro filtro) {
        return ResponseEntity.ok(usuarioServico.buscarTodosFiltro(filtro));

    }
}
