package org.test.epamtasks.part2task1234;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Registry {
    private Map<WorkPlace, StationeryKit> stationeryRegistry;

    Registry() {
        stationeryRegistry = new HashMap<>();
    }


    WorkPlace findWorkPlaceByID(String id) {
        for (WorkPlace wp : stationeryRegistry.keySet()) {
            if (wp.getId().equals(id)) {
                return wp;
            }
        }
        return null;
    }

    StationeryKit findKStationeryKitByID(String id) {
        for (WorkPlace wp : stationeryRegistry.keySet()) {
            if (wp.getId().equals(id)) {
                return stationeryRegistry.get(wp);
            }
        }
        return null;
    }

    List<WorkPlace> getWorkPlaceList() {
        return new ArrayList<>(stationeryRegistry.keySet());
    }

    void addStationeryToWorkPlaceByID(String id, Stationery stationery) {
        if (findWorkPlaceByID(id) != null) {
            stationeryRegistry.get(findWorkPlaceByID(id)).addToKit(stationery);
        }
    }

    private void addEmployee(WorkPlace workPlace) {
        stationeryRegistry.put(workPlace, new StationeryKit());
    }

    void addNewEmployee(WorkPlace workPlace) {
        stationeryRegistry.put(workPlace, StationeryKit.newEmpKit());
    }

    double SumPerEmployee(String id) {
        double sum = 0;
        for (Stationery s : stationeryRegistry.get(findWorkPlaceByID(id)).getStationeries()) {
            sum += s.price;
        }
        return sum;
    }

    void saveToFile() {
        StringBuilder stringForFile = new StringBuilder();
        for (WorkPlace wp : stationeryRegistry.keySet()) {
            stringForFile.append("\n" + Part2Task1234Main.regexWorkPlace + wp.getFullInfo());
            for (Stationery stationery : stationeryRegistry.get(wp).getStationeries()) {
                stringForFile.append(Part2Task1234Main.regexStationery + stationery.getFullInfo());
            }
        }

        try (FileWriter writer = new FileWriter(Part2Task1234Main.path, false)) {
            writer.write(stringForFile.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static Registry uploadRegistry() {
        Registry registry = new Registry();

        try (FileReader reader = new FileReader(Part2Task1234Main.path)) {
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.startsWith(Part2Task1234Main.regexWorkPlace)) {
                    String[] strings = line.split(Part2Task1234Main.regexStationery);
                    WorkPlace wp = WorkPlace.getFromString(strings[0].substring(Part2Task1234Main.regexWorkPlace.length()));
                    registry.addEmployee(wp);
                    for (int i = 1; i < strings.length; i++) {
                        Stationery st = Stationery.getStationeryFromString(strings[i]);
                        registry.addStationeryToWorkPlaceByID(wp.getId(), st);
                    }
                }
            }

        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        return registry;
    }
}