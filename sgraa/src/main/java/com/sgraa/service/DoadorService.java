// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Doador;
import com.sgraa.repository.DoadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Doador".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas aos doadores.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class DoadorService {

    // Repositório utilizado para acessar e manipular dados relacionados aos doadores
    private final DoadorRepository repository;

    /**
     * Construtor que recebe o repositório de doadores como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de DoadorRepository quando o serviço é criado.
     *
     * @param repository Repositório de doadores.
     */
    public DoadorService(DoadorRepository repository) {
        this.repository = repository;
    }

    /**
     * Método para listar todos os doadores cadastrados no sistema.
     *
     * @return Uma lista contendo todos os doadores.
     */
    public List<Doador> listarTodos() {
        return repository.findAll();
    }

    /**
     * Método para salvar um novo doador no sistema.
     * Este método persiste o doador no banco de dados e retorna o doador salvo.
     *
     * @param doador O doador a ser salvo.
     * @return O doador salvo, incluindo seu ID gerado.
     */
    public Doador salvar(Doador doador) {
        return repository.save(doador);
    }

    /**
     * Método para deletar um doador pelo seu ID.
     * Este método remove o doador do banco de dados com base no ID fornecido.
     *
     * @param id O ID do doador a ser deletado.
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
