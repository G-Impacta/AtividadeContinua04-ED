package Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes;

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException{
	
	public InvalidKeyException(String mensagemErro) {
		
		super(mensagemErro);
	}
}
