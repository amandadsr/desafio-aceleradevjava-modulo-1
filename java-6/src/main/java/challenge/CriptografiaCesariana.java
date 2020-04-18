package challenge;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {

		if (texto.isEmpty()) {
			throw new IllegalArgumentException();
		}

		if (texto == null) {
			throw new NullPointerException();
		}

		StringBuilder textoCriptografado = new StringBuilder();

		// Variavel com tamanho do texto a ser decriptado
		int tamanhoTexto = texto.length();

		int chave = 3;

		// Descriptografa cada caracter por vez
		for (int i = 0; i < tamanhoTexto; i++) {

			// Transforma o caracter em codigo ASCII e faz a criptografia
			int letraDescriptografadaASCII = ((int) texto.charAt(i));
			int letraCriptografadaASCII = letraDescriptografadaASCII + (chave);

			// para caracter vazio
			if (letraDescriptografadaASCII == 32) {
				letraCriptografadaASCII = 32;
			} else {
				// para numero e simbolos
				if (letraDescriptografadaASCII < 58 && letraDescriptografadaASCII > 47) {
					letraCriptografadaASCII = letraDescriptografadaASCII;
				} else {
					// para letras maiusculas
					if (letraDescriptografadaASCII < 91) {
						letraCriptografadaASCII = letraCriptografadaASCII + 32;
					} else {
						// para continuar na tabela de letras
						if (letraCriptografadaASCII > 122) {
							letraDescriptografadaASCII = (letraCriptografadaASCII - 122);

							letraCriptografadaASCII = 97 + letraDescriptografadaASCII;
						}
					}
				}
			}
			// Transforma codigo ASCII descriptografado em caracter ao novo texto
			textoCriptografado.append((char) letraCriptografadaASCII);
		}

		// Por fim retorna a mensagem descriptografada por completo
		return textoCriptografado.toString();

	}

	@Override
	public String descriptografar(String texto) {

		if (texto.isEmpty()) {
			// throw new UnsupportedOperationException("String está vazia ou é nula");
			throw new IllegalArgumentException();
		}
		if (texto == null) {
			// throw new UnsupportedOperationException("String está vazia ou é nula");
			throw new NullPointerException();
		}

		StringBuilder textoDescriptografado = new StringBuilder();

		// Variavel com tamanho do texto a ser decriptado
		int tamanhoTexto = texto.length();

		int chave = 3;

		// Descriptografa cada caracter por vez
		for (int i = 0; i < tamanhoTexto; i++) {

			// Transforma o caracter em codigo ASCII e faz a descriptografia
			int letraCriptografadaASCII = ((int) texto.charAt(i));
			int letraDescriptografadaASCII = letraCriptografadaASCII - (chave);

			// para vazio
			if (letraCriptografadaASCII == 32) {
				letraDescriptografadaASCII = 32;
			} else {
				// para numeros
				if (letraCriptografadaASCII < 58 && letraCriptografadaASCII > 47) {
					letraDescriptografadaASCII = letraCriptografadaASCII;
				} else {
					//para letras maiusculas
					if (letraCriptografadaASCII < 97) {
						letraDescriptografadaASCII = letraDescriptografadaASCII + 32;
					} else {
						// para ir para o final da tabela de letras
						if (letraDescriptografadaASCII < 97) {
							letraCriptografadaASCII = (97 - letraDescriptografadaASCII);

							letraDescriptografadaASCII = 123 - letraCriptografadaASCII;
						}
					}
				}
			}
			// Transforma codigo ASCII descriptografado em caracter ao novo texto
			textoDescriptografado.append((char) letraDescriptografadaASCII);
		}

		// Por fim retorna a mensagem descriptografada por completo
		return textoDescriptografado.toString();
	}

}
