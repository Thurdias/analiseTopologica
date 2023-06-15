import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	// Propriedades da classe
	private boolean[][] grafo;

	// Método construtor da classe
	public Grafo(int tamanho) {
		grafo = new boolean[tamanho][tamanho];
	}

	// Métodos da classe
	public void criar() {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

		try {
			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo[i].length; j++) {
					if (i != j) {
						System.out.print("Digite <S> para ligação entre " + i + " e " + j + ": ");
						if (leitor.readLine().equalsIgnoreCase("S")) {
							grafo[i][j] = true;
						}
					}
				}
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}

	public void ordernar() {
		boolean[] visitado = new boolean[grafo.length];

		for (int vertice = 0; vertice < grafo.length; vertice++) {
			if (!visitado[vertice]) {
				ordernarRecursivo(visitado, vertice);
			}
		}
		System.out.println();
	}

	private void ordernarRecursivo(boolean[] visitado, int vertice) {
		visitado[vertice] = true;
		
		for(int i = 0; i < grafo.length; i++) {
			if(grafo[vertice][i]) {
				if(! visitado[i]) {
					ordernarRecursivo(visitado, i);
				}
			}
		}
		System.out.print(vertice + "\t");
	}
}
