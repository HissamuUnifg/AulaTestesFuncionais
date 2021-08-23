
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", 
                "deps/drivers/chromedriver_linux64/chromedriver");
        this.browser = new ChromeDriver();
    }

    void fecharNavegador() {
        this.browser.quit();
    }

    void acessarLogin() {
        this.browser.navigate().to("http://ec2-54-89-211-20.compute-1.amazonaws.com/auth/login");
    }

    void preencherLoginEnviar(String usuario, String senha) {
        this.browser.findElement(By.id("username")).sendKeys(usuario);
        this.browser.findElement(By.id("password")).sendKeys(senha);  
        this.browser.findElement(By.id("submit")).submit();
    }

    String getCurrentUrl() {
        return this.browser.getCurrentUrl();
    }

    String getMensagemBoasVindas() {
        return this.browser.findElement(By.tagName("h1")).getText();
    }

    String getMensagemAlerta() {
        return this.browser.findElement(By.id("message")).getText();
    }

    void acessarPaginaPrivada() {
        browser.navigate().to("http://ec2-54-89-211-20.compute-1.amazonaws.com/user/Hissa");
    }
    
    
}
