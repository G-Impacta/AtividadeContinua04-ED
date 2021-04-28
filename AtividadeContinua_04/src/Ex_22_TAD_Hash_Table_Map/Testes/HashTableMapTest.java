package Ex_22_TAD_Hash_Table_Map.Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex_22_TAD_Hash_Table_Map.Fontes.HashTableMap;
import Ex_22_TAD_Hash_Table_Map.Fontes.HeapPriorityQueue;
import Ex_22_TAD_Hash_Table_Map.Interfaces.Entry;

class HashTableMapTest {

	@Test
	void test() {
		
		HashTableMap<Integer, String> mapa = new HashTableMap<Integer, String>();
		
		assertTrue(mapa.isEmpty());

		assertNull(mapa.put(5, "A"));
		assertEquals("{(5,A)}", ordenar(mapa.entrySet()));

		assertNull(mapa.put(7, "B"));
		assertEquals("{(5,A), (7,B)}", ordenar(mapa.entrySet()));

		assertNull(mapa.put(2, "C"));
		assertEquals("{(2,C), (5,A), (7,B)}", ordenar(mapa.entrySet()));

		assertNull(mapa.put(8, "D"));
		assertEquals("{(2,C), (5,A), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertNotNull(mapa.put(2, "E"));
		assertEquals("{(2,E), (5,A), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertEquals("B", mapa.get(7));
		assertEquals("{(2,E), (5,A), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertNull(mapa.get(4));

		assertEquals("{(2,E), (5,A), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertEquals("E", mapa.get(2));
		assertEquals("{(2,E), (5,A), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertEquals(4, mapa.size());

		assertEquals("{(2,E), (5,A), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertEquals("A", mapa.remove(5));
		assertEquals("{(2,E), (7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertEquals("E", mapa.remove(2));
		assertEquals("{(7,B), (8,D)}", ordenar(mapa.entrySet()));

		assertNull(mapa.get(2));

		assertFalse(mapa.isEmpty());

		assertEquals("{(7,B), (8,D)}", ordenar(mapa.entrySet()));
		assertEquals("{7, 8}", ordenarKeys(mapa.keySet()));
		
		assertEquals("{(7,B), (8,D)}", ordenar(mapa.entrySet()));
		assertEquals("{B, D}", ordenarValues(mapa.values()));
		
		assertEquals("{(7,B), (8,D)}", ordenar(mapa.entrySet()));		
	}
	
	private Object ordenarValues(Iterable<String> values) {

		String saida = "{";

		HeapPriorityQueue<String, String> filaPrioridade = new HeapPriorityQueue<String, String>();

		for (String entry : values) {filaPrioridade.insert(entry, entry);}

		Entry<String, String> entry;

		while (!filaPrioridade.isEmpty()) {

			entry = filaPrioridade.removeMin();
			saida += entry.getKey() + ", ";
		}

		return saida.substring(0, saida.length() - 2) + "}";
	}
	
	private Object ordenarKeys(Iterable<Integer> keys) {

		String saida = "{";

		HeapPriorityQueue<Integer, Integer> filaPrioridade = new HeapPriorityQueue<Integer, Integer>();

		for (Integer entry : keys) {filaPrioridade.insert(entry, entry);}

		Entry<Integer, Integer> entry;

		while (!filaPrioridade.isEmpty()) {

			entry = filaPrioridade.removeMin();
			saida += entry.getKey() + ", ";
		}

		return saida.substring(0, saida.length() - 2) + "}";
	}
	
	protected String ordenar(Iterable<Entry<Integer, String>> iterable) {

		String saida = "{";

		HeapPriorityQueue<Integer, String> filaPrioridade = new HeapPriorityQueue<Integer, String>();

		for (Entry<Integer, String> entry : iterable) {filaPrioridade.insert(entry.getKey(), entry.getValue());}

		Entry<Integer, String> entry;

		while (!filaPrioridade.isEmpty()) {

			entry = filaPrioridade.removeMin();	
			saida += "(" + entry.getKey() + "," + entry.getValue() + "), ";
		}

		return saida.substring(0, saida.length() - 2) + "}";
	}
}
