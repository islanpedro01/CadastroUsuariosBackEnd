package br.edu.ifpb.userManagement.service;

import br.edu.ifpb.userManagement.model.User;
import br.edu.ifpb.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User salvar(User usuario){
        return userRepository.save(usuario);
    }

    public List<User> listar(){
        return userRepository.findAll();
    }

    public void excluir(String id){
        userRepository.deleteById(id);

    }

}
