package views.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.vo.PetVO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class PetsReportExcel {
    
    private HSSFWorkbook book;
    private HSSFSheet sheet;
    private HSSFRow row;
    private HSSFCell cell;
    private final String sheet_name = "PetsOwnerReport";
    private CellStyle style;
    private HSSFFont font;
    private String[] headers;

    public PetsReportExcel() {
       setup();
    }
    
    private void setup() {
        book = new HSSFWorkbook();
        sheet = book.createSheet();
        book.setSheetName(0, sheet_name);
        //Styles        
        HSSFPalette palette = book.getCustomPalette();
        HSSFColor colorBg = palette.findSimilarColor(68, 114, 196);
        HSSFColor colorFont = palette.findSimilarColor(255, 255, 255);
        style = book.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(colorBg.getIndex());        
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font = book.createFont();
        font.setFontName("Calibri");
        font.setBold(true);
        font.setFontHeightInPoints((short)13);
        font.setColor(colorFont.getIndex());
        style.setFont(font);
    }
    
    public void createHeaders() {
        headers = new String[] {
            "ID", "Name", "Lastname", "Address", "Phone", "Email",
            "Code", "Name", "Age", "Weight", "Specie"
        };
        row = sheet.createRow(0);
        row.setHeightInPoints(25);
        for(int i=0;i<headers.length;i++) {
            sheet.setColumnWidth(i, 15*256);
            cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
    }
    
    public void setValues(LinkedList<PetVO> list) {
        for(int i=0;i<list.size();i++) {
            row = sheet.createRow(i+1);
            row.setHeightInPoints(25);
            //sheet.setColumnWidth(i, 15*256);
            
            //INFORMACION DEL CLIENTE
            //ID
            cell = row.createCell(0);
            cell.setCellValue(list.get(i).getCustomer().getId());
            //Name
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getCustomer().getName());
            //Lastname
            cell = row.createCell(2);
            cell.setCellValue(list.get(i).getCustomer().getLastname());
            //Address
            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getCustomer().getAddress());
            //Phone
            cell = row.createCell(4);
            cell.setCellValue(list.get(i).getCustomer().getPhone());
            //Email
            cell = row.createCell(5);
            cell.setCellValue(list.get(i).getCustomer().getEmail());
            
            //INFORMACION MASCOTA
            //Code
            cell = row.createCell(6);
            cell.setCellValue(list.get(i).getCode());
            //Name
            cell = row.createCell(7);
            cell.setCellValue(list.get(i).getName());
            //Age
            cell = row.createCell(8);
            cell.setCellValue(list.get(i).getAge());
            //Weight
            cell = row.createCell(9);
            cell.setCellValue(list.get(i).getWeight());
            //Specie
            cell = row.createCell(10);
            cell.setCellValue(list.get(i).getSpecie());
        } 
    }
    
    public boolean writeFile(String url) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime date = LocalDateTime.now();
                
        try (FileOutputStream file = new FileOutputStream("reports/" + url.concat("_"+dtf.format(date)) + ".xls")) {
            book.write(file);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException ex) {
            Logger.getLogger(PetsReportExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}