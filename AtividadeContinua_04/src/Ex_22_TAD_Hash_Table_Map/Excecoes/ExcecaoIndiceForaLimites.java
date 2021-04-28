package Ex_22_TAD_Hash_Table_Map.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoIndiceForaLimites extends RuntimeException{
	
	public ExcecaoIndiceForaLimites(String mensagemErro) {
		
		super(mensagemErro);
	}
}
