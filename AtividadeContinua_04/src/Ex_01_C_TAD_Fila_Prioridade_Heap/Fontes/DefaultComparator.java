package Ex_01_C_TAD_Fila_Prioridade_Heap.Fontes;

import java.util.Comparator;

public class DefaultComparator<TIPO> implements Comparator<TIPO>{
	
	@SuppressWarnings("unchecked")
	public int compare(TIPO PKey, TIPO SKey) throws ClassCastException {
		
		return ((Comparable<TIPO>) PKey).compareTo(SKey);
	}
}