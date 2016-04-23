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
	  ChainNode<K, V> newChainNode = new ChainNode(key, value, table[1]);
	  size++;
  }
  
  public boolean tableDelete(K searchKey){
	  for(int i = 0; i<size; i++){
		  if(table[i].getKey()==searchKey){
			  table[i-1].setNext(table[i+1]);
			  size--;
			  return true;
		  }
	  }
	  return false;
  }
  
  public V tableRetrieve(K searchKey){
	  for(int i = 0; i<size; i++){
		  if(table[i].getKey()==searchKey){
			  return (V)table[i];
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
