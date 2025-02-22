// Define o pacote onde esta classe está localizada
package com.sgraa.security;

// Importa as classes necessárias para configuração de segurança
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Anotação que indica que esta classe é uma classe de configuração do Spring
@Configuration
public class SecurityConfig {

    // Bean que define a cadeia de filtros de segurança (SecurityFilterChain)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita a proteção CSRF (Cross-Site Request Forgery)
                // Isso é útil para APIs RESTful, onde o CSRF não é uma preocupação,
                // e evita problemas ao testar endpoints com ferramentas como Postman.
                .csrf(csrf -> csrf.disable())

                // Configura as regras de autorização para as requisições HTTP
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso público aos endpoints de autenticação (/api/auth/**)
                        .requestMatchers("/api/auth/**").permitAll()

                        // Restringe acesso aos endpoints de animais (/api/animais/**) apenas para usuários com o papel "ADMIN"
                        .requestMatchers("/api/animais/**").hasRole("ADMIN")

                        // Restringe acesso aos endpoints de voluntários (/api/voluntarios/**) para usuários com os papéis "ADMIN" ou "VOLUNTARIO"
                        .requestMatchers("/api/voluntarios/**").hasAnyRole("ADMIN", "VOLUNTARIO")

                        // Exige autenticação para qualquer outra requisição que não corresponda às regras anteriores
                        .anyRequest().authenticated()
                )

                // Configura o endpoint de logout
                .logout(logout -> logout
                        // Define o endpoint de logout (/api/auth/logout)
                        .logoutUrl("/api/auth/logout")
                        // Permite que qualquer usuário acesse o endpoint de logout
                        .permitAll()
                );

        // Constrói e retorna a cadeia de filtros de segurança configurada
        return http.build();
    }

    // Bean que fornece o AuthenticationManager, responsável por gerenciar a autenticação
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        // Obtém o AuthenticationManager da configuração de autenticação
        return authConfig.getAuthenticationManager();
    }
}
