package Ex_01_C_TAD_Fila_Prioridade_Heap.Interfaces;

import java.util.Iterator;

import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.ExcecaoArvoreVazia;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.ExcecaoIndiceForaLimites;
import Ex_01_C_TAD_Fila_Prioridade_Heap.Excecoes.ExcecaoPosicaoInvalida;

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
