class MyStack
{
    private int maxSize;
    private long[] stackArray;
    private int top;
    
    public MyStack(int s)
    {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    
    public void push(long n)
    {
        if (isFull())
            throw new IllegalStateException("stack is full");
        
        stackArray[++top] = n;
    }
    
    public long pop()
    {
        if (isEmpty())
            throw new IllegalStateException("stack is empty");
            
        return stackArray[top--];
    }
    
    public long peek()
    {
        if (isEmpty())
            throw new IllegalStateException("stack is empty");
            
        return stackArray[top];
    }
    
    public boolean isFull()
    {
        return top == maxSize - 1;
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
}

class MyStackApp
{
    public static void main(String[] args)
    {
        MyStack theStack = new MyStack(10);
        
        theStack.push(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(50);
        theStack.push(60);
        theStack.push(70);
        
        while (!theStack.isEmpty())
        {
            System.out.println(theStack.pop());
        }
    }
}