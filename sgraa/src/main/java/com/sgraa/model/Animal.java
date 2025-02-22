// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Classe que representa a entidade "Animal" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre os animais disponíveis para adoção.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Animal {

    /**
     * Identificador único do animal.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Espécie do animal (ex: Cachorro, Gato, etc.).
     */
    private String especie;

    /**
     * Raça do animal (ex: Labrador, Siames, etc.).
     */
    private String raca;

    /**
     * Idade do animal em anos.
     */
    private Integer idade;

    /**
     * Sexo do animal (ex: Masculino, Feminino).
     */
    private String sexo;

    /**
     * Porte do animal (ex: Pequeno, Médio, Grande).
     */
    private String porte;

    /**
     * Cor do animal (ex: Preto, Branco, Marrom).
     */
    private String cor;

    /**
     * Status de adoção do animal.
     * Este campo é um enum que representa o estado atual do animal em relação à adoção (ex: DISPONIVEL, ADOTADO).
     */
    @Enumerated(EnumType.STRING) // Define que o valor do enum será armazenado como uma string no banco de dados
    private StatusAdocao status;

    /**
     * Data de chegada do animal ao abrigo.
     * Este campo armazena a data no formato LocalDate (AAAA-MM-DD).
     */
    private LocalDate dataChegada;

    /**
     * Data de saída do animal do abrigo (ex: data de adoção ou transferência).
     * Este campo armazena a data no formato LocalDate (AAAA-MM-DD).
     */
    private LocalDate dataSaida;
}
