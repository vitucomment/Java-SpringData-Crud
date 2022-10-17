package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;

	}

	public void inicial(Scanner scanner) {
		scanner = new Scanner(System.in);

		System.out.print("Digite um nome: ");
		String nome = scanner.nextLine();
		if (nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}

		System.out.print("Digite um cpf: ");
		String cpf = scanner.nextLine();
		if (cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}

		System.out.print("Digite um salario: ");
		Double salario = scanner.nextDouble();
		if (salario == 0) {
			salario = null;
		}
		
		scanner = new Scanner(System.in);
		System.out.print("Digite a data de contratacao: ");
		String data = scanner.nextLine();
		LocalDate dataContratacao;
		if (data.equalsIgnoreCase("NULL")) {
			dataContratacao = null;
		} else {
			dataContratacao = LocalDate.parse(data, formatter);
		}

		List<Funcionario> funcionarios = funcionarioRepository
				.findAll(Specification.where(SpecificationFuncionario.nome(nome))
						.or(SpecificationFuncionario.cpf(cpf))
						.or(SpecificationFuncionario.salario(salario))
						.or(SpecificationFuncionario.dataContratacao(dataContratacao)));
		
		funcionarios.forEach(System.out::println);
	}

}
