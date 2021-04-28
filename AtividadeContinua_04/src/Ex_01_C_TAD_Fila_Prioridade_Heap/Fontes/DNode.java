package Ex_01_C_TAD_Fila_Prioridade_Heap.Fontes;

import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.ExcecaoPosicaoInvalida;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces.Position;

public class DNode<TIPO> implements Position<TIPO>{	
	
	private DNode<TIPO> prev, next;
	private TIPO elemento;
	
	public DNode(DNode<TIPO> prev, DNode<TIPO> next, TIPO elemento) {
		
		this.prev = prev;
		this.next = next;
		this.elemento = elemento;
	}
	
	public TIPO element() throws ExcecaoPosicaoInvalida{
		
		if((prev == null) && (next == null)) {throw new ExcecaoPosicaoInvalida("Essa posi��o n�o est� na lista!");}
		return elemento;		
	}
	
	public DNode<TIPO> getNext() {return next;}
	
	public DNode<TIPO> getPrev() {return prev;}
	
	public void setNext(DNode<TIPO> novoNext) {next = novoNext;}
	
	public void setPrev(DNode<TIPO> novoPrev) {prev = novoPrev;}
	
	public void setElement(TIPO novoElemento) {elemento = novoElemento;}
}
