package degiovanni.jake.cryptool;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class VigenereMain extends AppCompatActivity {

    TextView MsgText;
    TextView KeyText;
    TextView out;
    Button mEnButton;
    Button mDeButton;
    Button mHoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_cipher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        MsgText = (TextView) findViewById(R.id.msgText);
        KeyText = (TextView) findViewById(R.id.keyText);
        out = (TextView) findViewById(R.id.outMsg);
        mEnButton = (Button) findViewById(R.id.encrypt);
        mDeButton = (Button) findViewById(R.id.decrypt);
        final Vigenerecipher v = new Vigenerecipher();

        mEnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = KeyText.getText().toString();
                key = key.toUpperCase();
                String result = MsgText.getText().toString();
                if (result.equals(""))
                    out.setText("Please enter a message to encode");
                else {
                    result = v.encrypt(MsgText.getText().toString(), key);
                    // Log.d("E-------", result);
                    out.setText(result);
                }
            }
        });

        mDeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = KeyText.getText().toString();
                key = key.toUpperCase();
                String result = MsgText.getText().toString();
                if (result.equals(""))
                    out.setText("Please enter a message to decode");
                else {
                    result = v.decrypt(MsgText.getText().toString(), key);
                    out.setText(result);
                }
            }
        });

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); */
    }

}
