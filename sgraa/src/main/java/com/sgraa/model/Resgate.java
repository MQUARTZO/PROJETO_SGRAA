// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe que representa a entidade "Resgate" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre operações de resgate de animais.
 * Um resgate pode estar associado a um ou mais animais.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Resgate {

    /**
     * Identificador único do resgate.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Data em que o resgate foi realizado.
     * Este campo armazena a data no formato LocalDate (AAAA-MM-DD).
     */
    private LocalDate dataResgate;

    /**
     * Localidade onde o resgate foi realizado.
     * Este campo armazena informações sobre o local do resgate (ex: cidade, bairro, endereço).
     */
    private String localidade;

    /**
     * Descrição detalhada do resgate.
     * Este campo pode conter informações sobre as circunstâncias do resgate, como condições do animal, situação do local, etc.
     */
    private String descricao;

    /**
     * Lista de animais resgatados nesta operação.
     * Este campo representa um relacionamento muitos-para-muitos com a entidade Animal.
     * Um resgate pode estar associado a vários animais, e um animal pode estar associado a vários resgates.
     */
    @ManyToMany // Define o relacionamento muitos-para-muitos com a entidade Animal
    @JoinTable(
            name = "rescue_animal", // Nome da tabela de junção no banco de dados
            joinColumns = @JoinColumn(name = "rescue_id"), // Coluna que referencia o resgate
            inverseJoinColumns = @JoinColumn(name = "animal_id") // Coluna que referencia o animal
    )
    private List<Animal> animais;
}
