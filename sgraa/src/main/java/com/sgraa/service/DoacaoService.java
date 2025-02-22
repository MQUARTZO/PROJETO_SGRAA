// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Doacao;
import com.sgraa.repository.DoacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Doacao".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas a doações.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class DoacaoService {

    // Repositório utilizado para acessar e manipular dados relacionados a doações
    private final DoacaoRepository doacaoRepository;

    /**
     * Construtor que recebe o repositório de doações como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de DoacaoRepository quando o serviço é criado.
     *
     * @param doacaoRepository Repositório de doações.
     */
    public DoacaoService(DoacaoRepository doacaoRepository) {
        this.doacaoRepository = doacaoRepository;
    }

    /**
     * Método para listar todas as doações cadastradas no sistema.
     *
     * @return Uma lista contendo todas as doações.
     */
    public List<Doacao> listarTodos() {
        return doacaoRepository.findAll();
    }

    /**
     * Método para salvar uma nova doação no sistema.
     * Este método persiste a doação no banco de dados e retorna a doação salva.
     *
     * @param doacao A doação a ser salva.
     * @return A doação salva, incluindo seu ID gerado.
     */
    public Doacao salvar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }
}
/**
 * Esta classe pode ser expandida para incluir novos métodos, como validações de doações ou consultas personalizadas.
 */
