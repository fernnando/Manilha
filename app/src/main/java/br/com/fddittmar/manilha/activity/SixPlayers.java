package br.com.fddittmar.manilha.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.com.fddittmar.manilha.R;

public class SixPlayers extends AppCompatActivity {
    private EditText et_player_1_team_a;
    private EditText et_player_2_team_a;
    private EditText et_player_3_team_a;
    private EditText et_player_1_team_b;
    private EditText et_player_2_team_b;
    private EditText et_player_3_team_b;

    private String player_1_team_a;
    private String player_2_team_a;
    private String player_3_team_a;
    private String player_1_team_b;
    private String player_2_team_b;
    private String player_3_team_b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_players);

        et_player_1_team_a = (EditText) findViewById(R.id.et_player_1_team_a);
        et_player_2_team_a = (EditText) findViewById(R.id.et_player_2_team_a);
        et_player_3_team_a = (EditText) findViewById(R.id.et_player_3_team_a);


        et_player_1_team_b = (EditText) findViewById(R.id.et_player_1_team_b);
        et_player_2_team_b = (EditText) findViewById(R.id.et_player_2_team_b);
        et_player_3_team_b = (EditText) findViewById(R.id.et_player_3_team_b);

    }

    public void startCounter(View view) {
        player_1_team_a = et_player_1_team_a.getText().toString();
        player_2_team_a = et_player_2_team_a.getText().toString();
        player_3_team_a = et_player_3_team_a.getText().toString();

        player_1_team_b = et_player_1_team_b.getText().toString();
        player_2_team_b = et_player_2_team_b.getText().toString();
        player_3_team_b = et_player_3_team_b.getText().toString();



        Intent intent = new Intent(this, Scoreboard.class);
        intent.putExtra("type", "six_players");

        intent.putExtra("first_a", player_1_team_a);
        intent.putExtra("second_a", player_2_team_a);
        intent.putExtra("third_a", player_3_team_a);

        intent.putExtra("first_b", player_1_team_b);
        intent.putExtra("second_b", player_2_team_b);
        intent.putExtra("third_b", player_3_team_b);

        startActivity(intent);
    }
}

