package testeNota;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class TesteNota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] notasMoedas = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5, 1};
		Scanner key = new Scanner(System.in);
		double valorTroco = key.nextDouble();
		// converte o valor para centavos
		int valorCentavos = (int) (valorTroco * 100);
		Map<Double, Integer> quantidades = new LinkedHashMap<>(); // guardar as quantidades de cada nota/moeda
		for (int nota : notasMoedas) {
		    if (valorCentavos >= nota) {
		        int qtd = valorCentavos / nota; // quantidade da nota/moeda
		        quantidades.put(nota / 100.0, qtd);
		        valorCentavos %= nota; // pega o resto da divisão, pra ter o valor restante
		        if (valorCentavos == 0) {
		            break; // se o valor zerou, sai do for (não tem porque continuar)
		        }
		    }
		}

		// imprime os resultados
		for (Map.Entry<Double, Integer> e : quantidades.entrySet()) {
		    double notaMoeda = e.getKey();
		    int qtd = e.getValue();
		    String tipo;
		    if (notaMoeda > 1) {
		        tipo = "nota";
		    } else {
		        tipo = "moeda";
		    }
		    System.out.printf("%d %s%s de %.2f\n", qtd, tipo, qtd > 1 ? "s" : "", notaMoeda);
		}
	}
        // Notas possiveis = 100,50,20,10,5,2,1,0.5,0.25,0.1,0.05 e 0.01;

}
