package com.backendproject.springBackend.auth;

import com.backendproject.springBackend.security.JwtTokenProvider;
import com.backendproject.springBackend.usuarios.dto.UsuarioLoginDTO;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdNoRolDTO;
import com.backendproject.springBackend.usuarios.service.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuariosService usuariosService;

    @Operation(summary = "Este Post permite autenticar un usuario", description = "Los parámetros requeridos para autenticar son los de email y password.")
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UsuarioLoginDTO user) {

        logger.info(() -> "ingresando a authenticate");

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

            String token = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(token);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado.");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contraseña invalida.");
        } catch (Exception e) {
            logger.error(e::getMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Autenticación fallida");
        }
    }

    @Operation(summary = "Este Post permite registrar un usuario", description = "El rol se asigna automáticamente y el id también.")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsuariosNoIdNoRolDTO user) {
        usuariosService.crearUnUsuario(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
}