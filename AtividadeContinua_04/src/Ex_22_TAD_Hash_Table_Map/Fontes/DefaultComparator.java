package Ex_22_TAD_Hash_Table_Map.Fontes;

import java.util.Comparator;

public class DefaultComparator<TIPO> implements Comparator<TIPO>{
	
	@SuppressWarnings("unchecked")
	public int compare(TIPO PKey, TIPO SKey) throws ClassCastException {
		
		return ((Comparable<TIPO>) PKey).compareTo(SKey);
	}
}