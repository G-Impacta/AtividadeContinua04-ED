package Ex_22_TAD_Hash_Table_Map.Fontes;

import Ex_22_TAD_Hash_Table_Map.Excecoes.InvalidKeyException;
import Ex_22_TAD_Hash_Table_Map.Interfaces.Entry;
import Ex_22_TAD_Hash_Table_Map.Interfaces.Map;
import Ex_22_TAD_Hash_Table_Map.Interfaces.PositionList;

public class HashTableMap<KEY, VALUE> implements Map<KEY, VALUE> {
	
	public static class HashEntry<KEY, VALUE> implements Entry<KEY, VALUE>{
		
		protected KEY key;
		protected VALUE value;

		public HashEntry(KEY key, VALUE value) {
			
			this.key = key;
			this.value = value;			
		}
		
		public VALUE getValue() {return value;}

		public KEY getKey() {return key;}
		
		public VALUE setValue(VALUE value) {

			VALUE valueTemporario = this.value;

			this.value = value;
			return valueTemporario;
		}
		
		@SuppressWarnings("unchecked")
		public boolean equals(Object object) {

			HashEntry<KEY, VALUE> entry;

			try {

				entry = (HashEntry<KEY, VALUE>) object;

			} catch (ClassCastException exception) {return false;}

			return (entry.getKey() == key) && (entry.getValue() == value);
		}
		
		public String toString() {return "(" + key + "," + value + ")";}		
	}
	
	protected Entry<KEY, VALUE> AVAILABLE = new HashEntry<KEY, VALUE>(null, null);
	
	protected int n = 0;
	protected int prime, capacity;
	protected Entry<KEY, VALUE>[] bucket;
	protected long scale, shift;
	
	public HashTableMap() {this(109345121, 1000);}
	
	public HashTableMap(int capacity) {this(109345121, capacity);}
	
	@SuppressWarnings("unchecked")
	public HashTableMap(int prime, int capacity) {

		this.prime = prime;	
		this.capacity = capacity;	
		this.bucket = (Entry<KEY, VALUE>[]) new Entry[capacity];
	
		java.util.Random rand = new java.util.Random();
	
		this.scale = rand.nextInt(prime - 1) + 1;	
		this.shift = rand.nextInt(prime);
	}
	
	protected void checkKey(KEY key) {if (key == null) throw new InvalidKeyException("Chave inválida: null.");}
	
	public int hashValue(KEY key) {return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);}
	
	public int size() {return n;}
	
	public boolean isEmpty() {return (n == 0);}
	
	public Iterable<KEY> keySet() {

		PositionList<KEY> keys = new NodePositionList<KEY>();

		for (int i = 0; i < capacity; i++)if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) keys.addLast(bucket[i].getKey());

		return keys;
	}
	
	protected int findEntry(KEY key) throws InvalidKeyException{
		
		int avail = -1;
		checkKey(key);
		int i = hashValue(key);
		int j = i;
		
		do {

			Entry<KEY, VALUE> entrys = bucket[i];

			if (entrys == null) {if (avail < 0) avail = i; break;}
			if (key.equals(entrys.getKey())) return i;
			if (entrys == AVAILABLE) {if (avail < 0) avail = i;}

			i = (i + 1) % capacity;
			
		} while (i != j);
		
		return -(avail + 1);		
	}
	
	public VALUE get(KEY key) throws InvalidKeyException {

		int i = findEntry(key);
		if (i < 0) return null;

		return bucket[i].getValue();
	}
	
	public VALUE put(KEY key, VALUE value) throws InvalidKeyException {

		int i = findEntry(key);

		if (i >= 0) return ((HashEntry<KEY, VALUE>) bucket[i]).setValue(value);

		if (n >= capacity / 2) {rehash(); i = findEntry(key);}

		bucket[-i - 1] = new HashEntry<KEY, VALUE>(key, value);
		n++;

		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected void rehash() {

		capacity = 2 * capacity;

		Entry<KEY, VALUE>[] temporario = bucket;
		bucket = (Entry<KEY, VALUE>[]) new Entry[capacity];

		java.util.Random rand = new java.util.Random();

		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);

		for (int i = 0; i < temporario.length; i++) {

			Entry<KEY, VALUE> entry = temporario[i];

			if ((entry != null) && (entry != AVAILABLE)) {

				int j = -1 - findEntry(entry.getKey());
				bucket[j] = entry;
			}
		}
	}
	
	public VALUE remove(KEY key) throws InvalidKeyException {

		int i = findEntry(key);
		if (i < 0) return null;

		VALUE toReturn = bucket[i].getValue();
		bucket[i] = AVAILABLE;
		n--;

		return toReturn;
	}
	
	public Iterable<Entry<KEY, VALUE>> entrySet() {

		PositionList<Entry<KEY, VALUE>> entries = new NodePositionList<Entry<KEY, VALUE>>();

		for (int i = 0; i < capacity; i++)

			if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) entries.addLast(bucket[i]);

		return entries;
	}
	
	public Iterable<VALUE> values() {

		PositionList<VALUE> values = new NodePositionList<VALUE>();

		for (int i = 0; i < capacity; i++)

			if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) values.addLast(bucket[i].getValue());

		return values;
	}
}
