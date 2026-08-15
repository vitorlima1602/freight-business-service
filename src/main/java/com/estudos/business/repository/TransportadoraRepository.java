package com.estudos.business.repository;

import com.estudos.business.entity.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
    boolean existsByCnpj(String cnpj);
}
