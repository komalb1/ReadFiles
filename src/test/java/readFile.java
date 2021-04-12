import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Caret;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class readFile {
private static WebDriver driver;
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","Tests/Readfile/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://cartaxcheck.co.uk");
        Thread.sleep(5000);  // Let the user actually see something!

        List<String> result = new ArrayList<>();
        BufferedReader in = null;
        in = new BufferedReader(new FileReader("inputFile.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                WebElement enterReg = driver.findElement(By.xpath("//input[@id='vrm-input']"));
                enterReg.sendKeys(str);

                WebElement checkBtn = driver.findElement(By.xpath("//button[contains(text(),'Free Car Check')]"));
                checkBtn.click();
                Thread.sleep(5000);

            OutputStream outputStream = new FileOutputStream("src/test/resources/Properties/outPutFile.txt");

        String txtMake = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")).getText();
        String txtReg = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")).getText();
        String txtModel = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")).getText();
        String txtColor = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd")).getText();
        String txtYear = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")).getText();
        String header = "REGISTRATION,MAKE,MODEL,COLOR,YEAR";
        String content = txtReg+","+txtMake+","+txtModel+","+txtColor+","+txtYear;
        //outputStream.write("\r\n".getBytes())
        outputStream.write(header.getBytes());
        outputStream.write(content.getBytes());
        outputStream.close();

        System.out.println("REGISTRATION,MAKE,MODEL,COLOR,YEAR");
        System.out.println(txtReg+","+txtMake+","+txtModel+","+txtColor+","+txtYear);

            }
    }

}