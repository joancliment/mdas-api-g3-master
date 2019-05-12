package tv.codely.java_bootstrap;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHtmlReport"},
        features="src/test/resources/features/PokemonTypeSearch",
        glue = {"tv.codely.java_bootstrap.StepDefs"}
)
 public class SearchTest {
}
