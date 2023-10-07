package com.app.stream.controllers;

import com.app.stream.entity.User;
import com.app.stream.repository.UserRepository;
import com.app.stream.util.JWTUtil;
import com.app.stream.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;


@CrossOrigin(origins = "*")
@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    private User user;
    private Message message;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/auth/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User userReq) {
        try {
            message = new Message();
            user = userRepository.findByEmail(userReq.getEmail());
            if (passwordEncoder.matches(userReq.getPassword(), user.getPassword())) {
                String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());

                // Obtén el rol del usuario
                String userRole = user.getRol_id().getRolName(); // Accede al rol a través de la relación "rol_id"

                // Crea un objeto JSON que incluye el token y el rol
                JSONObject responseJson = new JSONObject();
                responseJson.put("token", token);
                responseJson.put("userRole", userRole);

                return ResponseEntity.ok(responseJson.toString()); // Devuelve la respuesta JSON con el token y el rol
            }
            return message.viewMessage(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "invalid username or password");
        } catch (Exception e) {
            return message.viewMessage(HttpStatus.INTERNAL_SERVER_ERROR, "error", "An error occurred!" + e.getLocalizedMessage());
        }
    }

}