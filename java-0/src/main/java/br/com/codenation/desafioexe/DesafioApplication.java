package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> lista = new ArrayList<>();

		int numMax = 350;
		int posicao = 1;
		int valorFib = 2;

		lista.add(0);
		lista.add(1);

		while (valorFib < numMax) {
			lista.add(lista.get(posicao) + lista.get(posicao - 1));
			valorFib = lista.get(posicao + 1);
			posicao++;
		}

		return lista;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}