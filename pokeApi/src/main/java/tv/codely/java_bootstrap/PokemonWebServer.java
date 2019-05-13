package tv.codely.java_bootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PokemonWebServer extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(PokemonWebServer.class, args);
    }

}




