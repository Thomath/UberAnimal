package thomas.uberanimal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {

    public Button but1;
    public Useraccount nutzer1 = new Useraccount();

    private FirebaseAuth fbAuth;
    private FirebaseAuth.AuthStateListener fbAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbAuth = FirebaseAuth.getInstance();

        fbAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    //user signed in
                    Log.d("LOGGED_IN","onAuthStateChanged:signed__in:" + user.getUid());
                } else {
                    Log.d("LOGGED_OUT","onAuthStateChanged:signed_out:");
                }
            }
        };




    }

    @Override
    public void onStart() {
        super.onStart();
        fbAuth.addAuthStateListener(fbAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if (fbAuthListener != null) {
            fbAuth.removeAuthStateListener(fbAuthListener);
        }
    }


}
