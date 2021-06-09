package Adapter;

public class FishingBoatAdapter implements RowingBoat{

    private final FishingBoat fishingBoat;

    public FishingBoatAdapter() {
        this.fishingBoat = new FishingBoat();
    }

    @Override
    public void row() {
        fishingBoat.sail();
    }
}
