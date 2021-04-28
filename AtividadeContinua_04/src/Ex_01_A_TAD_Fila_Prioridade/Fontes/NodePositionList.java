package Ex_01_A_TAD_Fila_Prioridade.Fontes;

import java.util.Iterator;

import Ex_01_A_TAD_Fila_Prioridade.Excecoes.ExcecaoIndiceForaLimites;
import Ex_01_A_TAD_Fila_Prioridade.Excecoes.ExcecaoListaVazia;
import Ex_01_A_TAD_Fila_Prioridade.Excecoes.ExcecaoPosicaoInvalida;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.Position;
import Ex_01_A_TAD_Fila_Prioridade.Interfaces.PositionList;

public class NodePositionList<TIPO> implements PositionList<TIPO> {	
	
	protected int numElementos;
	protected DNode<TIPO> header, trailer;
	
	public NodePositionList() {		
		
		numElementos = 0;
		header = new DNode<TIPO>(null, null, null);
		trailer = new DNode<TIPO>(header, null, null);
		header.setNext(trailer);
	}
	
	protected DNode<TIPO> checkPosition(Position<TIPO> position) throws ExcecaoPosicaoInvalida{
		
		if (position == null) throw new ExcecaoPosicaoInvalida("A posi��o informada tem valor null");
		if (position == header) throw new ExcecaoPosicaoInvalida("A cabe�a da lista n�o � uma posi��o valida");
		if (position == trailer) throw new ExcecaoPosicaoInvalida("A cabe�a da lista n�o � uma posi��o valida");
		
		try {
			
			DNode<TIPO> temp = (DNode<TIPO>) position;			
			if ((temp.getPrev() == null) || (temp.getNext() == null)) {throw new ExcecaoPosicaoInvalida("A posi��o n�o pertence a uma NodeList v�lida");}
			
			return temp;
			
		} catch (ClassCastException elemento) {throw new ExcecaoPosicaoInvalida("A posi��o � do tipo errado para esta lista");}		
	}
	
	public int size() {return numElementos;}
	
	public boolean isEmpty() { return (numElementos == 0); }
	
	public Position<TIPO> first() throws ExcecaoListaVazia {

		if (isEmpty()) throw new ExcecaoListaVazia("A lista est� vazia!");

		return header.getNext();
	}	
	
	public Position<TIPO> prev(Position<TIPO> position) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites {

		DNode<TIPO> validaPosition = checkPosition(position);
		DNode<TIPO> prev = validaPosition.getPrev();

		if (prev == header) throw new ExcecaoIndiceForaLimites("N�o � poss�vel avan�ar al�m do in�cio da lista");

		return prev;
	}
	
	public void addBefore(Position<TIPO> position, TIPO elemento) throws ExcecaoPosicaoInvalida {

		DNode<TIPO> validaPosition = checkPosition(position);
		numElementos++;
		DNode<TIPO> newNode = new DNode<TIPO>(validaPosition.getPrev(), validaPosition, elemento);

		validaPosition.getPrev().setNext(newNode);
		validaPosition.setPrev(newNode);
	}
	
	public void addFirst(TIPO elemento) {

		numElementos++;
		DNode<TIPO> newNode = new DNode<TIPO>(header, header.getNext(), elemento);

		header.getNext().setPrev(newNode);
		header.setNext(newNode);
	}
	
	public TIPO remove(Position<TIPO> position) throws ExcecaoPosicaoInvalida {

		DNode<TIPO> validaPosition = checkPosition(position);

		numElementos--;

		DNode<TIPO> validaPositionPrev = validaPosition.getPrev();
		DNode<TIPO> validaPositionNext = validaPosition.getNext();
		validaPositionPrev.setNext(validaPositionNext);
		validaPositionNext.setPrev(validaPositionPrev);
		TIPO elementoValidado = validaPosition.element();		

		validaPosition.setNext(null);
		validaPosition.setPrev(null);

		return elementoValidado;
	}
	
	public TIPO set(Position<TIPO> position, TIPO elemento) throws ExcecaoPosicaoInvalida {

		DNode<TIPO> validaPosition = checkPosition(position);
		TIPO elementoTemp = validaPosition.element();
		validaPosition.setElement(elemento);

		return elementoTemp;
	}
	
	public Position<TIPO> last() {
		
		if (isEmpty()) throw new ExcecaoListaVazia("A lista est� vazia!");

		return trailer.getPrev();
	}
	
	public Position<TIPO> next(Position<TIPO> position) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites {

		DNode<TIPO> validaPosition = checkPosition(position);
		DNode<TIPO> next = validaPosition.getNext();

		if (next == trailer) throw new ExcecaoIndiceForaLimites("N�o � poss�vel avan�ar al�m da finaliza��o da lista");

		return next;
	}
	
	public void addLast(TIPO elemento) {

		numElementos++;

		DNode<TIPO> newNode = new DNode<TIPO>(trailer.getPrev(), trailer, elemento);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}
	
	public void addAfter(Position<TIPO> position, TIPO elemento) throws ExcecaoPosicaoInvalida {

		DNode<TIPO> validaPosition = checkPosition(position);

		numElementos++;

		DNode<TIPO> newNode = new DNode<TIPO>(validaPosition, validaPosition.getNext(), elemento);
		validaPosition.getNext().setPrev(newNode);
		validaPosition.setNext(newNode);
	}
	
	public void makeFirst(Position<TIPO> position) {
		
		DNode<TIPO> validaPosition = checkPosition(position);

		DNode<TIPO> validaPositionPrev = validaPosition.getPrev();
		DNode<TIPO> validaPositionNext = validaPosition.getNext();
		validaPositionPrev.setNext(validaPositionNext);
		validaPositionNext.setPrev(validaPositionPrev);		
		
		validaPosition.setNext(header.getNext());
		validaPosition.setPrev(header);
		
		header.getNext().setPrev(validaPosition);
		header.setNext(validaPosition);		
	}	
	
	public static <TIPO> String toString(PositionList<TIPO> l) {

		String elementosLista = "";

		for (TIPO i: l) { elementosLista += ", " + i; }

		elementosLista = (elementosLista.length() == 0 ? elementosLista : elementosLista.substring(2));

		return "[" + elementosLista + "]";
	}
	
	public Iterator<TIPO> iterator() { return new ElementIterator<TIPO>(this); }

	public String toString() { return toString(this); }
}
