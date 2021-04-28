package Ex_01_D_Fila_Prioridade_Ordenacao;

/*Atividade Continua 04
 * 
 * Nome dos Integrantes:
 * Caio Victor dos Santos - 1904013
 * Cristhian Ocampo Quinteiro – 1902919
 * Thiago Souza do Amparo – 1904089
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex_01_C_TAD_Fila_Prioridade_Heap.Fontes.HeapPriorityQueue;

class OrdenaListaTest {

	@Test
	void testOrdenarLista() {
		
		Integer lista[] = {9, 1, 3, 6, 2, 7, 8};
		
		assertEquals("[9, 1, 3, 6, 2, 7, 8]",toString(lista), "[9, 1, 3, 6, 2, 7, 8]");
		
		ordenarLista(lista);
		assertEquals("[1, 2, 3, 6, 7, 8, 9]",toString(lista), "[1, 2, 3, 6, 7, 8, 9]");				
	}	
	
	public void ordenarLista(Integer lista[]) {
		
		HeapPriorityQueue<Integer, String> filaPrioridade = new HeapPriorityQueue<Integer, String>();
		
		for(int i=0; i < lista.length; i++) {filaPrioridade.insert(lista[i], null);}
		
		for(int i=0; i < lista.length; i++) {lista[i] = filaPrioridade.removeMin().getKey();}
	}
	
	public String toString(Integer lista[]) {
		
		String saida = "[";
		
		for(int i = 0; i < lista.length; i++) {
			
			saida += lista[i];			
			if(i + 1 != lista.length) {saida += ", ";}			
		}
		
		saida += "]";
		return saida;		
	}
}
