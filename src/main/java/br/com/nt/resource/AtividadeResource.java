package br.com.nt.resource;

import br.com.nt.bo.AtividadeBO;
import br.com.nt.dao.AtividadeDAO;
import br.com.nt.to.AtividadeTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/atividade")

public class AtividadeResource {
    private AtividadeBO atividadeBO = new AtividadeBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (@Valid AtividadeTO atividade) {
        try {
            AtividadeTO result = atividadeBO.save(atividade);
            Response.ResponseBuilder responseBuilder = null;
            if (result != null) {
                responseBuilder = Response.created(null);
            } else {
                responseBuilder = Response.status(400);
            }
            responseBuilder.entity(result);
            return responseBuilder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update (@Valid AtividadeTO atividade, @PathParam("id") Long id) {
        try {
            atividade.setId(id);
            AtividadeTO result = atividadeBO.update(atividade);
            Response.ResponseBuilder responseBuilder = null;
            if (result != null) {
                responseBuilder = Response.created(null);
            } else {
                responseBuilder = Response.status(400);
            }
            responseBuilder.entity(result);
            return responseBuilder.build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder responseBuilder = null;
        if (atividadeBO.delete(id)) {
            responseBuilder = Response.status(204);
        } else {
            responseBuilder = Response.status(404);
        }
        return responseBuilder.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<AtividadeTO> result = atividadeBO.findAll();
        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        AtividadeTO result = atividadeBO.findById(id);
        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

    @GET
    @Path("/servico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdServico(@PathParam("id") Long id) {
        ArrayList<AtividadeTO> result = atividadeBO.findByServico(id);
        Response.ResponseBuilder responseBuilder = null;
        if (result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }

}
