package tv.codely.java_bootstrap.Acceptance.CLI;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/CLIPokemonTypeSearch.feature",
        glue = {"tv.codely.java_bootstrap.Acceptance.CLI"}
)
 public class CLIPokemonTypeSearchTest {
}
