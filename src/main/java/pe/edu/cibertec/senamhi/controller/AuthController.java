package pe.edu.cibertec.senamhi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.senamhi.dto.LoginRequest;
import pe.edu.cibertec.senamhi.dto.RegistroRequest;
import pe.edu.cibertec.senamhi.model.Usuario;
import pe.edu.cibertec.senamhi.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public String registrar(@RequestBody RegistroRequest request) {

        Optional<Usuario> existe = usuarioRepository.findByUsername(request.getUsername());

        if (existe.isPresent()) {
            return "El usuario ya existe";
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setUsername(request.getUsername());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol("USER");

        usuarioRepository.save(usuario);

        return "Usuario registrado correctamente";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(request.getUsername());

        if (usuarioOptional.isEmpty()) {
            return "Usuario no existe";
        }

        Usuario usuario = usuarioOptional.get();

        if (passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return "Login correcto";
        } else {
            return "Contraseña incorrecta";
        }
    }
}