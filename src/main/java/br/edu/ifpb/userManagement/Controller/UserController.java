package br.edu.ifpb.userManagement.Controller;

import br.edu.ifpb.userManagement.model.User;
import br.edu.ifpb.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("")
    public User salvarUsuario(@RequestBody User usuario){
        return userService.salvar(usuario);
    }

    @GetMapping("")
    public List<User> listarTodos(){
        return userService.listar();
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> buscarPorEmail(@PathVariable String email) {
    User user = userService.buscarPorEmail(email);
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(user);
    }

    @GetMapping("/orcid/{orcid}")
    public ResponseEntity<User> buscarPorOrcid(@PathVariable String orcid) {
    User user = userService.buscarPorEmail(orcid);
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable("id") String id){
        userService.excluir(id);

    }

    @PutMapping("/{id}")
    public User atualizarUsuario(@RequestBody User usuario){
        return userService.atualizar(usuario);
    }
}
