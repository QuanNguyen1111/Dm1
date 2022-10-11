package vidu.demo.dethithu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KetQuaActivity extends AppCompatActivity {

    ImageView imagesao;
    TextView txt_id , txt_name , txt_gia , txt_at , txt_up ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_ket_qua);
        Init ();
        Intent i = getIntent ();
        String id = i.getStringExtra ("pid");
        String name = i.getStringExtra ("name");
        String gia = i.getStringExtra ("price");
        String at = i.getStringExtra ("created_at");
        String up = i.getStringExtra ("updated_at");

        imagesao.setVisibility (View.GONE);
        if(Integer.parseInt (id) % 2 == 0){
            imagesao.setVisibility (View.VISIBLE);
        }else {
            imagesao.setVisibility (View.GONE);
        }
        txt_id.setText (id);
        txt_name.setText (name);
        txt_gia.setText (gia);
        txt_at.setText (at);
        txt_up.setText (up);

    }
    public void Init(){
        imagesao = findViewById (R.id.image_Sao);
        txt_id = findViewById (R.id.txt_ket_qua_id);
        txt_name = findViewById (R.id.txt_ket_qua_name);
        txt_gia = findViewById (R.id.txt_ket_qua_gia);
        txt_at = findViewById (R.id.txt_ket_qua_created_at);
        txt_up = findViewById (R.id.txt_ket_qua_updated_at);
    }
}