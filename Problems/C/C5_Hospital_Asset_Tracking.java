package C;

import java.util.*;

class Asset {
    String name;
    int urgency;

    Asset(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "Asset(\"" + name + "\", " + urgency + ")";
    }
}

public class C5_Hospital_Asset_Tracking {

    public static void sortAssets(List<Asset> assets) {

        if (assets == null || assets.isEmpty()) {
            throw new IllegalArgumentException("Assets cannot be null or empty");
        }

        assets.sort((a, b) -> {

            if (a.urgency != b.urgency) {
                return Integer.compare(b.urgency, a.urgency);
            }

            return a.name.compareTo(b.name);
        });
    }

    public static void main(String[] args) {

        List<Asset> assets = new ArrayList<>();

        assets.add(new Asset("Ventilator", 5));
        assets.add(new Asset("BedFrame", 2));
        assets.add(new Asset("Pump", 5));

        sortAssets(assets);

        System.out.println(assets);
    }
}