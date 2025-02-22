// Define o pacote onde esta enumeração está localizada
package com.sgraa.model;

/**
 * Enumeração que representa os possíveis status de adoção de um animal.
 * Cada constante define um estado específico que um animal pode ter em relação ao processo de adoção.
 */
public enum StatusAdocao {

    /**
     * Status que indica que o animal está disponível para adoção.
     * Animais com esse status podem ser adotados por pretendentes.
     */
    DISPONIVEL,

    /**
     * Status que indica que o animal já foi adotado.
     * Animais com esse status não estão mais disponíveis para adoção.
     */
    ADOTADO,

    /**
     * Status que indica que o animal está temporariamente indisponível para adoção.
     * Isso pode ocorrer devido a tratamentos médicos, avaliações comportamentais ou outros motivos.
     */
    INDISPONIVEL
}
