package com.curso.microsservico.pedido.controller;

import com.curso.microsservico.pedido.model.Pedido;
import com.curso.microsservico.pedido.service.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoService pedidoService;

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    public PedidoController(PedidoService pedidoService,  RabbitTemplate rabbitTemplate) {
        this.pedidoService = pedidoService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        rabbitTemplate.convertAndSend("", routingKey, pedidoSalvo);
        return ResponseEntity.ok(pedidoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

}
