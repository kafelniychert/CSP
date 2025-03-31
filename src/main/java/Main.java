import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main (String[] args) throws IOException {
        String fileLocation = "C:\\Users\\user\\Desktop\\CSP\\tables\\2023-datos-anuales-panel-consumo-hogares_tcm30-686036.xlsx";
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(2);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                if(cell.getColumnIndex() > 1){
                    break;
                }
                switch (cell.getCellType()) {
                    case STRING: data.get(new Integer(i)).add(cell.getRichStringCellValue().getString()); break;
                    case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
                        data.get(i).add(cell.getDateCellValue() + "");
                    } else {
                        data.get(i).add(cell.getNumericCellValue() + "");
                    } break;
                    case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + ""); break;
                    case FORMULA: data.get(i).add(cell.getCellFormula() + ""); break;
                    default: data.get(new Integer(i)).add(" ");
                }

            }
            i++;
        }
        data.remove(0);
        data.remove(1);
        data.remove(2);
        data.remove(3);
        data.remove(5);
        data.remove(6);
        for(int j = 0; j < data.size()+234+115+58+58+2+2; ++j){
            if(j > 228){
                data.remove(j);
            }
        }
        System.out.println(data);
        System.out.println(data.size());
    }
}
