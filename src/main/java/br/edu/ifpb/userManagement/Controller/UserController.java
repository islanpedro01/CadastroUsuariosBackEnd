package br.edu.ifpb.userManagement.Controller;

import br.edu.ifpb.userManagement.model.User;
import br.edu.ifpb.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("Usuário recebido no backend: " + usuario);
        return userService.salvar(usuario);
    }

    @GetMapping("")
    public List<User> listarTodos(){
        return userService.listar();
    }

    @DeleteMapping
    public void excluirUsuario(String id){
        userService.excluir(id);

    }
}
