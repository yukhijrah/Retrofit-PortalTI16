package syifa.app.portalti16;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import syifa.app.portalti16.R;
import syifa.app.portalti16.adapter.MahasiswaAdapter;
import syifa.app.portalti16.data.MahasiswaRepository;
import syifa.app.portalti16.entity.Mahasiswa;

/**
 * Created by USER on 07/01/2019.
 */

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView lstFavorite;

    private MahasiswaAdapter adapter;
    private MahasiswaRepository mhsRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.activity_favorite);

        lstFavorite = (RecyclerView) findViewById(R.id.lst_favorite);
        lstFavorite.setLayoutManager(new LinearLayoutManager(this));

        mhsRepository = new MahasiswaRepository(this);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                List<Mahasiswa> Mahasiswas = mhsRepository.getMahasiwas();
                if (mahasiswa.size() > 0) {
                    adapter = new MahasiswaAdapter(mahasiswas);
                    lstFavorite.setAdapter(adapter);
                } else {
                    Toast.makeText(FavoriteActivity.this, "Tidak ada item favorite.", Toast.LENGTH_LONG).show();
                }
                return null;
            }
        }
    }
}
