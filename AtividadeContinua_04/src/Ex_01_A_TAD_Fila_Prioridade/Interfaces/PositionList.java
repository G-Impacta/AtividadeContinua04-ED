package Ex_01_A_TAD_Fila_Prioridade.Interfaces;

import java.util.Iterator;

import Ex_01_A_TAD_Fila_Prioridade.Excecoes.ExcecaoIndiceForaLimites;
import Ex_01_A_TAD_Fila_Prioridade.Excecoes.ExcecaoPosicaoInvalida;

public interface PositionList<TIPO> extends Iterable<TIPO>{

	public int size();

	public boolean isEmpty();

	public Position<TIPO> first();

	public Position<TIPO> last();

	public Position<TIPO> next(Position<TIPO> posicao) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;

	public Position<TIPO> prev(Position<TIPO> posicao) throws ExcecaoPosicaoInvalida, ExcecaoIndiceForaLimites;

	public void addFirst(TIPO elemento);

	public void addLast(TIPO elemento);

	public void addAfter(Position<TIPO> posicao, TIPO elemento) throws ExcecaoPosicaoInvalida;

	public void addBefore(Position<TIPO> posicao, TIPO elemento) throws ExcecaoPosicaoInvalida;

	public TIPO remove(Position<TIPO> posicao) throws ExcecaoPosicaoInvalida;

	public TIPO set(Position<TIPO> posicao, TIPO elemento) throws ExcecaoPosicaoInvalida;

	public Iterator<TIPO> iterator();
}
