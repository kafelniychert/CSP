import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphHelper {
    /**
     * A method that adds a column style graph onto a provided Plot object
     * @param plt The Plot object onto which the column graph is added
     * @param arrayList The list with data to be graphed
     * @param index The needed year
     * @param color The desired color of the graph
     * @param style the type of line (-, .-, etc)
     * @param caption The caption of the graph
     * @return Returns the provided Plot objects with the graph added
     */
    public static Plot graphColumns(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style, String caption) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 5; i < 80; i += 5) {
            x.add(i);
            if (i % 2 != 0 && i != 5 && i != 75) {
                x.add(i);
            }
            if (i % 2 != 0) {
                x.add(i);
            }
        }
        ArrayList<Double> y = new ArrayList<>();
        y.add(0.0);
        for (int i = 0; i < 7; ++i) {
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
            y.add(0.0);
        } //The library used for plotting does not provide column style graphs by default, had to create them using the normal line graph

        plt.plot().color(color).add(x, y).label(caption).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        double max = 1000000;
        for (int i = 0; i < y.size(); ++i) {
            while(y.get(i) > max){
                max += 500000;
            }
        }
        plt.ylim(0, max);
        return plt;
    }

    /**
     * A method that adds a normal, line style graph onto a provided Plot object of the mass consumed for a specified product type throughout all the years of the data set
     * @param plt The Plot object onto which the graph is added.
     * @param arrayList The list with data to be graphed.
     * @param index The needed product type.
     * @param color The desired color of the graph.
     * @param style the type of line (-, .-, etc)
     * @return Returns the provided Plot objects with the graph added
     */
    public static Plot graphProduct(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 1999; i < 2024; ++i) {
            x.add(i);
        }
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < 25; ++i) {
            y.add(Double.valueOf(arrayList.get(i).get(index).get(1)));
        }

        plt.plot().color(color).add(x, y).label(arrayList.get(0).get(index).get(0)).linestyle(style);
        plt.xlabel("Year");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");

        return plt;
    }
}