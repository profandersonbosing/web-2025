package br.unipar.unilivrariarest;

import br.unipar.unilivrariarest.domain.Autor;
import br.unipar.unilivrariarest.dto.AutorInsertRequestDTO;
import br.unipar.unilivrariarest.exceptions.BusinessException;
import br.unipar.unilivrariarest.services.AutorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/autores")
public class AutorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autor> findAll(@QueryParam("nome") String nome) throws BusinessException {

        List<Autor> listaAutores = new ArrayList<Autor>();

        AutorService autorService = new AutorService();
        if (nome != null)
            listaAutores = autorService.buscarPorNome(nome);
        else
            listaAutores = autorService.buscarTodos();

        return listaAutores;

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Autor findById(@PathParam("id") Integer id) throws BusinessException {
        AutorService autorService = new AutorService();
        return new Autor();//autorService.buscarPorId(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Autor insert(AutorInsertRequestDTO autorInsertRequestDTO) throws BusinessException {
        AutorService autorService = new AutorService();
        Autor autor = new Autor(autorInsertRequestDTO);

        return autorService.inserir(autor);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Autor update(@PathParam("id") Integer id,
                        AutorInsertRequestDTO autorInsertRequestDTO) throws BusinessException {
        AutorService autorService = new AutorService();
        Autor autor = new Autor(id, autorInsertRequestDTO);

        return autorService.editar(autor);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) throws BusinessException {
        AutorService autorService = new AutorService();
        autorService.deletar(id);
    }

}