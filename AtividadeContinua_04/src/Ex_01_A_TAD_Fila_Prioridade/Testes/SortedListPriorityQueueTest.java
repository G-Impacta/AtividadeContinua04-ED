package Ex_01_A_TAD_Fila_Prioridade.Testes;

/*Atividade Continua 04
 * 
 * Nome dos Integrantes:
 * Caio Victor dos Santos - 1904013
 * Cristhian Ocampo Quinteiro – 1902919
 * Thiago Souza do Amparo – 1904089
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import Ex_01_A_TAD_Fila_Prioridade.Excecoes.EmptyPriorityQueueException;
import Ex_01_A_TAD_Fila_Prioridade.Fontes.SortedListPriorityQueue;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.Entry;
import Ex_01_A_TAD_Fila_Prioridade.Pessoa.Pessoa;
import Ex_01_A_TAD_Fila_Prioridade.Pessoa.PessoaComparator;

class SortedListPriorityQueueTest {

	@Test
	void teste_basico() {
		
		SortedListPriorityQueue<Integer, String> listaPrioridade = new SortedListPriorityQueue<Integer, String>();
		Entry<Integer, String> saida;

		saida = listaPrioridade.insert(5, "A");
		assertEquals("(5,A)", saida.toString());
		assertEquals("[(5,A)]", listaPrioridade.toString());

		saida = listaPrioridade.insert(9, "C");
		assertEquals("(9,C)", saida.toString());
		assertEquals("[(5,A), (9,C)]", listaPrioridade.toString());

		saida = listaPrioridade.insert(3, "B");
		assertEquals("(3,B)", saida.toString());
		assertEquals("[(3,B), (5,A), (9,C)]", listaPrioridade.toString());

		saida = listaPrioridade.insert(7, "D");
		assertEquals("(7,D)", saida.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", listaPrioridade.toString());

		saida = listaPrioridade.min();
		assertEquals("(3,B)", saida.toString());
		assertEquals("[(3,B), (5,A), (7,D), (9,C)]", listaPrioridade.toString());

		saida = listaPrioridade.removeMin();
		assertEquals("(3,B)", saida.toString());
		assertEquals("[(5,A), (7,D), (9,C)]", listaPrioridade.toString());
		
		assertEquals(3, listaPrioridade.size());

		saida = listaPrioridade.removeMin();
		assertEquals("(5,A)", saida.toString());
		assertEquals("[(7,D), (9,C)]", listaPrioridade.toString());

		saida = listaPrioridade.removeMin();
		assertEquals("(7,D)", saida.toString());
		assertEquals("[(9,C)]", listaPrioridade.toString());

		saida = listaPrioridade.removeMin();
		assertEquals("(9,C)", saida.toString());
		assertEquals("[]", listaPrioridade.toString());

		assertThrows(EmptyPriorityQueueException.class, () -> {listaPrioridade.removeMin();});
	}
	
	@Test
	void teste_comparador_de_Pessoa() {
	
		SortedListPriorityQueue<Pessoa, Pessoa> listaPessoas = new SortedListPriorityQueue<Pessoa, Pessoa>();	
		Entry<Pessoa, Pessoa> saida;
	
		Pessoa pessoa;
		
		pessoa = new Pessoa("J", 20);
	
		saida = listaPessoas.insert(pessoa, null);	
		assertEquals("(Pessoa {nome=J, idade=20},null)", saida.toString());	
		assertEquals("[(Pessoa {nome=J, idade=20},null)]", listaPessoas.toString());
	
		pessoa = new Pessoa("M", 30);
		
		saida = listaPessoas.insert(pessoa, null);	
		assertEquals("(Pessoa {nome=M, idade=30},null)", saida.toString());	
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]", listaPessoas.toString());
	
		pessoa = new Pessoa("F", 25);
	
		saida = listaPessoas.insert(pessoa, null);	
		assertEquals("(Pessoa {nome=F, idade=25},null)", saida.toString());	
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=F, idade=25},null), (Pessoa {nome=M, idade=30},null)]",
		listaPessoas.toString());
	}
	
	@Test
	void teste_comparador_externo_de_Pessoa() {
	
		Comparator<Pessoa> comparador = new PessoaComparator();
	
		SortedListPriorityQueue<Pessoa, Pessoa> listaPessoas = new SortedListPriorityQueue<Pessoa, Pessoa>(comparador);	
		Entry<Pessoa, Pessoa> saida;
	
		Pessoa pessoa;
		
		pessoa = new Pessoa("J", 20);
	
		saida = listaPessoas.insert(pessoa, null);	
		assertEquals("(Pessoa {nome=J, idade=20},null)", saida.toString());	
		assertEquals("[(Pessoa {nome=J, idade=20},null)]", listaPessoas.toString());
	
		pessoa = new Pessoa("M", 30);
	
		saida = listaPessoas.insert(pessoa, null);	
		assertEquals("(Pessoa {nome=M, idade=30},null)", saida.toString());	
		assertEquals("[(Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]", listaPessoas.toString());
	
		pessoa = new Pessoa("F", 25);
	
		saida = listaPessoas.insert(pessoa, null);	
		assertEquals("(Pessoa {nome=F, idade=25},null)", saida.toString());	
		assertEquals("[(Pessoa {nome=F, idade=25},null), (Pessoa {nome=J, idade=20},null), (Pessoa {nome=M, idade=30},null)]",
		listaPessoas.toString());
	}
}