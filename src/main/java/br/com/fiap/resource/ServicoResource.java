package br.com.fiap.resource;


import br.com.fiap.bo.ServicoBO;
import br.com.fiap.to.ServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/servico")

public class ServicoResource {
    private ServicoBO servicoBO = new ServicoBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (@Valid ServicoTO servico) {
        try {
            ServicoTO result = servicoBO.save(servico);
            Response.ResponseBuilder responseBuilder = null;
            if(result != null) {
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
    public Response update (@Valid ServicoTO servico, @PathParam("id") Long id) {
        try {
            servico.setId(id);
            ServicoTO result = servicoBO.update(servico);
            Response.ResponseBuilder responseBuilder = null;
            if(result != null) {
                responseBuilder = Response.ok();
            } else {
                responseBuilder = Response.status(404);
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
        if(servicoBO.delete(id)) {
            responseBuilder = Response.status(204);
        } else {
            responseBuilder = Response.status(404);
        }
        return responseBuilder.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ServicoTO> resultado = servicoBO.findAll();
        Response.ResponseBuilder responseBuilder = null;
        if(resultado != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(resultado);
        return responseBuilder.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        ServicoTO result = servicoBO.findById(id);
        Response.ResponseBuilder responseBuilder = null;
        if(result != null) {
            responseBuilder = Response.ok();
        } else {
            responseBuilder = Response.status(404);
        }
        responseBuilder.entity(result);
        return responseBuilder.build();
    }


}
