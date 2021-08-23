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
    
    private LoginPage loginPage;
    
    @Before
    public void beforeEach(){
        this.loginPage = new LoginPage();
    }
    
    @After
    public void afterEach(){
        this.loginPage.fecharNavegador();
    }
   
    @Test
    public void loginComDadosValidos() {
        this.loginPage.acessarLogin();        
        this.loginPage.preencherLoginEnviar("Hissa", "senha123");
        
        Assert.assertTrue(this.loginPage.getCurrentUrl().
                equals("http://ec2-54-89-211-20.compute-1.amazonaws.com/index"));
        
        Assert.assertEquals("Hi, Hissa!", this.loginPage.getMensagemBoasVindas());        
    }
    
    @Test
    public void loginComDadosInvalidos() {        
        this.loginPage.acessarLogin();        
        this.loginPage.preencherLoginEnviar("Hissa", "senha321");
        
        Assert.assertTrue(this.loginPage.getCurrentUrl().
                equals("http://ec2-54-89-211-20.compute-1.amazonaws.com/auth/login"));
        
        Assert.assertEquals("Invalid username or password", this.loginPage.getMensagemAlerta());
    }
    
    @Test
    public void navegarParaPaginaRestritaSemLogin() {        
        this.loginPage.acessarPaginaPrivada();   
                       
        Assert.assertTrue(this.loginPage.getCurrentUrl().
                equals("http://ec2-54-89-211-20.compute-1.amazonaws.com/auth/login?next=%2Fuser%2FHissa"));
          
    }
}
