import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TableHelper {
    public static Map<Integer, List<String>> getDataFromTable(String filename) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\CSP\\tables\\"+filename+".xlsx";
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(2);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            Cell cell = row.getCell(0);
            if(cell != null){
                if (cell.getCellType().equals(CellType.STRING)) {
                    if((cell.getRichStringCellValue().getString().contains("TOTAL") ||
                            cell.getRichStringCellValue().getString().equals("QUESO") ||
                            cell.getRichStringCellValue().getString().equals("YOGURT") ||
                            cell.getRichStringCellValue().getString().toLowerCase().contains("kgs")) &&
                            !cell.getRichStringCellValue().getString().contains("ALIMENTACION") &&
                            !cell.getRichStringCellValue().getString().contains("TOTAL HUEVOS"))
                    {
                        data.get(i).add(cell.getRichStringCellValue().getString());
                        boolean flag = false;
                        if(cell.getRichStringCellValue().getString().equals("QUESO")){
                            flag = true;
                        }
                        cell = row.getCell(1);
                        if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue() + "");
                        } else {
                            data.get(i).add(cell.getNumericCellValue() + "");
                        }
                        if(flag){
                            break;
                        }
                        ++i;
                    }
                }
            }
        }
        return data;
    }
    public static Map<Integer, List<String>> calculateTotal(ArrayList<Map<Integer, List<String>>> arrayList){
        Map<Integer, List<String>> data = new HashMap<>();
        for (int i = 0; i < 7; ++i) {
            data.put(i, new ArrayList<String>());
            double total = 0;
            for (int j = 0; j < 24; ++j) {
                total += Double.valueOf(arrayList.get(j).get(i).get(1));
            }
            data.get(i).add(arrayList.get(0).get(i).get(0));
            data.get(i).add(String.valueOf(total));
        }
        return data;
    }
}