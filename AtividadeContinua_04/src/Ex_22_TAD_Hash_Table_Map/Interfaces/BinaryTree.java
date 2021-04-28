package Ex_22_TAD_Hash_Table_Map.Interfaces;

import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoIndiceForaLimites;
import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoPosicaoInvalida;

public interface BinaryTree<TIPO> extends Tree<TIPO> {
	
	public Position<TIPO> left(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public Position<TIPO> right(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public boolean hasLeft(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
	
	public boolean hasRight(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
}
