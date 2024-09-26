package com.postgre.sql.controller.authentication;

import com.postgre.sql.dto.atuthentication.LoginDto;
import com.postgre.sql.dto.atuthentication.TokenDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;
import com.postgre.sql.security.encrypt.PasswordEncryptionService;
import com.postgre.sql.security.jwt.OperationJwt;
import com.postgre.sql.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthorizationController {

    private final OperationJwt operationJwt;
    private final UserService userService;
    private final PasswordEncryptionService passwordEncryptionService;

    public AuthorizationController(OperationJwt operationJwt, UserService userService, PasswordEncryptionService passwordEncryptionService) {
        this.operationJwt = operationJwt;
        this.userService = userService;
        this.passwordEncryptionService = passwordEncryptionService;
    }

    @PostMapping
    public ResponseEntity<TokenDto> generationJwt(@RequestBody LoginDto loginDto){
        UserRepositoryDto userFound = userService.findByEmail(loginDto.getEmail());
        System.out.println("userFound: " + userFound);
        if (userFound != null){
            TokenDto tokenDto = new TokenDto();
            Calendar durationToken = Calendar.getInstance();
            durationToken.add(Calendar.MINUTE, 5);
            String jwt = "JWT No generado";

            System.out.println("Password clara: " + loginDto.getPassword());
            System.out.println("Password cifrada: " + userFound.getPassword());
            System.out.println("$2a$10$FNyzRWxXGmYCmh8fDpyXRujs.8k1xP1281/p3wQCYm58mX5duH57O".equals(userFound.getPassword()));
            System.out.println("Validacion directa " + passwordEncryptionService.isPasswordMatch(loginDto.getPassword(), "$2a$10$FNyzRWxXGmYCmh8fDpyXRujs.8k1xP1281/p3wQCYm58mX5duH57O"));
            Boolean validacion1 = passwordEncryptionService.isPasswordMatch(loginDto.getPassword(), userFound.getPassword());
            System.out.println("Validacion parametrizada " + validacion1);
            BCryptPasswordEncoder descrifrador = new BCryptPasswordEncoder();
            System.out.println("Validacion parametrizada " + descrifrador.matches(loginDto.getPassword(), userFound.getPassword()));
            if (passwordEncryptionService.isPasswordMatch(loginDto.getPassword(), userFound.getPassword())){
                jwt = operationJwt.generateToken(userFound, durationToken);
            }else {
                return new ResponseEntity("The password " + loginDto.getPassword() + " is not correct", HttpStatus.NOT_FOUND);
            }

            tokenDto.setJwt(jwt);
            tokenDto.setExpirationDateJwt(durationToken.getTime());
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        }else {
            return new ResponseEntity("The email " + loginDto.getEmail() + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
