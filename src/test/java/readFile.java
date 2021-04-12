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
        List<String> result = new ArrayList<>();
        header();
        BufferedReader in = null;
          in = new BufferedReader(new FileReader("src/test/resources/Properties/inputFile"));
            String str;
            while ((str = in.readLine()) != null) {
                setDriver();
                WebElement enterReg = driver.findElement(By.xpath("//input[@id='vrm-input']"));
                enterReg.sendKeys(str);
                CheckRegValue(str);

                WebElement checkBtn = driver.findElement(By.xpath("//button[contains(text(),'Free Car Check')]"));
                checkBtn.click();
                Thread.sleep(5000);

                FileOutputStream outputStream = new FileOutputStream("src/test/resources/Properties/outPutFile.txt",true);

        String txtMake = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[2]/dd")).getText();
        String txtReg = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd")).getText();
        String txtModel = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[3]/dd")).getText();
        String txtColor = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[4]/dd")).getText();
        String txtYear = driver.findElement(By.xpath("//*[@id='m']/div[2]/div[5]/div[1]/div/span/div[2]/dl[5]/dd")).getText();

        String content = txtReg+","+txtMake+","+txtModel+","+txtColor+","+txtYear;
        outputStream.write("\n".getBytes());
        outputStream.write(content.getBytes());
        outputStream.close();

    System.out.println("REGISTRATION,MAKE,MODEL,COLOR,YEAR");
    System.out.println(txtReg + "," + txtMake + "," + txtModel + "," + txtColor + "," + txtYear);

                driver.close();
           }

      }
      private static  void header() throws FileNotFoundException,IOException{
          FileOutputStream outputStream = new FileOutputStream("src/test/resources/Properties/outPutFile.txt",true);

          String header = "REGISTRATION,MAKE,MODEL,COLOR,YEAR";
          outputStream.write(header.getBytes());

      }
      private static void setDriver()
      {

          System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

          driver.get("https://cartaxcheck.co.uk");
          System.out.println(driver.getTitle());

              }

    private static void CheckRegValue(String str) {
        if(str == "DN09HRM"){
            driver.findElement(By.xpath("//a[@href ='/free-car-check/mot-history/?vrm=DN09HRM']")).click();
            driver.findElement(By.xpath("//*[@id='m']/div[2]/div[2]/div/div/span/div/div/dl/a")).click();
            driver.findElement(By.xpath("//*[@id='btn-valuation']")).click();
            String carValue = driver.findElement(By.xpath("//*[@id='wbac-app-container']/div/div/valuation/section[2]/div/div[1]/div[1]/div[2]/div/div[1]/div/div")).getText();
            int amount = Integer.parseInt(carValue);
            if (amount == 3000){
                System.out.println("Test Fail Value more then £3000. Value is: " + amount);
            }


        }
    }

}
