package tv.codely.java_bootstrap;

import com.sun.deploy.net.HttpRequest;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HTTPProtocol {

    String rootUrl = "https://pokeapi.co/api/v2/pokemon/";
    String name = "Charmander";

    public List<PokeType> getPokemonBtName (String name) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://pokeapi.co/api/v2/pokemon/bulbasaur/")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        //final List<PokemonType> types = pokemon.getTypes();
        String jsondata = response.body().string();

        JSONObject Jobject = new JSONObject(jsondata);
        JSONArray Jarray = Jobject.getJSONArray("types");

        List <PokeType> pokeTypes = new ArrayList<>();

        for (int i = 0; i < Jarray.length(); i++){
            JSONObject object = Jarray.getJSONObject(i);
            name = object.getJSONObject("type").getString("name");
            pokeTypes.add( new PokeType(name));
        }

        return pokeTypes;

    }


}

