package com.example.cse.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button play;
    EditText player1;
    EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViewsById();//get all views by calling a functio
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent game=new Intent(MainActivity.this, game.class);
                Bundle b=new Bundle();
                b.putString("player1",player1.getText().toString());
                b.putString("player2",player2.getText().toString());
                player1.setText(" ok");
                game.putExtras(b);
                startActivity(game);
            }
        });
    }
    private void findAllViewsById(){
        play=(Button)findViewById(R.id.play);
        player1=(EditText)findViewById(R.id.player1);
        player2=(EditText)findViewById(R.id.player2);
    }
}
