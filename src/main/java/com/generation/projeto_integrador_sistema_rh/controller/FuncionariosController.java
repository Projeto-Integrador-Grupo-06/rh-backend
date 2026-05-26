package com.generation.projeto_integrador_sistema_rh.controller;

// Importações necessárias
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_integrador_sistema_rh.model.Funcionarios;
import com.generation.projeto_integrador_sistema_rh.repository.FuncionariosRepository;

import jakarta.validation.Valid;


@RestController   // Define que esta classe será um Controller REST
@RequestMapping("/funcionarios")   // Define a rota principal da API
@CrossOrigin(origins = "*", allowedHeaders = "*")   // Permite acesso de qualquer origem (frontend)
public class FuncionariosController {

	
	@Autowired	// Injeta automaticamente o Repository
	private FuncionariosRepository funcionariosRepository;

	// LISTAR TODOS FUNCIONÁRIOS
	@GetMapping 	// Endpoint: GET /funcionarios	// Método GET
	public ResponseEntity<List<Funcionarios>> getAll() {

		// Busca todos os funcionários no banco
		return ResponseEntity.ok(funcionariosRepository.findAll());
	}

	// BUSCAR FUNCIONÁRIO POR ID
	@GetMapping("/{id}")	// Endpoint: GET /funcionarios/{id}
	public ResponseEntity<Funcionarios> getById(@PathVariable Long id) {

		// Busca funcionário pelo ID
		return funcionariosRepository.findById(id)

				// Se encontrar retorna 200 OK
				.map(resposta -> ResponseEntity.ok(resposta))

				// Se não encontrar retorna 404 NOT FOUND
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// BUSCAR FUNCIONÁRIOS COM SALÁRIO MAIOR QUE

	// Endpoint:
	// GET /funcionarios/salario/1518

	@GetMapping("/salario/{salario}")
	public ResponseEntity<List<Funcionarios>> getBySalario(@PathVariable float salario) {

		// Busca funcionários com salário maior que o valor informado
		return ResponseEntity.ok(funcionariosRepository.findBySalarioGreaterThan(salario));
	}

	// CADASTRAR FUNCIONÁRIO
	@PostMapping	// Endpoint: // POST /funcionarios
	public ResponseEntity<Funcionarios> post(

			// @Valid ativa as validações do Model
			@Valid @RequestBody Funcionarios funcionario) { // Recebe os dados enviados no body da requisição

		// Garante que será criado um novo registro
		funcionario.setId(null);

		// Salva no banco e retorna status 201 CREATED
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionariosRepository.save(funcionario));
	}

	// ATUALIZAR FUNCIONÁRIO
	@PutMapping 	// Endpoint: // PUT /funcionarios
	public ResponseEntity<Funcionarios> put(@Valid @RequestBody Funcionarios funcionario) {

		// Verifica se o funcionário existe
		return funcionariosRepository.findById(funcionario.getId())

				// Se existir atualiza os dados
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(funcionariosRepository.save(funcionario)))

				// Se não existir retorna 404
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// DELETAR FUNCIONÁRIO
	// Endpoint:	// DELETE /funcionarios/{id}	// Retorna status 204 NO CONTENT
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		// Busca funcionário pelo ID
		Optional<Funcionarios> funcionario = funcionariosRepository.findById(id);

		// Se não existir lança erro 404
		if (funcionario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		// Deleta funcionário do banco
		funcionariosRepository.deleteById(id);
	}
}