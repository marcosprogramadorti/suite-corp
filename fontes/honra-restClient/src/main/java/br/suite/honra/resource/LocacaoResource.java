package br.suite.honra.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.suite.honra.negocio.interfaces.ILocacaoNegocio;
import br.suite.honra.negocio.to.LocacaoTO;

@RequestScoped
@Path("/locacao")
public class LocacaoResource {

    @EJB
    private ILocacaoNegocio locacaoNegocio;

    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LocacaoTO> listar() {
        System.out.println("teste");
        return locacaoNegocio.lista();
    }
}
