package thomas.uberanimal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button but1;
    public Useraccount nutzer1 = new Useraccount();

    public void init(){
        but1 = (Button)findViewById(R.id.button);

        nutzer1.setName("Hans");
        nutzer1.setAge(12);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(MainActivity.this, second.class);
                send.putExtra("Nutzer",nutzer1);
                MainActivity.this.startActivity(send);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


}
