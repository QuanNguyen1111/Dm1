package vidu.demo.dethithu1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vidu.demo.dethithu1.Fragment.DanhSachFragment;
import vidu.demo.dethithu1.Fragment.KetQuaFragment;
import vidu.demo.dethithu1.MainActivity;
import vidu.demo.dethithu1.R;
import vidu.demo.dethithu1.Sever.Api;
import vidu.demo.dethithu1.model.ThongTin;

public class Adapter_Product extends RecyclerView.Adapter<Adapter_Product.ViewHodelProduct>{

    private Context context;
    private List<ThongTin.Product> list;
    private DanhSachFragment danhSachFragment;

    public Adapter_Product(Context context, List<ThongTin.Product> list, DanhSachFragment danhSachFragment) {
        this.context = context;
        this.list = list;
        this.danhSachFragment = danhSachFragment;
    }

    @NonNull
    @Override
    public ViewHodelProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.item_recy_view_product,null);
        return new ViewHodelProduct (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelProduct holder, int position) {
        ThongTin.Product product = list.get (position);
        holder.txt_id.setText (product.getPid ());
        holder.click_item.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (context, "Click thành công", Toast.LENGTH_SHORT).show ();
                danhSachFragment.GetListID (product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    class ViewHodelProduct extends RecyclerView.ViewHolder {
        TextView txt_id ;
        ConstraintLayout click_item;
        public ViewHodelProduct(@NonNull View itemView) {
            super (itemView);
            txt_id = itemView.findViewById (R.id.txt_id);
            click_item = itemView.findViewById (R.id.contrain_thong_tin);
        }
    }
}
