package Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces;

import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.ExcecaoIndiceForaLimites;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.ExcecaoPosicaoInvalida;

public interface BinaryTree<TIPO> extends Tree<TIPO> {
	
	public Position<TIPO> left(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public Position<TIPO> right(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public boolean hasLeft(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
	
	public boolean hasRight(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
}
