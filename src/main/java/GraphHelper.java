import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GraphHelper {
    public static void graphColumns(ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for(int i = 5; i < 80; i += 5){
            x.add(i);
            if(i % 2 != 0 && i != 5 && i != 75){
                x.add(i);
            }
        }
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
        }
        System.out.println(x.size() + "\n" + y.size());
        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y).label("Protein sources " + (1999+index)).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        plt.legend();
        plt.show();
    }
    /*public static void graph(ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Double> y1 = Arrays.asList(
                Double.valueOf(arrayList.get(index).get(0).get(1)),
                Double.valueOf(arrayList.get(index).get(1).get(1)),
                Double.valueOf(arrayList.get(index).get(2).get(1)),
                Double.valueOf(arrayList.get(index).get(3).get(1)),
                Double.valueOf(arrayList.get(index).get(4).get(1)),
                Double.valueOf(arrayList.get(index).get(5).get(1)),
                Double.valueOf(arrayList.get(index).get(6).get(1))
        );

        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y1).label("Protein sources " + (1999+index)).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        plt.legend();
        plt.show();
    }
    public static Plot graph(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Double> y1 = Arrays.asList(
                Double.valueOf(arrayList.get(index).get(0).get(1)),
                Double.valueOf(arrayList.get(index).get(1).get(1)),
                Double.valueOf(arrayList.get(index).get(2).get(1)),
                Double.valueOf(arrayList.get(index).get(3).get(1)),
                Double.valueOf(arrayList.get(index).get(4).get(1)),
                Double.valueOf(arrayList.get(index).get(5).get(1)),
                Double.valueOf(arrayList.get(index).get(6).get(1))
        );

        //Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y1).label("Protein sources " + (1999+index)).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        //plt.legend();
        //plt.show();
        return plt;
    }
    public static Plot graphColumns(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        List<Double> x = Arrays.asList(0.5, 1.0, 1.5, 1.5, 2.0, 2.5, 2.5, 3.0, 3.5, 3.5, 4.0, 4.5, 4.5, 5.0, 5.5, 5.5, 6.0, 6.5, 6.5, 7.0, 7.5);
        List<Double> y1 = Arrays.asList(
                Double.valueOf(arrayList.get(index).get(0).get(1)),
                Double.valueOf(arrayList.get(index).get(0).get(1)),
                Double.valueOf(arrayList.get(index).get(0).get(1)),
                Double.valueOf(arrayList.get(index).get(1).get(1)),
                Double.valueOf(arrayList.get(index).get(1).get(1)),
                Double.valueOf(arrayList.get(index).get(1).get(1)),
                Double.valueOf(arrayList.get(index).get(2).get(1)),
                Double.valueOf(arrayList.get(index).get(2).get(1)),
                Double.valueOf(arrayList.get(index).get(2).get(1)),
                Double.valueOf(arrayList.get(index).get(3).get(1)),
                Double.valueOf(arrayList.get(index).get(3).get(1)),
                Double.valueOf(arrayList.get(index).get(3).get(1)),
                Double.valueOf(arrayList.get(index).get(4).get(1)),
                Double.valueOf(arrayList.get(index).get(4).get(1)),
                Double.valueOf(arrayList.get(index).get(4).get(1)),
                Double.valueOf(arrayList.get(index).get(5).get(1)),
                Double.valueOf(arrayList.get(index).get(5).get(1)),
                Double.valueOf(arrayList.get(index).get(5).get(1)),
                Double.valueOf(arrayList.get(index).get(6).get(1)),
                Double.valueOf(arrayList.get(index).get(6).get(1)),
                Double.valueOf(arrayList.get(index).get(6).get(1))

        );

        //Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y1).label("Protein sources " + (1999+index)).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        //plt.legend();
        //plt.show();
        return plt;
    }*/
}
