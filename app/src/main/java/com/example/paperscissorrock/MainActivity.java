package com.example.paperscissorrock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RadioButton paper,scissor,rock;
    TextView MyScore, GameScore,textView;
    Button play;
    Random r = new Random();
    String game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paper = (RadioButton) findViewById(R.id.paper);
        scissor = (RadioButton) findViewById(R.id.scissor);
        rock = (RadioButton) findViewById(R.id.rock);
        MyScore = (TextView) findViewById(R.id.myscore);
        GameScore = (TextView) findViewById(R.id.gameScore);
        textView = (TextView) findViewById(R.id.textView);
        play = (Button) findViewById(R.id.play);
    }

    public void play(View view) {
        if (!paper.isChecked() && !scissor.isChecked() && !rock.isChecked()){
            // you have to select at least one to play
            Toast.makeText(this.getBaseContext(), "You have to select att least one item", Toast.LENGTH_SHORT).show();
        }else{
            // generate a randome number between 1 and 3
            int gameChoice = r.nextInt(4-1)+1;
            if(gameChoice == 1 ){  game="paper";}
            if(gameChoice == 2 ){  game="scissor";}
            if(gameChoice == 3 ){  game="rock";}

            textView.setText("Game Played "+game);

            // in case the player and th system choosed the same item
            if(paper.isChecked() && game =="paper"){ }
            if(scissor.isChecked() && game =="scissor"){ }
            if(rock.isChecked() && game =="rock"){ }

            /*********************/
            if(paper.isChecked() && game =="rock"){
                textView.setText(textView.getText() +" You Win");
                MyScore.setText(Integer.parseInt(MyScore.getText().toString())+1+"");
            }
            if(paper.isChecked() && game =="scissor"){
                textView.setText(textView.getText() +" You lost");
                GameScore.setText(Integer.parseInt(GameScore.getText().toString())+1+"");
            }
            /*********************/
            if(scissor.isChecked() && game =="paper"){
                textView.setText(textView.getText() +" You Win ");
                MyScore.setText(Integer.parseInt(MyScore.getText().toString())+1+"");
            }
            if(scissor.isChecked() && game =="rock"){
                textView.setText(textView.getText() +" You lost");
                GameScore.setText(Integer.parseInt(GameScore.getText().toString())+1+"");
            }
            /*********************/
            if(rock.isChecked() && game =="scissor"){
                textView.setText(textView.getText() +" You Win");
                MyScore.setText(Integer.parseInt(MyScore.getText().toString())+1+"");
            }
            if(rock.isChecked() && game =="paper"){
                textView.setText(textView.getText() +" You lost");
                GameScore.setText(Integer.parseInt(GameScore.getText().toString())+1+"");
           }
            /*********************/
        }
    }
}