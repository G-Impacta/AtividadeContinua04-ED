package Ex_22_TAD_Hash_Table_Map.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoPosicaoInvalida extends RuntimeException{
	
	public ExcecaoPosicaoInvalida(String mensagemErro) {
		
		super(mensagemErro);
	}
}
