package com.postgre.sql.controller.user;

import com.postgre.sql.dto.user.UserCreatedDto;
import com.postgre.sql.dto.user.UserRegisterDto;
import com.postgre.sql.service.user.UserService;
import jakarta.persistence.Version;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserCreatedDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserCreatedDto> findUserById(@PathVariable("idUser") String idUser) {
        return new ResponseEntity<>(userService.findUserById(idUser), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCreatedDto> createUser(@RequestBody UserRegisterDto user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<Boolean> updateUser(@PathVariable("idUser") String idUser, @RequestBody UserRegisterDto user) {
        return new ResponseEntity<>(userService.updateUser(idUser, user), HttpStatus.OK);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("idUser") String idUser) {
        return new ResponseEntity<>(userService.deleteUser(idUser), HttpStatus.OK);
    }
}
