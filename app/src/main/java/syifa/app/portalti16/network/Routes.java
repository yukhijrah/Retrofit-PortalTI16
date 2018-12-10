package syifa.app.portalti16.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import syifa.app.portalti16.entity.DaftarMahasiswa;
import syifa.app.portalti16.entity.Mahasiswa;

/**
 * Created by USER on 26/11/2018.
 */

public interface Routes {

    @GET("list.php")
//    public void getMahasiswa;
    Call<DaftarMahasiswa> getMahasiswa();

//    untuk melakukan post data mahasiswa baru, jika di deskripsikan, berarti:
//    https://ti16.herokuapp.com/add.php

    @POST("add.php")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
    );
}
