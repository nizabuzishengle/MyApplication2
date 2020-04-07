package cn.edu.sdwu.android.classroom.sn170507180211;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ch5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch5_1);

    }
    public void toast1(View view){
        Toast.makeText(this,"toast1",Toast.LENGTH_LONG).show();
    }

    public void toast2(View view){
        Toast toast=Toast.makeText(this,"toast2",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void toast3(View view) {
        //加载自定义布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater = getLayoutInflater();//布局加载器
        View view1 = layoutInflater.inflate(R.layout.layout_toast, null);//文件转换为实例

        //设置文本
        TextView textView = (TextView) view1;
        textView.setText("toast3");

        Toast toast = new Toast(this);
        toast.setView(view1);//设置界面
        toast.setDuration(Toast.LENGTH_SHORT);//设置时常
        toast.setGravity(Gravity.CENTER, 0, 0);//设置位置
        toast.show();
    }

    public  void notification(View view){
        Notification.Builder builder=new Notification.Builder(this);
        //在构造器中，完成通知各种属性的设置
        builder.setContentTitle("title");
        builder.setContentText("message");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统资源
        //调用build方法 完成构造
        Notification notification=builder.build();
        //使用NotificationManger，发送通知
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);


    }

    public void cancel_notification(View view){
        //
        NotificationManager  notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }

    public void alert_dialog (View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //在构造器
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //添加点击建后，处理
                Toast.makeText(Ch5Activity1.this,"confirm",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();

    }
}