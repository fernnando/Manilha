package br.com.fddittmar.manilha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.com.fddittmar.manilha.R;

public class Scoreboard extends AppCompatActivity {
    public int scoreTeamA = 0;
    public int scoreTeamB = 0;
    public TextView teamA_score;
    public TextView teamB_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        teamA_score = (TextView) findViewById(R.id.team_a_score);
        teamB_score = (TextView) findViewById(R.id.team_b_score);
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

    public void updateCounterTeamA(int add){
        scoreTeamA += add;

        if(scoreTeamA > 12)
            scoreTeamA = 12;

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

    public void updateCounterTeamB(int add){
        scoreTeamB += add;

        if(scoreTeamB > 12)
            scoreTeamB = 12;

        teamB_score.setText(Integer.toString(scoreTeamB));
    }

    public void resetScore(View view) {
        scoreTeamA = scoreTeamB = 0;
        teamA_score.setText(Integer.toString(scoreTeamA));
        teamB_score.setText(Integer.toString(scoreTeamB));
    }
}
