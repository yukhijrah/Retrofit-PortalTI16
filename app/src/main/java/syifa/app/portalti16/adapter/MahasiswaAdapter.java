package syifa.app.portalti16.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import syifa.app.portalti16.DetailMahasiswaActivity;
import syifa.app.portalti16.R;
import syifa.app.portalti16.entity.Mahasiswa;
import syifa.app.portalti16.holder.MahasiswaHolder;
import syifa.app.portalti16.utilitas.Consts;

/**
 * Created by USER on 26/11/2018.
 */

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaHolder> {

    private List<Mahasiswa> mahasiswas;
    private MahasiswaListener listener;
//    private List<Mahasiswa> mahasiswas = new ArrayList<>();

    public MahasiswaAdapter(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public void setListener(MahasiswaListener listener) {
        this.listener = listener;
    }

    @Override
    public MahasiswaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent,false);
        MahasiswaHolder holder = new MahasiswaHolder(view);

        @Override
        public void onClick(view v) {
            // definisikan position untuk getMahasiswaa
            int adapterPosition = holder.getAdapterPosition();
            Mahasiswa mahasiswa = mahasiswas.get(adapterPosition);

            Intent detailIntent = new Intent(context, DetailMahasiswaActivity.class);
            detailIntent.putExtra("mahasiswa", mahasiswa);
            detailIntent.putExtra(Consts.KEY_ACTION_DETAIL, Consts.INTENT_EDIT);
            context.startActivity(detailIntent);
        }

        return holder;
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }
    public interface MahasiswaListener {
        void onDelete(int mhsId);
        void onFavorite(Mahasiswa mahasiswa);
    }

    @Override
    public void onBindViewHolder(final MahasiswaHolder holder, final int position) {

        holder.txtname.setText(mahasiswas.get(position).getName());
        holder.txtnim.setText(mahasiswas.get(position).getNim());

        //tambahkan fungsi delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDelete(mahasiswas.get(position).getId());
            }
        });

        // tambahkan fungsi Favorite
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFavorite(mahasiswas.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }
}
