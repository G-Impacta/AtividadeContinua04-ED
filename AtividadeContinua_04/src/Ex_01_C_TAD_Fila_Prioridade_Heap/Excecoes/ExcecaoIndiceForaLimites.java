package Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoIndiceForaLimites extends RuntimeException{
	
	public ExcecaoIndiceForaLimites(String mensagemErro) {
		
		super(mensagemErro);
	}
}
