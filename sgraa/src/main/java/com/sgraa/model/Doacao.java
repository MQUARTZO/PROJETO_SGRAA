// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Classe que representa a entidade "Doacao" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre doações realizadas por doadores.
 * O doador pode ser uma pessoa física ou uma instituição.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Doacao {

    /**
     * Identificador único da doação.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Doador associado à doação.
     * Este campo representa um relacionamento muitos-para-um com a entidade Doador.
     * Uma doação está associada a um único doador, mas um doador pode estar associado a várias doações.
     * O doador pode ser uma pessoa física ou uma instituição.
     */
    @ManyToOne // Define o relacionamento muitos-para-um com a entidade Doador
    private Doador doador;

    /**
     * Item doado (ex: ração, medicamentos, brinquedos, etc.).
     */
    private String item;

    /**
     * Quantidade do item doado.
     */
    private Integer quantidade;

    /**
     * Data em que a doação foi realizada.
     * Este campo armazena a data da doação no formato LocalDate (AAAA-MM-DD).
     */
    private LocalDate dataDoacao;
}
