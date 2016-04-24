// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique items(at most one 
//             item with a given search key at any time)
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K,V> {
	private ChainNode[] table;     // hash table
	private int size = 0;          // size of ADT table

	public HashTable() {
		table = new ChainNode[3];
	}  // end default constructor

	// table operations
	public boolean tableIsEmpty() {
		return size==0;
	}  // end tableIsEmpty

	public int tableLength() {
		return size;
	}  // end tableLength

	public void tableInsert(K key, V value) throws HashException{

		if(table[(Integer)value]==null){
			table[(Integer)value] = new ChainNode(key, value, null);
		}
		else{
			ChainNode<K, V> tail = table[(Integer)value];			
			while(tail.getNext()!=null){
				tail = tail.getNext();
			}
			tail.setNext(new ChainNode(key, value, null));		  
		}  
		size++;
	}

	public boolean tableDelete(K searchKey){
		if(size>0){
			for(int i = 0; i<3; i++){
				if(table[i]!=null){
					ChainNode<K, V> current = table[i];
					if(current.getNext()==null){
						current = null;
						return true;
					}
					while(current!=null){						
						if(current.getNext().getKey().equals(searchKey)){
							current.setNext(current.getNext().getNext());
							size--;
							return true;
						}
						current = current.getNext();
					}
				}
			}
		}	
		return false;
	}

	public V tableRetrieve(K searchKey){
		if(size>0){
			for(int i = 0; i<3; i++){
				if(table[i]!=null){
					ChainNode<K, V> current = table[i];
					while(current.getNext()!=null){		  
						if(current.getNext().getKey().equals(searchKey)){													
							return current.getNext().getValue();
						}
						current = current.getNext();
					}
				}
			}
		}	
		return null;
	}


	public int hashIndex(K key){
		for(int i = 0; i<size; i++){
			if(table[i].getKey()==key){
				return i;
			}
		}
		return -1;
	}


}  // end HashTable
