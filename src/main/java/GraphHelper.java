import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
     * A method that adds a normal, line style graph onto a provided Plot object of the mass consumed for a specified product type throughout all the years of the data set.
     * It also writes a simple percentage and minimum - maximum based analysis of changes that occurred with the consumption of the product
     * @param plt The Plot object onto which the graph is added.
     * @param arrayList The list with data to be graphed.
     * @param index The needed product type.
     * @param color The desired color of the graph.
     * @param style the type of line (-, .-, etc)
     * @param file The .txt file into which the analysis is written for the product type
     * @return Returns the provided Plot objects with the graph added
     */
    public static Plot graphProduct(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style, File file) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 1999; i < 2024; ++i) {
            x.add(i);
        }
        ArrayList<Double> y = new ArrayList<>();
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < 25; ++i) {
            y.add(Double.valueOf(arrayList.get(i).get(index).get(1)));
            if(Double.valueOf(arrayList.get(i).get(index).get(1)) > Double.valueOf(arrayList.get(maxIndex).get(index).get(1))){
                maxIndex = i;
            }
            if(Double.valueOf(arrayList.get(i).get(index).get(1)) < Double.valueOf(arrayList.get(minIndex).get(index).get(1))){
                minIndex = i;
            }
        }

        Scanner scanner = new Scanner(file);
        String tmp = "";
        while (scanner.hasNext()){
            tmp += scanner.nextLine() + "\n";
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\CSP\\data.txt");
        String point1 = "(maximum)";
        String point2 = "(minimum)";
        if(maxIndex > minIndex){
            int tmp2 = minIndex;
            minIndex = maxIndex;
            maxIndex = tmp2;
            String tmp3 = point1;
            point1 = point2;
            point2 = tmp3;
        }
        String analysis = arrayList.get(0).get(index).get(0) + "\n";
        if(maxIndex != 0 && maxIndex != 24){
            analysis += "The yearly consumption changed by " + Math.round((y.get(maxIndex) - y.get(0)) / y.get(0) * 100.0 * 100.0) / 100.0 + "% to reach the extreme point" +
                    point1 + " of " + Math.round(y.get(maxIndex) * 100.0) / 100.0 + " tonnes in " + (1999 + maxIndex);
            if(minIndex != 0 && minIndex != 24){
                analysis += ". Next it changed by " + Math.round((y.get(minIndex) - y.get(maxIndex)) / y.get(maxIndex) * 100.0 * 100.0) / 100.0 + "% to reach the next extreme point" +
                        point2 + " of " + Math.round(y.get(minIndex) * 100.0) / 100.0 + " tonnes in " + (minIndex + 1999);
                analysis += ". Finally, by 2023 it changed by " + Math.round((y.get(24) - y.get(minIndex)) / y.get(minIndex) * 100.0 * 100.0) / 100.0 + "% to reach " +
                        Math.round(y.get(24) * 100.0) / 100.0 + " tonnes.";
            }
            else{
                analysis += ". Finally, by 2023 it changed by " + Math.round((y.get(24) - y.get(maxIndex)) / y.get(maxIndex) * 100.0 * 100.0) / 100.0 + "% to reach " +
                        Math.round(y.get(24) * 100.0) / 100.0 + " tonnes.";
            }
        }
        else{
            if(minIndex != 0 && minIndex != 24){
                analysis += "The yearly consumption changed by " + Math.round((y.get(minIndex) - y.get(0)) / y.get(0) * 100.0 * 100.0) / 100.0 + "% to reach the extreme point" +
                        point2 + " of " + Math.round(y.get(minIndex) * 100.0) / 100.0 + " tonnes in " + (minIndex + 1999);
                analysis += ". Finally, by 2023 it changed by " + Math.round((y.get(24) - y.get(minIndex)) / y.get(minIndex) * 100.0 * 100.0) / 100.0 + "% to reach " +
                        Math.round(y.get(24) * 100.0) / 100.0 + " tonnes.";
            }
            else{
                analysis += "The yearly consumption changed by " + Math.round((y.get(24) - y.get(0)) / y.get(0) * 100.0 * 100.0) / 100.0 + "% to reach the extreme point" +
                        point2 + " of " + Math.round(y.get(minIndex) * 100.0) / 100.0 + " tonnes from 1999 to 2023";
            }
        }

        fileWriter.write(tmp + "\n" + analysis);
        fileWriter.close();
        scanner.close();

        plt.plot().color(color).add(x, y).label(arrayList.get(0).get(index).get(0)).linestyle(style);
        plt.xlabel("Year");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");

        return plt;
    }
}