package br.com.algaecommerce.repository;

import br.com.algaecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("from Produto p left join fetch p.tags")
    List<Produto> findAll();

}
