package Ex_22_TAD_Hash_Table_Map.Excecoes;

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException{
	
	public InvalidKeyException(String mensagemErro) {
		
		super(mensagemErro);
	}
}
