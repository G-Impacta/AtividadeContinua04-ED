package Ex_01_C_TAD_Fila_Prioridade_Heap.Fontes;

import java.util.Comparator;

import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.EmptyPriorityQueueException;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.InvalidKeyException;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces.CompleteBinaryTree;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces.Entry;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces.Position;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces.PriorityQueue;

public class HeapPriorityQueue<KEY, VALUE> implements PriorityQueue<KEY, VALUE> {
	
	protected CompleteBinaryTree<Entry<KEY, VALUE>> heap;
	protected Comparator<KEY> comparator;
	
	protected static class MyEntry<KEY, VALUE> implements Entry<KEY, VALUE> {

		protected KEY key;
		protected VALUE value;

		public MyEntry(KEY key, VALUE value) {
	
			this.key = key;	
			this.value = value;
		}

		public KEY getKey() {return key;}

		public VALUE getValue() {return value;}

		public String toString() {return "(" + key + "," + value + ")";}
	}
	
	public HeapPriorityQueue() {

		heap = new ArrayListCompleteBinaryTree<Entry<KEY, VALUE>>();
		comparator = new DefaultComparator<KEY>();
	}
	
	public HeapPriorityQueue(Comparator<KEY> comparator) {

		this.heap = new ArrayListCompleteBinaryTree<Entry<KEY, VALUE>>();
		this.comparator = comparator;
	}
	
	public void setComparator(Comparator<KEY> comparator) throws IllegalStateException {

		if (!isEmpty()) throw new IllegalStateException("A fila de prioridade não está vazia!");
		this.comparator = comparator;
	}
	
	public int size() {return heap.size();}
	
	public boolean isEmpty() {return heap.size() == 0;}
	
	public Entry<KEY, VALUE> min() throws EmptyPriorityQueueException {

		if (isEmpty()) throw new EmptyPriorityQueueException("A fila de prioridade está vazia!");
		return heap.root().element();
	}
	
	public Entry<KEY, VALUE> insert(KEY key, VALUE value) throws InvalidKeyException {

		checkKey(key);
		
		Entry<KEY, VALUE> entry = new MyEntry<KEY, VALUE>(key, value);
		upHeap(heap.add(entry));
		
		return entry;
	}
	
	public Entry<KEY, VALUE> removeMin() throws EmptyPriorityQueueException {

		if (isEmpty()) throw new EmptyPriorityQueueException("A fila de prioridade está vazia!");

		Entry<KEY, VALUE> min = heap.root().element();

		if (size() == 1) heap.remove();
		else {
	
			heap.replace(heap.root(), heap.remove());	
			downHeap(heap.root());
		}

		return min;
	}
	
	protected void checkKey(KEY key) throws InvalidKeyException {

		try { comparator.compare(key, key);
		} catch (Exception erro) {throw new InvalidKeyException("Chave invalida!");}
	}
	
	protected void upHeap(Position<Entry<KEY, VALUE>> node) {

		Position<Entry<KEY, VALUE>> nodeParent;

		while (!heap.isRoot(node)) {
	
			nodeParent = heap.parent(node);
	
			if (comparator.compare(nodeParent.element().getKey(), node.element().getKey()) <= 0) break;
	
			swap(nodeParent, node);	
			node = nodeParent;
		}
	}
	
	protected void downHeap(Position<Entry<KEY, VALUE>> node) {

		while (heap.isInternal(node)) {
	
			Position<Entry<KEY, VALUE>> child;
	
			if (!heap.hasRight(node)) child = heap.left(node);	
			else if (comparator.compare(heap.left(node).element().getKey(), heap.right(node).element().getKey()) <= 0)
	
				child = heap.left(node);
			
			else child = heap.right(node);
	
			if (comparator.compare(child.element().getKey(), node.element().getKey()) < 0) {
		
				swap(node, child);		
				node = child;
	
			} else break;
		}
	}
	
	protected void swap(Position<Entry<KEY, VALUE>> nodeP, Position<Entry<KEY, VALUE>> nodeS) {

		Entry<KEY, VALUE> nodeTemporario = nodeP.element();

		heap.replace(nodeP, nodeS.element());
		heap.replace(nodeS, nodeTemporario);
	}
	
	public String toString() {return heap.toString();}
}
