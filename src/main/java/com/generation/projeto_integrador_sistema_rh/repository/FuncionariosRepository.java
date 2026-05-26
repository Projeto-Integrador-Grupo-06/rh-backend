package com.generation.projeto_integrador_sistema_rh.repository;

//Importações necessárias

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.projeto_integrador_sistema_rh.model.Funcionarios;

// Repository responsável pelo acesso ao banco
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

	// Busca funcionários com salário maior que o valor informado
	public List<Funcionarios> findBySalarioGreaterThan(float salario);

}