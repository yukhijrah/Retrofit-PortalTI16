package syifa.app.portalti16.network;

import retrofit2.Call;
import retrofit2.http.GET;
import syifa.app.portalti16.entity.DaftarMahasiswa;

/**
 * Created by USER on 26/11/2018.
 */

public interface Routes {

    @GET("list.php")
//    Call<DaftarMahasiswa> getMahasiswa();
    void getMahasiswa();
}
