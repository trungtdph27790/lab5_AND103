package fpoly.trungtdph27790.lab1_firebase.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.trungtdph27790.lab1_firebase.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lab5_MainActivity extends AppCompatActivity {
    EditText txt1, txt2,txt3 ;
    TextView tvkq ;
    Button btn1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab5_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        tvkq = findViewById(R.id.tvkq);
        btn1 = findViewById(R.id.lab5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData(txt1,txt2,txt3,tvkq);
            }
        });
    }
    private void insertData(EditText txt1, EditText txt2, EditText txt3, TextView tvkq){
        //
        sanpham s = new sanpham(txt1.getText().toString(),
                txt2.getText().toString(),
                txt3.getText().toString());
        //
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.31.42/lab5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //
        interfaceInsertSanPham insertSanPham = retrofit.create(interfaceInsertSanPham.class);
        //
        Call<SvrResponseSanPham> call = insertSanPham.insertSanPham(s.getMaSp(),s.getTenSp(),s.getMota());
        //
        call.enqueue(new Callback<SvrResponseSanPham>() {
            @Override
            public void onResponse(Call<SvrResponseSanPham> call, Response<SvrResponseSanPham> response) {
                SvrResponseSanPham res =  response.body();
                tvkq.setText(res.getMessage());
            }

            @Override
            public void onFailure(Call<SvrResponseSanPham> call, Throwable t) {
                tvkq.setText(t.getMessage());
            }
        });
    }
}