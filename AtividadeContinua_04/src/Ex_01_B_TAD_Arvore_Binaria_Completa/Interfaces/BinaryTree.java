package Ex_01_B_TAD_Arvore_Binaria_Completa.Interfaces;

import Ex_01_B_TAD_Arvore_Binaria_Completa.Excecoes.ExcecaoIndiceForaLimites;
import Ex_01_B_TAD_Arvore_Binaria_Completa.Excecoes.ExcecaoPosicaoInvalida;

public interface BinaryTree<TIPO> extends Tree<TIPO> {
	
	public Position<TIPO> left(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public Position<TIPO> right(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public boolean hasLeft(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
	
	public boolean hasRight(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
}
