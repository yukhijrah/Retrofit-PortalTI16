package syifa.app.portalti16.entity;

/**
 * Created by USER on 26/11/2018.
 */

public class Mahasiswa {

    private int id;
    private String name;
    private String nim;

    public Mahasiswa(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public String getNim()   {
        return nim;
    }

    public int getId() {
        return id;
    }
}
