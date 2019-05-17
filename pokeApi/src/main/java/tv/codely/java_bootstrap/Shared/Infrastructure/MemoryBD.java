package tv.codely.java_bootstrap.Shared.Infrastructure;

import tv.codely.java_bootstrap.Shared.Domain.PokeFavsRepository;

public class MemoryBD {

    private static MemoryBD instance;
    public PokeFavsRepository pokeFavsRepository;

    private MemoryBD(PokeFavsRepository pokeFavsRepository){
        this.pokeFavsRepository = pokeFavsRepository;
    }

    public static MemoryBD getInstance(PokeFavsRepository pokeFavsRepository){
        if(instance == null){
            instance = new MemoryBD(pokeFavsRepository);
        }
        return instance;
    }
}