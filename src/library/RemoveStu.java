package library;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class RemoveStu {

	public static void main(String[] args) throws IOException, InterruptedException {
 System.setProperty("webdriver.edge.driver", "D:\\edgedriver\\msedgedriver.exe");
	     
	     WebDriver driver = new EdgeDriver();
	     driver.get("file:///C:/Users/lenovo/Desktop/StudentsProject/Qa-automation-7thmar/index.html");
		 driver.manage().window().maximize();
		 
		 
		 List <WebElement> theStudents =driver.findElements(By.tagName("option"));
		 int theTotalNumberOfStudents = theStudents.size();
		 int howManyItemes = 5;
		 
		 for(int i =0; i<howManyItemes; i++) {
			 driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		 }
		 List <WebElement> theStudentsAfterRemove = driver.findElements(By.tagName("option"));
		 
		 int actualNumber =theStudentsAfterRemove.size();
		 
		 int expectedItems = theTotalNumberOfStudents - howManyItemes;
		 
			Assert.assertEquals(actualNumber, expectedItems);
			
		Thread.sleep(2000);
			Date currentDate =new Date();
			 String theActualDate = currentDate.toString().replace(":", "-");

		     TakesScreenshot src =((TakesScreenshot) driver);
		     File srcFile =src.getScreenshotAs(OutputType.FILE);
		     File dest = new File("./mypics/"+theActualDate+".png");
		     FileUtils.copyFile(srcFile, dest);

		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
