package Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoListaVazia extends RuntimeException{
	
	public ExcecaoListaVazia(String mensagemErro) {
		
		super(mensagemErro);
	}
}
