package syifa.app.portalti16;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import syifa.app.portalti16.R;
import syifa.app.portalti16.entity.Mahasiswa;
import syifa.app.portalti16.network.Network;
import syifa.app.portalti16.network.Routes;
import syifa.app.portalti16.utilitas.Consts;

/**
 * Created by USER on 09/12/2018.
 */

public class DetailMahasiswaActivity extends AppCompatActivity {

    private EditText edtName, edtNim;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);

        //casting untuk semua view
        edtName = (EditText) findViewById(R.id.edt_name);
        edtNim = (EditText) findViewById(R.id.edt_nim);
        btnAdd = (Button) findViewById(R.id.btn_add);

        String action = getIntent().getStringExtra(Consts.KEY_ACTION_DETAIL);
        switch (action) {
            case Consts.INTENT_ADD:
                btnAdd.setText("TAMBAH MAHASISWA");
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString();
                        String nim = edtNim.getText().toString();
                        if (!name.isEmpty() && !nim.isEmpty()) {
                        addNewMahasiswa(name, nim);
                    } else {
                            Toast.makeText(DetailMahasiswaActivity.this, "maaf, nama dan nim tidak boleh kosong", Toast.LENGTH_SHORT).show();
                        }
                });
                break;

            case Consts.INTENT_EDIT:
                Mahasiswa mahasiswa = (Mahasiswa) getIntent().getSerializableExtra("mahasiswa");
                edtName.setText(mahasiswa.getName());
                edtNim.setText(mahasiswa.getNim());

                btnAdd.setText("UPDATE DATA");
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            mahasiswa.setName(edtName.getText().toString());
                            mahasiswa.setNim(edtNim.getText().toString());
                            updateMahasiswa(mahasiswa);
                        }
                    }
                });
            break;
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewMahasiswa();
                String name = edtName.getText().toString();
                String nim = edtNim.getText().toString();
                addNewMahasiswa(name, nim);
            }
        });

    }

    @Override
    public void onFailure(Call<Mahasiswa> call, Throwable t) {
        Toast.makeText(DetailMahasiswaActivity.this, "Maaf, terjadi kesalahan", Toast.LENGTH_LONG).show();
        onErrorAddMahasiswa();
    }

    private void onErrorAddMahasiswa() {
        Toast.makeText(DetailMahasiswaActivity.this,
                "Maaf, terjadi kesalahan",
                Toast.LENGTH_LONG).show();
    }

//    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        lstMahasiswa.setLayoutManager(linearLayoutManager);
//
//    requestDaftarMahasiswa();
//    //requestDaftarMahasiswa();


    private void updateMahasiswa(Mahasiswa mahasiswa) {
        Routes services = Network.request().create(Routes.class);

        String mahasiswaId = String.valueOf(mahasiswa.getId());
        String name = mahasiswa.getName();
        String nim = mahasiswa.getNim();

        services.updateMahasiswa(mahasiswaId, name, nim).enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(DetailMahasiswaActivity.this, "update berhasil!", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    onErrorAddMahasiswa();
                }
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {

            }
        });
    }

    private void addNewMahasiswa(String name, String nim) {
        Routes services = Network.request().create(Routes.class);
        //lalu, kita lakukan post terhadap data mahasiswa baru dari API /add.php
        services.postMahasiswa(name, nim).enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                if (response.isSuccessful()) {
                    //ketika post nya berhasil, maka akan kembali ke mainActivity
                    finish(); //ini akan destroy si activity DetailMahasiswaActivity()
                    finish(); //ini akan destroy si DetailMahasiswaActivity()
                } else {
                    Toast.makeText(DetailMahasiswaActivity.this, "Maaf, terjadi kesalahan", Toast.LENGTH_LONG).show();
                    onErrorAddMahasiswa();
                }
            }
        });
    }
}

    private void addNewMahasiswa() {
    }