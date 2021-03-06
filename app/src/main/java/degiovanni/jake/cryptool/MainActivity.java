package degiovanni.jake.cryptool;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

//    TextView cae;
//    TextView vig;
//    TextView rot;
    ImageView caeI;
    ImageView vigI;
    ImageView rotI;
    CardView caesar_card;
    CardView vigenere_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        cae = (TextView) findViewById(R.id.cae);
//        vig = (TextView) findViewById(R.id.vig);
//        rot = (TextView) findViewById(R.id.rot);

        caesar_card = (CardView) findViewById(R.id.card_caesar);
        vigenere_card = (CardView) findViewById(R.id.card_vigenere);

        caeI = (ImageView) findViewById(R.id.ci);
        Glide.with(this).load(R.drawable.julius_caesar).centerCrop().into(caeI);

        vigI = (ImageView) findViewById(R.id.vi);
        Glide.with(this).load(R.drawable.rotor).centerCrop().into(vigI);

        rotI = (ImageView) findViewById(R.id.ri);
        Glide.with(this).load(R.drawable.rome).centerCrop().into(rotI);

        caesar_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caesar_card.setCardElevation(8);
                MainActivity.this.startActivity(new Intent(MainActivity.this, CaesarMain.class));
            }
        });

        vigenere_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, VigenereMain.class));
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
