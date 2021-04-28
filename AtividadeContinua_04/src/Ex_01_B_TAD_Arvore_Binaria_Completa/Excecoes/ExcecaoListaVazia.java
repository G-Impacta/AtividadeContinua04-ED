package Ex_01_B_TAD_Arvore_Binaria_Completa.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoListaVazia extends RuntimeException{
	
	public ExcecaoListaVazia(String mensagemErro) {
		
		super(mensagemErro);
	}
}
