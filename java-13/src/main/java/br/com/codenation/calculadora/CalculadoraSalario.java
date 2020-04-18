package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		// Use o Math.round apenas no final do método para arredondar o valor final.
		// Documentação do método:
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase < 1039) {
			return 0;
		} else {
			double salarioDescontadoINSS;
			double salarioLiquido;

			salarioDescontadoINSS = calcularDescontoINSS(salarioBase);
			salarioLiquido = calcularDescontoIRRF(salarioDescontadoINSS);

			return Math.round(salarioLiquido);
		}
	}

	private double calcularDescontoINSS(double salarioBase) {

		double desconto_INSS;

		if (salarioBase <= 1500) {
			desconto_INSS = salarioBase * 0.08;
		} else if (salarioBase <= 4000) {
			desconto_INSS = salarioBase * 0.09;
		} else
			desconto_INSS = salarioBase * 0.11;

		return (salarioBase - desconto_INSS);
	}

	private double calcularDescontoIRRF(double salarioDescontadoINSS) {

		double desconto_IRRF;

		if (salarioDescontadoINSS <= 3000) {
			desconto_IRRF = 0;
		} else if (salarioDescontadoINSS <= 6000) {
			desconto_IRRF = salarioDescontadoINSS * 0.075;
		} else
			desconto_IRRF = salarioDescontadoINSS * 0.15;

		return (salarioDescontadoINSS - desconto_IRRF);
	}

	public static void main(String[] args) {
		CalculadoraSalario calc = new CalculadoraSalario();
		System.out.println(calc.calcularSalarioLiquido(1500));
	}
}
/*
 * Dúvidas ou Problemas? Manda e-mail para o meajuda@codenation.dev que iremos
 * te ajudar!
 */