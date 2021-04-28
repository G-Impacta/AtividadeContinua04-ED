package Ex_22_TAD_Hash_Table_Map.Interfaces;

public interface CompleteBinaryTree<TIPO> extends BinaryTree<TIPO> {
	
	public Position<TIPO> add(TIPO element);
	
	public TIPO remove();
}