// Define o pacote onde esta classe está localizada
package com.sgraa.model;

// Importa as classes necessárias para a definição da entidade e anotações
import jakarta.persistence.*;
import lombok.Data;

/**
 * Classe que representa a entidade "Estoque" no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e armazena informações sobre os itens disponíveis no estoque.
 * O item pode ser tanto medicamento quanto alimento, ou qualquer outro tipo de recurso necessário.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar automaticamente getters, setters, toString, equals e hashCode
public class Estoque {

    /**
     * Identificador único do item no estoque.
     * Este campo é gerado automaticamente pelo banco de dados usando uma estratégia de autoincremento.
     */
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração de valor (autoincremento)
    private Long id;

    /**
     * Nome ou descrição do item no estoque.
     * Este campo pode representar tanto medicamentos quanto alimentos, ou qualquer outro tipo de recurso.
     */
    private String item;

    /**
     * Quantidade disponível do item no estoque.
     */
    private int quantidade;

    /**
     * Construtor com parâmetros para criar uma instância de Estoque.
     * Útil para inicializar o objeto com valores específicos.
     *
     * @param item Nome ou descrição do item.
     * @param quantidade Quantidade disponível do item.
     */
    public Estoque(String item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    /**
     * Construtor padrão sem argumentos.
     * Necessário para a JPA (Java Persistence API) e frameworks que dependem de reflexão.
     */
    public Estoque() {
    }
}
