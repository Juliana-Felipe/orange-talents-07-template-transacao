package br.com.zupacademy.transacoes.transacoes;

import br.com.zupacademy.transacoes.transacoes.DTO.TransacaoListened;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    private Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoListened transacaoListened) {
        Transacao transacao = transacaoListened.converteParaTransacao();
        transacaoRepository.save(transacao);
        logger.info("Transação de id: {}, efetuada com sucesso!", transacaoListened.getId());
    }
}
