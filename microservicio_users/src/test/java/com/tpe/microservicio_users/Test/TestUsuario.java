package com.tpe.microservicio_users.Test;
import com.tpe.microservicio_users.controller.UserController;
import com.tpe.microservicio_users.entity.User;
import com.tpe.microservicio_users.entity.UserAccount;
import com.tpe.microservicio_users.service.UserAccountService;
import com.tpe.microservicio_users.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TestUsuario {

    private final UserAccountService userAccountService = new UserAccountService() {
        @Override
        public UserAccount linkUserToAccount(Long userId, Long accountId) {
            return new UserAccount();
        }
    };

    private final UserService userService = new UserService() {
        @Override
        public Optional<User> getUserById(Long id) {
            if (id == 1L) {
                User user = new User();
                user.setId(1L);
                user.setFirstName("Test User");
                return Optional.of(user);
            }
            return Optional.empty();
        }

        @Override
        public void deleteUser(Long id) {
        }
    };

    private final UserController userController = new UserController();

    public TestUsuario() {
        userController.userAccountService = userAccountService;
        userController.userService = userService;
    }

    @Test
    void testLinkUserToAccount() {
        Long userId = 1L;
        Long accountId = 100L;

        ResponseEntity<String> response = userController.linkUserToAccount(userId, accountId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Cuenta vinculada exitosamente.", response.getBody());
    }

    @Test
    void testGetUserByIdFound() {
        ResponseEntity<User> response = userController.getUserById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Test User", response.getBody().getFirstName());
    }

    @Test
    void testGetUserByIdNotFound() {
        ResponseEntity<User> response = userController.getUserById(2L);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void testDeleteUser() {
        ResponseEntity<Void> response = userController.deleteUser(1L);
        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}