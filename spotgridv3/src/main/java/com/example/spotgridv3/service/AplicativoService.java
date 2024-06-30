package com.example.spotgridv3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spotgridv3.model.Aplicativo;
import com.example.spotgridv3.repository.AplicativoRepository;

@Service
public class AplicativoService {

    private final AplicativoRepository aplicativoRepository;

    public AplicativoService(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<Aplicativo> listarTodosAplicativos() {
        return (List<Aplicativo>) aplicativoRepository.findAll();
    }

    public Optional<Aplicativo> buscarAplicativoPorId(Long id) {
        return aplicativoRepository.findById(id);
    }

    public Aplicativo atualizarAplicativo(Long id, double custo) {
        Optional<Aplicativo> atualizarAplicativo = aplicativoRepository.findById(id);
        if (atualizarAplicativo.isPresent()) {
            Aplicativo aplicativoExistente = atualizarAplicativo.get();
            aplicativoExistente.setCustoMensal(custo);
            return aplicativoRepository.save(aplicativoExistente);
        } else {
            return null;
        }
    }
}