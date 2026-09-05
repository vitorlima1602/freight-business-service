package com.estudos.business.service;

import com.estudos.business.dto.AtualizarTransportadoraRequest;
import com.estudos.business.dto.TransportadoraRequest;
import com.estudos.business.dto.TransportadoraResponse;
import com.estudos.business.entity.Endereco;
import com.estudos.business.entity.Transportadora;
import com.estudos.business.exception.RegraNegocioException;
import com.estudos.business.mapper.EnderecoMapper;
import com.estudos.business.mapper.TransportadoraMapper;
import com.estudos.business.repository.EnderecoRepository;
import com.estudos.business.repository.TransportadoraRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportadoraService {
    private final TransportadoraRepository transportadoraRepository;
    private final TransportadoraMapper transportadoraMapper;
    private  final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    public TransportadoraService(TransportadoraRepository transportadoraRepository, TransportadoraMapper transportadoraMapper,
                                 EnderecoRepository enderecoRepository, EnderecoMapper enderecoMapper) {
        this.transportadoraRepository = transportadoraRepository;
        this.transportadoraMapper = transportadoraMapper;
        this.enderecoRepository = enderecoRepository;
        this.enderecoMapper = enderecoMapper;
    }

    public TransportadoraResponse salvar(TransportadoraRequest request){
        if (transportadoraRepository.existsByCnpj(request.getCnpj())){
            throw  new RegraNegocioException(
                    "Já existe uma transportadora cadastrada com este CNPJ."
            );
        }

        Transportadora transportadora = transportadoraMapper.toEntity(request);

        transportadora.setAtiva(true);

        Transportadora transportadoraSalva = transportadoraRepository.save(transportadora);



        if (request.getEndereco() != null) {
            Endereco endereco = enderecoMapper.toEntity(request.getEndereco());

            endereco.setTransportadora(transportadoraSalva);

            enderecoRepository.save(endereco);

            transportadoraSalva.setEndereco(endereco);
        }

        return transportadoraMapper.toResponse(transportadoraSalva);
    }

    public TransportadoraResponse atualizar(Long id, AtualizarTransportadoraRequest request){
        Transportadora transportadora = buscarPorId(id);

        transportadoraMapper.updateEntity(request, transportadora);

        Transportadora transportadoraAtualizada = transportadoraRepository.save(transportadora);

        return transportadoraMapper.toResponse(transportadoraAtualizada);
    }

    public TransportadoraResponse desativar(Long id){
        return alterarStatus(id, false);
    }

    public TransportadoraResponse ativar(Long id) {
        return alterarStatus(id, true);
    }

    private TransportadoraResponse alterarStatus(Long id, boolean ativa) {
        Transportadora transportadora = buscarPorId(id);

        transportadora.setAtiva(ativa);

        Transportadora transportadoraAtualizada =
                transportadoraRepository.save(transportadora);

        return transportadoraMapper.toResponse(transportadoraAtualizada);
    }

    public Transportadora buscarPorId(Long id){
        return transportadoraRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException(
                        "Transportadora não encontrada."
                ));
    }
}
