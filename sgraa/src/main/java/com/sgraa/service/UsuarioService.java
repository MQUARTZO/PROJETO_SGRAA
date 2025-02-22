// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Usuario;
import com.sgraa.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Usuario".
 * Esta classe implementa a interface UserDetailsService do Spring Security para fornecer
 * detalhes do usuário durante o processo de autenticação.
 * Além disso, ela gerencia operações como salvar usuários e buscar usuários por e-mail.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class UsuarioService implements UserDetailsService {

    // Repositório utilizado para acessar e manipular dados relacionados aos usuários
    private final UsuarioRepository usuarioRepository;

    // Codificador de senhas utilizado para criptografar senhas antes de salvar no banco de dados
    private final PasswordEncoder passwordEncoder;

    /**
     * Construtor que recebe o repositório de usuários e o codificador de senhas como dependências.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * as instâncias necessárias quando o serviço é criado.
     *
     * @param usuarioRepository Repositório de usuários.
     * @param passwordEncoder Codificador de senhas.
     */
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Método da interface UserDetailsService que carrega os detalhes do usuário pelo e-mail.
     * Este método é usado pelo Spring Security durante o processo de autenticação.
     *
     * @param email O e-mail do usuário a ser carregado.
     * @return UserDetails contendo as informações do usuário (e-mail, senha e papéis).
     * @throws UsernameNotFoundException Se o usuário não for encontrado no banco de dados.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca o usuário pelo e-mail no banco de dados
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Constrói um objeto UserDetails com as informações do usuário
        return User.builder()
                .username(usuario.getEmail()) // Define o e-mail como nome de usuário
                .password(usuario.getSenha()) // Define a senha (já criptografada)
                .roles(usuario.getRoles().stream() // Mapeia os papéis (roles) do usuário
                        .map(role -> role.getNome()) // Obtém o nome de cada papel
                        .toArray(String[]::new)) // Converte para um array de strings
                .build();
    }

    /**
     * Método para buscar um usuário pelo e-mail.
     *
     * @param email O e-mail do usuário a ser buscado.
     * @return Um Optional contendo o usuário, se encontrado.
     */
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Método para salvar um novo usuário no sistema.
     * Este método criptografa a senha antes de salvar o usuário no banco de dados.
     *
     * @param usuario O usuário a ser salvo.
     * @return O usuário salvo, incluindo sua senha criptografada.
     */
    public Usuario salvarUsuario(Usuario usuario) {
        // Criptografa a senha antes de salvar o usuário
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }
}
