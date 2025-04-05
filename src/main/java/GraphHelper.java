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
        }
        System.out.println(x.size() + "\n" + y.size());
        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y).label("Protein sources " + (1999 + index)).linestyle(style);
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
        plt.legend();
        plt.show();
    }

    public static void graphColumns(ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style, String caption) throws PythonExecutionException, IOException {
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
        }
        System.out.println(x.size() + "\n" + y.size());
        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
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
        plt.legend();
        plt.show();
    }

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
        }
        //System.out.println(x.size() + "\n" + y.size());

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

    public static Plot graphColumns(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
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
        }
        //System.out.println(x.size() + "\n" + y.size());
        plt.plot().color(color).add(x, y).label("Protein sources " + (1999 + index)).linestyle(style);
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

    public static void graph(ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 1; i < 8; i += 1) {
            x.add(i);
        }
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
        }

        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y).label("Protein sources " + (1999 + index)).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        plt.legend();
        plt.show();
    }

    public static Plot graph(Plot plt, ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 1; i < 8; i += 1) {
            x.add(i);
        }
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < 7; ++i) {
            y.add(Double.valueOf(arrayList.get(index).get(i).get(1)));
        }
        plt.plot().color(color).add(x, y).label("Protein sources " + (1999 + index)).linestyle(style);
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        return plt;
    }

    public static void graphProduct(ArrayList<Map<Integer, List<String>>> arrayList, int index, String color, String style) throws PythonExecutionException, IOException {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 1999; i < 2024; ++i) {
            x.add(i);
        }
        ArrayList<Double> y = new ArrayList<>();
        for (int i = 0; i < 25; ++i) {
            y.add(Double.valueOf(arrayList.get(i).get(index).get(1)));
        }

        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().color(color).add(x, y).label(arrayList.get(0).get(index).get(0)).linestyle(style);
        plt.xlabel("Year");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes by type");
        plt.legend();
        plt.show();
    }

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