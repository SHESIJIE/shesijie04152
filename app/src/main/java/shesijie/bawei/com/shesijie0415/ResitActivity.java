package shesijie.bawei.com.shesijie0415;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResitActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    EditText check;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_resit );
        button = findViewById ( R.id.resit_button );
        name = findViewById ( R.id.resit_name );
        pass = findViewById ( R.id.resit_pass );
        check = findViewById ( R.id.resit_check );

        TextView textView = findViewById ( R.id.resit_finish );
        textView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (name == null || pass == null || check == null) {
                    Toast.makeText ( ResitActivity.this , "输入的内容不能为空" , Toast.LENGTH_SHORT ).show ();
                }
            }
        } );
    }
}