package br.unipar.exemplorest;

import br.unipar.exemplorest.domain.Professor;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/professores")
public class ProfessorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> findAll() {
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

}