package com.estudos.business.mapper;

import com.estudos.business.dto.EnderecoRequest;
import com.estudos.business.dto.EnderecoResponse;
import com.estudos.business.entity.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public Endereco toEntity(EnderecoRequest request) {
        Endereco endereco = new Endereco();

        endereco.setLogradouro(request.getLogradouro());
        endereco.setNumero(request.getNumero());
        endereco.setComplemento(request.getComplemento());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());
        endereco.setCep(request.getCep());

        return endereco;
    }

    public EnderecoResponse toResponse(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        EnderecoResponse response = new EnderecoResponse();

        response.setId(endereco.getId());
        response.setLogradouro(endereco.getLogradouro());
        response.setNumero(endereco.getNumero());
        response.setComplemento(endereco.getComplemento());
        response.setBairro(endereco.getBairro());
        response.setCidade(endereco.getCidade());
        response.setEstado(endereco.getEstado());
        response.setCep(endereco.getCep());

        return response;
    }
}
