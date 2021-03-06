package br.com.algaecommerce;

import br.com.algaecommerce.model.Cliente;
import br.com.algaecommerce.model.Pedido;
import br.com.algaecommerce.model.Produto;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class InitBancoDeDados implements ApplicationRunner {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 20; i++) {
			Produto produto1 = new Produto();
			produto1.setNome("Desktop");
			produto1.setTags(Arrays.asList("TI", "Mesa"));
			manager.persist(produto1);
			
			
			Produto produto2 = new Produto();
			produto2.setNome("Notebook");
			produto2.setTags(Arrays.asList("TI", "Portátil", "Departamento de TI"));
			manager.persist(produto2);
			
			
			Cliente cliente1 = new Cliente();
			cliente1.setNome("João");
			manager.persist(cliente1);
			
			
			Pedido pedido = new Pedido();
			pedido.setDataCriacao(LocalDateTime.now());
			pedido.setProdutoList(Arrays.asList(produto1, produto2));
			pedido.setCliente(cliente1);
			manager.persist(pedido);
			
			Cliente cliente2 = new Cliente();
			cliente2.setNome("Maria");
			manager.persist(cliente2);
			
			Pedido pedido2 = new Pedido();
			pedido2.setDataCriacao(LocalDateTime.now());
			pedido2.setProdutoList(Arrays.asList(produto1, produto2));
			pedido2.setCliente(cliente2);
			manager.persist(pedido2);
		}
	}
}
