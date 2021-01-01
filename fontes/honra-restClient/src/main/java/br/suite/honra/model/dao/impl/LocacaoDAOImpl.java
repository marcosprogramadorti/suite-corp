package br.suite.honra.model.dao.impl;

import javax.ejb.Stateless;

import br.suite.honra.model.dao.ILocacaoDAO;
import br.suite.honra.model.entity.Locacao;

/**
 * Session Bean implementation class LocacaoDAOImpl
 */
@Stateless(name = "locacao_DAO")
public class LocacaoDAOImpl extends GenericDAOSupport<Locacao, Long> implements ILocacaoDAO {

}
