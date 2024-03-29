public class NumberList implements java.util.Collection {
	private Long[] numberList;
	private int count;


    /** Constructs an empty number list. */
    // Complexity -> O(1)
    public NumberList() {
    	this.numberList = new Long[1];
    	count = 0;
	}


    /** Constructs a number list from an array of Longs. */
    //  Complexity -> O(n)
    public NumberList(Long[] l) {
    	this.count = l.length;
    	this.numberList = new Long[l.length * 2];

    	for (int i = 0; i < l.length; i++) {
    		this.numberList[i] = l[i];
    	}
    }
    

    /** Increases by one the number of instances of the given element in this collection. */
    // Complexity -> O(n)
    public boolean add (Object obj) {
    	int nlLength = this.numberList.length;
    	int countArray = 0;

        if(obj == null) {
            throw new NullPointerException();
        } else if (!(obj instanceof Long)) {
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
        			this.count++;
        			break;
        		}
        		countArray++;
        	}
        }
	    return true;
    }
    

    /** Adds all of the elements of the given number list to this one. */
    // Complexity -> O(n)
    public boolean addAll(java.util.Collection c) {

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList)) {
            return false;
        } else if (((NumberList) c).sizeIncludingDuplicates() == 0) {
            return true;
        }

        String stringifiedC = ((NumberList) c).toString();
        String[] elementsOfC = (stringifiedC.substring(1, stringifiedC.length() -1)).split(", ");

        for(int i = 0; i < elementsOfC.length; i++) {
            this.add(new Long(Long.parseLong(elementsOfC[i])));
        }

        return true;
    }


    /** Removes all of the elements from this collection. */
    // Complexity -> O(1)
    public void clear() {
        Long[] tempNl = new Long[1];
        this.count = 0;
        this.numberList = tempNl;
    }


    /** Returns true iff this number list contains at least one instance of the specified element. */
    //  Complexity ->  O(n)
    public boolean contains(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        } else if (!(obj instanceof Long)) {
            throw new ClassCastException();
        } else {
            for (int i = 0; i < this.numberList.length; i++) {
                if ( ((Long) obj).equals(this.numberList[i])) {
                    return true;
                }
            }
        }
        return false;
    }


    //helper method that converts a numberList into a long[]
    //  Complexity -> O(n)
    public long[] convertNl(java.util.Collection c) {
        //quick base case check
        if (c.isEmpty()) {
            return new long[0];
        }

        String stringifiedC = ((NumberList) c).toString();
        String[] elementsOfC = (stringifiedC.substring(1, stringifiedC.length() -1)).split(", ");
        long[] longsOfC = new long[((NumberList) c).sizeIncludingDuplicates()];

        for (int i = 0; i < elementsOfC.length; i++) {
            longsOfC[i] = Long.parseLong(elementsOfC[i]);
        }

        return longsOfC;
    }
 

    /** Returns true iff this number list contains at least one instance of each element 
        in the specified list. Multiple copies of some element in the argument do not
        require multiple copies in this number list. */
    // Complexity -> O(n^2)
    public boolean containsAll (java.util.Collection c) {
        long[] elementsOfC;
        boolean containsAllVals = false;

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList) || (this.count == 0 && ((NumberList) c).sizeIncludingDuplicates() != 0)) {
            return false;
        } else if ( ((NumberList) c).sizeIncludingDuplicates() == 0) {
            return true;
        } else {
            elementsOfC = convertNl(c);
            int contains = 0;

            //i goes over every element in c, and j goes over every element in this list
            for (int i = 0; i < elementsOfC.length; i++) {
                for (int j = 0; j < this.count; j++) {
                    if (this.numberList[j] == elementsOfC[i]) {
                        contains++;
                        break;
                    }
                }
            }

            if (contains == elementsOfC.length) {
                containsAllVals = true;
            } else {
                containsAllVals = false;
            }
            return containsAllVals;
        }
    }
 
 
    /** Compares the specified object with this collection for equality. */
    // Complexity -> O(n)
    public boolean equals(Object obj) {
        if (!(obj instanceof NumberList)) {
            return false;    
        } else {
            return this.toString().equals(obj.toString()) ? true : false;
        }
    }


    /** Returns the hashcode value for this collection. */
    //  Complexity ->  O(n)
    public int hashCode () {
        int hashCode = 1;
        
        for (Long l : this.numberList) {
            hashCode = 31 * hashCode + (l == null ? 0 : l.hashCode());    
        }
        return hashCode;
    }


    /** Returns true if this collection contains no elements. */
    // Complexity -> O(1)
    public boolean isEmpty () {
    	return (count == 0) ? true : false;
    }


    /** Returns an iterator over the elements in this collection. Replicated elements should
        be "iterated over" just once. */
    public java.util.Iterator iterator () {
        throw new UnsupportedOperationException();
    }


    /** Removes a single instance of the specified element from 
        this collection, if it is present. */
    // Complexity -> O(n^2)
    public boolean remove(Object obj) {
        Long[] tempNl = new Long[this.numberList.length];
        int indexOfRemovedValue = 0;
        if (!(obj instanceof Long)) {
            throw new ClassCastException();
        } else if (obj == null) {
            throw new NullPointerException();
        } else if (count == 0) {
            return false;
        } else {
            for (int i = 0; i < this.numberList.length; i++) {

                if (((Long) obj).equals(this.numberList[i])) {
                    indexOfRemovedValue = i;

                    //copying over all values before the removed value
                    for (int j = 0; j < i; j++) {
                        tempNl[j] = this.numberList[j];
                    }

                    // copying over all values after the removed value
                    for (indexOfRemovedValue = indexOfRemovedValue; indexOfRemovedValue < count - 1; indexOfRemovedValue++) {
                        tempNl[indexOfRemovedValue] = this.numberList[indexOfRemovedValue + 1];
                    }

                    count--;
                    this.numberList = tempNl;
                    
                    return true;
                }
            }
        }
        return false;
    }


    /** Removes all of this collection's elements that are also contained 
        in the specified collection. */
    // Complexity -> O(n^2)
    public boolean removeAll(java.util.Collection c) {
        long[] elementsOfC;

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList)) {
            return false;
        } else if ( ((NumberList) c).sizeIncludingDuplicates() == 0 || (this.count == 0)) {
            return true;
        } else {
            elementsOfC = convertNl(c);

            //i goes over every element in c, and j goes over every element in this list
            for (int i = 0; i < elementsOfC.length; i++) {
                for (int j = 0; j < this.count; j++) {
                    while (this.contains(new Long(elementsOfC[i]))) {
                        this.remove(elementsOfC[i]);
                    }
                }
            }
            return true;
        }
    }


    /** Retains only the elements in this collection that are contained in the specified collection. 
         In other words, removes from this collection all of its elements that are not contained in the 
         specified collection. */
    //  Complexity -> O (n)
	public boolean retainAll(java.util.Collection c){
        long[] elementsOfC;
        Long[] tempNl = new Long[this.count];
        int elementIndex = 0;

        if ((NumberList) c == null) {
            throw new NullPointerException();
        } else if (!(c instanceof NumberList)) {
            return false;
        } else if ( (this.count == 0)) {
            return true;
        } else {
            elementsOfC = convertNl(c);

            for (int i = 0; i < this.count; i++) {
                if (c.contains(new Long(this.numberList[i]))) {
                    tempNl[elementIndex] = this.numberList[i];
                    elementIndex++;
                }
            }

            this.numberList = tempNl;
            this.count = elementIndex;
            return true;
        }
    }


    /** Returns the number of elements in this number list, including duplicates. */
    // Complexity -> O (1)
    public int sizeIncludingDuplicates() {
    	return this.count;
    }
    
    
    /** Returns a Long[] containing all of the elements in this collection, not including duplicates. */
    // Complexity -> 0(n^2)
    public Long[] toArray() {
        long[] valuesOfCopy = this.convertNl(this);
        NumberList tempStorage = new NumberList();
        Long[] elementsWithNoRep;

        if (this.size() == 0) {
            return new Long[]{};
        } else {
            for (int i = 0; i < this.sizeIncludingDuplicates(); i++) {
                if (!tempStorage.contains(new Long(valuesOfCopy[i]))) {
                    tempStorage.add(new Long(valuesOfCopy[i]));
                }
            }
        }

        elementsWithNoRep = new Long[tempStorage.size()];
        long[] tempStorageElements = convertNl(tempStorage);

        for(int i = 0; i < elementsWithNoRep.length; i++) {
            elementsWithNoRep[i] = new Long(tempStorageElements[i]);
        }

        return elementsWithNoRep;
    }


    /** Not supported for this class. */
    public Object[] toArray (Object[] obj) {
        throw new UnsupportedOperationException();
    }


    /** Returns the number of elements in this number list, not including duplicates. */
    // Complexity -> O(n^2)
    public int size () {
        NumberList tempNl = new NumberList();

        int sizeNoRepeating = 0;
        for (int i = 0; i < count; i++) {
            boolean uniqueElement = true;

            for (int j = 0; j < count; j++) {

                if(numberList[i].equals(numberList[j]) && i != j) {
                    uniqueElement = false;                    
                    //check to see if the temp NumberList contains this value as it is a duplicate
                    if (!tempNl.contains(numberList[j])) {
                        tempNl.add(numberList[j]);
                    }
                }
            }
            if (uniqueElement == true) {
                sizeNoRepeating++;
            }
        }
        // add all of the missing repeated values;
        sizeNoRepeating += tempNl.sizeIncludingDuplicates();

        return sizeNoRepeating;
    }


    /** Returns the number of instances of the given element in this number list. */
    // Complexity -> O (n)
    public int count(Object obj) {
    	int tally = 0;
    	for (int i = 0; i < this.count; i++) {
    		if (this.numberList[i].equals((Long) obj)) {
    			tally++;
    		}
    	}
    	return tally;
    }
    

    /** This returns a stringy version of this number list. */
    //  Complexity -> O (n)
	@Override
	public String toString () {
        String stringifiedArray = "[";
        for (int i = 0; i < this.count; i++) {
        	if (i == this.count - 1) {
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
    // Complexity -> O (n)
    public static NumberList fromArray (long[] l) {
        NumberList tempNl = new NumberList();

        for(int i = 0; i < l.length; i++) {
            tempNl.add(new Long(l[i]));
        }
        return tempNl;
    }

    
    public static void main (String[] args) {
        // Please see NumberListTestHarness.java for tests

    	NumberListTestHarness.main(new String[]{"test away!"});

	}
    
}