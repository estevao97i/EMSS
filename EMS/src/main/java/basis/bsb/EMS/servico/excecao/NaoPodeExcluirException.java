package basis.bsb.EMS.servico.excecao;

public class NaoPodeExcluirException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NaoPodeExcluirException(String message, Throwable cause) {
        super(message, cause);
    }
    public NaoPodeExcluirException(String message){
        super(message);
    }

    public NaoPodeExcluirException() {

    }
}
