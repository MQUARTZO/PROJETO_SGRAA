package com.sgraa.service;
// Importa as classes necessárias para o funcionamento do serviço
import com.sgraa.model.Adocao;
import com.sgraa.repository.AdocaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio relacionada à entidade "Adocao".
 * Esta classe é responsável por intermediar a comunicação entre o controlador e o repositório,
 * aplicando regras de negócio e operações relacionadas a adoções.
 */
@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class AdocaoService {

    // Repositório utilizado para acessar e manipular dados relacionados a adoções
    private final AdocaoRepository adocaoRepository;

    /**
     * Construtor que recebe o repositório de adoções como dependência.
     * Isso é uma forma de injeção de dependência, onde o Spring injeta automaticamente
     * uma instância de AdocaoRepository quando o serviço é criado.
     *
     * @param adocaoRepository Repositório de adoções.
     */
    public AdocaoService(AdocaoRepository adocaoRepository) {
        this.adocaoRepository = adocaoRepository;
    }

    /**
     * Método para listar todas as adoções cadastradas no sistema.
     *
     * @return Uma lista contendo todas as adoções.
     */
    public List<Adocao> listarTodos() {
        return adocaoRepository.findAll();
    }

    /**
     * Método para salvar uma nova adoção no sistema.
     * Este método persiste a adoção no banco de dados e retorna a adoção salva.
     *
     * @param adocao A adoção a ser salva.
     * @return A adoção salva, incluindo seu ID gerado.
     */
    public Adocao salvar(Adocao adocao) {
        return adocaoRepository.save(adocao);
    }
}
