package com.example.spotgridv3.repository;

import com.example.spotgridv3.model.Assinatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaRepository extends CrudRepository<Assinatura, Long> {
    Assinatura findById(long id);
    List<Assinatura> findByClienteCodigo(Long codigoCliente); // Busca assinaturas por código do cliente
    List<Assinatura> findByAplicativoCodigo(Long codigoAplicativo); // Busca assinaturas por código do aplicativo
    List<Assinatura> findByStatusAtual(String status); // Busca assinaturas por status
}
