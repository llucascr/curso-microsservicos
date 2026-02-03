package com.curso.microsservico.pedido.repository;

import com.curso.microsservico.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
