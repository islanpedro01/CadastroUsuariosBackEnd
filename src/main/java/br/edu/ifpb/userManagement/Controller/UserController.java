package br.edu.ifpb.userManagement.Controller;

import br.edu.ifpb.userManagement.model.User;
import br.edu.ifpb.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    @Transactional
    public User salvarUsuario(User usuario){
        return userService.salvar(usuario);
    }

    @GetMapping
    public List<User> listarTodos(){
        return userService.listar();
    }

    @DeleteMapping
    public void excluirUsuario(String id){
        userService.excluir(id);

    }
}
