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
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        teamA_score = (TextView) findViewById(R.id.team_a_score);
        teamA_all_score = (TextView) findViewById(R.id.tv_team_a_games_won);
        teamB_score = (TextView) findViewById(R.id.team_b_score);
        teamB_all_score = (TextView) findViewById(R.id.tv_team_b_games_won);
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
        teamA_all_score.setText(R.string.tv_zero);

        winsTeamB = 0;
        teamB_all_score.setText(R.string.tv_zero);

    }
}
