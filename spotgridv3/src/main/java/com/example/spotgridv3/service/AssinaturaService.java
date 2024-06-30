package com.example.spotgridv3.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spotgridv3.model.Assinatura;
import com.example.spotgridv3.repository.AssinaturaRepository;

@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> listarTodasAssinaturas() {
        return (List<Assinatura>) assinaturaRepository.findAll();
    }
    public List<Assinatura> buscarAssinaturaPorCodigo(Long codigo) {
        Optional<Assinatura> assinaturaOptional = assinaturaRepository.findById(codigo);
        return assinaturaOptional.map(Collections::singletonList).orElse(Collections.emptyList());
    }
    
    public Assinatura criarAssinatura(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    public Assinatura atualizarAssinatura(Long codigo, Assinatura assinaturaAtualizada) {
        Optional<Assinatura> optionalAssinatura = assinaturaRepository.findById(codigo);
        if (optionalAssinatura.isPresent()) {
            Assinatura assinaturaExistente = optionalAssinatura.get();
            assinaturaExistente.setCliente(assinaturaAtualizada.getCliente());
            assinaturaExistente.setAplicativo(assinaturaAtualizada.getAplicativo());
            assinaturaExistente.setStatus(assinaturaAtualizada.getStatus());
            assinaturaExistente.setInicioVigencia(assinaturaAtualizada.getInicioVigencia());
            assinaturaExistente.setFimVigencia(assinaturaAtualizada.getFimVigencia());
            return assinaturaRepository.save(assinaturaExistente);
        } else {
            throw new RuntimeException("Assinatura não encontrada para atualização. Código: " + codigo);
        }
    }

    public void deletarAssinatura(Long codigo) {
        assinaturaRepository.deleteById(codigo);
    }

    public List<Assinatura> buscarAssinaturasPorCodigoCliente(Long codigoCliente) {
        return assinaturaRepository.findByClienteCodigo(codigoCliente);
    }

    public List<Assinatura> buscarAssinaturasPorCodigoAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.findByAplicativoCodigo(codigoAplicativo);
    }
    
    public List<Assinatura> buscarAssinaturasPorStatus(String status) {
        return assinaturaRepository.findByStatusAtual(status);
    }

    public Optional<Assinatura> buscarPorCodigo(Long codigo) {
        return assinaturaRepository.findById(codigo);
    }
}