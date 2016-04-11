class MultApp
{
    public static void main(String[] args)
    {
        System.out.println(mult(4, 2)); // 8
        System.out.println(mult(4, 4)); // 16
        System.out.println(mult(8, 8)); // 64
        System.out.println(mult(7, 12)); // 84
        System.out.println(mult(25, 3)); // 75
        System.out.println(mult(17, 42)); // 714
    }
    
    private static int mult(int x, int y)
    {
        return multRec(x, x, y);
    }
    
    private static int multRec(int sum, int x, int y)
    {
        if (y == 1)
            return sum;
        else 
            return multRec(sum + x, x, y - 1);
    }
}