package org.test.epamtasks.part2task1234;

import java.util.ArrayList;
import java.util.List;

public class StationeryKit implements Sort {
   private List<Stationery> stationeries;

    StationeryKit() {
        stationeries = new ArrayList<>();
    }

    static StationeryKit newEmpKit() {
        StationeryKit newKit = new StationeryKit();
        Pen penBrd = new Pen("Pilot BPGP-10R-F", 500, "blue", true);
        Pen penBlue = new Pen("Pilot BPS-GP-EF-Bl", 64.20, "blue", false);
        Pen penBlack = new Pen("Pilot BPS-GP-EF-Blck", 65.08, "black", false);
        Pencil pencil1 = new Pencil("Kores HB", 16.30);
        Ruler ruler1 = new Ruler("Stamm 20", 18.70, 20);
        Stapler stapler1 = new Stapler("Stepler Secundo", 139, 10);

        newKit.stationeries.add(penBrd);
        newKit.stationeries.add(penBlue);
        newKit.stationeries.add(penBlack);
        newKit.stationeries.add(stapler1);
        newKit.stationeries.add(pencil1);
        newKit.stationeries.add(ruler1);

        return newKit;
    }

    List<Stationery> getStationeries() {
        return stationeries;
    }

    void addToKit(Stationery stationery) {
        stationeries.add(stationery);
    }

    @Override
    public void sortByName() {
        if (stationeries.size() >= 1) {
            stationeries.sort(Stationery::compareToByName);
        }
    }

    @Override
    public void sortByPrice() {
        if (stationeries.size() >= 1) {
            stationeries.sort(Stationery::compareToByPrice);
        }
    }

    @Override
    public void sortByPriceByName() {
        if (stationeries.size() >= 1) {
            stationeries.sort(Stationery::compareTo);
        }
    }
}
