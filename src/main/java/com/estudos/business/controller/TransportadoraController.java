package com.estudos.business.controller;

import com.estudos.business.dto.TransportadoraRequest;
import com.estudos.business.dto.TransportadoraResponse;
import com.estudos.business.service.TransportadoraService;
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
    public ResponseEntity<TransportadoraResponse> salvar(@RequestBody TransportadoraRequest request){
        TransportadoraResponse response = transportadoraService.salvar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
