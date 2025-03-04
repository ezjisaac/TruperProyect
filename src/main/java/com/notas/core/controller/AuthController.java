package com.notas.core.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserLogin userLogin) {
        // Autenticación del usuario (esto es solo un ejemplo, deberías verificar contra una base de datos)
        if ("user".equals(userLogin.getUsername()) && "password".equals(userLogin.getPassword())) {
            String token = Jwts.builder()
                    .setSubject(userLogin.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + 864_000_000)) // 10 días
                    .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs")
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        } else {
            throw new RuntimeException("Nombre de usuario o contraseña incorrectos");
        }
    }

    static class UserLogin {
        private String username;
        private String password;

        // Getters y Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
