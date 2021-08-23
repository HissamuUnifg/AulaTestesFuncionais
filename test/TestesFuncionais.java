import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesFuncionais {    
   
    @Test
    public void hello() {
        System.setProperty("webdriver.chrome.driver", 
                "deps/drivers/chromedriver_linux64/chromedriver");
        
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://www.google.com");
        
    }
}
