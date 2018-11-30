import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PDF_ReaderTest {
@Test
public void readPDFTest() throws IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	//directly from site URL
	driver.get("http://zums.ac.ir/files/research/site/ebooks/Robotics/AUTOMATION%20&%20CONTROL%20-%20Theory%20and%20Practice.pdf");
	//From specific file location
	//driver.get("file:///C:/Users/all/Desktop/employee-information-form-download-20170810.pdf");
	
	String currentUrl=driver.getCurrentUrl();
	System.out.println(currentUrl);
	
	//Creating the object of class
	URL url=new URL("http://zums.ac.ir/files/research/site/ebooks/Robotics/AUTOMATION%20&%20CONTROL%20-%20Theory%20and%20Practice.pdf"); 
	
	//Open stream method is used to open the pdf file
	InputStream is=url.openStream();
	
	//using the Buffered input class(creating the object file parse)
	BufferedInputStream fileParse=new BufferedInputStream(is);
	
	//PD document is coming from PDF box
	PDDocument document=null;
	
	//Initialize the document from load method(load buffered input class)
	document=PDDocument.load(fileParse);
	
	//creating object he he & returning the content
	String pdfContent=new PDFTextStripper().getText(document);
	
	//Printing the content on console
	System.out.println(pdfContent);
	//Assert.assertTrue(pdfContent.contains ("Company Name"));
	//Assert.assertTrue(pdfContent.contains ("Employee Information"));
	
}
}
