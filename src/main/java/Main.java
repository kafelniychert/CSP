import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
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
    }
}
