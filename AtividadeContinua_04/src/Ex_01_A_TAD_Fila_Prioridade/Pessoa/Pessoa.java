package Ex_01_A_TAD_Fila_Prioridade.Pessoa;

public class Pessoa implements Comparable<Pessoa>{
	
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {return nome;}
	
	public int getIdade() {return idade;}
	
	@Override
	public String toString() {
		
		return "Pessoa {nome=" + nome + ", idade=" + idade + "}";
	}
	
	public int compareTo(Pessoa pessoa) {
		
		if(this.idade < pessoa.idade) {return -1;}
		if(this.idade > pessoa.idade) {return 1;}
		
		return 0;
	}
}
