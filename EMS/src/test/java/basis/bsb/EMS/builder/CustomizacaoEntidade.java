package basis.bsb.EMS.builder;

public interface CustomizacaoEntidade<E> {

    /**
     * Executa a customização da entidade
     *
     * @param entidade a ser customizada
     */
    void executar(E entidade);
}