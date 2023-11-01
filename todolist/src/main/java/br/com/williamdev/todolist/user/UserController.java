package br.com.williamdev.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired // responsible for managing the userRepository lifecycle
    private InterfaceUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create (@RequestBody UserModel userModel) { // @Requestbody indicates that the parameters will come by request

        // validating username
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if(user != null) {
            // bad response entity
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário '" + user.getUsername() + "' já existe.");
        }

        /*
         * "hashToString" is responsible for encrypting a string.
         * "toCharArray" is responsible for transforming a string into an array of characters to serve as a parameter for "hashToString".
         */
        var passwordHashred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword()
        .toCharArray());

        userModel.setPassword(passwordHashred); // changes the password entered by the user to an encrypted one.

        var userCreated = this.userRepository.save(userModel); // saves the user to the database.
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); // good response entity.

    }

}
