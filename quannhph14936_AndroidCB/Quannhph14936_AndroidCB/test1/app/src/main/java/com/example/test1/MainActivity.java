package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtmasv,txtmalop,txttensv,txtdiem,txtdate;
    Button btnthem, btnsua,btnxoatrang, btnView, btnxoa;
    TextView tv;
    ListView listView;
    QLSinhvien qlsv;
    Sinhvien sv;
    ArrayAdapter adapter;
    List<String> list = new ArrayList<>();
    Context context;
        String item,item1,item2,item3,item4,item5;
        int index;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tv = findViewById(R.id.tv);
            txtmalop = findViewById(R.id.txtMalop);
            txttensv = findViewById(R.id.txtTensv);
            txtmasv = findViewById(R.id.txtMasv);
            txtdate = findViewById(R.id.txtDate);
            txtdiem = findViewById(R.id.txtDiem);
            btnthem = findViewById(R.id.btnThem);
            btnxoa = findViewById(R.id.btnXoa);
            btnsua = findViewById(R.id.btnSua);
        btnView = findViewById(R.id.btnView);
        btnxoatrang = findViewById(R.id.btnXoaTrang);
        listView = findViewById(R.id.listView);


        // khởi tạo
        context = this;
        list.clear();
        qlsv = new QLSinhvien(context);
        list = qlsv.getAll();
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kq = list.get(2);
                String kq1 = list.get(3);

                String kq2 = kq.substring(kq.indexOf("-")+2, kq.indexOf("--") - 1);
                String kq3 = kq1.substring(kq1.indexOf("-")+2, kq1.indexOf("--") - 1);

                tv.setText(kq2 + " - " + kq3);
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Sinhvien sv = new Sinhvien();
                    sv.setMasv(txtmasv.getText().toString());
                    sv.setMalop(txtmalop.getText().toString());
                    sv.setTensv(txttensv.getText().toString());
                    sv.setDiem(txtdiem.getText().toString());
                    sv.setDate(txtdate.getText().toString());
                    check();
                    int kq = qlsv.them(sv);
                    if( kq == -1) {
                        Toast.makeText(context,"Thêm thất bại",Toast.LENGTH_LONG).show();
                    }
                    if (kq == 1) {
                        Toast.makeText(context,"Thêm thành công",Toast.LENGTH_LONG).show();
                    }
                    show(view);
            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sinhvien sv = new Sinhvien();
                sv.setMalop(txtmalop.getText().toString());
                sv.setMasv(txtmasv.getText().toString());
                sv.setTensv(txttensv.getText().toString());
                sv.setDiem(txtdiem.getText().toString());
                sv.setDate(txtdate.getText().toString());

                int kq = qlsv.sua(sv);
                if( kq == -1) {
                    Toast.makeText(context,"Sửa thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq == 1) {
                    Toast.makeText(context,"Sửa thành công",Toast.LENGTH_LONG).show();
                }
                show(view);
            }
        });

        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masv = txtmasv.getText().toString();
                int kq = qlsv.xoa(masv);
                if( kq == -1) {
                    Toast.makeText(context, "Xoá thất bại", Toast.LENGTH_LONG).show();
                }
                if(kq ==1) {
                    Toast.makeText(context, "Xoá thành công", Toast.LENGTH_LONG).show();
                }
                show(view);
            }
        });

        btnxoatrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtmasv.setText("");
                txtmalop.setText("");
                txttensv.setText("");
                txtdate.setText("");
                txtdiem.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = (String) listView.getItemAtPosition(position);
                item1 = item.substring(0, item.indexOf(" "));
                item2 = item.substring(item.indexOf("-")+2, item.indexOf("--") - 1 );
                item3 = item.substring(item.indexOf("--")+3 , item.indexOf("---")- 1);
                item4 = item.substring(item.indexOf("---")+4, item.indexOf("----")- 1);
                item5 = item.substring(item.indexOf("----")+5);
                txtmalop.setText(item1);
                txtmasv.setText(item2);
                txttensv.setText(item3);
                txtdiem.setText(item4);
                txtdate.setText(item5);
                index = position;
            }
        });
    }

    public boolean check() {
        if(txtmalop.getText().equals(" ") && txttensv.getText().equals(" ") && txtmasv.getText().equals(" ")
        && txtdiem.getText().equals(" ") && txtdate.getText().equals(" ")) {
            Toast.makeText(context,"Vui lòng nhập đủ thông tin",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void show(View view) {
        qlsv = new QLSinhvien(context);
        list = new ArrayList<String>();
        list = qlsv.getAll();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.deferNotifyDataSetChanged();
    }
}