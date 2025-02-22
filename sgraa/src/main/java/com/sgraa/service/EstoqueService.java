// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Estoque;
import com.sgraa.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Estoque".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas ao estoque de itens.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class EstoqueService {

    // Repositório utilizado para acessar e manipular dados relacionados ao estoque
    private final EstoqueRepository estoqueRepository;

    /**
     * Construtor que recebe o repositório de estoque como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de EstoqueRepository quando o serviço é criado.
     *
     * @param estoqueRepository Repositório de estoque.
     */
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    /**
     * Método para consumir itens do estoque.
     * Este método verifica se há itens suficientes no estoque e, se houver, reduz a quantidade disponível.
     *
     * @param item Nome ou descrição do item a ser consumido.
     * @param quantidade Quantidade do item a ser consumida.
     * @return true se o item foi consumido com sucesso, false se não houver itens suficientes no estoque.
     */
    public boolean consumirItem(String item, int quantidade) {
        // Busca o item no estoque pelo nome
        Optional<Estoque> estoqueOpt = estoqueRepository.findByItem(item);

        // Verifica se o item existe e se há quantidade suficiente no estoque
        if (estoqueOpt.isEmpty() || estoqueOpt.get().getQuantidade() < quantidade) {
            return false; // Não há itens suficientes no estoque
        }

        // Atualiza a quantidade do item no estoque
        Estoque estoque = estoqueOpt.get();
        estoque.setQuantidade(estoque.getQuantidade() - quantidade);
        estoqueRepository.save(estoque);

        return true; // Item consumido com sucesso
    }
}
