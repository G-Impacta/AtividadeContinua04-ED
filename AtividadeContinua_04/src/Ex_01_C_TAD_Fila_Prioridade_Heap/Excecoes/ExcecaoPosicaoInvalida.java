package Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoPosicaoInvalida extends RuntimeException{
	
	public ExcecaoPosicaoInvalida(String mensagemErro) {
		
		super(mensagemErro);
	}
}
