package Ex_01_A_TAD_Fila_Prioridade.Excecoes;

@SuppressWarnings("serial")
public class ExcecaoPosicaoInvalida extends RuntimeException{
	
	public ExcecaoPosicaoInvalida(String mensagemErro) {
		
		super(mensagemErro);
	}
}
