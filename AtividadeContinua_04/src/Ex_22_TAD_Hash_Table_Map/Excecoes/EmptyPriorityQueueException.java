package Ex_22_TAD_Hash_Table_Map.Excecoes;

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException{
	
	public EmptyPriorityQueueException(String mensagemErro) {
		
		super(mensagemErro);
	}
}