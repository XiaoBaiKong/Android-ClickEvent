/*
按钮的单击事件有三种写法
1.直接在组件属性里面添加对应的属性，不需要设置ID
    * 在布局里面的按钮组件下面添加如下属性
    * android:onClick="hello" 引号里面的文本是你的方法名称
2.局部事件，需要给按钮设置ID
    * 直接看下面的方法（40行）
    * ff2.setOnClick...  其中的"ff2"是你的组件名称
3.全局事件，需要给按钮设置ID
    * 此方法需要给类引入接口
    * 在"public class MainActivity extends Activity"到后面添加"implements View.OnClickListener"
    * 语法又改成"组件名称.setOnClickListener(this);"，然后在泪里面声明一个方法去判断被单击的组件（58行）
*/
package com.user.onClick;

import android.app.*;
import android.view.*;
import android.widget.TextView;
import android.widget.Button;
import android.content.DialogInterface.OnClickListener;
import android.os.*;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView mytext;

    private Button ff2;
    private Button ff3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mytext = (TextView) findViewById(R.id.mytext);
        
        ff2 = (Button) findViewById(R.id.ff2);
        ff3 = (Button) findViewById(R.id.ff3);
        
        //方法2
        ff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在这里面写被单击后触发的事件的代码
                mytext.setText("这是第2种方法");
            }
        });
        
        //方法3
        ff3.setOnClickListener(this);
    }

    //第1种方法
    public void hello(View view) {
        mytext.setText("这是第1种方法");
    }
    
    // Onclick
    public void onClick(View view) {
        //不一定要用if语句，其他的判断方法也行
        if (view == ff3) {
            mytext.setText("这是第3种方法");
        }
    }
    
}