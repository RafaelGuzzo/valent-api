package com.valent.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valent.domain.model.Fornecedor;
import com.valent.domain.repository.FornecedorRepository;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}

	@GetMapping("/{idFornecedor}")
	public ResponseEntity<Fornecedor> buscar(@PathVariable Long idFornecedor) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(idFornecedor);
		return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public Fornecedor adicionar(@RequestBody Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	@PutMapping("/{idFornecedor}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Long idFornecedor, @RequestBody Fornecedor fornecedor) {
		if (!fornecedorRepository.existsById(idFornecedor)) {
			return ResponseEntity.notFound().build();
		}

		fornecedor.setIdPessoa(idFornecedor);
		fornecedor = fornecedorRepository.save(fornecedor);

		return ResponseEntity.ok(fornecedor);
	}

	@DeleteMapping("/{idFornecedor}")
	public ResponseEntity<Void> excluir(@PathVariable Long idFornecedor) {
		if (!fornecedorRepository.existsById(idFornecedor)) {
			return ResponseEntity.notFound().build();
		}

		fornecedorRepository.deleteById(idFornecedor);
		return ResponseEntity.noContent().build();
	}

}
