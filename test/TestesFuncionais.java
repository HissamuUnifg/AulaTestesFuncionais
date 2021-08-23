import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesFuncionais {    
   
    @Test
    public void hello() {
        System.setProperty("webdriver.chrome.driver", 
                "deps/drivers/chromedriver_linux64/chromedriver");
        
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://ec2-54-89-211-20.compute-1.amazonaws.com/index");
        
        browser.findElement(By.id("username")).sendKeys("Hissa");
        browser.findElement(By.id("password")).sendKeys("senha123");  
        browser.findElement(By.id("submit")).submit();
        
        Assert.assertEquals("Hi, Hissa!", browser.findElement(By.tagName("h1")).getText());
        browser.quit();
    }
}
