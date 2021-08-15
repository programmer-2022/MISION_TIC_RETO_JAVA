package views.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFontFormatting;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;


public class PetsReportExcel {

    public PetsReportExcel() {
        //Crear libro
        HSSFWorkbook book = new HSSFWorkbook();
        //crear hoja(s)
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "Vehículos");
        HSSFRow row = sheet.createRow(0);
            
        //crear celdas en las filas
        HSSFCell cell = row.createCell(0);
        
        //Estilos
        CellStyle style = book.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        HSSFFont font = book.createFont();
        font.setBold(true);
        //font.setFontName("Calibri");
        style.setFont(font);
                
        //Establecer valores a las celdas        
        for(int i=0;i<10;i++) {
            
            //crear filas en las hojas
            //HSSFRow row = sheet.createRow(0);
            
            cell.setCellValue("Hoja");
            cell.setCellStyle(style);
            cell = row.createCell(1);
        }
                
        //Escribir en el archivo
        try (FileOutputStream file = new FileOutputStream("reports/archivo.xls")) {
            book.write(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException ex) {
            Logger.getLogger(PetsReportExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}