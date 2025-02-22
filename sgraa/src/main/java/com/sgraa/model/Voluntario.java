// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;

/**
 * Classe que representa a entidade "Voluntario" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre os voluntários
 * que colaboram com o sistema, incluindo suas funções e informações de contato.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Voluntario {

    /**
     * Identificador único do voluntário.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Nome completo do voluntário.
     */
    private String nome;

    /**
     * Informações de contato do voluntário (ex: telefone, e-mail).
     */
    private String contato;

    /**
     * Função exercida pelo voluntário no sistema.
     * Este campo é um enum que representa a função do voluntário, como "RESGATE" ou "ASSISTENCIA".
     * O valor é armazenado como uma string no banco de dados.
     */
    @Enumerated(EnumType.STRING) // Define que o valor do enum será armazenado como uma string no banco de dados
    private FuncaoVoluntario funcao;
}
