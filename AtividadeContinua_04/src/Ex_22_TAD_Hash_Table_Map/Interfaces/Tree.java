package Ex_22_TAD_Hash_Table_Map.Interfaces;

import java.util.Iterator;

import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoArvoreVazia;
import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoIndiceForaLimites;
import Ex_22_TAD_Hash_Table_Map.Excecoes.ExcecaoPosicaoInvalida;

public interface Tree<TIPO> extends Iterable<TIPO> {	
	
	public int size();
	
	public boolean isEmpty();
	
	public Iterator<TIPO> iterator();
	
	public Iterable<Position<TIPO>> positions();
	
	public TIPO replace(Position<TIPO> posNode, TIPO elemento) throws ExcecaoPosicaoInvalida;
	
	public Position<TIPO> root() throws ExcecaoArvoreVazia;
	
	public Position<TIPO> parent(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;
	
	public Iterable<Position<TIPO>> children(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
	
	public boolean isInternal(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
	
	public boolean isExternal(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
	
	public boolean isRoot(Position<TIPO> posNode) throws ExcecaoPosicaoInvalida;
}
