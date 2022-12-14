package com.example.quannhph14936_duanmau.topTen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.quannhph14936_duanmau.Adapter.TopAdapter;
import com.example.quannhph14936_duanmau.DAO.PhieuMuonDAO;
import com.example.quannhph14936_duanmau.R;
import com.example.quannhph14936_duanmau.model.Top;

import java.util.ArrayList;


public class TopTenFragment extends Fragment {
ListView lv;
ArrayList<Top> list;
TopAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v =inflater.inflate(R.layout.fragment_top_ten, container, false);
        lv = v.findViewById(R.id.lvTop);
        PhieuMuonDAO phieuMuonDAO = new PhieuMuonDAO(getActivity());
        list = (ArrayList<Top>) phieuMuonDAO.getTop();
     adapter = new TopAdapter(getActivity(),this,list);
     lv.setAdapter(adapter);
      return v;
    }
}