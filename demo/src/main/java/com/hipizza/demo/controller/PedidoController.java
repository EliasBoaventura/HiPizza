package com.hipizza.demo.controller;

import com.hipizza.demo.domain.Pedido;
import com.hipizza.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/fazer")
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        pedidoService.cadastrarPedido(pedido);

         return ResponseEntity.ok("Pedido realizado com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @GetMapping("/lista/{idConsumidor}")
    public ResponseEntity<List<Pedido>> getPedidosPorConsumidor(@PathVariable Long idConsumidor) {
        List<Pedido> pedidos = pedidoService.getPedidosPorConsumidor(idConsumidor);
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        pedidoService.excluirPedidoPorId(id);
        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }
}
