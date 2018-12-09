package syifa.app.portalti16.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import syifa.app.portalti16.R;

/**
 * Created by USER on 26/11/2018.
 */

public class MahasiswaHolder extends RecyclerView.ViewHolder {

    public TextView txtname;
    public TextView txtnim;



    public MahasiswaHolder(View itemView) {
        super(itemView);
        txtname = (TextView) itemView.findViewById(R.id.txt_name);
        txtnim = (TextView) itemView.findViewById(R.id.txt_nim);
    }
}
