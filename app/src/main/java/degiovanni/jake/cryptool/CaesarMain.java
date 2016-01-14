package degiovanni.jake.cryptool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.widget.Toast;

public class CaesarMain extends AppCompatActivity {

    TextView mMsgText;
    TextView mOutText;
    Spinner mKey;
    Button mEnButton;
    Button mDeButton;
    Button mHoButton;
    FloatingActionButton info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mMsgText = (TextView) findViewById(R.id.user_msg);
        mOutText = (TextView) findViewById(R.id.msgText);
        mKey = (Spinner) findViewById(R.id.caesar_choice);
        mEnButton = (Button) findViewById(R.id.encrypt);
        mDeButton = (Button) findViewById(R.id.decrypt);
        final CaesarCipher c = new CaesarCipher();
        info = (FloatingActionButton) findViewById(R.id.info);

        mEnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int key = Integer.parseInt(mKey.getSelectedItem().toString());
                String result = mMsgText.getText().toString();
                if (result.equals(""))
                    mOutText.setText("Please enter a message to encode");
                else {
                    result = c.encode(mMsgText.getText().toString(), key);
                    // Log.d("E-------", result);
                    mOutText.setText(result);
                }
            }
        });

        mDeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int key = Integer.parseInt(mKey.getSelectedItem().toString());
                String result = mMsgText.getText().toString();
                if (result.equals(""))
                    mOutText.setText("Please enter a message to decode");
                else {
                    result = c.decode(mMsgText.getText().toString(), key);
                    mOutText.setText(result);
                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CaesarMain.this, "Hello World!", Toast.LENGTH_SHORT).show();
            }
        });
    }

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
