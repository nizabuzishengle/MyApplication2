package cn.edu.sdwu.android.classroom.sn170507180211;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch1Activity_1 extends AppCompatActivity implements View.OnFocusChangeListener{
    @Override       //初始化的工作
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //加载界面,不要写文件名，使用资源ID来引用资源
        setContentView(R.layout.layout_ch4_1);

        //1)获取普通界面组件;必须在 setContentView之后调用 findViewById
        Button button=(Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView)findViewById(R.id.ch4_iv);
        //3）调用事件源
        button.setOnClickListener((new MyClickListener()));

        //3使用内部匿名类注册监听器
        imageView.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View view){
                //设置壁纸，

                WallpaperManager wallpaperManager=(WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try{
                    wallpaperManager.setResource(R.raw.fengjing);
                }catch (IOException e){
                    Log.e(Ch1Activity_1.class.toString(),e.toString());
                }

                return true;
            }
        });

        EditText email=(EditText) findViewById(R.id.ch4_1_email);
        email.setOnFocusChangeListener(this);

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        //参数b代表是否获取焦点
        //判断邮箱地址的合法性
        EditText editText=(EditText) view;
        if(!b){
            String content=editText.getText().toString();//得到EditText的内容
            //判断邮箱地址的正则表达式
            String regExl="";
            Pattern pattern= Pattern.compile(regExl);
            Matcher matcher=pattern.matcher(content);
            TextView textView=(TextView)findViewById(R.id.Ch4_1_tv);
            if(matcher.matches()){
                textView.setText("");
            }else{
                textView.setText("email invalidate");
            }
        }
    }

    //2）实现时间监听类，必须实现一个接口
    class MyClickListener implements View.OnClickListener{
        public void onClick(View view){
            Log.i(Ch1Activity_1.class.toString(),"button click");
        }
    }




}
