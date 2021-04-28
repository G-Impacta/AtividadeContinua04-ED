package Ex_01_B_TAD_Arvore_Binaria_Completa.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoArvoreVazia extends RuntimeException{
	
	public ExcecaoArvoreVazia(String mensagemErro) {
		
		super(mensagemErro);
	}
}
