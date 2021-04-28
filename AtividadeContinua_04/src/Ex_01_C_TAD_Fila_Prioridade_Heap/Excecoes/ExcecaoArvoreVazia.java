package Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoArvoreVazia extends RuntimeException{
	
	public ExcecaoArvoreVazia(String mensagemErro) {
		
		super(mensagemErro);
	}
}
