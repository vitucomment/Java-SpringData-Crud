package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private Boolean system = true;
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario, data contratacao e salario maior");
			System.out.println("3 - Busca funcionario por data de contratacao");
			System.out.println("4 - Pesquisa funcionario salario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscaFuncionarioDataContratacao(scanner);
				break;
			case 4:
				pesquisaFuncionarioSalario();
				break;
			default:
				system = false;
				break;
			}

		}

	}

	private void buscaFuncionarioNome(Scanner scanner) {
		scanner = new Scanner(System.in);
		System.out.print("Qual o nome do funcionario: ");
		String nome = scanner.nextLine();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		scanner = new Scanner(System.in);

		System.out.print("Qual o nome do funcionario: ");
		String nome = scanner.nextLine();
		
		System.out.print("Qual data de contratação deseja pesquisar: ");
		String data = scanner.nextLine();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.print("Qual salario ");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		scanner = new Scanner(System.in);

		System.out.print("Qual data de contratação deseja pesquisar: ");
		String data = scanner.nextLine();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
		list.forEach(System.out::println);
	}
	
	private void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
		list.forEach(f -> System.out.println("Funcionario: id: " + f.getId() + " | Nome: " + f.getNome() + " | Salario: " + f.getSalario()));
	}
}
