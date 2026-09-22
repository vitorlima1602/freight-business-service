package com.estudos.business.mapper;

import com.estudos.business.dto.AtualizarTransportadoraRequest;
import com.estudos.business.dto.TransportadoraRequest;
import com.estudos.business.dto.TransportadoraResponse;
import com.estudos.business.entity.Transportadora;
import org.springframework.stereotype.Component;

@Component
public class TransportadoraMapper {
    private final EnderecoMapper enderecoMapper;

    public TransportadoraMapper(EnderecoMapper enderecoMapper) {
        this.enderecoMapper = enderecoMapper;
    }

    public Transportadora toEntity(TransportadoraRequest request){
        Transportadora transportadora = new Transportadora();

        transportadora.setRazaoSocial(request.getRazaoSocial());
        transportadora.setNomeFantasia(request.getNomeFantasia());
        transportadora.setCnpj(request.getCnpj());
        transportadora.setEmail(request.getEmail());
        transportadora.setTelefone(request.getTelefone());

        return transportadora;
    }

    public TransportadoraResponse toResponse(Transportadora transportadora){
        TransportadoraResponse response = new TransportadoraResponse();

        response.setId(transportadora.getId());
        response.setRazaoSocial(transportadora.getRazaoSocial());
        response.setNomeFantasia(transportadora.getNomeFantasia());
        response.setCnpj(transportadora.getCnpj());
        response.setEmail(transportadora.getEmail());
        response.setTelefone(transportadora.getTelefone());
        response.setAtiva(transportadora.getAtiva());
        response.setEndereco(
                enderecoMapper.toResponse(transportadora.getEndereco())
        );

        return response;
    }

    public void updateEntity(AtualizarTransportadoraRequest request, Transportadora transportadora){
        transportadora.setRazaoSocial(request.getRazaoSocial());
        transportadora.setNomeFantasia(request.getNomeFantasia());
        transportadora.setEmail(request.getEmail());
        transportadora.setTelefone(request.getTelefone());
    }
}
