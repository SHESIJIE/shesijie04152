package shesijie.bawei.com.shesijie0415;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import shesijie.bawei.com.shesijie0415.bean.MyBean;
import shesijie.bawei.com.shesijie0415.mvp.Conster;

public class MainActivity extends AppCompatActivity implements Conster.IView {

    EditText name;
    EditText pass;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        name = findViewById ( R.id.login_name );
        pass = findViewById ( R.id.login_pass );
        textView = findViewById ( R.id.login_text );
        button = findViewById ( R.id.login_button );

        textView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent ( MainActivity.this,ResitActivity.class );
                startActivity ( intent1 );
            }
        } );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent ( MainActivity.this ,ShowActivity.class);
                startActivity ( intent2 );
            }
        } );
    }


    @Override
    public void getPresenter(String data) {
        if(data!=null){
            Gson gson = new Gson ();
            MyBean loginBean = gson.fromJson(data, MyBean.class);
            Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_LONG).show();
            if(loginBean.getStatus().equals("0000")){
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
