package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHelper {

    public static List<String> excelConverterText(String filePath) {
        List<String> rawData = new ArrayList<>();
        InputStream reader;
        XSSFWorkbook workbook = null;
        try {
            reader = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (workbook == null) {
            return null;
        }
        Sheet rows = workbook.getSheetAt(0);
        StringBuilder builder = new StringBuilder();
        Iterator<Row> rowIterator = rows.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            for (int i = 0; cellIterator.hasNext(); i++) {
                Cell cell = cellIterator.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        builder
                            .append(String.format("%-30s", cell.getStringCellValue()));

                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        builder
                            .append(String.format("%-14.2f    ", cell.getNumericCellValue()));

                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        builder
                            .append(String.format("%-14.2f    ", cell.getNumericCellValue()));

                        break;
                    case Cell.CELL_TYPE_BLANK:
                        break;
                }
            }
            if (!builder.toString().isEmpty()) {
                rawData.add(builder.toString().trim());
            }

            builder.setLength(0);
        }

        return rawData;
    }


}
