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

		System.out.print("Entre com o nome do departamento:");
		String departamentoName = scan.nextLine();
		System.out.print("Dados do trabalhador");
		System.out.print("Name: ");
		String workername = scan.nextLine();
		System.out.print("Level: ");
		String workerlevel = scan.nextLine();
		System.out.println("Salário Base: ");
		Double workersalarioBase = scan.nextDouble();

		Worker worker = new Worker(workername, NivelTrabalho.valueOf(workerlevel), workersalarioBase,
				new Departamento(departamentoName));

		System.out.print("Quantos contrato o trabalhador tem?");
		int n = scan.nextInt();
		for (int i = 1; i < n; i++) {
			System.out.print("Entre com os dados do " + i + " contrato");
			System.out.print("Data (DD/MM/YYYY");
			Date contractDate = sdf.parse(scan.next());
			System.out.println("Valor por hora");
			double valorHora = scan.nextDouble();
			System.out.println("Tempo do contrato(Hr)");
			int horas = scan.nextInt();
			ContratoHora contract = new ContratoHora(contractDate, valorHora, horas);
			worker.AddContract(contract);
		}
		System.out.println();
		System.out.println("Entre com o Mês e Ano (MM/YYYY) para calcular o salário: ");
		String monthandYear = scan.next();
		int month = Integer.parseInt(monthandYear.substring(0, 2));
		int year = Integer.parseInt(monthandYear.substring(3));
		
		System.out.println("Name: "+ worker.getNome());
		System.out.println("Departamento: " + worker.getDepartamento().getNome());
		System.out.println("O Funcionario ganhou na data " + monthandYear);
		//System.out.println();
		
		
		scan.close();
	}

}
