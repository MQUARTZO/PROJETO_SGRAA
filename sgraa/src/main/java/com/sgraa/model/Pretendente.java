// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;

/**
 * Classe que representa a entidade "Pretendente" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre pessoas
 * que estão interessadas em adotar um animal.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Pretendente {

    /**
     * Identificador único do pretendente.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Nome completo do pretendente.
     */
    private String nome;

    /**
     * Informações de contato do pretendente (ex: telefone, e-mail).
     */
    private String contato;

    /**
     * Endereço do pretendente.
     */
    private String endereco;
}
