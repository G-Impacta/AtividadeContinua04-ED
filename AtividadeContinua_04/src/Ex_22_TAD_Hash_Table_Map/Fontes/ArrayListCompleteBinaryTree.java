package Ex_22_TAD_Hash_Table_Map.Fontes;

import java.util.ArrayList;
import java.util.Iterator;

import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoArvoreVazia;
import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoIndiceForaLimites;
import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoPosicaoInvalida;
import Ex_22_TAD_Hash_Table_Map.Interfaces.CompleteBinaryTree;
import Ex_22_TAD_Hash_Table_Map.Interfaces.Position;
import Ex_22_TAD_Hash_Table_Map.Interfaces.PositionList;

public class ArrayListCompleteBinaryTree<TIPO> implements CompleteBinaryTree<TIPO> {
	
	protected ArrayList<BTPos<TIPO>> TREE;
	
	protected static class BTPos<TIPO> implements Position<TIPO> {
		
		TIPO element;
		int index;
		
		public BTPos(TIPO element, int index) {
			
			this.element = element;
			this.index = index;
		}
		
		public TIPO element() {return element;}
		
		public int index() {return index;}
		
		public TIPO setElement(TIPO element) {
			
			TIPO elementoTemporario = this.element;
			this.element = element;
			return elementoTemporario;
		}
		
		public String toString() { return ("[" + element + "," + index + "]"); }		
	}
	
	public ArrayListCompleteBinaryTree() {

		TREE = new ArrayList<BTPos<TIPO>>();
		TREE.add(0, null); 
	}
	
	public int size() {return TREE.size() - 1;}
	
	public boolean isEmpty() {return (size() == 0);}
	
	public boolean isInternal(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		return hasLeft(node);
	}
	
	public boolean isExternal(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		return !isInternal(node);
	}
	
	protected BTPos<TIPO> checkPosition(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		if (node == null || !(node instanceof BTPos)) throw new ExcecaoPosicaoInvalida("Essa posição é inválida!");
		return (BTPos<TIPO>) node;
	}
	
	public boolean isRoot(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		BTPos<TIPO> nodeValidado = checkPosition(node);
		return nodeValidado.index() == 1;
	}
	
	public boolean hasLeft(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		BTPos<TIPO> nodeValidado = checkPosition(node);
		return 2 * nodeValidado.index() <= size();
	}
	
	public boolean hasRight(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		BTPos<TIPO> nodeValidado = checkPosition(node);
		return 2 * nodeValidado.index() + 1 <= size();
	}
	
	public Position<TIPO> root() throws ExcecaoArvoreVazia {

		if (isEmpty()) throw new ExcecaoArvoreVazia("A árvore está vazia!");
		return TREE.get(1);
	}
	
	public Position<TIPO> left(Position<TIPO> node) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites {

		if (!hasLeft(node)) throw new ExcecaoIndiceForaLimites("Não há filhos a esquerda!");
		
		BTPos<TIPO> nodeValidado = checkPosition(node);
		return TREE.get(2 * nodeValidado.index());
	}
	
	public Position<TIPO> right(Position<TIPO> node) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites {

		if (!hasRight(node)) throw new ExcecaoIndiceForaLimites("Não há filhos a direita!");

		BTPos<TIPO> nodeValidado = checkPosition(node);
		return TREE.get(2 * nodeValidado.index() + 1);
	}
	
	public Position<TIPO> parent(Position<TIPO> node) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites {

		if (isRoot(node)) throw new ExcecaoIndiceForaLimites("Esse node não tem pai!");

		BTPos<TIPO> nodeValidado = checkPosition(node);
		return TREE.get(nodeValidado.index() / 2);
	}
	
	public Iterable<Position<TIPO>> children(Position<TIPO> node) throws ExcecaoPosicaoInvalida {

		PositionList<Position<TIPO>> children = new NodePositionList<Position<TIPO>>();

		if (hasLeft(node)) children.addLast(left(node));
		if (hasRight(node)) children.addLast(right(node));

		return children;
	}
	
	public Iterable<Position<TIPO>> positions() {

		ArrayList<Position<TIPO>> listNodes = new ArrayList<Position<TIPO>>();
		Iterator<BTPos<TIPO>> link = TREE.iterator();

		link.next();

		while (link.hasNext()) listNodes.add(link.next());
		return listNodes;
	}
	
	public TIPO replace(Position<TIPO> node, TIPO element) throws ExcecaoPosicaoInvalida {

		BTPos<TIPO> nodeValidado = checkPosition(node);

		return nodeValidado.setElement(element);
	}
	
	public Position<TIPO> add(TIPO element) {

		int index = size() + 1;

		BTPos<TIPO> node = new BTPos<TIPO>(element, index);
		TREE.add(index, node);

		return node;
	}
	
	public TIPO remove() throws ExcecaoArvoreVazia {

		if (isEmpty()) throw new ExcecaoArvoreVazia("A árvore está vazia!");
		return TREE.remove(size()).element();
	}
	
	public Position<TIPO> sibling(Position<TIPO> node) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites {

		try {

			Position<TIPO> nodeParent = parent(node);	
			Position<TIPO> nodeLeft = left(nodeParent);
	
			if (node == nodeLeft) return right(nodeParent);	
			else return nodeLeft;

		} catch (ExcecaoIndiceForaLimites erro) { throw new ExcecaoIndiceForaLimites("Esse node não tem irmão!"); }
	}
	
	public void swapElements(Position<TIPO> nodeP, Position<TIPO> nodeS) throws ExcecaoPosicaoInvalida {

		BTPos<TIPO> nodePValidado = checkPosition(nodeP);
		BTPos<TIPO> nodeSValidado = checkPosition(nodeS);

		TIPO nodeTemporario = nodePValidado.element();

		nodePValidado.setElement(nodeSValidado.element());
		nodeSValidado.setElement(nodeTemporario);
	}
	
	public Iterator<TIPO> iterator() {

		ArrayList<TIPO> list = new ArrayList<TIPO>();
		Iterator<BTPos<TIPO>> link = TREE.iterator();

		link.next();

		while (link.hasNext()) list.add(link.next().element());
		return list.iterator();
	}
	
	public String toString() {return TREE.toString();}
}
