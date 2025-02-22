// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;

/**
 * Classe que representa a entidade "Role" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre os papéis (roles)
 * que podem ser atribuídos aos usuários do sistema, como "ADMIN" ou "VOLUNTARIO".
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Role {

    /**
     * Identificador único do papel (role).
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Nome do papel (role).
     * Este campo armazena o nome do papel, como "ADMIN" ou "VOLUNTARIO".
     * O valor deve ser único no sistema, garantindo que não haja duplicação de papéis.
     */
    @Column(unique = true) // Define que o valor deste campo deve ser único no banco de dados
    private String nome; // Exemplo: "ADMIN", "VOLUNTARIO"
}
