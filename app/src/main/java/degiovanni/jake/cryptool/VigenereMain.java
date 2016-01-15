package degiovanni.jake.cryptool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

        MsgText = (TextView) findViewById(R.id.msg);
        KeyText = (TextView) findViewById(R.id.key);
        out = (TextView) findViewById(R.id.out);
        mEnButton = (Button) findViewById(R.id.encode);
        mDeButton = (Button) findViewById(R.id.decode);
        final VigenereCipher v = new VigenereCipher();

        mEnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = KeyText.getText().toString();
                String result = MsgText.getText().toString();
                if (result.equals(""))
                    out.setText("Please enter a message to encode");
                else if (key.equals(""))
                    out.setText("Please enter a key for your message");
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
                String result = MsgText.getText().toString();
                if (key.equals(""))
                    out.setText("Please enter a key for your message");
                else if (result.equals(""))
                    out.setText("Please enter a message to encode");
                else {
                    result = v.decrypt(MsgText.getText().toString(), key);
                    out.setText(result);
                }
            }
        });

    }

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
