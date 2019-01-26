package syifa.app.portalti16.data;

import syifa.app.portalti16.entity.Mahasiswa;

/**
 * Created by USER on 07/01/2019.
 */

@Database(entities = {Mahasiswa.class}, version = 1, exportSchema = false)
public abstract class MahasiswaDatabase extends RoomDatabase {
    public abstract MahasiswaDao mahasiswaDao();

}
