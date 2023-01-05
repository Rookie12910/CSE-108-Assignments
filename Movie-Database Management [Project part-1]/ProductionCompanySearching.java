import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
public class ProductionCompanySearching {
    public static void MostRecent(String productionCompany) {
        int latestYear = 0;
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getProductionCompany().equalsIgnoreCase(productionCompany)) {
                if (m.getReleaseYear() > latestYear) {
                    index = i;
                    latestYear = m.getReleaseYear();
                }
            }
        }
        if (index == -1)
            System.out.println("No such Production Company with this name");
        else {
            for (int i = 0; i < MovieList.movieList.size(); i++) {
                Movie m = MovieList.movieList.get(i);
                if (m.getReleaseYear()==latestYear && m.getProductionCompany().equalsIgnoreCase(productionCompany))
                {
                    m.printDetails();
                }
            }
        }
    }

    public static void MaxRevenue(String productionCompany) {
        long maxRevenue = 0;
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getProductionCompany().equalsIgnoreCase(productionCompany)) {
                if (m.getRevenue() > maxRevenue) {
                    index = i;
                    maxRevenue = m.getRevenue();
                }
            }
        }
        if (index == -1)
            System.out.println("No such Production Company with this name");
        else{
            for (int i = 0; i < MovieList.movieList.size(); i++) {
                Movie m = MovieList.movieList.get(i);
                if (m.getRevenue()==maxRevenue && m.getProductionCompany().equalsIgnoreCase(productionCompany))
                {
                    m.printDetails();
                }
            }
        }

    }

    public static void TotalProfit(String productionCompany) {
        long totalProfit = 0;
        int index = -1;
        for (int i = 0; i < MovieList.movieList.size(); i++) {
            Movie m = MovieList.movieList.get(i);
            if (m.getProductionCompany().equalsIgnoreCase(productionCompany)) {
                index = i;
                totalProfit += m.getRevenue() - m.getBudget();
            }
        }
        if (index == -1)
            System.out.println("No such Production Company with this name");
        else
            System.out.println("Total Profit of " + productionCompany + " is: " + totalProfit);
    }

    public static void ProductionCompany()
    {
       Map <String,Integer> PCmap = new HashMap<>();
       for(Movie m : MovieList.movieList )
       {
           if(!PCmap.containsKey(m.getProductionCompany()))
               PCmap.put(m.getProductionCompany(),1);
           else
               PCmap.put(m.getProductionCompany(),PCmap.get(m.getProductionCompany())+1);
       }
        Iterator<Map.Entry<String,Integer>> I = PCmap.entrySet().iterator();

        while(I.hasNext())
        {
            Map.Entry<String, Integer> entry = I.next();
            System.out.println("Production Company: "+entry.getKey() + "------> Number of Movies Produced: " + entry.getValue()) ;
        }
    }

}
