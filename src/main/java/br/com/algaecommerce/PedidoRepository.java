package br.com.algaecommerce;

import java.util.List;

public interface PedidoRepository {
	List<Pedido> findAll();
}
