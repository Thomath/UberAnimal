package thomas.uberanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class second extends AppCompatActivity {

    private TextView textViewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewUser=(TextView)findViewById(R.id.textView);

        Useraccount user = (Useraccount)getIntent().getParcelableExtra("Nutzer");
        textViewUser.setText(user.getName()+", "+user.getAge());
    }
}
