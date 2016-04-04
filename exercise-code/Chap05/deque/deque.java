class Link
{
    public long lData;
    public Link next;
    public Link previous;
    
    public Link(long n)
    {
        lData = n;
    }
    
    public void displayLink()
    {
        System.out.print(lData + " ");
    }
}

class Deque
{
    private Link first;
    private Link last;
    
    public Deque()
    {
        first = null;
        last = null;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public void insertFirst(long n)
    {
        Link newLink = new Link(n);
        
        if ( isEmpty() )
        {
            last = newLink;
        }
        else
        {
            first.previous = newLink;
        }
        
        newLink.next = first;
        first = newLink;
    }
    
    public void insertLast(long n)
    {
        Link newLink = new Link(n);
        
        if ( isEmpty() )
        {
            first = newLink;
        }
        else
        {
            last.next = newLink;
            newLink.previous = last;
        }
        
        last = newLink;
    }
    
    public long deleteFirst()
    {
        if ( isEmpty() )
            throw new IllegalStateException("queue is empty");
        
        Link temp = first;
        
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
            
        first = first.next;
        return temp.lData;
    }
    
    public long deleteLast()
    {
        if ( isEmpty() )
            throw new IllegalStateException("queue is empty");
        
        Link temp = last;
        
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
            
        last = last.previous;
        return temp.lData;
    }
}

class DequeApp
{
    public static void main(String[] args)
    {
        Deque dqe = new Deque();
        
        dqe.insertLast(10);
        dqe.insertLast(20);
        dqe.insertLast(30);
        dqe.insertLast(40);
        dqe.insertLast(50);
        
        System.out.println(dqe.deleteFirst());
        System.out.println(dqe.deleteLast());
        
        dqe.insertFirst(60);
        dqe.insertFirst(70);
        
        System.out.println(dqe.deleteFirst());
        System.out.println(dqe.deleteLast());
    }
}