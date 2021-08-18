import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("put your name:");
        String yourName=scanner.next();
        System.out.println("put your password:");
        String yourPassword=scanner.next();
        System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        WebElement elementPrsonal=driver.findElement(By.cssSelector("a[href=\"https://portal.aac.ac.il\"]"));
        elementPrsonal.click();
        WebElement userName= driver.findElement(By.id("Ecom_User_ID"));
        userName.sendKeys(yourName);
        WebElement password=driver.findElement(By.id("Ecom_Password"));
        password.sendKeys(yourPassword);
        WebElement enter =driver.findElement(By.id("wp-submit"));
        enter.click();
        WebElement moodle=driver.findElement(By.cssSelector("a[href=\"https://moodle.aac.ac.il/login/index.php\"]"));
        moodle.click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){

        }
        List<WebElement> coures=driver.findElements(By.cssSelector("a[class=\"aalink coursename\"]"));
        for (WebElement coure : coures) {
            System.out.println(coure.getText());

        }
        driver.manage().window().minimize();
        System.out.println("choose number of course:");
        int numcuorse= scanner.nextInt();
        driver.manage().window().maximize();
        coures.get(numcuorse).click();

        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){

        }



        WebElement exit=driver.findElement(By.id("action-menu-toggle-1"));
        exit.click();
        WebElement exit1=driver.findElement(By.cssSelector("a[data-title=\"logout,moodle\"]"));
        exit1.click();
        WebElement exit2=driver.findElement(By.cssSelector("a[href=\"https://portal.aac.ac.il/AGLogout\"]"));
        exit2.click();
    }
}
