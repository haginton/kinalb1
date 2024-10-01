package com.postgre.sql.controller.user;

import com.postgre.sql.dto.user.UserCreatedDto;
import com.postgre.sql.dto.user.UserRegisterDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.RoleEnum;
import com.postgre.sql.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void get_all_user_test(){
        //organizar

        List<UserCreatedDto> mockUsers = new ArrayList<>();
        mockUsers.add(new UserCreatedDto(new UserRepositoryDto("1", "pepe", "123adc", "pepe@mail.com", LocalDateTime.now(),LocalDateTime.now(), Collections.singletonList(RoleEnum.USER))));
        mockUsers.add(new UserCreatedDto(new UserRepositoryDto("2", "pepe", "123adc", "pepe@mail.com", LocalDateTime.now(),LocalDateTime.now(), Collections.singletonList(RoleEnum.USER))));
        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);

        //actuar

        ResponseEntity<List<UserCreatedDto>> response = userController.getAllUsers();
        //afirmar

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mockUsers, response.getBody());
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();

    }

    @Test
    public void get_all_user_empty_list_test(){
        //organizar

        List<UserCreatedDto> mockUsers = new ArrayList<>();
        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);

        //actuar

        ResponseEntity<List<UserCreatedDto>> response = userController.getAllUsers();
        //afirmar

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();

    }

    @Test
    public void get_all_user_server_error_test(){
        //organizar

        Mockito.when(userService.getAllUsers()).thenThrow(new RuntimeException("An error has occurred in the server"));

        //actuar

        ResponseEntity<List<UserCreatedDto>> response = userController.getAllUsers();
        //afirmar

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        //Mockito.verify(userService, Mockito.times(1)).getAllUsers();
        Assertions.assertEquals("An error has occurred in the server", response.getBody());

    }

    @Test
    public void find_user_by_id_not_found_test(){
        //organizar

        String userId = "a1";
        Mockito.when(userService.findUserById(userId)).thenThrow(new NoSuchElementException("User " + userId + " not found"));
        //actuar

        ResponseEntity<UserCreatedDto> response = userController.findUserById(userId);

        //afirmar

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        //Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("User " + userId + " not found", response.getBody());

    }

    @Test
    public void create_user_failure_test() {
        // Arrange
        UserRegisterDto userRequestDto = new UserRegisterDto("juanito", "1234", "juanito@mail.com");
        Mockito.when(userService.createUser(userRequestDto)).thenThrow(new RuntimeException("Failed to create user"));

        // Act
        ResponseEntity<UserCreatedDto> response = userController.createUser(userRequestDto);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void update_user_not_found_test() {
        // Arrange
        String userId = "123";
        UserRegisterDto userRequestDto = new UserRegisterDto("juanito", "1234", "juanito@mail.com");
        Mockito.when(userService.updateUser(userId, userRequestDto)).thenReturn(false);

        // Act
        ResponseEntity<Boolean> response = userController.updateUser(userId, userRequestDto);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.getBody());
    }

    @Test
    public void update_user_exception_test() {
        // Arrange
        String userId = "123";
        UserRegisterDto userRequestDto = new UserRegisterDto("juanito", "1234", "juanito@mail.com");
        Mockito.when(userService.updateUser(userId, userRequestDto)).thenThrow(new NoSuchElementException("User not found"));

        // Act
        ResponseEntity<Boolean> response = userController.updateUser(userId, userRequestDto);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("The user " + userId + " doesn't exist in the data base", response.getBody());
    }

}