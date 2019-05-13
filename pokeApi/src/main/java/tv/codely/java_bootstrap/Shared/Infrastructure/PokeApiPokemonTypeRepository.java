package tv.codely.java_bootstrap.Shared.Infrastructure;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.codely.java_bootstrap.Shared.Domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PokeApiPokemonTypeRepository implements PokemonTypeRepository {

    String rootUrl = "http://pokeapi.co/api/v2/pokemon/";

    @Override
    public PokeTypeList search(PokeName pokeName) throws PokeTypeException, IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(rootUrl + pokeName.getPokeName() +"/")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        String jsondata = response.body().string();

        if(response.code() == 404){
            throw new PokeTypeException();
        }
        else {

            JSONObject Jobject = new JSONObject(jsondata);
            JSONArray Jarray = Jobject.getJSONArray("types");

            List<PokeType> pokeTypes = new ArrayList<>();

            for (int i = 0; i < Jarray.length(); i++) {
                String name;
                JSONObject object = Jarray.getJSONObject(i);
                name = object.getJSONObject("type").getString("name");
                pokeTypes.add(new PokeType(name));
            }
            return new PokeTypeList(pokeTypes);
        }
    }

    @Override
    public void save(PokeName pokeName, PokeTypeList types) {

    }

}

