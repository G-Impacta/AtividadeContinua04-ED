package Ex_01_B_TAD_Arvore_Binaria_Completa.Fontes;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Ex_01_B_TAD_Arvore_Binaria_Completa.Interfaces.Position;
import Ex_01_B_TAD_Arvore_Binaria_Completa.Interfaces.PositionList;

public class ElementIterator<TIPO> implements Iterator<TIPO> {	
	
	protected PositionList<TIPO> list;
	protected Position<TIPO> cursor;
	
	public ElementIterator(PositionList<TIPO> list) {
		
		this.list = list;
		cursor = (list.isEmpty()) ? null : list.first();
	}
	
	public boolean hasNext() {return(cursor != null);}
	
	public TIPO next() throws NoSuchElementException{
		
		if(cursor == null) {throw new NoSuchElementException("N�o existe proximo elemento!");}
		
		TIPO toReturn = cursor.element();
		cursor = (cursor == list.last()) ? null : list.next(cursor);
		return toReturn;
	}
	
	public void remove() throws UnsupportedOperationException {

		throw new UnsupportedOperationException("remove");
	}
}
