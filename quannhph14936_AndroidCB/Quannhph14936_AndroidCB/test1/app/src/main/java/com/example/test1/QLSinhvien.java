package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class QLSinhvien {
    private SQLite sql;
    private SQLiteDatabase dtb;
    Context context;
    List<String> list = new ArrayList<>();

    public QLSinhvien(Context context) {
        this.context = context;
        sql = new SQLite(context);
        dtb = sql.getWritableDatabase();
    }

    // thêm sv
    public int them(Sinhvien sv) {
        ContentValues values = new ContentValues();
        values.put("masv",sv.getMasv());
        values.put("malop",sv.getMalop());
        values.put("tensv",sv.getTensv());
        values.put("diem",sv.getDiem());
        values.put("date",sv.getDate());

        if(dtb.insert("SINHVIEN", null, values) <0) {
            return  -1;
        } return 1;
    }

    // hiển thị list
    public List<String> getAll() {
        Cursor cursor = dtb.query("SINHVIEN", null, null, null, null, null, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Sinhvien sv = new Sinhvien();
            sv.setMalop(cursor.getString(0));
            sv.setMasv(cursor.getString(1));
            sv.setTensv(cursor.getString(2));
            sv.setDiem(cursor.getString(3));
            sv.setDate(cursor.getString(4));

            String chuoi = sv.getMalop() + " - " + sv.getMasv()+ " -- "  + sv.getTensv()+ " --- "  + sv.getDiem()+ " ---- "  + sv.getDate();
            list.add(chuoi);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    // sửa
    public int sua(Sinhvien sv) {
        ContentValues values = new ContentValues();
        values.put("malop",sv.getMalop());
        values.put("masv",sv.getMasv());
        values.put("tensv",sv.getTensv());
        values.put("diem",sv.getDiem());
        values.put("date",sv.getDate());

        int kq = dtb.update("SINHVIEN", values, "masv=?", new String[]{sv.getMasv()});
        if(kq <= 0) {
            return -1;
        } return 1;
    }

    // xoá
    public int xoa(String masv) {
        list.remove(masv);
        int kq = dtb.delete("SINHVIEN", "masv=?", new String[]{masv});
        if(kq <=0) {
            return -1;
        } return 1;
    }
}
