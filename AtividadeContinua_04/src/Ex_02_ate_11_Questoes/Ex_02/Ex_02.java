package Ex_02_ate_11_Questoes.Ex_02;

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

import Ex_01_A_TAD_Fila_Prioridade.Fontes.SortedListPriorityQueue;

class Ex_02 {
	
	/* Resposta Questão 02:
	 * 
	 * 1- insert(5,A) - [(5,A)]
	 * 2- insert(4,B) - [(4,B), (5,A)]
	 * 3- insert(7,I) - [(4,B), (5,A), (7,I)]
	 * 4- insert(1,D) - [(1,D), (4,B), (5,A), (7,I)]
	 * 5- removeMin() - [(4,B), (5,A), (7,I)]
	 * 6- insert(3,J) - [(3,J), (4,B), (5,A), (7,I)]
	 * 7- insert(6,L) - [(3,J), (4,B), (5,A), (6,L), (7,I)]
	 * 8- removeMin() - [(4,B), (5,A), (6,L), (7,I)]
	 * 9- removeMin() - [(5,A), (6,L), (7,I)]
	 * 10- insert(8,G) - [(5,A), (6,L), (7,I), (8,G)]
	 * 11- removeMin() - [(6,L), (7,I), (8,G)]
	 * 12- insert(2.H) - [(2.H), (6,L), (7,I), (8,G)]
	 * 13- removeMin() - [(6,L), (7,I), (8,G)]
	 * 14- removeMin() - [(7,I), (8,G)] -> Resultado Final.
	 */
	
	@Test
	void test() {
		
		//Instancia e cria uma fila de prioridade.
		SortedListPriorityQueue<Integer, String> listaPrioridade = new SortedListPriorityQueue<Integer, String>();
		
		//Inseri elementos na lista.		
		listaPrioridade.insert(5, "A");
		listaPrioridade.insert(4, "B");
		listaPrioridade.insert(7, "I");
		listaPrioridade.insert(1, "D");
		
		//Remove elementos da lista.
		listaPrioridade.removeMin();
		
		//Inseri elementos na lista.		
		listaPrioridade.insert(3, "J");
		listaPrioridade.insert(6, "L");
		
		//Remove elementos da lista.
		listaPrioridade.removeMin();
		listaPrioridade.removeMin();
		
		//Inseri elementos na lista.
		listaPrioridade.insert(8, "G");		
		
		//Remove elementos da lista.
		listaPrioridade.removeMin();
		
		//Inseri elementos na lista.
		listaPrioridade.insert(2, "H");		
		
		//Remove elementos da lista.
		listaPrioridade.removeMin();
		listaPrioridade.removeMin();
		
		//Deve verificar se o resultado é [(7,I), (8,G)].
		assertEquals("[(7,I), (8,G)]", listaPrioridade.toString(), "[(7,I), (8,G)]");
	}
}
