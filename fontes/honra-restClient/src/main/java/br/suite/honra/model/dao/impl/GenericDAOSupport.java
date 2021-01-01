package br.suite.honra.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.transform.Transformers;

import br.suite.honra.model.dao.IGenericDAO;

public abstract class GenericDAOSupport<T1, PK> implements IGenericDAO<T1, PK> {

    private static final String FROM_LITERAL = "FROM ";
    private Class<T1> classe;
    @PersistenceContext(unitName = "SuiteCoreDominio")
    public EntityManager em;

    @SuppressWarnings("unchecked")
    public GenericDAOSupport() {
        this.classe = (Class<T1>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * @version 1.0
     * @return Criteria
     */
    public Criteria getHbCriteria() {
        Session session = getSession();
        return session.createCriteria(classe);
    }

    /**
     * 
     * @version 1.0
     * @return Session
     */
    public Session getSession() {
        return getEntityManager().unwrap(org.hibernate.Session.class);
    }

    /**
     * 
     * @version 1.0
     * @return String
     */
    public String getDefaultSchema() {
        SessionFactoryImplementor sfi = (SessionFactoryImplementor) getSession().getSessionFactory();
        return sfi.getSettings().getDefaultSchemaName();
    }

    /**
     * @see br.gov.transportes.scaadm.model.dao.IGenericDAO#verificaInicializacao(java.lang.Object)
     */
    @Override
    public Boolean verificaInicializacao(Object obj) {
        return Hibernate.isInitialized(obj);
    }

    /**
     * 
     * @description Lista todos os objetos com tipo genérico
     * @version 1.0
     * @author carlosjrvieira
     * @return List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T1> lista() {

        return getEntityManager().createQuery(FROM_LITERAL + classe.getName()).getResultList();

    }

    /**
     * 
     * @description Lista todos os objetos com tipo genérico
     * @version 1.0
     * @author carlosjrvieira
     * @return List<T>
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<T1> pesquisar(List<String> parametros, T1 t) {
        Criteria cr = getHbCriteria();
        for (String p : parametros) {
            cr.setProjection(Projections.projectionList().add(Projections.property(p), p));
        }
        return cr.setResultTransformer(Transformers.aliasToBean(t.getClass())).list();
    }

    /**
     * 
     * @version 1.0
     * @return EntityManager
     */

    protected EntityManager getEntityManager() {
        return this.em;

    }

    /**
     * 
     * @version 1.0
     * @param em
     * @return EntityManager
     */
    public EntityManager setEntityManager(EntityManager em) {
        this.em = em;
        return this.em;
    }

    /**
     * 
     * @author carlosjrvieira
     * @description Salva entidade do tipo genérico
     * @version 1.0
     * @param t
     * @return T
     */
    @Override
    public T1 salvaOuAtualiza(T1 t) {
        return getEntityManager().merge(t);
    }

    /**
     * 
     * @author carlosjrvieira
     * @version 1.0
     * @description remove entidade ao passar a entidade a ser removida
     * @param t
     * @return Boolean
     */
    @Override
    public Boolean remove(T1 t) {
        getEntityManager().remove(t);
        return Boolean.TRUE;
    }

    /**
     * 
     * @author carlosjrvieira
     * @version 1.0
     * @description retorna entidade ao passar long id
     * @param id
     * @return T
     */
    @Override
    public T1 buscarPorId(PK id) {
        return getEntityManager().find(classe, id);
    }

    /**
     * 
     * @author carlosjrvieira
     * @version 1.0
     * @description remove entidade por id com parametro do tipo long
     * @param id
     */
    @Override
    public void removePorId(PK id) {
        getEntityManager().remove(getEntityManager().getReference(classe, id));
    }

    /**
     * 
     * @author carlosjrvieira
     * @description busca por id entidade mas ignora se ela tiver sido marcado como removido
     * @version 1.0
     * @param id
     * @return T
     */
    @SuppressWarnings("unchecked")
    @Override
    public T1 buscarPorIdNaoRemovido(PK id) {
        Query query = getEntityManager().createQuery(FROM_LITERAL + classe.getName() + " WHERE stExcluido = 0 AND id = :id");
        query.setParameter("id", id);
        List<T1> t = query.getResultList();
        if (!t.isEmpty()) {
            return t.get(0);
        }
        return null;
    }

    /**
     * @author jackson
     * @description lista todos mas ignora se ela tiver sido marcado como removido
     * @version 1.0
     * @param id
     * @return T
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T1> listarNaoRemovidos() {
        Query query = getEntityManager().createQuery(FROM_LITERAL + classe.getName() + " WHERE stExcluido = 0");
        return query.getResultList();
    }
}
