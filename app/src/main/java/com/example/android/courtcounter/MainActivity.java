package com.example.android.courtcounter;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0,scoreTeamB = 0;

    ScoreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        displayScoreTeamA( viewModel.getScoreTeamA());
        displayScoreTeamB( viewModel.getScoreTeamB());

    }

    void displayScoreTeamA(int score){
        TextView scoreViewTeamA  = (TextView) findViewById(R.id.score_team_a);
        scoreViewTeamA.setText(""+score);

    }

    void displayScoreTeamB(int score){
        TextView scoreViewTeamB  = (TextView) findViewById(R.id.score_team_b);
        scoreViewTeamB.setText(""+score);

    }
    public void threePointsTeamA(View view){
            scoreTeamA = scoreTeamA + 3;
            viewModel.setScoreTeamA(scoreTeamA);
        displayScoreTeamA(viewModel.getScoreTeamA());
    }
    public void twoPointsTeamA(View view){
        scoreTeamA = scoreTeamA + 2;
        viewModel.setScoreTeamA(scoreTeamA);
        displayScoreTeamA(viewModel.getScoreTeamA());
    }
    public void onePointsTeamA(View view){
        scoreTeamA = scoreTeamA + 1;
        viewModel.setScoreTeamA(scoreTeamA);
        displayScoreTeamA(viewModel.getScoreTeamA());
    }
    public void threePointsTeamB(View view){
        scoreTeamB = scoreTeamB + 3;
        viewModel.setScoreTeamB(scoreTeamB);
        displayScoreTeamB(viewModel.getScoreTeamB());
    }
    public void twoPointsTeamB(View view){
        scoreTeamB = scoreTeamB + 2;
        viewModel.setScoreTeamB(scoreTeamB);
        displayScoreTeamB(viewModel.getScoreTeamB());
    }
    public void onePointsTeamB(View view){
        scoreTeamB = scoreTeamB + 1;
        viewModel.setScoreTeamB(scoreTeamB);
        displayScoreTeamB(viewModel.getScoreTeamB());
    }
    public void resetScore(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        viewModel.setScoreTeamA(0);
        viewModel.setScoreTeamB(0);
        displayScoreTeamA(viewModel.getScoreTeamA());
        displayScoreTeamB(viewModel.getScoreTeamB());
    }

    public void sendScore(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "addresses");
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
