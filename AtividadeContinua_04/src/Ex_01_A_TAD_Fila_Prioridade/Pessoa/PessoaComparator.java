package Ex_01_A_TAD_Fila_Prioridade.Pessoa;

import java.util.Comparator;

public class PessoaComparator implements Comparator<Pessoa> {
	
	public int compare(Pessoa PPessoa, Pessoa SPessoa) {
		
		return PPessoa.getNome().compareTo(SPessoa.getNome());
	}
}