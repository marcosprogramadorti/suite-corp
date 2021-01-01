package br.suite.honra.model.dao;

import java.util.List;

public interface IGenericDAO<T, PK> {
    /**
     * 
     * @description Lista todos os objetos com tipo genérico
     * @version 1.0
     * @author carlosjrvieira
     * @return List<T>
     */
    public List<T> lista();

    /**
     * 
     * @author carlosjrvieira
     * @description Salva entidade do tipo genérico
     * @version 1.0
     * @param t
     * @return T
     */
    public T salvaOuAtualiza(T t);

    /**
     * 
     * @author carlosjrvieira
     * @version 1.0
     * @description remove entidade ao passar a entidade a ser removida
     * @param t
     * @return Boolean
     */
    public Boolean remove(T t);

    /**
     * 
     * @author carlosjrvieira
     * @version 1.0
     * @description remove entidade por id com parametro do tipo long
     * @param id
     */
    public void removePorId(PK id);

    /**
     * 
     * @author carlosjrvieira
     * @description busca por id entidade mas ignora se ela tiver sido marcado como removido
     * @version 1.0
     * @param id
     * @return T
     */
    public T buscarPorIdNaoRemovido(PK id);

    /**
     * @param parametros
     * @param t
     * @return
     */
    public List<T> pesquisar(List<String> parametros, T t);

    /**
     * @param id
     * @return
     */
    public T buscarPorId(PK id);

    /**
     * @return
     */
    public List<T> listarNaoRemovidos();

    public Boolean verificaInicializacao(Object obj);

}
