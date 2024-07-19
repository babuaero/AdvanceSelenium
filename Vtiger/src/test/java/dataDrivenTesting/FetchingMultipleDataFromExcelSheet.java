package dataDrivenTesting;

	import java.io.FileInputStream;

	import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	public class FetchingMultipleDataFromExcelSheet {

			public static void main(String[] args) throws Throwable {
				
				//step1: path connection
						FileInputStream fis = new FileInputStream("/Users/babu/Documents/TestData1.xlsx"); 
						
						//step2: keep excel file in read mode
						Workbook book = WorkbookFactory.create(fis);
						
						//step3: get control of the sheet
						Sheet sheet = book.getSheet("Sheet1");
						
						int rowNum =sheet.getLastRowNum();
						System.out.println(rowNum);
						
						for (int i=0; i < rowNum; i++)
						{
							Row row = sheet.getRow(i);
							for (int j=0; j < row.getLastCellNum(); j++)
							{
							Cell cell = row.getCell(j);
						//	String link = cell.getStringCellValue();  using normal method
						//	System.out.println(link);
							
							DataFormatter format = new DataFormatter();  // using data formatter method
						    String link = format.formatCellValue(cell);
						    System.out.println(link);
						    }
						}
			}
			
		}

	



