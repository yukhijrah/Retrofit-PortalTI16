package syifa.app.portalti16.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import syifa.app.portalti16.entity.Mahasiswa;
import syifa.app.portalti16.holder.MahasiswaHolder;

/**
 * Created by USER on 26/11/2018.
 */

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaHolder> {

    private List<Mahasiswa> mahasiswas;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    @Override
    public MahasiswaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MahasiswaHolder holder, int position) {
        
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }
}
