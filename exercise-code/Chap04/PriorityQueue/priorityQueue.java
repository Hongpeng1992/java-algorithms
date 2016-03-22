class PriorityQueue
{
    private int maxSize;
    private long[] queArray;
    private int nItems;
    
    public PriorityQueue(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    
    public void insert(long n)
    {
        if (isFull())
            throw new IllegalStateException("queue is full");
        
        queArray[nItems++] = n;
    }
    
    public long remove()
    {
        if (isEmpty())
            throw new IllegalStateException("queue is empty");
            
        if (nItems == 1)
            return queArray[--nItems];
            
        insertionSort();
        return queArray[--nItems];
    }
    
    public long peekMin()
    {
        if (isEmpty())
            throw new IllegalStateException("queue is empty");
            
        if (nItems == 1)
            return queArray[nItems - 1];
            
        insertionSort();
        return queArray[nItems - 1];
    }
    
    public boolean isFull()
    {
        return nItems == maxSize;
    }
    
    public boolean isEmpty()
    {
        return nItems == 0;
    }
    
    private void insertionSort()
    {
        int in, out;
        
        for (out = 1; out < nItems; out++)
        {
            long temp = queArray[out];
            in = out;
            while (in > 0 && queArray[in - 1] <= temp)
            {
                queArray[in] = queArray[in - 1];
                --in;
            }
            queArray[in] = temp;
        }
    }
    
    public void display()
    {
        for (int i = 0; i < nItems; i++)
        {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }
}

class PriorityQueueApp
{
    public static void main(String[] args)
    {
        PriorityQueue pque = new PriorityQueue(10);
        
        pque.insert(60);
        pque.insert(50);
        pque.insert(10);
        pque.insert(20);
        pque.insert(30);
        pque.insert(90);
        
        pque.display();
        
        System.out.println("peekMin: " + pque.peekMin());
        pque.display();
        
        pque.remove();
        
        pque.insert(5);
        pque.insert(100);
        
        pque.display();
        
        System.out.println("peekMin: " + pque.peekMin());
        pque.display();
    }
}