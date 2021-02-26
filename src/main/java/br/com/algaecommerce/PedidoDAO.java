package br.com.algaecommerce;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoDAO implements PedidoRepository {
	
	@PersistenceContext
	EntityManager manager;
	
	PedidoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public List<Pedido> findAll() {
		TypedQuery<Pedido> typedQuery = manager.createQuery("select p from Pedido p", Pedido.class);
		List<Pedido> lista = typedQuery.getResultList();
		return new ArrayList<>(lista);
	}
	
}
