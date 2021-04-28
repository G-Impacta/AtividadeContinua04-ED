package Ex_01_A_TAD_Fila_Prioridade.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoListaVazia extends RuntimeException{
	
	public ExcecaoListaVazia(String mensagemErro) {
		
		super(mensagemErro);
	}
}
