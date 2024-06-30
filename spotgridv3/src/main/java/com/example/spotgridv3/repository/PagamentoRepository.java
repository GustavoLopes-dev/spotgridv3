package com.example.spotgridv3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spotgridv3.model.Pagamento;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
}