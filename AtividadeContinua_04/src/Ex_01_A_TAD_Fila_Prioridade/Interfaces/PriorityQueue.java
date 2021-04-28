package Ex_01_A_TAD_Fila_Prioridade.Interfaces;

import Ex_01_A_TAD_Fila_Prioridade.Excecoes.EmptyPriorityQueueException;
import Ex_01_A_TAD_Fila_Prioridade.Excecoes.InvalidKeyException;

public interface PriorityQueue<KEY, VALUE> {
	
	public int size();
	
	public boolean isEmpty();
	
	public Entry<KEY, VALUE> min() throws EmptyPriorityQueueException;
	
	public Entry<KEY, VALUE> insert(KEY key, VALUE value) throws InvalidKeyException;
	
	public Entry<KEY, VALUE> removeMin() throws EmptyPriorityQueueException;
}
