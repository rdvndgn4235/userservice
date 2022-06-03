package com.rd.userservice.api;

import com.rd.userservice.domain.Role;
import com.rd.userservice.domain.User;
import com.rd.userservice.payload.RoleToUserPayload;
import com.rd.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

/**
 * Created at 2.06.2022.
 *
 * @author Ridvan Dogan
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    ResponseEntity<?> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/user/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/role/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @GetMapping("/users/{username}")
    ResponseEntity<User> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }

    @PostMapping("/role/addtouser")
    ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserPayload payload){
        userService.addRoleToUser(payload.getUserName(), payload.getRoleName());
        return ResponseEntity.ok().build();
    }
}
