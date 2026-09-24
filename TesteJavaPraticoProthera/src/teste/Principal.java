package teste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;


public class Principal {

	public static void main(String[] args) {

		//Inicio Exercicio 3.1 -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		List<Funcionario> listaDeFuncionarios = new ArrayList<>();
		
		//Atribuição de informações aos objs funcionarios
		Funcionario funcionarioMaria = new Funcionario();
		funcionarioMaria.setNome("Maria");
		funcionarioMaria.setNascimento(LocalDate.of(2000, 10, 18));
		funcionarioMaria.setSalario(new BigDecimal("2009.44"));
		funcionarioMaria.setFuncao("Operador");
		
		Funcionario funcionarioJoao = new Funcionario();
		funcionarioJoao.setNome("João");
		funcionarioJoao.setNascimento(LocalDate.of(1990, 5, 12));
		funcionarioJoao.setSalario(new BigDecimal("2284.38"));
		funcionarioJoao.setFuncao("Operador");
		
		Funcionario funcionarioCaio = new Funcionario();
		funcionarioCaio.setNome("Caio");
		funcionarioCaio.setNascimento(LocalDate.of(1961, 5, 2));
		funcionarioCaio.setSalario(new BigDecimal("9836.14"));
		funcionarioCaio.setFuncao("Coordenador");
		
		Funcionario funcionarioMiguel = new Funcionario();
		funcionarioMiguel.setNome("Miguel");
		funcionarioMiguel.setNascimento(LocalDate.of(1988, 10, 14));
		funcionarioMiguel.setSalario(new BigDecimal("19119.88"));
		funcionarioMiguel.setFuncao("Diretor");
		
		Funcionario funcionarioAlice = new Funcionario();
		funcionarioAlice.setNome("Alice");
		funcionarioAlice.setNascimento(LocalDate.of(1995, 1, 5));
		funcionarioAlice.setSalario(new BigDecimal("2234.68"));
		funcionarioAlice.setFuncao("Recepcionista");
		
		Funcionario funcionarioHeitor = new Funcionario();
		funcionarioHeitor.setNome("Heitor");
		funcionarioHeitor.setNascimento(LocalDate.of(1999, 11, 19));
		funcionarioHeitor.setSalario(new BigDecimal("1582.72"));
		funcionarioHeitor.setFuncao("Operador");
		
		Funcionario funcionarioArthur = new Funcionario();
		funcionarioArthur.setNome("Arthur");
		funcionarioArthur.setNascimento(LocalDate.of(1993, 3, 31));
		funcionarioArthur.setSalario(new BigDecimal("4071.84"));
		funcionarioArthur.setFuncao("Contador");
		
		Funcionario funcionarioLaura = new Funcionario();
		funcionarioLaura.setNome("Laura");
		funcionarioLaura.setNascimento(LocalDate.of(1994, 7, 8));
		funcionarioLaura.setSalario(new BigDecimal("3017.45"));
		funcionarioLaura.setFuncao("Gerente");
		
		Funcionario funcionarioHeloisa = new Funcionario();
		funcionarioHeloisa.setNome("Heloísa");
		funcionarioHeloisa.setNascimento(LocalDate.of(2003, 5, 24));
		funcionarioHeloisa.setSalario(new BigDecimal("1606.85"));
		funcionarioHeloisa.setFuncao("Eletricista");
		
		Funcionario funcionarioHelena = new Funcionario();
		funcionarioHelena.setNome("Helena");
		funcionarioHelena.setNascimento(LocalDate.of(1996, 9, 2));
		funcionarioHelena.setSalario(new BigDecimal("2799.93"));
		funcionarioHelena.setFuncao("Gerente");
		
		//Adicionando os funcionarios a listaDeFuncionarios
		listaDeFuncionarios.add(funcionarioMaria);
		listaDeFuncionarios.add(funcionarioJoao);
		listaDeFuncionarios.add(funcionarioCaio);
		listaDeFuncionarios.add(funcionarioMiguel);
		listaDeFuncionarios.add(funcionarioAlice);
		listaDeFuncionarios.add(funcionarioHeitor);
		listaDeFuncionarios.add(funcionarioArthur);
		listaDeFuncionarios.add(funcionarioLaura);
		listaDeFuncionarios.add(funcionarioHeloisa);
		listaDeFuncionarios.add(funcionarioHelena);
		
		//Fim exercicio 3.1 -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		
		//Inicio exercicio 3.2
		listaDeFuncionarios.remove(funcionarioJoao);
		//Fim exercicio 3.2
		
		//Inicio exercicio 3.3
		DateTimeFormatter nascimentoFormatado = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		NumberFormat salarioFormatado = NumberFormat.getInstance(new Locale("pt", "BR"));
		
		
		//Print de funcionarios 3.3
		System.out.println("Print dados dos funcionarios (3.3):");
		
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			System.out.println(funcionarioAtual.getNome());
			System.out.println(funcionarioAtual.getNascimento().format(nascimentoFormatado));
			System.out.println(salarioFormatado.format(funcionarioAtual.getSalario()));
			System.out.println(funcionarioAtual.getFuncao());
			System.out.println();
		}
		
		
		//Fim exercicio 3.3
		
		//Inicio exercicio 3.5
		
		//Criação do MAP
		Map<String, List<Funcionario>> separadorFuncao = new HashMap<>();
		
		//Inicio exercicio 3.4
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			BigDecimal salarioAtualizado = funcionarioAtual.getSalario().multiply(new BigDecimal("1.10"));
			funcionarioAtual.setSalario(salarioAtualizado);
			
			//Criação do MAP
			String funcao = funcionarioAtual.getFuncao();
			List<Funcionario> listaMap = separadorFuncao.get(funcao);
			
			if (listaMap == null) {
				listaMap = new ArrayList<>();
				separadorFuncao.put(funcao, listaMap);
			}
			listaMap.add(funcionarioAtual);
				
		}
		
		//Incio exerciocio 3.6
		
		//Print dos funcionarios separados por função
		System.out.println("Print de funcionarios separados por função com keys MAP (3.6):");
		
		for (String funcao : separadorFuncao.keySet()) {
		    System.out.println("Função: " + funcao);

		    for (Funcionario funcionario : separadorFuncao.get(funcao)) {
		        System.out.println(funcionario.getNome());
		    }

		    System.out.println();
		    
		}
		
		//Incio exerciocio 3.8
		
		//Print dos funcionarios que fazem aniversario nos meses 10 e 12
		System.out.println("Print de funcionarios que fazem aniversário nos meses 10 e 12 (3.8):");
		
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			if (funcionarioAtual.getNascimento().getMonthValue() == 10 || funcionarioAtual.getNascimento().getMonthValue() == 12) {
				System.out.println(funcionarioAtual.getNome());
			}
				
		}
		
		System.out.println();
		
		//Incio exerciocio 3.9
		System.out.println("Print do funcionario com a maior idade (3.9):");
		
		int idadeAtual = 0;
		Funcionario funcionarioMaisVelho = null;
		
		
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			int idade = Period.between(funcionarioAtual.getNascimento(), LocalDate.now()).getYears();
			
			if (idade > idadeAtual) {
				idadeAtual = idade;
				funcionarioMaisVelho = funcionarioAtual;
			}
			
		}
		System.out.println("Nome: " + funcionarioMaisVelho.getNome());
		System.out.println("Idade: " + idadeAtual);
		System.out.println();
		
		
		//Incio exerciocio 3.10
		
		//Print dos nomes dos funcionarios em ordem alfabética
		System.out.println("Print dos nomes dos funcionarios em ordem alfabética (3.10):");
		listaDeFuncionarios.sort(Comparator.comparing(Funcionario::getNome));
		
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			System.out.println(funcionarioAtual.getNome());
		}
		System.out.println();
		
		
		//Incio exerciocio 3.11
		
		
		BigDecimal salarioTotal = new BigDecimal("0");
		
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			salarioTotal = salarioTotal.add(funcionarioAtual.getSalario());
			
		}
		System.out.println("O valor total dos salários distribuidos entre os funcionarios é de (3.11):\n" + salarioFormatado.format(salarioTotal.setScale(2, RoundingMode.HALF_UP)));
		System.out.println();
		
		
		//Incio exerciocio 3.12
		
		
		System.out.println("Quantidade de salários minimos por funcionario (3.12):");
		
		BigDecimal salarioMin = new BigDecimal("1212");
		BigDecimal salarioMinFuncionario = new BigDecimal("0");
		for (Funcionario funcionarioAtual : listaDeFuncionarios) {
			salarioMinFuncionario = funcionarioAtual.getSalario().divide(salarioMin, 1, RoundingMode.HALF_UP);
			System.out.println(funcionarioAtual.getNome() + " recebe " + salarioMinFuncionario + " salários minimos");
		}
		
	}

}
