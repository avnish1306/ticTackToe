package com.example.cse.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class game extends AppCompatActivity {
    Button btn11,btn12,btn13,btn21,btn22,btn23,btn31,btn32,btn33,replay,newGame;
    int sc1=0,sc2=0,flag=0,flag1=0;
    TextView score1,score2,player1,player2,win;
    int turn=1,chance=0;
    char result;
    tac tic=new tac();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final Bundle b=getIntent().getExtras();
        findAllViewsById();
        player1.setText(b.getCharSequence("player1"));
        player2.setText(b.getCharSequence("player2"));
        //int zero=0;
        score1.setText(String.valueOf(sc1));
        score2.setText(String.valueOf(sc2));
        startGame();
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn11,1,1);
            }
        });
       btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn12,1,2);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn13,1,3);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn21,2,1);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn22,2,2 );
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn23,2,3);
            }
        });
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn31,3,1);
            }
        });
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn32,3,2);
            }
        });
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print(btn33,3,3);
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mains=new Intent(game.this,MainActivity.class);

                startActivity(mains);


            }
        });

    }
    private void print(Button b,int x,int y){
        chance++;
        if(turn==1){
            result= tic.fill(x,y, 'x');
            b.setText("X");
        }else if(turn==2) {
            result = tic.fill(x, y, 'o');
            b.setText("O");
        }else{
            if(flag==0){
            Context context = getApplicationContext();
            CharSequence text = "Please start new game";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text,duration );
            toast.show();
            flag=1;}
        }
        Log.d(" Result out ",String.valueOf(result));

        if(result=='x'){

            win.setText(player1.getText()+" wins!!");
            if(flag1==0){
            sc1++;
            score1.setText(String.valueOf(sc1));
            flag1=1;}
            turn=0;
        }else if(result=='o'){
            win.setText(player2.getText()+" wins!!");
            if(flag1==0){
                sc2++;
                score2.setText(String.valueOf(sc2));
                flag1=1;}
            turn=0;
        }else if(chance==9){
            win.setText("draw");
        }
    }
    private void findAllViewsById(){
        btn11=(Button)findViewById(R.id.btn11);
        btn12=(Button)findViewById(R.id.btn12);
        btn13=(Button)findViewById(R.id.btn13);
        btn21=(Button)findViewById(R.id.btn21);
        btn22=(Button)findViewById(R.id.btn22);
        btn23=(Button)findViewById(R.id.btn23);
        btn31=(Button)findViewById(R.id.btn31);
        btn32=(Button)findViewById(R.id.btn32);
        btn33=(Button)findViewById(R.id.btn33);
        replay=(Button)findViewById(R.id.replay);
        newGame=(Button)findViewById(R.id.newGame);
        player1=(TextView)findViewById(R.id.player1);
        player2=(TextView)findViewById(R.id.player2);
        score1=(TextView)findViewById(R.id.score1);
        score2=(TextView)findViewById(R.id.score2);
        win=(TextView)findViewById(R.id.win);
    }
    private void startGame(){
        Log.d("start game ", "startgame");
        tic.init();
        setBtn();
        chance=0;
        win.setText("Game started");
        turn=1;
        result='z';
        flag=0;
        flag1=0;

    }
    private void setBtn(){
        btn11.setText(" . ");
        btn12.setText(" . ");
        btn13.setText(" . ");
        btn21.setText(" . ");
        btn22.setText(" . ");
        btn23.setText(" . ");
        btn31.setText(" . ");
        btn32.setText(" . ");
        btn33.setText(" . ");

    }
    public class tac{
        char [][]a=new char[3][3];
        int i=0,j=0;
        public void init(){
            Log.d("init ", "  init() ");
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    a[i][j]='z';
                }
            }
        }
        private void tsetprint(){
            for(i=0;i<3;i++){
                for(j=0;j<3;j++){
                    Log.d("i",String.valueOf(i));
                    Log.d("j  l",String.valueOf(j));
                    Log.d("a ",String.valueOf(a[i][j]));
                }
            }
        }
        public char check(){
            if(a[0][0]==a[0][1]&&a[0][1]==a[0][2]){
                return a[0][0];
            }else if(a[1][0]==a[1][1]&&a[1][1]==a[1][2]){
                return a[1][0];
            }else if(a[2][0]==a[2][1]&&a[2][1]==a[2][2]){
                return a[2][0];
            }else if(a[0][0]==a[1][0]&&a[1][0]==a[2][0]){
                return a[0][0];
            }else if(a[0][1]==a[1][1]&&a[1][1]==a[2][1]){
                return a[0][1];
            }else if(a[0][2]==a[1][2]&&a[1][2]==a[2][2]){
                return a[0][2];
            }else if(a[0][0]==a[1][1]&&a[1][1]==a[2][2]){
                return a[0][0];
            }else if(a[0][2]==a[1][1]&&a[1][1]==a[2][0]){
                return a[0][2];
            }
            else
                return 'z';
        }
        public char fill(int x,int y,char c){
            Log.d("x",String.valueOf(x));
            Log.d("y",String.valueOf(y));
            Log.d("c",String.valueOf(c));
            a[x-1][y-1]=c;
            if(c=='x')
                turn=2;
            else
                turn=1;
            char r=check();
            //tsetprint();
            Log.d("result ",String.valueOf(r));
            if(r=='x'||r=='o')
                turn=0;
            return r;
        }

    }
}
