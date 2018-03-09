package com.ckw.rotarytableview;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ckw.rotarytableviewmodule.RotaryTableInfo;
import com.ckw.rotarytableviewmodule.RotaryTableView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.找到控件
        RotaryTableView rotaryTableView = findViewById(R.id.rotary_table_view);

        //2.初始化数据
        final String[] songName = new String[]{"七里香","借口", "半兽人", "夜曲","退后","发如雪"};

        List<RotaryTableInfo> infos = new ArrayList<>();
        for (int i = 0; i < songName.length; i++) {
            infos.add(new RotaryTableInfo(songName[i], BitmapFactory.decodeResource(getResources(), R.mipmap.ic_cd
            )));
        }

        //3.设置数据
        rotaryTableView.setBitInfos(infos);

        //4.设置监听
        rotaryTableView.setOnWheelCheckListener(new RotaryTableView.OnWheelCheckListener() {
            @Override
            public void onCheck(int position) {
                Log.d("----", "onCheck: 点击了第"+position+"个位置");
                Toast.makeText(getApplicationContext(),"点击了第"+position+"个位置,歌名是："+songName[position],Toast.LENGTH_SHORT).show();
            }
        });

        rotaryTableView.setOnCenterBitmapClickListener(new RotaryTableView.OnCenterBitmapClickListener() {
            @Override
            public void onCenterClick(int position) {
                Toast.makeText(getApplicationContext(),"当前第0个位置所在的歌曲名是:"+songName[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}
