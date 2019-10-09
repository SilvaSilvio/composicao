package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.enuns.NivelTrabalho;

public class Worker {
	private String nome;
	private Departamento departamento;
	private NivelTrabalho level;
	private List<ContratoHora> contrato = new ArrayList<ContratoHora>();
	private Double salarioBase;

	public Worker() {

	}

	public Worker(String nome, Departamento departamento, NivelTrabalho level, Double salarioBase) {
		this.nome = nome;
		this.departamento = departamento;
		this.level = level;
		this.salarioBase = salarioBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public NivelTrabalho getLevel() {
		return level;
	}

	public void setLevel(NivelTrabalho level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;

	}

	public List<ContratoHora> getContrato() {
		return contrato;
	}

	public void AddContract(ContratoHora contratos) {
		this.contrato.add(contratos);
	}

	public void removeContract(ContratoHora contratos) {
		this.contrato.remove(contratos);
	}

	public void calcularSalario(int year, int month) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoHora c : contrato) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				soma += c.valorHora(); // VERIFICAR ESSA LINHA...
			}

		}
	}

}
