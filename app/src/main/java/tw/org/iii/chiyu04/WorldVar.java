package tw.org.iii.chiyu04;

import android.app.Application;

public class WorldVar extends Application {
    int a = 10;
    WorldVar(){
        a = 100;
    }
    @Override
    public void onCreate() {
        a = 1000;
        super.onCreate();
    }
}
