import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling
{
    public static int intInput()
    {
        int n;
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            try
            {
                n = scan.nextInt();
            } catch (InputMismatchException e)
            {
                System.out.println("Invalid Input! Please try again...");
                continue;
            }
            break;
        }
        return n;
    }

    public static long longInput()
    {
        long n;
        while (true)
        {
            Scanner scan = new Scanner(System.in);
            try
            {
                n = scan.nextLong();
            } catch (InputMismatchException e)
            {
                System.out.println("Invalid Input! Please try again...");
                continue;
            }
            break;
        }
        return n;
    }
}
