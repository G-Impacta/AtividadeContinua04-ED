package Ex_01_C_TAD_Fila_Prioridade_Heap.Testes;

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

class HeapPriorityQueueTest {

	@Test
	void test() {
	
		HeapPriorityQueue<Integer, String> filaPrioridade = new HeapPriorityQueue<Integer, String>();
	
		filaPrioridade.insert(4, "C");	
		filaPrioridade.insert(5, "A");	
		filaPrioridade.insert(6, "Z");	
		filaPrioridade.insert(15, "K");	
		filaPrioridade.insert(9, "F");	
		filaPrioridade.insert(7, "Q");	
		filaPrioridade.insert(20, "B");	
		filaPrioridade.insert(16, "X");	
		filaPrioridade.insert(25, "J");	
		filaPrioridade.insert(14, "E");	
		filaPrioridade.insert(12, "H");	
		filaPrioridade.insert(11, "S");	
		filaPrioridade.insert(8, "W");
	
		assertEquals("[null, [(4,C),1], [(5,A),2], [(6,Z),3], [(15,K),4], [(9,F),5], [(7,Q),6], [(20,B),7], "
				+ "[(16,X),8], [(25,J),9], [(14,E),10], [(12,H),11], [(11,S),12], [(8,W),13]]", 
				filaPrioridade.toString());
	
		filaPrioridade.insert(2, "T");
	
		assertEquals("[null, [(2,T),1], [(5,A),2], [(4,C),3], [(15,K),4], [(9,F),5], [(7,Q),6], [(6,Z),7], "
				+ "[(16,X),8], [(25,J),9], [(14,E),10], [(12,H),11], [(11,S),12], [(8,W),13], [(20,B),14]]", 
				filaPrioridade.toString());
	
		filaPrioridade.removeMin();
	
		assertEquals("[null, [(4,C),1], [(5,A),2], [(6,Z),3], [(15,K),4], [(9,F),5], [(7,Q),6], [(20,B),7], "
				+ "[(16,X),8], [(25,J),9], [(14,E),10], [(12,H),11], [(11,S),12], [(8,W),13]]", 
				filaPrioridade.toString());
	}
}