import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Movie {
    private String title, genre1, genre2, genre3, productionCompany;
    private int releaseYear, runningTime;
    private long budget, revenue;


    public Movie(String title, int releaseYear, String genre1, String genre2, String genre3, int runningTime, String productionCompany, long budget, long revenue) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.runningTime = runningTime;
        this.productionCompany = productionCompany;
        this.budget = budget;
        this.revenue = revenue;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public long getBudget() {
        return budget;
    }

    public long getRevenue() {
        return revenue;
    }
   public void printDetails()
    {
        System.out.println("Title: "+this.getTitle());
        System.out.println("Release Year: "+this.getReleaseYear());
        System.out.println("Genre: "+this.getGenre1()+", "+this.getGenre2()+", "+this.getGenre3());
        System.out.println("Running Time: "+this.getRunningTime()+" minutes");
        System.out.println("Production Company: "+this.getProductionCompany());
        System.out.println("Budget: "+this.getBudget());
        System.out.println("Revenue: "+this.getRevenue());
        System.out.println(" ");
    }
}



    public class MovieList {

        private static final String INPUT_FILE = "movies.txt";
        public static List<Movie> movieList = new ArrayList();
        public static void inputList() throws Exception {

            BufferedReader record = new BufferedReader(new FileReader(INPUT_FILE));

            while (true) {
                String line = record.readLine();
                if (line == null) break;
                String[] details = line.split(",");
                Movie m = new Movie(details[0], Integer.parseInt(details[1]), details[2], details[3], details[4], Integer.parseInt(details[5]), details[6], Long.parseLong(details[7]), Long.parseLong(details[8]));
                movieList.add(m);

            }
            record.close();


        }
    }
