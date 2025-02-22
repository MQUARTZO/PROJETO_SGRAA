// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

/**
 * Classe que representa a entidade "Usuario" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre os usuários do sistema,
 * incluindo seus papéis (roles) e credenciais de acesso.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Usuario {

    /**
     * Identificador único do usuário.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Nome completo do usuário.
     */
    private String nome;

    /**
     * Endereço de e-mail do usuário.
     * Este campo deve ser único no sistema, garantindo que não haja duplicação de e-mails.
     */
    @Column(unique = true) // Define que o valor deste campo deve ser único no banco de dados
    private String email;

    /**
     * Senha do usuário.
     * Este campo armazena a senha criptografada do usuário para autenticação no sistema.
     */
    private String senha;

    /**
     * Conjunto de papéis (roles) associados ao usuário.
     * Este campo representa um relacionamento muitos-para-muitos com a entidade Role.
     * Um usuário pode ter vários papéis, e um papel pode ser atribuído a vários usuários.
     * O fetch type EAGER garante que os papéis sejam carregados imediatamente quando o usuário for carregado.
     */
    @ManyToMany(fetch = FetchType.EAGER) // Define o relacionamento muitos-para-muitos com a entidade Role
    @JoinTable(
            name = "usuario_roles", // Nome da tabela de junção no banco de dados
            joinColumns = @JoinColumn(name = "usuario_id"), // Coluna que referencia o usuário
            inverseJoinColumns = @JoinColumn(name = "role_id") // Coluna que referencia o papel (role)
    )
    private Set<Role> roles; // Conjunto de papéis associados ao usuário
}
