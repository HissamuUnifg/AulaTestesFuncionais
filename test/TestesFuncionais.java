import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesFuncionais {   
    private WebDriver browser;
    
    @Before
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", 
                "deps/drivers/chromedriver_linux64/chromedriver");
        
        this.browser = new ChromeDriver();
    }
    
    @After
    public void afterEach(){
        this.browser.quit();
    }
   
    @Test
    public void loginComDadosValidos() {
        
        browser.navigate().to("http://ec2-54-89-211-20.compute-1.amazonaws.com/auth/login");
        
        browser.findElement(By.id("username")).sendKeys("Hissa");
        browser.findElement(By.id("password")).sendKeys("senha123");  
        browser.findElement(By.id("submit")).submit();
        
        Assert.assertEquals("Hi, Hissa!", browser.findElement(By.tagName("h1")).getText());        
    }
    
    @Test
    public void loginComDadosInvalidos() {        
        browser.navigate().to("http://ec2-54-89-211-20.compute-1.amazonaws.com/auth/login");
        
        browser.findElement(By.id("username")).sendKeys("Hissa");
        browser.findElement(By.id("password")).sendKeys("senha-qualquer");  
        browser.findElement(By.id("submit")).submit();
        
        Assert.assertTrue(browser.getCurrentUrl().
                equals("http://ec2-54-89-211-20.compute-1.amazonaws.com/auth/login"));
        Assert.assertEquals("Invalid username or password", browser.findElement(By.id("message")).getText());        
    }
}
