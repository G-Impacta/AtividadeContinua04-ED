package Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces;

public interface CompleteBinaryTree<TIPO> extends BinaryTree<TIPO> {
	
	public Position<TIPO> add(TIPO element);
	
	public TIPO remove();
}