package br.com.coletafacil.ColetaFacil.service;

import br.com.coletafacil.ColetaFacil.ColetaFacilApplication;
import br.com.coletafacil.ColetaFacil.model.User;
import br.com.coletafacil.ColetaFacil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User createUser (User user){
        return repository.save(user);
    }

    public String loginUser(User user) {
        List<User> users = repository.findAll();
        for (User u: users) {
            if (u.getUserEmail().equals(user.getUserEmail()) && u.getUserPassword().equals(user.getUserPassword())) {
                return user.getUserEmail();
            }
        }

        return "FAILURE";


    }


}


