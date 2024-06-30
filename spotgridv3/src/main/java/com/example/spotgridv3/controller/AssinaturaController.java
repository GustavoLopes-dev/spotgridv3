package com.example.spotgridv3.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.spotgridv3.formatacoes.CriarAssinaturaRequest;
import com.example.spotgridv3.model.Aplicativo;
import com.example.spotgridv3.service.AplicativoService;
import com.example.spotgridv3.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spotgridv3.model.Assinatura;
import com.example.spotgridv3.model.Cliente;
import com.example.spotgridv3.service.AssinaturaService;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;
    private final ClienteService clienteService;
    private final AplicativoService aplicativoService;

    public AssinaturaController(AssinaturaService assinaturaService, ClienteService clienteService, AplicativoService aplicativoService) {
        this.assinaturaService = assinaturaService;
        this.clienteService = clienteService;
        this.aplicativoService = aplicativoService;
    }

    //okay
    @GetMapping("")
    public List<Assinatura> listarAssinaturas() {
        return assinaturaService.listarTodasAssinaturas();
    }

    //okay
    @GetMapping("/status/{status}")
    public List<Assinatura> listarAssinaturasStatus(@PathVariable String status) {
        return assinaturaService.buscarAssinaturasPorStatus(status);
    }

    //ok
    @GetMapping("/codigo/{codigo}")
    public Assinatura buscarAssinaturaPorCodigo(@PathVariable Long codigo) {
        Optional<Assinatura> assinatura = assinaturaService.buscarPorCodigo(codigo);
        return assinatura.get();
    }

    //ok
    @PostMapping("")
    public Assinatura criarAssinatura(@RequestBody CriarAssinaturaRequest requestAssinatura) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(requestAssinatura.getCodigoCliente());
        Optional<Aplicativo> aplicativo = aplicativoService.buscarAplicativoPorId(requestAssinatura.getCodigoApp());
        Assinatura novaAssinatura = new Assinatura(cliente.get(), aplicativo.get());

        assinaturaService.criarAssinatura(novaAssinatura);
        return novaAssinatura;
    }

    //okay
    @GetMapping("/{tipo}")
    public List<Assinatura> buscarAssinaturasPorTipo(@PathVariable String tipo) {
        LocalDate dataAtual = LocalDate.now();

        switch (tipo.toUpperCase()) {
            case "TODAS":
                return listarAssinaturas();
            case "ATIVAS":
                return listarAssinaturasStatus("ativo").stream()
                        .filter(assinatura -> assinatura.getFimVigencia().isAfter(dataAtual))
                        .collect(Collectors.toList());
            case "CANCELADAS":
                return listarAssinaturasStatus("cancelado");
            case "INATIVAS":
                List<Assinatura> assinaturasInativasMarcadas = listarAssinaturasStatus("inativo");
                List<Assinatura> assinaturasInativasVerificadas = listarAssinaturas().stream()
                        .filter(assinatura -> assinatura.getFimVigencia().isBefore(dataAtual))
                        .collect(Collectors.toList());

                List<Assinatura> inativas = new ArrayList<>();
                inativas.addAll(assinaturasInativasMarcadas);
                inativas.addAll(assinaturasInativasVerificadas);
                return inativas;
            default:
                throw new IllegalArgumentException("Tipo de assinatura inválido: " + tipo);
        }   
    }


    //ok
    @GetMapping("/asscli/{codigocli}")
    public List<Assinatura> assinaturasByCliente(@PathVariable long codigocli) {
        List<Assinatura> assinaturas = assinaturaService.buscarAssinaturasPorCodigoCliente(codigocli);
        if (assinaturas!=null) {
            return assinaturas;
        } else {
            return null;
        }
    }

    //okay
    @GetMapping("/assap/{codigoAplicativo}")
    public ResponseEntity<List<Assinatura>> buscarAssinaturasPorCodigoAplicativo(@PathVariable Long codigoAplicativo) {
        List<Assinatura> assinaturas = assinaturaService.buscarAssinaturasPorCodigoAplicativo(codigoAplicativo);
        return ResponseEntity.ok(assinaturas);
    }

    //okay
    @GetMapping("/assinvalida/{codass}")
    public Boolean isValidaFunc(@PathVariable long codass) {
        Assinatura assinatura = assinaturaService.buscarAssinaturaPorCodigo(codass).get(0);
        if(assinatura.getStatus().equalsIgnoreCase("ativo")) {
            return true;
        } else {
            return false;
        }
    }
}
