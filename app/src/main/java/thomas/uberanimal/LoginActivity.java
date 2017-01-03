package thomas.uberanimal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogin;
    EditText editTextEmail,editTextPassword;
    TextView textViewRegister;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewRegister = (TextView) findViewById(R.id.textViewRegister);

        progressDialog = new ProgressDialog(this);

        buttonLogin.setOnClickListener(this);
        textViewRegister.setOnClickListener(this);
    }

    private void loginUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString();

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this,"Please enter your Email!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter your password!",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Einloggen...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            //start profile activity
                            Toast.makeText(LoginActivity.this,"Login erfolgreich!",Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(LoginActivity.this,NavigationDrawer.class));
                        } else {
                            Toast.makeText(LoginActivity.this,"Login fehlgeschlagen!",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogin){
            loginUser();
        }

        if (v == textViewRegister) {
            finish();
            startActivity(new Intent(this,RegisterActivity.class));
        }
    }
}
