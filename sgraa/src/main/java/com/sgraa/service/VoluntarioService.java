// Define o pacote onde esta classe está localizada
package com.sgraa.service;

// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Voluntario;
import com.sgraa.repository.VoluntarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Voluntario".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas aos voluntários.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class VoluntarioService {

    // Repositório utilizado para acessar e manipular dados relacionados aos voluntários
    private final VoluntarioRepository repository;

    /**
     * Construtor que recebe o repositório de voluntários como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de VoluntarioRepository quando o serviço é criado.
     *
     * @param repository Repositório de voluntários.
     */
    public VoluntarioService(VoluntarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Método para listar todos os voluntários cadastrados no sistema.
     *
     * @return Uma lista contendo todos os voluntários.
     */
    public List<Voluntario> listarTodos() {
        return repository.findAll();
    }

    /**
     * Método para salvar um novo voluntário no sistema.
     * Este método persiste o voluntário no banco de dados e retorna o voluntário salvo.
     *
     * @param voluntario O voluntário a ser salvo.
     * @return O voluntário salvo, incluindo seu ID gerado.
     */
    public Voluntario salvar(Voluntario voluntario) {
        return repository.save(voluntario);
    }
}
