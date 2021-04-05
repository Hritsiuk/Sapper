package com.example.sapper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sapper.models.Game;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {


    Game g;
    Button[][] buttons;
    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceType", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timer timer=new Timer();

        restart();
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    public void restart()
    {
        setContentView(R.layout.activity_main);
        g=new Game();
        TextView textView=(TextView) findViewById(R.id.textView);
        textView.setText(g.getcountBomb()+"");
        buttons = new Button[10][10];
        GridLayout lay=(GridLayout) new GridLayout(this);
        lay.setColumnCount(10);
        lay.setRowCount(10);
        GridLayout.LayoutParams params3=new GridLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        lay.setLayoutParams(params3);
        TableRow.LayoutParams params=new TableRow.LayoutParams(145, 145);
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                buttons[i][j] = new Button(this);
                buttons[i][j].setBackgroundDrawable(this.getResources().getDrawable(R.drawable.btn));
                buttons[i][j].setTextSize(13);
                buttons[i][j].setLayoutParams(params);
                buttons[i][j].setId(Integer.parseInt(i+""+j));
                buttons[i][j].setOnClickListener(view -> {
                    Button but= findViewById(view.getId());
                    int [] arr=g.parseBtn(but.getId());
                    but.setBackgroundDrawable(this.getResources().getDrawable(arr[0]));
                    if(arr[1]!=100 && arr[1]!=99)
                        but.setText(g.parseBtn(but.getId())[1]+"");

                    cl(buttons,arr);
                    if(g.getcountBomb()<10) {
                        Lose();
                        Toast toast=Toast.makeText(this,"You Lose!",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP,0,160);
                        toast.show();
                    }

                    textView.setText(g.getcountBomb()+"");
                });
                lay.addView(buttons[i][j]);
            }
        }
        addContentView(lay,params3);

    }

    public void ClickB(View view) {
        restart();
    }
    public void Lose()
    {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                buttons[i][j].setClickable(false);
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void cl(Button[][] arr, int [] arr2)
    {

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if(arr2[1]==100 && g.mass[i][j].numberbombaround==100)
                {

                    arr[i][j].setBackgroundDrawable(this.getResources().getDrawable(arr2[0]));

                }
            }
        }
    }

}