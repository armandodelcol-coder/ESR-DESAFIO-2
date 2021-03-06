package br.com.algaecommerce.repository;

import br.com.algaecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("from Pedido p join fetch p.produtoList join fetch p.cliente")
	List<Pedido> findAll();

}
