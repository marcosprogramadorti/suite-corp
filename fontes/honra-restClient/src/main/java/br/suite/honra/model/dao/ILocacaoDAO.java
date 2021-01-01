package br.suite.honra.model.dao;

import javax.ejb.Remote;

import br.suite.honra.model.entity.Locacao;

@Remote
public interface ILocacaoDAO extends IGenericDAO<Locacao, Long> {
}
