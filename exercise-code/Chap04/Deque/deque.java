class Deque
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int numItems;
    
    public Deque(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        numItems = 0;
    }
    
    public void insertLeft(long n)
    {
        if (numItems == maxSize)
            throw new IllegalStateException("stack is full");
            
        if (front == 0)
            front = maxSize - 1;
        else
            front--;
            
        queArray[front] = n;
        numItems++;
    }
    
    public void insertRight(long n)
    {
        if (numItems == maxSize)
            throw new IllegalStateException("stack is full");
            
        if (rear == maxSize - 1)
            rear = 0;
        else
            rear++;
            
        queArray[rear] = n;
        numItems++;
    }
    
    public long removeLeft()
    {
        long temp = queArray[front];
        if (front == maxSize - 1)
            front = 0;
        else
            front++;
        numItems--;
        return temp;
    }
    
    public long removeRight()
    {
        long temp = queArray[rear];
        if (rear == 0)
            rear = maxSize - 1;
        else
            rear--;
        numItems--;
        return temp;
    }
    
    public boolean isEmpty()
    {
        return numItems == 0;
    }
    
    public boolean isFull()
    {
        return numItems == maxSize;
    }
    
    public void display()
    {
        for (int i = 0; i < numItems; i++)
        {
            int idx = ((front + i) > (maxSize - 1)) ? front + i - maxSize : front + i;
            System.out.print(queArray[idx] + " ");
        }
        System.out.println();
    }
}

class DequeApp
{
    public static void main(String[] args)
    {
        Deque arr = new Deque(10);
        
        arr.insertRight(10);
        arr.insertRight(20);
        arr.insertRight(30);
        arr.insertRight(40);
        arr.insertRight(50);
        
        arr.display();
        
        arr.removeLeft();
        arr.removeRight();
        
        arr.display();
        
        arr.insertLeft(60);
        arr.insertLeft(70);
        
        arr.display();
    }
}