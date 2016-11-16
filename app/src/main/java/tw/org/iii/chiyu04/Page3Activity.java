package tw.org.iii.chiyu04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        TextView MSN = (TextView) findViewById(R.id.page3_MSN);

        // 任何的 Activity 都已經會有 Intent 物件
        // 所以才可以直接使用 getIntent
        // 接收收到的參數
        Intent Int = getIntent();
        int IQ = Int.getIntExtra("IQ",0);
        String name = Int.getStringExtra("name");
        Boolean isMale = Int.getBooleanExtra("isMale", false);
        //
        int r1 = (int) (Math.random()*49+1);

        //
        MSN.setText("Name : " + name + "\n" +
                    "IQ : "+ IQ + "\n" +
                    "Gender : " + isMale +
                    "Lottery : " + r1);


        Intent B1 = new Intent();
        B1.putExtra("lottery",r1);
        setResult(1,B1);
    }

    @Override
    public void finish() {

        Intent B1 = new Intent();
        B1.putExtra("Hello","World");
        setResult(2,B1);

        super.finish();
    }
}
