package hu.test.dave.controller;

import hu.test.dave.model.User;
import hu.test.dave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class NewUserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String createNewUser(){

        User user = new User();
        user.setName("Michael Jackson");

        userRepository.save(user);

        return "OK";
    }

}
