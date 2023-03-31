package VIDEOCLUB;

import java.util.ArrayList;

public class Alquiler {

    private static int alquilerCount = 0;
    private int id;
    private ArrayList<Socio> arrayListSocio;
    private ArrayList<Multimedia> arrayListMultimedia;

    public Alquiler() {
        alquilerCount ++;
        arrayListSocio = new ArrayList<>();
        arrayListMultimedia = new ArrayList<>();
        id = alquilerCount;
    }

    @Override
    public String toString() {
        String text = "";

        for (int x = 0; x < arrayListSocio.size(); x++) {
            text += arrayListSocio.get(x).toString() + "\n";
        }

        for (int x = 0; x < arrayListMultimedia.size(); x++) {
            text += arrayListMultimedia.get(x).toString() + "\n";
        }

        return text;
    }

    public ArrayList<Socio> getArrayListSocio() {
        return arrayListSocio;
    }
    public void setArrayListSocio(ArrayList<Socio> arrayListSocio) {
        this.arrayListSocio = arrayListSocio;
    }
    public ArrayList<Multimedia> getArrayListMultimedia() {
        return arrayListMultimedia;
    }
    public void setArrayListMultimedia(ArrayList<Multimedia> arrayListMultimedia) {
        this.arrayListMultimedia = arrayListMultimedia;
    }
}
