package com.curso.microsservico.pedido.repository;

import com.curso.microsservico.pedido.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
