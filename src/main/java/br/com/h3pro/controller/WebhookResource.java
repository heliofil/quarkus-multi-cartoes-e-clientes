package br.com.h3pro.controller;


import br.com.h3pro.domain.dto.ErrorDTO;
import br.com.h3pro.domain.dto.NovoCVVDTO;
import br.com.h3pro.domain.dto.PedidoDTO;
import br.com.h3pro.mapper.CartaoMapper;
import br.com.h3pro.service.CartaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

@Path("/webhook")
public class WebhookResource {


    @Inject
    CartaoService service;
    @Inject
    CartaoMapper mapper;


    //To colocando uma chave para o webhook aqui mas poderia estar em uma base de urls.
    public final static String WEB_DELIVERY_KEY = "89743a65-1982-4fdd-9aa5-02634c182844";
    public final static String WEB_CCV_KEY = "27764a7e-3522-4a70-9ef0-fc169822a366";


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delivery/status/{webkey}")
    public Response updateDeliveryStatus(@PathParam("webkey") String webkey, PedidoDTO pedido) {
        if(!webkey.equals(WEB_DELIVERY_KEY)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if(Objects.isNull(pedido)){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }

        if(service.atualizarPedido(mapper.mapPedido(pedido))) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Não foi possivel atualizar o status da entrega, tente mais tarde")).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/card/virtual/cvv/{webkey}")
    public Response changeVirtualCVV(@PathParam("webkey") String webkey, NovoCVVDTO novo) {
        if(!webkey.equals(WEB_CCV_KEY)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if(Objects.isNull(novo)){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }

        if(service.atualizaCVV(novo.getCpf(),novo.getCartao(),novo.getCvv(),novo.getDataValiade())) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Não foi possivel atualizar o cvv do cartao")).build();
    }


}
