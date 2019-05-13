package tv.codely.java_bootstrap.Shared.Infrastructure.Get;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tv.codely.java_bootstrap.Shared.Infrastructure.PokemonWebServer;

import java.util.concurrent.TimeUnit;

public class GetStepDefs {
    Process proc;
    private static WebDriver driver;
    @Before
    public static void beforeClass(){
        System.setProperty ("webdriver.chrome.driver","bin\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
        driver.manage().window().maximize() ;

        PokemonWebServer.main(new String[]{});
    }

    @Given("^i'm in Browser$")
    public void i_m_in_or_Browser() throws Throwable {
        String URL = "localhost:8080/types?name=charizard";
        driver.get(URL);
        driver.getTitle();
        driver.getCurrentUrl();
        driver.getPageSource();
    }

    @When("^i enter pokemon name <pokemonName>$")
    public void i_enter_pokemon_name() throws Throwable {
    }

    @Then("^return the pokemon types$")
    public void ireturnTypes() {

    }
}


