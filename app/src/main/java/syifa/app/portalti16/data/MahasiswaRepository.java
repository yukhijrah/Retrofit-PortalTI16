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

    private final static String DB_NAME = "datalokal";
    private MahasiswaDatabase mahasiswaDatabase;

    public MahasiswaRepository(Context context) {
        mahasiswaDatabase = Room.databaseBuilder(
                context,
                MahasiswaDatabase.class,
                DB_NAME
        ).build();
    }

    public void insertMahasiswa(final String name, final String nim) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setName(name);
                mahasiswa.setNim(nim);
                mahasiswaDatabase.mahasiswaDao().insert(mahasiswa);
                return null;
            }
        }.execute();
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswaDatabase.mahasiswaDao().getMahasiswa();
    }
}
