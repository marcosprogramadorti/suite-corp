package br.suite.honra.negocio.interfaces;

import java.util.List;

import javax.ejb.Remote;

import br.suite.honra.negocio.to.LocacaoTO;

@Remote
public interface ILocacaoNegocio {

    public List<LocacaoTO> lista();
}
