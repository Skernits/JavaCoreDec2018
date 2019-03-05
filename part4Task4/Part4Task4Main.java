package org.epamtasks.part4.part4Task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Part4Task4Main {
    public static final String PATH= "filmcollection.srl";

    public static void main(String[] args) {

        List<FilmActor> filmList = new ArrayList<>();
        filmList.add(new FilmActor("film1", "actor1"));
        filmList.add(new FilmActor("film2", "actor1"));
        filmList.add(new FilmActor("film3", "actor2"));
        filmList.add(new FilmActor("film4", "actor2"));
        filmList.add(new FilmActor("film5", "actor3"));

        for (FilmActor film : filmList) {
            System.out.println(film.getInfo());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH)){
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(filmList);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try (FileInputStream fileInputStream = new FileInputStream(PATH)){
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() > 0) {
                List<FilmActor> filmActorList = (List) ois.readObject();
            for (FilmActor film : filmActorList) {
                System.out.println(film.getInfo());
            }
            }
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
