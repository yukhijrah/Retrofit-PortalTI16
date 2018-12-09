package syifa.app.portalti16.network;

import retrofit2.Call;
import retrofit2.http.GET;
import syifa.app.portalti16.entity.DaftarMahasiswa;
import syifa.app.portalti16.entity.Mahasiswa;

/**
 * Created by USER on 26/11/2018.
 */

public interface Routes {

    @GET("list.php")
    public void getMahasiswa;
    Call<DaftarMahasiswa> getMahasiswa();
}
