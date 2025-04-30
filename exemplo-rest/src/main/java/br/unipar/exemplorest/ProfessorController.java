package br.unipar.exemplorest;

import br.unipar.exemplorest.domain.Professor;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/professores")
public class ProfessorController {

    //C - @POST - /professores - Body
    //R - @GET - /professores?nomeContem=And, /professores/{id}
    //U - @PUT - /professores/{id} - Body
    //D - @DELETE - /professores/{id}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> findAll(@QueryParam("nomeContem") String nomeContem,
                               @QueryParam("salario") Double salario) {
        System.out.println(nomeContem);
        System.out.println(salario);
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor(1, "Professor Anderson"));
        professores.add(new Professor(2, "Professor Triacca"));
        professores.add(new Professor(3, "Professora Juliane"));

        return professores;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor findById(@PathParam("id") Integer id) {
        return new Professor(id, "Professor Anderson");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professor insert(Professor professor) {
        return professor;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        // Implementar a lógica de exclusão
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professor update(@PathParam("id") Integer id, Professor professor) {
        // Implementar a lógica de atualização
        return professor;
    }

}