package com.estudos.business.service;

import com.estudos.business.dto.TransportadoraRequest;
import com.estudos.business.dto.TransportadoraResponse;
import com.estudos.business.entity.Transportadora;
import com.estudos.business.exception.RegraNegocioException;
import com.estudos.business.mapper.TransportadoraMapper;
import com.estudos.business.repository.TransportadoraRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportadoraService {
    private final TransportadoraRepository transportadoraRepository;
    private final TransportadoraMapper transportadoraMapper;

    public TransportadoraService(TransportadoraRepository transportadoraRepository, TransportadoraMapper transportadoraMapper) {
        this.transportadoraRepository = transportadoraRepository;
        this.transportadoraMapper = transportadoraMapper;
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

        return transportadoraMapper.toResponse(transportadoraSalva);
    }

    public Transportadora buscarPorId(Long id){
        return transportadoraRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException(
                        "Transportadora não encontrada."
                ));
    }
}
