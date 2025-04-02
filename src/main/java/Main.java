import com.github.sh0nk.matplotlib4j.NumpyUtils;
import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import com.github.sh0nk.matplotlib4j.builder.HistBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main (String[] args) throws PythonExecutionException, IOException {
        ArrayList<Map<Integer, List<String>>> arrayList = new ArrayList<Map<Integer, List<String>>>();
        for(int i = 0; i <= 24; ++i){
            arrayList.add(TableHelper.getDataFromTable(String.valueOf(i+1999)));
        }
        //System.out.println(arrayList);
        String rez = "";
        int cnt = 1999;
        for(Map<Integer, List<String>> map: arrayList){
            rez += cnt + "\n";
            for(int i = 0; i < 7; ++i) {
                rez += map.get(i).get(0) + " " + map.get(i).get(1) + "\n";;
            }
            ++cnt;
        }
        System.out.println(rez);
        File dataFile = new File("C:\\Users\\user\\Desktop\\CSP\\data.txt");
        if(!dataFile.exists()){
            dataFile.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(dataFile);
        fileWriter.write(rez);
        fileWriter.close();


        List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Double> y = Arrays.asList(Double.valueOf(arrayList.get(0).get(0).get(1)),
            Double.valueOf(arrayList.get(0).get(1).get(1)),
            Double.valueOf(arrayList.get(0).get(2).get(1)),
            Double.valueOf(arrayList.get(0).get(3).get(1)),
            Double.valueOf(arrayList.get(0).get(4).get(1)),
            Double.valueOf(arrayList.get(0).get(5).get(1)),
            Double.valueOf(arrayList.get(0).get(6).get(1))
        );

        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt.plot().add(x, y).label("Protein sources").linestyle("-");
        plt.xlabel("Product type");
        plt.ylabel("Mass, tonnes");
        plt.title("Protein sources in tonnes, 1999");
        plt.legend();
        plt.show();
    }
}
