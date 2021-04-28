package Ex_22_TAD_Hash_Table_Map.Interfaces;

import Ex_22_TAD_Hash_Table_Map.Excecoes.EmptyPriorityQueueException;
import Ex_22_TAD_Hash_Table_Map.Excecoes.InvalidKeyException;

public interface PriorityQueue<KEY, VALUE> {
	
	public int size();
	
	public boolean isEmpty();
	
	public Entry<KEY, VALUE> min() throws EmptyPriorityQueueException;
	
	public Entry<KEY, VALUE> insert(KEY key, VALUE value) throws InvalidKeyException;
	
	public Entry<KEY, VALUE> removeMin() throws EmptyPriorityQueueException;
}
