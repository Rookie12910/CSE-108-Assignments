import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AddMovie {
    public static void addMovie()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the Movie title :");
        String title = scan.nextLine();
        System.out.println("Please enter the Release year :");
        int releaseYear = ExceptionHandling.intInput();
        System.out.println("Please enter the genres :");
        Scanner sc1 = new Scanner(System.in);
        String genre1 = sc1.nextLine();
        String genre2 = sc1.nextLine();
        String genre3 = sc1.nextLine();
        System.out.println("Please enter the running time :");
        int runTime = ExceptionHandling.intInput();
        System.out.println("Please enter the Production Company:");
        Scanner sc2 = new Scanner(System.in);
        String productionCompany = sc2.nextLine();
        System.out.println("Please enter the Budget :");
        long budget =  ExceptionHandling.longInput();
        System.out.println("Please enter the Revenue :");
        long revenue = ExceptionHandling.longInput();


        boolean flag =true;
        for(int i =0;i<MovieList.movieList.size();i++)
        {
            if(title.equalsIgnoreCase(MovieList.movieList.get(i).getTitle()))
            {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            Movie M = new Movie(title, releaseYear, genre1, genre2, genre3, runTime, productionCompany, budget, revenue);
            MovieList.movieList.add(M);
        }
        else
            System.out.println("Sorry! This movie is already enlisted");

    }
}
