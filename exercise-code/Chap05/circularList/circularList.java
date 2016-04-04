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

class CircularList
{
    private Link current;
    
    public CircularList()
    {
        current = null;
    }
    
    public boolean isEmpty()
    {
        return current == null;
    }
    
    public void insert(long n)
    {
        Link newLink = new Link(n);
        
        if ( isEmpty() )
        {
            current = newLink;
        }
        else if ( current.next == null && current.previous == null )
        {
            newLink.previous = current;
            newLink.next = current;
            current.next = newLink;
            current.previous = newLink;
            current = current.next;
        }
        else
        {
            newLink.next = current.next;
            newLink.previous = current;
            current.next = newLink;
            current = current.next;
        }
    }
    
    public long delete()
    {
        if ( isEmpty() )
            throw new IllegalStateException("list is empty");
        
        Link temp = current;
        
        if ( current.next == null )
        {
            current = null;
            return temp.lData;
        }
        
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current = current.next;
        return temp.lData;
    }
    
    public boolean find(long key)
    {
        Link start = current;
        
        if ( current.lData == key )
            return true;
            
        while ( current != start )
        {
            current = current.next;
            if ( current.lData == key )
                return true;
        }
        
        return false;
    }
}

class CircularListApp
{
    public static void main(String[] args)
    {
        CircularList cList = new CircularList();
        
        cList.insert(10);
        cList.insert(20);
        cList.insert(30);
        cList.insert(40);
        cList.insert(50);
        cList.insert(60);
        
        System.out.println(cList.delete());
        System.out.println(cList.delete());
        
        System.out.println(cList.find(10));
        System.out.println(cList.find(20));
    }
}