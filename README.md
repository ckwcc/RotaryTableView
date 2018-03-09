# RotaryTableView

使用： 
为了方便，我将其做成了一个Library 

1.引入： 
在整个项目的build.gradle中如下位置加入：

        allprojects {
                repositories {
                        //需要加的代码
                         maven { url 'https://www.jitpack.io' }
                }
        }

接着在你的app这个包下的build.gradle中加入依赖：

        compile 'com.github.ckwcc:RotaryTableView:1.0.0'

2.使用：

在xml中需要使用的地方 输入RotaryTableView，就会有提示 
使用自定义属性需要 在xml的根布局中加入

        xmlns:app="http://schemas.android.com/apk/res-auto"

目前该控件的自定义属性有： 
这里写图片描述

        app:canClick="true"//是否可以点击，用于上面模式一二的切换
        app:backgroundColor="@color/colorDark"//背景色
        app:centerBitmapSrc="@mipmap/ic_round_play"//中心区域图片设置
        app:itemSelectedColor="@color/colorYellow"//item被选中时的颜色
        app:itemUnSelectedColor="@color/colorAccent"//item没有被选中时的颜色，当不可点击时，无效
        app:splitLineColor="@color/colorDark"//分割线颜色

代码中：

        //1.找到控件
        RotaryTableView rotaryTableView = findViewById(R.id.rotary_table_view);

        //2.初始化数据
        final String[] songName = new String[]{"七里香","借口", "半兽人", "夜曲","退后","发如雪"};

        List<RotaryTableInfo> infos = new ArrayList<>();
        for (int i = 0; i < songName.length; i++) {
            infos.add(new RotaryTableInfo(songName[i], 
                                    BitmapFactory.decodeResource(getResources(), R.mipmap.ic_cd)));
        }

        //3.设置数据
        rotaryTableView.setBitInfos(infos);

        //4.设置监听
        //模式一：
        rotaryTableView.setOnWheelCheckListener(new RotaryTableView.OnWheelCheckListener() {
               @Override
               public void onCheck(int position) {
                   Log.d("----", "onCheck: 点击了第"+position+"个位置");
                   Toast.makeText(getApplicationContext(),
                   "点击了第"+position+"个位置,歌名是："+songName[position],
                   Toast.LENGTH_SHORT).show();
               }
         });

        //模式二：
        rotaryTableView.setOnCenterBitmapClickListener(
                new RotaryTableView.OnCenterBitmapClickListener() {
                    @Override
                    public void onCenterClick(int position) {
                        Toast.makeText(getApplicationContext(),
                        "当前第0个位置所在的歌曲名是:"+songName[position],Toast.LENGTH_SHORT).show();
                    }
         });

详情请看：http://blog.csdn.net/ckwccc/article/details/79497212
