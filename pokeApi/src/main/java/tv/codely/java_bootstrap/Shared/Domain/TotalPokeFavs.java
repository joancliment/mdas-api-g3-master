package tv.codely.java_bootstrap.Shared.Domain;

public class TotalPokeFavs {

    private int totalFavs;

    public TotalPokeFavs(int totalFavs) {
        this.totalFavs = totalFavs;
    }

    public int getTotalFavs() {
        return totalFavs;
    }

    public void increase(){
        totalFavs++;
        //return new TotalPokeFavs(value);
    }
}
