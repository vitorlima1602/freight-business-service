package com.estudos.business.service;

import com.estudos.business.entity.Transportadora;
import com.estudos.business.exception.RegraNegocioException;
import com.estudos.business.repository.TransportadoraRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportadoraService {
    private final TransportadoraRepository transportadoraRepository;

    public TransportadoraService(TransportadoraRepository transportadoraRepository) {
        this.transportadoraRepository = transportadoraRepository;
    }

    public Transportadora salvar(Transportadora transportadora){
        if (transportadoraRepository.existsByCnpj(transportadora.getCnpj())){
            throw  new RegraNegocioException(
                    "Já existe uma transportadora cadastrada com este CNPJ."
            );
        }

        transportadora.setAtiva(true);

        return transportadoraRepository.save(transportadora);
    }
}
