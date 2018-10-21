import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends BaseTest {

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Anna");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Zaradna");

        List <WebElement> sex = driver.findElements(By.name("sex"));
        sex.get(1).click();


        Assert.assertTrue(sex.get(1).isSelected());

        Random generator = new Random();
        int i = generator.nextInt(6);

        List <WebElement> exp = By.name("exp").findElements(driver);
        exp.get(i).click();
        Assert.assertTrue(exp.get(i).isSelected());


        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("12.11.2018");


        i = generator.nextInt(1);

        List <WebElement> profession = driver.findElements(By.cssSelector("input[id*='profession']"));
        profession.get(i).click();

        WebElement uploadPhoto = driver.findElement(By.id("photo"));
        File photo=new File("src\\files2\\Przechwytywanie.jpg");
        String absolutePathToPoto=photo.getAbsolutePath();
        System.out.println("absolut path : "+absolutePathToPoto);
        uploadPhoto.sendKeys(absolutePathToPoto);

        WebElement linkText = driver.findElement(By.linkText("Selenium Automation Hybrid Framework"));
        linkText.click();

        WebElement countryList = driver.findElement(By.id("continents"));
        Select countrySelect = new Select((countryList));
        countrySelect.selectByVisibleText("Europe");

        WebElement seleniumComand = driver.findElement(By.id("selenium_commands"));
        Select comandSelect = new Select((seleniumComand));
        comandSelect.selectByVisibleText("Wait Commands");



        Thread.sleep(5000);

    }
}
