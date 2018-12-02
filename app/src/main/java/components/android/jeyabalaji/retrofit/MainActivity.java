package components.android.jeyabalaji.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import components.android.jeyabalaji.retrofit.data.RetrofitController;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitController controller = new RetrofitController();
        controller.start();
    }
}
