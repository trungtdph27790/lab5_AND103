package fpoly.trungtdph27790.lab1_firebase.lab5;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface interfaceInsertSanPham {
    @FormUrlEncoded
    @POST("insert2.php")
    Call<SvrResponseSanPham> insertSanPham(
            @Field("MaSp") String MaSP ,
            @Field("TenSp") String TenSP ,
            @Field("Mota") String Mota
    );
}
