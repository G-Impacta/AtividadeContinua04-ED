package Ex_01_B_TAD_Arvore_Binaria_Completa.Testes;

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

import Ex_01_B_TAD_Arvore_Binaria_Completa.Fontes.ArrayListCompleteBinaryTree;

class ArrayListCompleteBinaryTreeTest {

	@Test
	void test() {
		
		ArrayListCompleteBinaryTree<Integer> TREE = new ArrayListCompleteBinaryTree<Integer>();

		TREE.add(4);

		TREE.add(5);

		TREE.add(6);

		TREE.add(15);

		TREE.add(9);

		TREE.add(7);

		TREE.add(20);

		TREE.add(16);

		TREE.add(25);

		TREE.add(14);

		TREE.add(12);

		TREE.add(11);

		TREE.add(8);

		assertEquals(

		"[null, [4,1], [5,2], [6,3], [15,4], [9,5], [7,6], [20,7], [16,8], [25,9], [14,10], [12,11], [11,12], [8,13]]",

		TREE.toString());		
	}
}
