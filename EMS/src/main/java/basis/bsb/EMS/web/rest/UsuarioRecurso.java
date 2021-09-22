package basis.bsb.EMS.web.rest;


import basis.bsb.EMS.servico.DTO.UsuarioDTO;
import basis.bsb.EMS.servico.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity <UsuarioDTO> buscarPorId(@PathVariable Long id){
        UsuarioDTO usuario = usuarioServico.encontrarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity <List<UsuarioDTO>> buscarTodos(){
        return ResponseEntity.ok(usuarioServico.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioServico.salvar(usuarioDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id){
        return ResponseEntity.ok(usuarioServico.editar(usuarioDTO));
    }

    @PutMapping(value = "/ativa/{id}")
    public ResponseEntity<Void> ativarUsuario(@PathVariable Long id){
        usuarioServico.ativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/desativa/{id}")
    public ResponseEntity<Void> inativarUsuario(@PathVariable Long id){
        usuarioServico.inativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
