package br.com.algaecommerce.api.controller;

import br.com.algaecommerce.model.Pedido;
import br.com.algaecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public @ResponseBody
    Pedido inserir(@RequestBody Pedido pedido) {
        pedido.setDataCriacao(LocalDateTime.now(ZoneId.systemDefault()));
        pedido.setId(null);
        return pedidoRepository.save(pedido);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Pedido> listar() {
        List<Pedido> pedidoRepositorioAll = pedidoRepository.findAll();
        return pedidoRepositorioAll;
    }

}
