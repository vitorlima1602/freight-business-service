package com.estudos.business.controller;

import com.estudos.business.dto.AtualizarTransportadoraRequest;
import com.estudos.business.dto.TransportadoraRequest;
import com.estudos.business.dto.TransportadoraResponse;
import com.estudos.business.service.TransportadoraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraController {
    private final TransportadoraService transportadoraService;

    public TransportadoraController(TransportadoraService transportadoraService){
        this.transportadoraService = transportadoraService;
    }

    @PostMapping
    public ResponseEntity<TransportadoraResponse> salvar(@Valid @RequestBody TransportadoraRequest request){
        TransportadoraResponse response = transportadoraService.salvar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportadoraResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarTransportadoraRequest request){
        TransportadoraResponse response = transportadoraService.atualizar(id, request);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<TransportadoraResponse> desativar(@PathVariable Long id){
        TransportadoraResponse response = transportadoraService.desativar(id);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/ativar")
    public ResponseEntity<TransportadoraResponse> ativar(
            @PathVariable Long id
    ) {
        TransportadoraResponse response =
                transportadoraService.ativar(id);

        return ResponseEntity.ok(response);
    }
}
