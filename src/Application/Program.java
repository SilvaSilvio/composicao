package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.ContratoHora;
import Entities.Departamento;
import Entities.Worker;
import Entities.enuns.NivelTrabalho;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do Departamento:");
		String departamentoName = scan.nextLine();
		System.out.print("Dados do Trabalhador");
		System.out.print("Name: ");
		String workername = scan.nextLine();
		System.out.print("Level: ");
		String workerlevel = scan.nextLine();
		System.out.println("Salário Base: ");
		Double workerSalaryBase = scan.nextDouble();

		Worker worker = new Worker(workername, NivelTrabalho.valueOf(workerlevel), workerSalaryBase,
				new Departamento(departamentoName));

		System.out.print("Quantos contrato o trabalhador vai ter?");
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print("Entre com os dados do " + i + " contrato");
			System.out.print("Data (DD/MM/YYYY");
			Date contractDate = sdf.parse(scan.next());
			System.out.print("Valor por Hora: ");
			double valorHora = scan.nextDouble();
			System.out.print("Tempo do contrato(Hr)");
			int horas = scan.nextInt();

			ContratoHora contract = new ContratoHora(contractDate, valorHora, horas);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Entre com o Mês e Ano (MM/YYYY) para calcular o Salário: ");
		String monthAndYear = scan.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartamento().getNome());
		System.out.println("O Funcionario ganhou na data " + monthAndYear + ": " + worker.income(year, month));

		// System.out.println();

		scan.close();
	}

}
