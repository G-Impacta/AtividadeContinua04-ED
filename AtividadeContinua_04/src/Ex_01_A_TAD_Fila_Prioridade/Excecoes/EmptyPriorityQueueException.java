package Ex_01_A_TAD_Fila_Prioridade.Excecoes;

@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends RuntimeException{
	
	public EmptyPriorityQueueException(String mensagemErro) {
		
		super(mensagemErro);
	}
}