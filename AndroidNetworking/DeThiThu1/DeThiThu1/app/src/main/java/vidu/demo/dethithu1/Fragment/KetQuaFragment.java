package vidu.demo.dethithu1.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vidu.demo.dethithu1.R;
import vidu.demo.dethithu1.Sever.Api;
import vidu.demo.dethithu1.model.ThongTin;

public class KetQuaFragment extends Fragment {


    double tong ;
    TextView txt_tong ;
    double trungbinh;
    public KetQuaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_ket_qua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        txt_tong = view.findViewById (R.id.txt_ket_qua_trung_binh);
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
                for (ThongTin.Product tt : response.body ().getProducts ()){
                    double gia = Double.parseDouble (tt.getPrice ());
                  trungbinh = (tong += gia) /3 ;
                }
                txt_tong.setText ("Trung bình là : "+trungbinh +"");

            }

            @Override
            public void onFailure(Call<ThongTin> call, Throwable t) {

            }
        });

    }
}