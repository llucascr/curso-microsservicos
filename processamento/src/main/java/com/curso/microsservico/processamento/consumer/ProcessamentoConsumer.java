package com.curso.microsservico.processamento.consumer;

import com.curso.microsservico.processamento.dto.PedidoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessamentoConsumer {


    private static final Logger log = LoggerFactory.getLogger(ProcessamentoConsumer.class);

    @RabbitListener(queues = "${broker.queue.processamento.name}")
    public void listenerProcessamentoQueue(PedidoDTO dto) {
        log.info("Recebendo descrição: {}", dto.descricao());
    }

}
