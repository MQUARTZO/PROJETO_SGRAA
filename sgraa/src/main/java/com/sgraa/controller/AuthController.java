package com.sgraa.controller;

import com.sgraa.model.Role;
import com.sgraa.model.Usuario;
import com.sgraa.repository.RoleRepository;
import com.sgraa.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/auth") // Define o endpoint base para autenticação
public class AuthController {
    private final UsuarioService usuarioService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // Construtor para injetar dependências do serviço de usuário, repositório de papéis e encoder de senha
    public AuthController(UsuarioService usuarioService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Endpoint para registro de usuário
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        // Verifica se já existe um usuário com o e-mail informado
        Optional<Usuario> usuarioExistente = usuarioService.buscarPorEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            return ResponseEntity.badRequest().body("Erro: Email já cadastrado.");
        }

        // Codifica a senha antes de salvar no banco de dados
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        // Busca o papel padrão "VOLUNTARIO" no banco de dados
        Role role = roleRepository.findByNome("VOLUNTARIO");
        if (role == null) { // Se o papel não existir, cria um novo e salva
            role = new Role();
            role.setNome("VOLUNTARIO");
            roleRepository.save(role);
        }

        // Atribui o papel "VOLUNTARIO" ao novo usuário
        usuario.setRoles(Collections.singleton(role));

        // Salva o novo usuário no banco de dados
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario); // Retorna o usuário criado com status 200 OK
    }
}
