package Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes;

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException{
	
	public EmptyPriorityQueueException(String mensagemErro) {
		
		super(mensagemErro);
	}
}