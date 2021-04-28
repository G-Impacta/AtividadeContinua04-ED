package Ex_22_TAD_Hash_Table_Map.Interfaces;

import Ex_22_TAD_Hash_Table_Map.Excecoes.InvalidKeyException;

public interface Map<KEY, VALUE> {
	
	public int size();

	public boolean isEmpty();

	public VALUE put(KEY key, VALUE value) throws InvalidKeyException;

	public VALUE get(KEY key) throws InvalidKeyException;

	public VALUE remove(KEY key) throws InvalidKeyException;

	public Iterable<KEY> keySet();

	public Iterable<VALUE> values();

	public Iterable<Entry<KEY,VALUE>> entrySet();
}
