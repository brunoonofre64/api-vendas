package io.github.brunoonofre64.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoonofre64.vendas.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
