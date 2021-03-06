package br.com.algaecommerce.api.controller;

import br.com.algaecommerce.exception.MyEntityNotFoundException;
import br.com.algaecommerce.model.Produto;
import br.com.algaecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public @ResponseBody Produto inserir(@RequestBody Produto produto) {
		produto.setDataCriacao(LocalDateTime.now(ZoneId.systemDefault()));
		produto.setId(null);
		return produtoRepository.save(produto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@PutMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public @ResponseBody Produto editar(@PathVariable Long produtoId, @RequestBody Produto produto) {
		produto.setId(produtoId);
		Produto produtoAtualizar = produtoRepository.findById(produtoId).orElseThrow(
				() -> new MyEntityNotFoundException("Erro 404 - Produto não encontrado")
		);
		produtoAtualizar.setNome(produto.getNome());
		produtoAtualizar.setTags(produto.getTags());
		return produtoRepository.save(produtoAtualizar);
	}

}
