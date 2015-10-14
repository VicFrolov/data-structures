public class NumberList implements java.util.Collection {
	public Long[] numberList;
	private int count;


    /** Constructs an empty number list. */ 
    public NumberList(){
    	numberList = new Long[1];
    	count = 0;
	}


    /** Constructs a number list from an array of Longs. */
    public NumberList(Long[] l){
    	this.count = l.length;
    	this.numberList = new Long[l.length * 2];

    	for (int i = 0; i < l.length; i++) {
    		this.numberList[i] = l[i];
    	}
    }
    
    /** Increases by one the number of instances of the given element in this collection. */
    public boolean add ( Object obj ) {
    	int nlLength = this.numberList.length;
    	int countArray = 0;
    	if (!(obj instanceof Long)) {
    		return false;
    	} else {

	    	for (int i = 0; i < nlLength; i++) {
	    		if (this.numberList[i] == null) {
	    			this.numberList[i] = (Long) obj;
	    			count++;
	    			break;
	    		} else if (countArray == this.count || this.count == nlLength) {
	    			Long[] tempNl = new Long[nlLength * 2];

	    			for (int j = 0; j < nlLength; j++) {
	    				tempNl[j] = this.numberList[j];
	    			}
	    			tempNl[nlLength] = (Long) obj;
	    			this.numberList = tempNl;
	    			count++;
	    			break;

	    		}
	    		countArray++;
	    	}
	    }

	    return true;
    }
    

    /** Adds all of the elements of the given number list to this one. */
    public boolean addAll ( java.util.Collection c  ) {
        throw new UnsupportedOperationException();

    }
 

    /** Removes all of the elements from this collection. */
    public void clear () {
        Long[] tempNl = new Long[1];
        count = 0;
        numberList = tempNl;
    }
 

    /** Returns true iff this number list contains at least one instance of the specified element. */
    public boolean contains ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
 


    /** Returns true iff this number list contains at least one instance of each element 
        in the specified list. Multiple copies of some element in the argument do not
        require multiple copies in this number list. */
    public boolean containsAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
 
 


    /** Compares the specified object with this collection for equality. */
    public boolean equals ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
 



    /** Returns the hashcode value for this collection. */
    public int hashCode () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
    	if (count == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }



    /** Returns an iterator over the elements in this collection. Replicated elements should
        be "iterated over" just once. */
    public java.util.Iterator iterator () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Removes a single instance of the specified element from 
        this collection, if it is present. */
    public boolean remove ( Object obj ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Removes all of this collection's elements that are also contained 
        in the specified collection. */
    public boolean removeAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




	/** Retains only the elements in this collection that are contained in the specified collection. 
		 In other words, removes from this collection all of its elements that are not contained in the 
		 specified collection. */
	public boolean retainAll ( java.util.Collection c ) {
		throw new UnsupportedOperationException();
	}


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
    	return this.count;
    }
    
    

    /** Returns a Long[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
        throw new UnsupportedOperationException();
    }



    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }


    public int size () {
    /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




    /** Returns the number of instances of the given element in this number list. */
    public int count( Object obj ) {
    	int tally = 0;
    	for (int i = 0; i < this.count; i++) {
    		if(this.numberList[i].equals((Long) obj)) {
    			tally++;
    		}
    	}
    	return tally;
    }
    
	@Override
	public String toString () {
        String stringifiedArray = "[";
        for (int i = 0; i < this.count; i++) {
        	if (i == this.count-1) {
        		stringifiedArray += (this.numberList[i].toString());
        	} else {
        		stringifiedArray += (this.numberList[i].toString()) + ", ";
        	}
        }
        stringifiedArray += "]";

        return stringifiedArray;
    }


    
    /** This so-called "static factory" returns a new number list comprised of the numbers in the specified array.
        Note that the given array is long[], not Long[]. */
    public static NumberList fromArray ( long[] l ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }

    
    public static void main ( String[] args ) {

    	// Please see NumberListTestHarness.java for tests

    	NumberListTestHarness.main(new String[]{"test"});


	
	}
    
}