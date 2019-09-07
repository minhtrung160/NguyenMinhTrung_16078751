package com.example.nmt_cau1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText soa, sob, soc;
    Button giai,thoat;
    TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soa = (EditText)findViewById(R.id.edt_a);
        sob = (EditText)findViewById(R.id.edt_b);
        soc = (EditText)findViewById(R.id.edt_c);
        giai = (Button)findViewById(R.id.btn_giai);
        thoat = (Button)findViewById(R.id.btn_thoat);
        kq = (TextView)findViewById(R.id.txt_kq);

        giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a, b, c;
                double x, x1,x2, delta;
                String st = "";

                a = Double.parseDouble(soa + "");
                b = Double.parseDouble(sob + "");
                c = Double.parseDouble(soc + "");

                delta = b*b - 4*a*c;

                if(a == 0){
                    if(b==0){
                        if(c==0){
                            st = "Phương trình vô số nghiệm";
                        }else {
                            st = "Phương trình vô nghiệm";
                        }
                    }else {
                        st = "x = " + (-c)/b + "" ;
                    }
                }else {
                    if(delta < 0){
                        st = "Phương trình vô nghiệm";
                    }else if(delta == 0){
                        st = "Phương trình có nghiệm kép" +(-b)/(2*a) + "";
                    }else {
                        double delta_sqrt = Math.sqrt(delta);
                        st = "x1 = " +((b*b + delta_sqrt)/(2 * a)) + "\n" + "x2 = " + ((b*b - delta_sqrt)/(2 * a))  +"";
                    }
                }
                kq.setText(st);

            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
