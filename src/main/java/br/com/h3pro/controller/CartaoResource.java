package br.com.h3pro.controller;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.dto.CartaoDTO;
import br.com.h3pro.domain.dto.ErrorDTO;
import br.com.h3pro.domain.dto.SolicitacaoCartaoDTO;
import br.com.h3pro.mapper.CartaoMapper;
import br.com.h3pro.service.CartaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Objects;

@Path("/cartao")
public class CartaoResource {


    @Inject
    CartaoService service;
    @Inject
    CartaoMapper mapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response solicitarCartao(SolicitacaoCartaoDTO solicitacao) {
        if(Objects.isNull(solicitacao)){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Cartao cartao = service.solicitarCartao(solicitacao.getCpf(),solicitacao.getEVirtual());

        if(Objects.isNull(cartao)){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO("Não foi possivel solicitar o cartao")).build();
        }

        return Response.ok().entity(mapper.mapCartao(cartao)).build();

    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/reemissao/{idCartao}/{idMotivo}")
    public Response reemitirCartao(@PathParam("idCartao") long idCartao,@PathParam("idMotivo") int motivo) {

        Cartao cartao = service.reemitirCartao(idCartao,motivo);
        if(Objects.isNull(cartao)) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorDTO("Não foi possivel reemitir um novo cartão"))
                    .build();
        }

        CartaoDTO cartaoDTO = mapper.mapCartao(cartao);

        return Response
                .status(Response.Status.CREATED)
                .entity(cartaoDTO)
                .build();


    }

}
