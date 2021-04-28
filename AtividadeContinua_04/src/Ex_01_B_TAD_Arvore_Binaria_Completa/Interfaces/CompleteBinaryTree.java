package Ex_01_B_TAD_Arvore_Binaria_Completa.Interfaces;

public interface CompleteBinaryTree<TIPO> extends BinaryTree<TIPO> {
	
	public Position<TIPO> add(TIPO element);
	
	public TIPO remove();
}