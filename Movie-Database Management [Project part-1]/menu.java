import java.util.Scanner;
public class menu {
    public static void main (String [] args) throws Exception
    {

        MovieList.inputList();

        int menuOption,searchOption,productionSearch;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Main Menu:");
            System.out.println("1) Search Movies");
            System.out.println("2) Search Production Companies");
            System.out.println("3) Add Movie");
            System.out.println("4) Exit System");

            menuOption = ExceptionHandling.intInput();

            switch (menuOption) {
                case 1:
                    do {
                        System.out.println("Movie Searching Option:");
                        System.out.println("1) By Movie Title");
                        System.out.println("2) By Release Year");
                        System.out.println("3) By Genre");
                        System.out.println("4) By Production Company");
                        System.out.println("5) By Running Time");
                        System.out.println("6) Top 10 Movies");
                        System.out.println("7) Back To Main Menu");

                        searchOption = ExceptionHandling.intInput();

                        switch (searchOption) {
                            case 1:
                                System.out.println("Please enter a movie title");
                                Scanner sc1 = new Scanner(System.in);
                                String title =new String();
                                title = sc1.nextLine();
                                SearchMovies.byTitle(title);
                                break;
                            case 2:
                                System.out.println("Please enter a release year");
                                int year = scan.nextInt();
                                SearchMovies.byReleaseYear(year);
                                break;
                            case 3:
                                System.out.println("Please enter a movie genre");
                                Scanner sc2 = new Scanner(System.in);
                                String genre =new String();
                                genre = sc2.nextLine();
                                SearchMovies.byGenre(genre);
                                break;
                            case 4:
                                System.out.println("Please enter the name of a Production Company");
                                Scanner sc3 = new Scanner(System.in);
                                String productionCompany =new String();
                                productionCompany = sc3.nextLine();
                                SearchMovies.byProductionCompany(productionCompany);
                                break;
                            case 5:
                                System.out.println("Please enter the Running Time Range");
                                int t1 = scan.nextInt();
                                int t2 = scan.nextInt();
                                SearchMovies.byRunningTime(t1,t2);
                                break;
                            case 6:
                                SearchMovies.TopTenMovies();
                                break;
                            default:
                                if(searchOption!=7)
                                System.out.println("Invalid Input. Please try again...");


                        }
                    }
                    while (searchOption != 7);
                    break;


                case 2:
                    do {
                        System.out.println("Production Company Searching Option:");
                        System.out.println("1) Most Recent Movie");
                        System.out.println("2) Movies with Maximum Revenue");
                        System.out.println("3) Total Profit");
                        System.out.println("4) List of Production Companies and the Count of their Produced Movies");
                        System.out.println("5) Back To Main Menu");

                        productionSearch = ExceptionHandling.intInput();

                        switch (productionSearch) {
                            case 1:
                                System.out.println("Please enter the name of a Production Company");
                                Scanner sc1 = new Scanner(System.in);
                                String productionCompany1 =new String();

                                productionCompany1 = sc1.nextLine();
                                ProductionCompanySearching.MostRecent(productionCompany1);
                                break;
                            case 2:
                                System.out.println("Please enter the name of a Production Company");
                                Scanner sc2 = new Scanner(System.in);
                                String productionCompany2 =new String();
                                productionCompany2 = sc2.nextLine();
                                ProductionCompanySearching.MaxRevenue(productionCompany2);
                                break;
                            case 3:
                                System.out.println("Please enter the name of a Production Company");
                                Scanner sc3 = new Scanner(System.in);
                                String productionCompany3 =new String();
                                productionCompany3 = sc3.nextLine();
                                ProductionCompanySearching.TotalProfit(productionCompany3);
                                break;
                            case 4:
                                ProductionCompanySearching.ProductionCompany();
                                break;
                            default:
                                if(productionSearch!=5)
                                    System.out.println("Invalid Input. Please try again...");

                        }
                    }
                    while (productionSearch != 5);
                    break;

                case 3:
                    AddMovie.addMovie();
                    break;
                case 4:
                    ExitSystem.exitSystem();
                    break;
                default:
                    System.out.println("Invalid Input. Please try again...");

            }

        }
        while(menuOption!=4);
    }
}
