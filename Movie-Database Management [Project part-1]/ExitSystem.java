import java.io.*;
public class ExitSystem {
    private static final String OUTPUT_FILE_NAME = "movies.txt";
    public static void exitSystem() throws Exception
    {

        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for(Movie m : MovieList.movieList )
        {
            String text = new String(m.getTitle()+","+m.getReleaseYear()+","+m.getGenre1()+","+m.getGenre2()+","+m.getGenre3()+","+m.getRunningTime()+","+m.getProductionCompany()+","+m.getBudget()+","+m.getRevenue());
            bw.write(text);
            bw.write(System.lineSeparator());
        }
        bw.close();
        System.exit(0);
    }
}
