package vidu.demo.dethithu1.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vidu.demo.dethithu1.Adapter.Adapter_Product;
import vidu.demo.dethithu1.KetQuaActivity;
import vidu.demo.dethithu1.MainActivity;
import vidu.demo.dethithu1.R;
import vidu.demo.dethithu1.Sever.Api;
import vidu.demo.dethithu1.model.ThongTin;


public class DanhSachFragment extends Fragment {

    RecyclerView mRecyclerView;
    Adapter_Product adapter_product ;
    public DanhSachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_danh_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        mRecyclerView =  view.findViewById (R.id.recy_ds_sp);
        mRecyclerView.setHasFixedSize (true);
        mRecyclerView.setLayoutManager (new LinearLayoutManager (getActivity (),LinearLayoutManager.VERTICAL,false));
        GetListAPI ();

    }
    public void GetListAPI(){
        Gson gson = new GsonBuilder ()
                .setLenient ()
                .create ();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Api api = retrofit.create (Api.class);

        Call<ThongTin> call = api.GetList ();
        call.enqueue (new Callback<ThongTin> () {
            @Override
            public void onResponse(Call<ThongTin> call, Response<ThongTin> response) {
                ArrayList<ThongTin.Product> arrayList1 = (ArrayList<ThongTin.Product>) response.body ().getProducts ();

                for (ThongTin.Product tt : arrayList1){
//                    ThongTin.Product product = new ThongTin.Product (tt.getPid (),tt.getName (),tt.getPrice (),tt.getCreatedAt (),tt.getUpdatedAt ());
                    adapter_product = new Adapter_Product (getActivity (),arrayList1,DanhSachFragment.this);
                    mRecyclerView.setAdapter (adapter_product);
                    adapter_product.notifyDataSetChanged ();
                }
            }

            @Override
            public void onFailure(Call<ThongTin> call, Throwable t) {

            }
        });
    }
    public void GetListID(ThongTin.Product product){
        Gson gson = new GsonBuilder ()
                .setLenient ()
                .create ();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Api api = retrofit.create (Api.class);

        Call<ThongTin> call = api.GetList ();
        call.enqueue (new Callback<ThongTin> () {
            @Override
            public void onResponse(Call<ThongTin> call, Response<ThongTin> response) {
                ArrayList<ThongTin.Product> arrayList = (ArrayList<ThongTin.Product>) response.body ().getProducts ();
                for(int i = 0 ; i < arrayList.size () ; i ++ ){
                    if(product.getPid ().equals (arrayList.get (i).getPid ())){
                        Intent intent = new Intent (getActivity (), KetQuaActivity.class);
                        intent.putExtra ("pid",arrayList.get (i).getPid ());
                        intent.putExtra ("name",arrayList.get (i).getName ());
                        intent.putExtra ("price",arrayList.get (i).getPrice ());
                        intent.putExtra ("created_at",arrayList.get (i).getCreatedAt ());
                        intent.putExtra ("updated_at",arrayList.get (i).getUpdatedAt ());
                        startActivity (intent);
                    }
                }
            }
            @Override
            public void onFailure(Call<ThongTin> call, Throwable t) {

            }
        });
    }
}