package OTS.Opencart.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import OTS.Opencart.Utilities.ReadConfig;

public class BaseTests {
	public ReadConfig readconfig = new ReadConfig();
	public String firstname = readconfig.getFirstName();
	public String Lastname = readconfig.getLastName();
	public String emaildom = readconfig.getEmail();
	public String number = readconfig.getNumber();
	public String pswrd = readconfig.getPassword();
	public String psswrd = readconfig.confirmPassword();
	public String baseURL = readconfig.getURL();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		logger = Logger.getLogger("Opencart");
		PropertyConfigurator.configure("log4j.properties");
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="TestData")
	public Object[][] getTestData() throws IOException
	{
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\OTS\\Opencart\\TestData\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getPhysicalNumberOfCells();
		Object data[][] = new Object[rowCount-1][columnCount];
		for(int i=0; i<rowCount-1; i++)
		{
			row = sheet.getRow(i+1);
			for(int j=0; j<columnCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
	return data;	
				
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir")+"//Test Reports//"+ testCaseName + ".png";
		File file = new File(filepath);
		FileUtils.copyFile(source, file);
		return filepath;
		
		
		
	}

}
