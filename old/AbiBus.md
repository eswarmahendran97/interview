Iterators in Java
	Enumaration - Used for legacy (Vector,hashTables) eg: Enumaration e = vec.elements();
	Iterators - Used for Collections(list,set,map) eg: Iterator it = list.iterator();
	ListIterator - Used for List eg: ListIterator li = list.listIterator();
Iterator vs listIterator
ListIterator li = list.listIterator();
	li.hasNext(),li.next(),li.hasPrevious(),li.previous()
Iterator it = list.iterator();
	li.hasNext(),li.next()
Marker Interface
Used to  inform the Java compiler
	Its an empty interface(dont have any methods) 
	Eg: Serializable, Cloneable and Remote interface
Covariant return type
hql query to get top 1
	session.(Select query ). SetMaxResults(1)
