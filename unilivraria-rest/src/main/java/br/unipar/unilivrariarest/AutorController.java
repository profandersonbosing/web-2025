package br.unipar.unilivrariarest;

import br.unipar.unilivrariarest.domain.Autor;
import br.unipar.unilivrariarest.dto.AutorInsertRequestDTO;
import br.unipar.unilivrariarest.dto.ExceptionResponseDTO;
import br.unipar.unilivrariarest.exceptions.BusinessException;
import br.unipar.unilivrariarest.services.AutorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    public Response insert(AutorInsertRequestDTO autorInsertRequestDTO) {

        try {

            AutorService autorService = new AutorService();
            Autor autor = new Autor(autorInsertRequestDTO);

            autor = autorService.inserir(autor);

            return Response.
                    status(Response.Status.CREATED).
                    entity(autor).build();

        } catch (BusinessException businessException) {
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO(businessException.getMessage());

            return Response.
                    status(Response.Status.BAD_REQUEST).
                    entity(exceptionResponseDTO).
                    build();
        } catch (Exception exception) {
            ExceptionResponseDTO exceptionResponseDTO =
                    new ExceptionResponseDTO("Ocorreu um erro Interno.");

            return Response.
                    serverError().
                    entity(exceptionResponseDTO).
                    build();
        }
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