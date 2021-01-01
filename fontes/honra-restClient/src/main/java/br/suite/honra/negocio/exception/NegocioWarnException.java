package br.suite.honra.negocio.exception;

/**
 * 
 * @author carlosjrvieira
 * @date 03/08/2014
 * @version 1.0
 */
public class NegocioWarnException extends RuntimeException {
    private static final long serialVersionUID = 7214045413200634602L;

    public NegocioWarnException() {
        super();
    }

    /**
     * 
     * @version 1.0
     * @param msg
     */
    public NegocioWarnException(String msg) {
        super(msg);
    }

    /**
     * 
     * @version 1.0
     * @param msg
     * @param e
     */
    public NegocioWarnException(String msg, Exception e) {
        super(msg, e);
    }
}
