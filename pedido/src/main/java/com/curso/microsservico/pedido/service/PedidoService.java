package com.curso.microsservico.pedido.service;

import com.curso.microsservico.pedido.model.ItemPedido;
import com.curso.microsservico.pedido.model.Pedido;
import com.curso.microsservico.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(Pedido pedido) {

        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

}
