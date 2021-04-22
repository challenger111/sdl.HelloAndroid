package jp.ac.titech.itpro.sdl.helloandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private TextView outputView;
    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputView = findViewById(R.id.output_view);
        inputName = findViewById(R.id.input_name);
    }
    public void greet(View v) {
        String name = inputName.getText().toString().trim();
        for(int i=0;i<name.length();i++){
            char tempc=name.charAt(i);
            if(tempc>=65&&tempc<=90)
                continue;
            if(tempc>=97&&tempc<=122)
                continue;
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("input error");
            builder.setMessage("Please type English only");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setCancelable(true);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            builder.show();
            return;
        }
        if (name.length() > 0) {
            outputView.setText("Hello " + name + "!\nNice to see you!");
        } } }