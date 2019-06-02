package tv.codely.java_bootstrap.Pokemon.Infrastructure.Get;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/GetPokemonTypeSearch.feature",
        glue = {"tv.codely.java_bootstrap.Pokemon.Infrastructure.Get"}
)
 public class GetPokemonTypeSearchTest {
}
