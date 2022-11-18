package library;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "D:\\edgedriver\\msedgedriver.exe");
	     
	     WebDriver driver = new EdgeDriver();
	     driver.get("https://www.wise.edu.jo/");
		 driver.manage().window().maximize();
		 
		 Date currentDate =new Date();
		 String theActualDate = currentDate.toString().replace(":", "-");

	     TakesScreenshot src =((TakesScreenshot) driver);
	     File srcFile =src.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./mypics/"+theActualDate+".png");
	     FileUtils.copyFile(srcFile, dest);
	}

}
