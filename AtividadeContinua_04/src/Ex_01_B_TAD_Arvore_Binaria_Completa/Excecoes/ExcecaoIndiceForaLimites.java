package Ex_01_B_TAD_Arvore_Binaria_Completa.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoIndiceForaLimites extends RuntimeException{
	
	public ExcecaoIndiceForaLimites(String mensagemErro) {
		
		super(mensagemErro);
	}
}
