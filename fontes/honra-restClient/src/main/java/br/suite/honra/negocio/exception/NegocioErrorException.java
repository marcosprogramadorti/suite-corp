package br.suite.honra.negocio.exception;

/**
 * 
 * @author carlosjrvieira
 * @date 03/08/2014
 * @version 1.0
 */
public class NegocioErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NegocioErrorException() {
        super();
    }

    /**
     * 
     * @version 1.0
     * @param msg
     */
    public NegocioErrorException(String msg) {
        super(msg);
    }

    /**
     * 
     * @version 1.0
     * @param msg
     * @param e
     */
    public NegocioErrorException(String msg, Exception e) {
        super(msg, e);
    }
}
