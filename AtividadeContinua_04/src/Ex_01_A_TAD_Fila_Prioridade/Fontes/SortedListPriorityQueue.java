package Ex_01_A_TAD_Fila_Prioridade.Fontes;

import java.util.Comparator;

import Ex_01_A_TAD_Fila_Prioridade.Excecoes.EmptyPriorityQueueException;
import Ex_01_A_TAD_Fila_Prioridade.Excecoes.InvalidKeyException;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.Entry;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.Position;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.PositionList;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.PriorityQueue;

public class SortedListPriorityQueue<KEY, VALUE> implements PriorityQueue<KEY, VALUE>{
	
	protected PositionList<Entry<KEY, VALUE>> entries;
	protected Comparator<KEY> comparator;
	protected Position<Entry<KEY, VALUE>> actionPos;
	
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
	
	public SortedListPriorityQueue() {
		
		this.entries = new NodePositionList<Entry<KEY, VALUE>>();
		this.comparator = new DefaultComparator<KEY>();
	}
	
	public SortedListPriorityQueue(Comparator<KEY> comparator) {
		
		this.entries = new NodePositionList<Entry<KEY, VALUE>>();
		this.comparator = comparator;
	}
	
	public SortedListPriorityQueue(PositionList<Entry<KEY, VALUE>> entries, Comparator<KEY>  comparator) {
		
		this.entries = entries;
		this.comparator = comparator;
	}
	
	public void setComparator(Comparator<KEY> comparator) throws IllegalStateException {
		
		if(!isEmpty()) throw new IllegalStateException("A fila prioritária não está vazia!");
		this.comparator = comparator;
	}
	
	public int size() {return entries.size();}
	
	public boolean isEmpty() {return entries.isEmpty();}
	
	public Entry<KEY, VALUE> min() throws EmptyPriorityQueueException {
		
		if(entries.isEmpty()) throw new EmptyPriorityQueueException("A fila de prioridade está vazia!");
		else return entries.first().element();
	}
	
	public Entry<KEY, VALUE> insert(KEY key, VALUE value) throws InvalidKeyException {
		
		checkKey(key);
		
		Entry<KEY, VALUE> entry = new MyEntry<KEY, VALUE>(key, value);
		insertEntry(entry);		
		
		return entry;
	}
	
	public void insertEntry(Entry<KEY, VALUE> entry) {
		
		if(entries.isEmpty()) {
			
			entries.addFirst(entry);
			actionPos = entries.first();
			
		} else if(comparator.compare(entry.getKey(), entries.last().element().getKey()) > 0) {
			
			entries.addLast(entry);
			actionPos = entries.last();
			
		} else {
			
			Position<Entry<KEY, VALUE>> current = entries.first();
			
			while(comparator.compare(entry.getKey(), current.element().getKey()) > 0) {
				
				current = entries.next(current);				
			}
			
			entries.addBefore(current, entry);
			actionPos = entries.prev(current);
		}
	}
	
	public Entry<KEY, VALUE> removeMin() throws EmptyPriorityQueueException {
		
		if(entries.isEmpty()) throw new EmptyPriorityQueueException("A fila de prioridade está vazia!");
		else return entries.remove(entries.first());
	}
	
	protected boolean checkKey(KEY key) throws InvalidKeyException {
		
		boolean result;
		
		try {
			
			result = (comparator.compare(key, key) == 0);
			
		} catch (ClassCastException erro) {
			
			throw new InvalidKeyException("A chave não pode ser comparada!");
		}
		
		return result;
	}
	
	public String toString() {return entries.toString();}
}
