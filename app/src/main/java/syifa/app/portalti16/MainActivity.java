package syifa.app.portalti16;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import syifa.app.portalti16.adapter.MahasiswaAdapter;
import syifa.app.portalti16.entity.DaftarMahasiswa;
import syifa.app.portalti16.network.Network;
import syifa.app.portalti16.network.Routes;

/**
 * Created by USER on 26/11/2018.
 */

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);
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

            @Override
            public void onFailure(Call<DaftarMahasiswa> call, Throwable throwable) {

            }
        });
    }
}