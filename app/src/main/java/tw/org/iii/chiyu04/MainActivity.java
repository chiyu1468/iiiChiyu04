package tw.org.iii.chiyu04;

// A. 重點一
// Activity 的生命週期
// 以下七個方法 在管理生命週期 是自己會呼叫的 硬叫也沒用
// 打開玩一玩 https://developer.android.com/training/basics/activity-lifecycle/starting.html 看看啥時會發生啥麼事
// 旋轉畫面 看看發生啥事

// B. 重點二
// Activity 的切換
//      1. manifests -> 裡面的表單要加 activity
//      2. 有對應的 java code 與 layout
// Activity 是堆疊的概念

// C. 重點三
// 從主要 Activity 用 Intent 切換到 其他 Activity
// 還可以 來回傳參數

// D. 超級厲害
// 所有 Activity 都認識的 屬性
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Btest1, Btest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Btest1 = (Button) findViewById(R.id.test1);
        Btest2 = (Button) findViewById(R.id.test2);


        Log.v("chiyu","this Create");
    }

    public void test1(View v){
        // Context 的類別才可以跳(Activity & Service)
        // 這裡的 Intent 功能是 系統本身 跳過去的
        // 又由於 你要跳過去的地方 不一定存在 所以不能指定 物件 要指定類別
        // 因為 android 一種 Activity 只能單一存在 所以會跳到"那個"裡面
        Intent Int = new Intent(this, Page2Activity.class);
        startActivity(Int);

        if(v == Btest1){
            Log.v("Chiyu", "Jump Return");
        }else if(v == Btest2){
            // finish = Pause -> Stop -> Destroy
            finish();
        }
    }

    public void test3(View v){
        Intent Int = new Intent(this, Page3Activity.class);

        Int.putExtra("name","Chiyu");
        Int.putExtra("IQ",200);
        Int.putExtra("isMale",true);

        startActivity(Int);
    }

    public void test4(View v){
        Intent Int = new Intent(this, Page3Activity.class);
        Int.putExtra("name","Chiyu");
        Int.putExtra("IQ",200);
        Int.putExtra("isMale",true);
        // 為了要回傳 這個方法要給一個"序號"
        startActivityForResult(Int,004);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String key1 = data.getStringExtra("Hello");
//        int lottery1 = data.getIntExtra();

        Log.v("chiyu","onActivityResult \n" + requestCode + "\n" + resultCode + ":" + key1);
    }

    @Override
    protected void onStart() {
        super.onStart();


        Log.v("chiyu","this Start");
    }
    @Override
    protected void onResume() {
        super.onResume();


        Log.v("chiyu","this Resume");
    }
    @Override
    protected void onPause() {
        super.onPause();


        Log.v("chiyu","this Pause");
    }
    @Override
    protected void onStop() {
        super.onStop();


        Log.v("chiyu","this Stop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();


        Log.v("chiyu","this Destroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();


        Log.v("chiyu","this Restart");
    }

}
