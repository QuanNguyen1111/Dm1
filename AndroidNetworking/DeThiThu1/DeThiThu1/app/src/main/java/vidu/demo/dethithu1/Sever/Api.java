package vidu.demo.dethithu1.Sever;

import retrofit2.Call;
import retrofit2.http.GET;
import vidu.demo.dethithu1.model.ThongTin;

public interface Api {
    @GET("getall.json")
    Call<ThongTin> GetList();
}
