package Ex_01_A_TAD_Fila_Prioridade.Excecoes;

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException{
	
	public InvalidKeyException(String mensagemErro) {
		
		super(mensagemErro);
	}
}
