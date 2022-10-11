package vidu.demo.dethithu1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vidu.demo.dethithu1.Adapter.Adapter_tablayout;
import vidu.demo.dethithu1.Fragment.KetQuaFragment;
import vidu.demo.dethithu1.Sever.Api;
import vidu.demo.dethithu1.model.ThongTin;

public class MainActivity extends AppCompatActivity {

    TabLayout mTableLayout;
    ViewPager2 mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mTableLayout = findViewById (R.id.tab_lay_out);
        mViewPager2 = findViewById (R.id.view_page2);

        Adapter_tablayout adapter_tablayout = new Adapter_tablayout (this);
        mViewPager2.setAdapter (adapter_tablayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator (mTableLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy () {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0 :
                        tab.setText ("Danh Sách");
                        break;
                    case 1:
                        tab.setText ("Kết quả");
                        break;
                }
            }
        });
        tabLayoutMediator.attach ();
    }

}