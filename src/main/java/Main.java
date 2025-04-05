import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

        arrayList.add(TableHelper.calculateTotal(arrayList));
        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
        plt = GraphHelper.graphColumns(plt, arrayList, 25, "000000", "-", "Total of each by type");
        plt.savefig("C:/Users/user/Desktop/CSP/graphs/total.png").dpi(200);
        plt.executeSilently();
        for (int i = 0; i < 7; ++i) {
            Plot plt2 = Plot.create(PythonConfig.pythonBinPathConfig("C:\\Users\\user\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"));
            GraphHelper.graphProduct(plt2, arrayList, i, "000000", "-");
            plt2.savefig("C:/Users/user/Desktop/CSP/graphs/" + arrayList.get(0).get(i).get(0) + ".png").dpi(200);
            plt2.executeSilently();
        }
    }
}
