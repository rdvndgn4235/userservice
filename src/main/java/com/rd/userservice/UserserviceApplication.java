package com.rd.userservice;

import com.rd.userservice.domain.Role;
import com.rd.userservice.domain.User;
import com.rd.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Taner Kaya", "taner", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Tom Rock", "tom", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Anna Smith", "anna", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Linda North", "linda", "password", new ArrayList<>()));


            userService.addRoleToUser("taner", "ROLE_USER");
            userService.addRoleToUser("taner", "ROLE_MANAGER");
            userService.addRoleToUser("tom", "ROLE_ADMIN");
            userService.addRoleToUser("anna", "ROLE_MANAGER");
            userService.addRoleToUser("linda", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("linda", "ROLE_ADMIN");
            userService.addRoleToUser("linda", "ROLE_USER");
        };
    }

}
