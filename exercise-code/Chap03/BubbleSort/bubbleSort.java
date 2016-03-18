// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayBub(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void bubbleSort()
      {
      boolean forward = true;

      for(int outR=nElems-1,outL=0;outR>1||outL<nElems;outR--,outL++) // outer loop (bidirectional)
         if (forward) {
            for(int in=0; in<outR; in++)        // inner loop (forward)
               if( a[in] > a[in+1] )       // out of order?
                  swap(in, in+1);          // swap them
         } else {
            for (int in = outR; in > outL; in--)
               if(a[in] < a[in - 1])
                  swap(in - 1, in);
         }
      }  // end bubbleSort()
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class ArrayBub
////////////////////////////////////////////////////////////////
class BubbleSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayBub arr;                 // reference to array
      ArrayBub arr2;
      arr = new ArrayBub(maxSize);  // create the array
      arr2 = new ArrayBub(10000);

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      
      for (long i = 9999; i >= 0; i--)
         arr2.insert(i);

      arr.display();                // display items

      arr.bubbleSort();             // bubble sort them

      arr.display();                // display them again
      
      System.out.println();
      
      arr2.bubbleSort();
      }  // end main()
   }  // end class BubbleSortApp
////////////////////////////////////////////////////////////////