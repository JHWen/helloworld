package com.example.codesky.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取View
        Button btn = findViewById(R.id.button);
        final TextView tv1 = findViewById(R.id.text);

        //给按钮添加监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "trigger button listener");
                tv1.setText("What a wonderful world!");
            }
        });

        //获取seekBar
        SeekBar seekBar = findViewById(R.id.seekBar);

        //给可拖动进度条设置监听器
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //seekBar改变事件触发
                Log.d("MainActivity", "seekBar onProgressChanged event");
                tv1.setText("SeekBar进度为" + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //按住seekBar事件触发
                //通过Toast显示简短的信息
                Log.d("MainActivity", "seekBar onStartTrackingTouch event");
                Toast.makeText(getApplicationContext(), "按住SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //松开seek事件触发
                //通过Toast显示简短的信息
                Log.d("MainActivity", "seekBar onStopTrackingTouch event");
                Toast.makeText(getApplicationContext(), "松开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

        //获取Switch
        Switch sw = findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && buttonView.isPressed()) {
                    //夜间模式
                    Log.d("MainActivity", "Switch Checked 夜间模式");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    recreate();
                } else if (buttonView.isPressed()) {
                    //日间模式
                    Log.d("MainActivity", "Switch Checked 日间模式");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    recreate();
                }
            }
        });

    }
}
