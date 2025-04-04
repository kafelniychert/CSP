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
        //GraphHelper.graphColumns(arrayList, 24, "000000", "-", "Total of each by type");
        GraphHelper.graphProduct(arrayList, 2, "000000", "-.");
        //System.out.println(arrayList);
    }
}
