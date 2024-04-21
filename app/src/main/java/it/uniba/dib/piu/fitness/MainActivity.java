package it.uniba.dib.piu.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import it.uniba.dib.piu.fitness.HomeFragment;
import it.uniba.dib.piu.fitness.LoginFragment;
import it.uniba.dib.piu.fitness.R;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        if (user == null) {
            // Utente non loggato, avvia il fragment Login
            Fragment loginFragment = new LoginFragment(); // Assumi che il Fragment sia stato rinominato in LoginFragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, loginFragment);
            transaction.commit();
        }

        else {
            Fragment homeFragment = new HomeFragment(); // Assumi che il Fragment sia stato rinominato in LoginFragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, homeFragment);
            transaction.commit();
        }
    }
}