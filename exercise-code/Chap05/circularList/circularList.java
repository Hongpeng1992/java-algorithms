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
    
    public void next()
    {
        if ( !isEmpty() && current.next != null)
        {
            current = current.next;
        }
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
            current.next.previous = current;
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
        
        if ( current.next.next == current )
        {
            current = current.next;
            current.previous = null;
            current.next = null;
            return temp.lData;
        }
        
        current.previous.next = temp.next;
        current.next.previous = temp.previous;
        current = current.next;

        return temp.lData;
    }
    
    public boolean find(long key)
    {
        Link start = current;
        
        if ( current.lData == key )
            return true;
            
        current = current.next;
            
        while ( current != start )
        {
            if ( current.lData == key )
                return true;
            current = current.next;
        }
        
        return false;
    }
    
    public long currentValue()
    {
        return current.lData;
    }
    
    public String printObject()
    {
        String temp = "{ previous: ";
        if (current.previous != null)
            temp += current.previous.lData;
        else
            temp += "null";
        temp = temp + ", current: " + current.lData + ", next: ";
        if (current.next != null)
            temp += current.next.lData;
        else
            temp += "null";
        temp += " }";
        return temp;
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
        
        System.out.println(cList.delete());
    }
}

class JosephusProblem
{
    public static void main(String[] args)
    {
        CircularList people = new CircularList();
        
        int numPeople = Integer.parseInt(args[0]);
        int everyN = Integer.parseInt(args[1]);
        int start = Integer.parseInt(args[2]);
        int remaining = numPeople;
        int counter = 0;
        
        for (int i = 1; i <= numPeople; i++)
        {
            people.insert(i);
        }
        
        people.find(start);
        
        while ( remaining > 1 )
        {
            for (int j = everyN; j > 0; j--)
            {
                people.next();
            }
            people.delete();
            --remaining;
        }
        
        System.out.println("Joseph should choose " + people.currentValue());
    }
}