package com.websarva.wings.android.rensyusample1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンを取得
        Button btCalc = findViewById(R.id.btCalc);
        //リスナーを取得
        CalcListener listener = new CalcListener();
        //リスナーの紐付け
        btCalc.setOnClickListener(listener);
    }


    private class CalcListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //出力エリアの取得

            double bmi;

            TextView output = findViewById(R.id.tv_output);

            //名前を取得
            EditText etName = findViewById(R.id.etName);
            String name = etName.getText().toString();

            //身長を取得
            EditText etHeight = findViewById(R.id.etHeight);
            double height = Double.parseDouble(etHeight.getText().toString());

            //体重を取得
            EditText etWeight = findViewById(R.id.etWeight);
            double weight = Double.parseDouble(etWeight.getText().toString());

            //BMIを計算
            bmi = weight / Math.pow(height / 100, 2);

            //画面に表示
            output.setText(String.format("%sさんのBMIは%.2fです。", name, bmi));

        }
    }
}