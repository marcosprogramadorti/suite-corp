package br.suite.honra.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.suite.honra.model.dao.ILocacaoDAO;
import br.suite.honra.model.entity.Locacao;
import br.suite.honra.negocio.interfaces.ILocacaoNegocio;
import br.suite.honra.negocio.to.LocacaoTO;
import br.suite.honra.negocio.util.Conversor;

/**
 * Session Bean implementation class LocacaoNegocio
 */
@Stateless(name = "locacao_negocio")
public class LocacaoNegocio implements ILocacaoNegocio {
    @EJB
    private ILocacaoDAO locacaoDAO;

    @Override
    public List<LocacaoTO> lista() {
        List<Locacao> lista = locacaoDAO.lista();
        List<LocacaoTO> listaTO = Conversor.getInstancia().mapList(lista, LocacaoTO.class);

        return listaTO;
    }

}
