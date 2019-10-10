package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.enuns.NivelTrabalho;

public class Worker {
	private String name;
	private NivelTrabalho level;
	private Double salarioBase;

	private Departamento departamento;
	private List<ContratoHora> contrato = new ArrayList<>();

	public Worker() {

	}

	public Worker(String nome, NivelTrabalho level, Double salarioBase, Departamento departamento) {
		this.name = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
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

	public void addContract(ContratoHora contratos) {
		this.contrato.add(contratos);
	}

	public void removeContract(ContratoHora contratos) {
		this.contrato.remove(contratos);
	}

	/* Esse método foi osso duro */

	public double income(int year, int month) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoHora c : contrato) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

}
