package syifa.app.portalti16.data;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import syifa.app.portalti16.entity.Mahasiswa;

/**
 * Created by USER on 07/01/2019.
 */

public class MahasiswaRepository {

    // untuk mengelola data kita di lokal

    private final static String DB_NAME = "datalokak";
    private MahasiswaDatabase mahasiswaDatabase;

    public MahasiswaRepository(Context context) {
        mahasiswaDatabase = Room.databaseBuilder(
                context,
                MahasiswaDatabase.class
                DB_NAME
        ).build();
    }

    public static void insertMahasiswa(final Mahasiswa mahasiswa) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Mahasiswa mahasiswa = new mahasiswa();
                mahasiswa.setName(name);
                mahasiswa.setNim(nim);
                mahasiswaDatabase.mahasiswaDao().iinsert(mahasiswa);
                return null;
            }
        }.execute();
    }
    public List<Mahasiswa>getMahasiwas() {
        return mahasiswaDatabase.mahasiswaDao().getMahasiswa();
    }

}
