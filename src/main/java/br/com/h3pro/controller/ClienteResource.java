package br.com.h3pro.controller;

import br.com.h3pro.domain.dto.ClienteDTO;
import br.com.h3pro.domain.dto.ErrorDTO;
import br.com.h3pro.mapper.ClienteMapper;
import br.com.h3pro.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;


@Path("/cliente")
public class ClienteResource {

    @Inject
    ClienteService service;
    @Inject
    ClienteMapper mapper;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarCliente(ClienteDTO cliente) {
        if(Objects.isNull(cliente)){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }

        if(!service.criarCliente(
                    mapper.mapCliente(cliente)
            )){
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorDTO("Não foi cadastrar o cliente"))
                    .build();
        }

        return Response.ok().build();

    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response desativarCliente(@HeaderParam("cpf") String cpf) {
        if(Objects.isNull(cpf)){
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorDTO("Cliente não informado."))
                    .build();
        }
        if(!service.desativarCliente(cpf)){
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorDTO("Não foi possivel desativar o cliente, tente mais tarde"))
                    .build();
        }

        return Response.ok().build();

    }


}
