package vidu.demo.dethithu1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vidu.demo.dethithu1.Fragment.DanhSachFragment;
import vidu.demo.dethithu1.Fragment.KetQuaFragment;

public class Adapter_tablayout extends FragmentStateAdapter {

    public Adapter_tablayout(@NonNull FragmentActivity fragmentActivity) {
        super (fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new DanhSachFragment ();
            case 1:
                return new KetQuaFragment ();
            default:
                return new DanhSachFragment ();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
