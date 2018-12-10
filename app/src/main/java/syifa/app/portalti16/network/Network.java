package syifa.app.portalti16.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

/**
 * Created by USER on 26/11/2018.
 */

public class Network {

    public static Retrofit request(){
        // instance


        return new Retrofit.Builder()
                .baseUrl("https://ti16.herokuapp.com/") // diakses https://ti16.herokuapp.com/list.php
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
