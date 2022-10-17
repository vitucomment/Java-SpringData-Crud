package br.com.alura.spring.data.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome) {
		return (root, riteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}

	public static Specification<Funcionario> cpf(String cpf) {
		return (root, riteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
	}

	public static Specification<Funcionario> salario(Double salario) {
		return (root, riteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
	}

	public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) {
		return (root, riteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dataContratacao"),
				dataContratacao);
	}
}
