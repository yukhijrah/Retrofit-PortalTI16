package syifa.app.portalti16.data;

import retrofit2.http.DELETE;
import retrofit2.http.Query;
import syifa.app.portalti16.entity.Mahasiswa;

/**
 * Created by USER on 07/01/2019.
 */

public interface MahasiswaDao {

    @Insert
    void insert(Mahasiswa mahasiswa);

    @Query("SELECT *FROM mahasiswa")
    List<Mahasiswa> getMahasiswa();

    @Update
    void update(Mahasiswa mahasiswa);

    @DELETE
    void delete(Mahasiswa mahasiswa);
}
