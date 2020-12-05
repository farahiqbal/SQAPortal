package QAClick.SQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven {
	
	public ArrayList<String> getData(String testcasename) throws IOException 
	{
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream file= new FileInputStream("C://Users//TK-LPT-0050//Documents//data.xlsx");
      XSSFWorkbook workbook=new XSSFWorkbook(file);
      int sheets=workbook.getNumberOfSheets();
      for(int i=0; i<sheets;i++)
      {
    	  if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
    	  {
    		  XSSFSheet sheet=workbook.getSheetAt(i); 
    		  Iterator<Row> rows =sheet.iterator();
    		  Row firstrow= rows.next();
    		  Iterator<Cell> ce=firstrow.cellIterator();
    		  int k=0;
    		  int column=0;
    		  while(ce.hasNext())
    		  {
    			  Cell value=ce.next();
    			  if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
    			  {
    				  column=k;
    			  }
        		  k++;

    		  }
    		  System.out.println(column);
    		  
    		  while(rows.hasNext())
    		  {
    			  Row r=rows.next();
    			  if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename));
    			  Iterator<Cell> ca=r.cellIterator();
    			  while(ca.hasNext())
    			  {
    				a.add(ca.next().getStringCellValue());
    			  }
    			  
    		  }
    	  }

      }
	return a;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Fileinput stream argument 
		
	}
}
    	  

    	  
    	  
      
	


