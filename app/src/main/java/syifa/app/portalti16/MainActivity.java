package syifa.app.portalti16;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import syifa.app.portalti16.adapter.MahasiswaAdapter;
import syifa.app.portalti16.entity.DaftarMahasiswa;
import syifa.app.portalti16.entity.Mahasiswa;
import syifa.app.portalti16.network.Network;
import syifa.app.portalti16.network.Routes;

/**
 * Created by USER on 26/11/2018.
 */

public class MainActivity extends AppCompatActivity {

    //deklarasikan recyclerviewnya
    private RecyclerView lstMahasiswa;


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);

        //casting recyclerviewnya dari id lst_mahasiswa yang ada di activity_main
        lstMahasiswa = (RecyclerView) findViewById(R.id.lst_mahasiswa);

        //set layout manager untuk lstMahasiswa
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstMahasiswa.setLayoutManager(linearLayoutManager);

        requestDaftarMahasiswa();

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMahasiswaActivity.class));
            }
        });
    }

    private DaftarMahasiswa mahasiswas;
    // tampilkan daftar mahasiswa di recyclerview
    MahasiswaAdapter adapter = new MahasiswaAdapter(mahasiswas.getData());

    lstMahasiswa.setAdapter(adapter);

    @Override
    protected void onStart() {
        super.onStart();
        requestDaftarMahasiswa();
    }

    private void requestDaftarMahasiswa(){
        // pertama memanggil request() dari retrofit yang sudah ada
        Routes service = Network.request().create(Routes.class);

        // melakukan request terhadap getMahasiswa()
        service.getMahasiswa().enqueue(new Callback<DaftarMahasiswa>() {

            @Override
            public void onResponse(Call<DaftarMahasiswa> call, Response<DaftarMahasiswa> response) {
                // mengecek request yang dilakukan, berhasil atau tidak
                if (response.isSuccessful()) {
                    // casting data yang didapatkan, menjadi DaftarMahasiswa
                    DaftarMahasiswa mahasiswas = response.body();

                    //get title
                    Log.d("SyifaTazfa", mahasiswas.getTitle());

                    //tampilkan daftar mahasiswa di recyclerview
                    MahasiswaAdapter adapter = new MahasiswaAdapter(mahasiswas.getData());

                    // panggil file adapter


                }
            }

            private void onMahasiswaError() {
                Toast.makeText(
                        MainActivity.this,
                        "Gagal. Silahkan periksa koneksi internet anda.",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DaftarMahasiswa> call, Throwable t) {

                //ketika data tidak berhasil di load
                onMahasiswaError();
            }
        });
    }
}