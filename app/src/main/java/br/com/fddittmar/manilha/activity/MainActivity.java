package br.com.fddittmar.manilha.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.fddittmar.manilha.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGameFourPlayers(View view) {
        Intent intent = new Intent(this, FourPlayers.class);
        startActivity(intent);
    }

    public void startGameSixPlayers(View view) {
        Intent intent = new Intent(this, SixPlayers.class);
        startActivity(intent);
    }

    public void startTutorial(View view) {
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }
}
