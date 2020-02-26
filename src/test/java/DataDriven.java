import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testcase) throws IOException {
		
		ArrayList<String> l = new ArrayList();
		FileInputStream fis = new FileInputStream("C:\\Users\\alahiri\\Desktop\\Book1.xlsx");
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		int sheet = xsf.getNumberOfSheets();
		for(int i=0 ; i<sheet;i++) {
			
			if(xsf.getSheetName(i).equalsIgnoreCase("test")) {
				
				XSSFSheet s = xsf.getSheetAt(i);
				Iterator<Row> itr = s.iterator();
				Row first = itr.next();
				Iterator<Cell> ce = first.cellIterator();
				int k = 0;
				int col = 0;
				while(ce.hasNext())
				{
					 Cell scell = ce.next();
					if(scell.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						col=k;
					}
					k++;
				}
			
				System.out.println(col);
				
				int r = 0;
				int row = 0 ;
				while(itr.hasNext())
				{
					Row rowval = itr.next();
					if(rowval.getCell(col).getStringCellValue().equalsIgnoreCase(testcase ))
					{
						Iterator<Cell> re = rowval.cellIterator();
						while(re.hasNext())
						{
							Cell u = re.next();
							if(u.getCellType()==CellType.STRING)
							{
							l.add((u.getStringCellValue()));
							}
							else
							{
							l.add(NumberToTextConverter.toText(u.getNumericCellValue()));
							}
						}
					}
					
				}
				
				
				
				
			}
		}
		return l;
		
	}

	
	public static void main(String...args) throws IOException
	{
		
}
	}
