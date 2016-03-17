// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public long get(int idx)
      { return a[idx]; }
   //-----------------------------------------------------------
   public int find(long searchKey, String operator)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;
      int closest = nElems;
      long minDistance;
      
      if (nElems == 0) 
         minDistance = 0;
      else
         minDistance = a[nElems - 1];
      
      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            {
            if (operator == "eq")
               return nElems;             // can't find it
            else if (operator == "gt")
               return closest;
            }
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
            {
               if (a[curIn] - searchKey < minDistance)
               {
                  minDistance = a[curIn] - searchKey;
                  closest = curIn;
               }
               upperBound = curIn - 1; // it's in lower half
            }
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int j;
      j = find(value, "gt");
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value, "eq");
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   public OrdArray merge(OrdArray other)
   {
      int thisLen = this.size();
      int otherLen = other.size();
      int thisMove = 0;
      int otherMove = 0;
      int size = (this.size() + other.size()) * 2;
      OrdArray b = new OrdArray(size);
      
      while (thisMove < thisLen || otherMove < otherLen)
      {
         if (thisMove < thisLen && otherMove < otherLen)
         {
            if (this.get(thisMove) < other.get(otherMove)) {
               b.insert(this.get(thisMove));
               thisMove++;
            } else {
               b.insert(other.get(otherMove));
               otherMove++;
            }
         } else if (thisMove < thisLen) {
            b.insert(this.get(thisMove));
            thisMove++;
         } else if (otherMove < otherLen) {
            b.insert(other.get(otherMove));
            otherMove++;
         }
      }
      
      return b;
   }
   //-----------------------------------------------------------
   }  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array
      OrdArray arr2 = new OrdArray(maxSize);

      arr.insert(77); // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey, "eq") != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again
      
      arr2.insert(5);
      arr2.insert(24);
      arr2.insert(53);
      arr2.insert(81);
      
      OrdArray arr3 = arr.merge(arr2);
      arr3.display();
      }  // end main()
   }  // end class OrderedApp
