public class SearchMovies {
    public static void byTitle(String title) {
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getTitle().equalsIgnoreCase(title)) {
                index = i;
            }
        }
        if(index==-1)
            System.out.println("No such movie with this name");
        else
            MovieList.movieList.get(index).printDetails();
    }

    public static void byReleaseYear(int year) {
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getReleaseYear()==year) {
                index = i;
                MovieList.movieList.get(index).printDetails();
            }

        }
        if(index==-1)
            System.out.println("No such movie with this release year");
    }

    public static void byGenre(String genre) {
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getGenre1().equalsIgnoreCase(genre) || m.getGenre2().equalsIgnoreCase(genre) ||m.getGenre3().equalsIgnoreCase(genre)) {
                index = i;
                MovieList.movieList.get(index).printDetails();
            }
        }
        if(index==-1)
            System.out.println("No such movie with this genre");
    }

    public static void byProductionCompany(String productionCompany) {
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getProductionCompany().equalsIgnoreCase(productionCompany)) {
                index = i;
                MovieList.movieList.get(index).printDetails();
            }
        }
        if(index==-1)
            System.out.println("No such movie with this name");
    }

    public static void byRunningTime(int t1, int t2) {
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getRunningTime()>=t1 && m.getRunningTime()<=t2) {
                index = i;
                MovieList.movieList.get(index).printDetails();
            }
        }
        if(index==-1)
            System.out.println("No such movie with this running time range");
    }

    public static void TopTenMovies()
    {
        Movie []movies  = new Movie[MovieList.movieList.size()];
        for(int i =0;i<MovieList.movieList.size();i++)
        {
            movies[i] = MovieList.movieList.get(i);
        }

        for(int i=0; i< movies.length;i++)
        {
            for(int j =i +1; j< movies.length;j++)
                if((movies[i].getRevenue()-movies[i].getBudget())<(movies[j].getRevenue()-movies[j].getBudget()))
                {
                    Movie tempM;
                    tempM = movies[i];
                    movies[i] = movies[j];
                    movies[j] = tempM;
                }
        }
        for(int i=0;i<10;i++)
        {
            movies[i].printDetails();
        }

    }
}
