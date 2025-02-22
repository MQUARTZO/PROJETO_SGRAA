// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Classe que representa a entidade "Adocao" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre adoções de animais.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Adocao {

    /**
     * Identificador único da adoção.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Animal que foi adotado.
     * Este campo representa um relacionamento muitos-para-um com a entidade Animal.
     * Uma adoção está associada a um único animal, mas um animal pode estar associado a várias adoções.
     */
    @ManyToOne // Define o relacionamento muitos-para-um com a entidade Animal
    private Animal animal;

    /**
     * Pretendente que realizou a adoção.
     * Este campo representa um relacionamento muitos-para-um com a entidade Pretendente.
     * Uma adoção está associada a um único pretendente, mas um pretendente pode estar associado a várias adoções.
     */
    @ManyToOne // Define o relacionamento muitos-para-um com a entidade Pretendente
    private Pretendente pretendente;

    /**
     * Data em que a adoção foi realizada.
     * Este campo armazena a data da adoção no formato LocalDate (AAAA-MM-DD).
     */
    private LocalDate dataAdocao;
}
