// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Pretendente;
import com.sgraa.repository.PretendenteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Pretendente".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas aos pretendentes (pessoas interessadas em adotar animais).
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class PretendenteService {

    // Repositório utilizado para acessar e manipular dados relacionados aos pretendentes
    private final PretendenteRepository repository;

    /**
     * Construtor que recebe o repositório de pretendentes como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de PretendenteRepository quando o serviço é criado.
     *
     * @param repository Repositório de pretendentes.
     */
    public PretendenteService(PretendenteRepository repository) {
        this.repository = repository;
    }

    /**
     * Método para listar todos os pretendentes cadastrados no sistema.
     *
     * @return Uma lista contendo todos os pretendentes.
     */
    public List<Pretendente> listarTodos() {
        return repository.findAll();
    }

    /**
     * Método para salvar um novo pretendente no sistema.
     * Este método persiste o pretendente no banco de dados e retorna o pretendente salvo.
     *
     * @param pretendente O pretendente a ser salvo.
     * @return O pretendente salvo, incluindo seu ID gerado.
     */
    public Pretendente salvar(Pretendente pretendente) {
        return repository.save(pretendente);
    }

    /**
     * Método para deletar um pretendente pelo seu ID.
     * Este método remove o pretendente do banco de dados com base no ID fornecido.
     *
     * @param id O ID do pretendente a ser deletado.
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
/**
 * Esta classe pode ser expandida para incluir novos métodos, como validações de pretendentes ou consultas personalizadas.
 */
