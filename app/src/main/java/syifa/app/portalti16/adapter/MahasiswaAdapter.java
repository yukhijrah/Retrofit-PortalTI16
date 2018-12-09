package syifa.app.portalti16.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import syifa.app.portalti16.R;
import syifa.app.portalti16.entity.Mahasiswa;
import syifa.app.portalti16.holder.MahasiswaHolder;

/**
 * Created by USER on 26/11/2018.
 */

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaHolder> {

//    private List<Mahasiswa> mahasiswas;
    private List<Mahasiswa> mahasiswas = new ArrayList<>();

    public MahasiswaAdapter(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    @Override
    public MahasiswaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent,false);
        MahasiswaHolder holder = new MahasiswaHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MahasiswaHolder holder, int position) {

        holder.txtname.setText(mahasiswas.get(position).getName());
        holder.txtnim.setText(mahasiswas.get(position).getNim());

    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }
}
