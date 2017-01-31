package br.com.fddittmar.manilha.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.fddittmar.manilha.R;

public class Scoreboard extends AppCompatActivity {
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int winsTeamA = 0;
    private int winsTeamB = 0;
    private TextView teamA_score;
    private TextView teamB_score;
    private TextView teamA_all_score;
    private TextView teamB_all_score;

    private TextView tv_first_a;
    private TextView tv_second_a;
    private TextView tv_third_a;
    private TextView tv_first_b;
    private TextView tv_second_b;
    private TextView tv_third_b;

    private AlertDialog alerta;

    private String player_1_team_a;
    private String player_2_team_a;
    private String player_3_team_a;
    private String player_1_team_b;
    private String player_2_team_b;
    private String player_3_team_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        teamA_score = (TextView) findViewById(R.id.team_a_score);
        teamA_all_score = (TextView) findViewById(R.id.tv_team_a_games_won);
        teamB_score = (TextView) findViewById(R.id.team_b_score);
        teamB_all_score = (TextView) findViewById(R.id.tv_team_b_games_won);

        tv_first_a = (TextView) findViewById(R.id.tv_first_player_a);
        tv_second_a = (TextView) findViewById(R.id.tv_second_player_a);
        tv_third_a = (TextView) findViewById(R.id.tv_third_player_a);

        tv_first_b = (TextView) findViewById(R.id.tv_first_player_b);
        tv_second_b = (TextView) findViewById(R.id.tv_second_player_b);
        tv_third_b = (TextView) findViewById(R.id.tv_third_player_b);



        if(!getIntent().getStringExtra("first_a").isEmpty() &&
                !getIntent().getStringExtra("second_a").isEmpty() &&
                !getIntent().getStringExtra("first_b").isEmpty() &&
                !getIntent().getStringExtra("second_b").isEmpty()){

            player_1_team_a = getIntent().getStringExtra("first_a");
            player_2_team_a = getIntent().getStringExtra("second_a");
            player_1_team_b = getIntent().getStringExtra("first_b");
            player_2_team_b = getIntent().getStringExtra("second_b");

            tv_first_a.setText(player_1_team_a);
            tv_second_a.setText(player_2_team_a);
            tv_first_b.setText(player_1_team_b);
            tv_second_b.setText(player_2_team_b);

            if(getIntent().getStringExtra("type").equals("six_players")){
                if(!getIntent().getStringExtra("third_a").isEmpty() && !getIntent().getStringExtra("first_b").isEmpty()){
                    player_3_team_a = getIntent().getStringExtra("third_a");
                    player_3_team_b = getIntent().getStringExtra("third_b");

                    tv_third_a.setText(player_3_team_a);
                    tv_third_b.setText(player_3_team_b);
                }else{
                    tv_third_a.setVisibility(View.GONE);
                    tv_third_b.setVisibility(View.GONE);
                }
            }


        }else{

            tv_first_a.setVisibility(View.GONE);
            tv_second_a.setVisibility(View.GONE);
            tv_third_a.setVisibility(View.GONE);

            tv_first_b.setVisibility(View.GONE);
            tv_second_b.setVisibility(View.GONE);
            tv_third_b.setVisibility(View.GONE);
        }
    }

    public void addTeamAPoints(View view) {
        int identifier = view.getId();

        switch (identifier){

            case R.id.addThreeTeamA:
                updateCounterTeamA(3);
                break;
            case R.id.addSixTeamA:
                updateCounterTeamA(6);
                break;
            case R.id.addNineTeamA:
                updateCounterTeamA(9);
                break;
            case R.id.addTwelveTeamA:
                updateCounterTeamA(12);
                break;
        }
    }

    private void updateCounterTeamA(int add){
        scoreTeamA += add;

        if(scoreTeamA >= 12){
            scoreTeamA = 12;
            teamA_score.setText(Integer.toString(scoreTeamA));
            winnerAlert("Time A venceu!");

            winsTeamA++;
            teamA_all_score.setText("(" + Integer.toString(winsTeamA) + ")");
            return;
        }

        teamA_score.setText(Integer.toString(scoreTeamA));
    }



    public void addTeamBPoints(View view) {
        int identifier = view.getId();

        switch (identifier){

            case R.id.addThreeTeamB:
                updateCounterTeamB(3);
                break;
            case R.id.addSixTeamB:
                updateCounterTeamB(6);
                break;
            case R.id.addNineTeamB:
                updateCounterTeamB(9);
                break;
            case R.id.addTwelveTeamB:
                updateCounterTeamB(12);
                break;
        }
    }

    private void updateCounterTeamB(int add){
        scoreTeamB += add;

        if(scoreTeamB >= 12){
            scoreTeamB = 12;
            teamB_score.setText(Integer.toString(scoreTeamB));
            winnerAlert("Time B venceu!");
            winsTeamB++;
            teamB_all_score.setText("(" + Integer.toString(winsTeamB) + ")");
            return;
        }


        teamB_score.setText(Integer.toString(scoreTeamB));
    }

    public void resetScore(View view) {
        resetGame();
    }

    private void resetGame(){
        scoreTeamA = scoreTeamB = 0;
        teamA_score.setText(Integer.toString(scoreTeamA));
        teamB_score.setText(Integer.toString(scoreTeamB));
    }


    private void winnerAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acabou a partida");
        builder.setMessage(message);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getBaseContext(), "Partida reiniciada.", Toast.LENGTH_SHORT).show();
                resetGame();
            }
        });

        alerta = builder.create();
        alerta.show();
    }

    public void resetAll(View view) {
        resetGame();

        winsTeamA = 0;
        teamA_all_score.setText("(0)");

        winsTeamB = 0;
        teamB_all_score.setText("(0)");

    }
}
