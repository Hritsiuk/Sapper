package com.example.sapper.models;

import com.example.sapper.R;

import java.util.Random;

public class Game {

    public Cell[][] mass;

    public Game()
    {
        mass=new Cell[10][10];

        for (int i=0;i<10;i++)
        {
            for (int j=0;j<10;j++)
            {
                mass[i][j]=new Cell();
            }
        }
        randomCells();
        setnumber2();

    }
    public int[] parseBtn(Integer id)
    {
        int i=id/10,j=id%10;
        int[] arr=new int[2];
        if(!mass[i][j].isBomb)
        {

            arr[0]=R.drawable.emptybtn;
            arr[1]=mass[i][j].numberbombaround;

            return arr;
        }
        else {
            arr[0]=R.drawable.btnbomb;
            arr[1]=mass[i][j].numberbombaround;
            mass[i][j].isBomb=false;
            return arr;
        }}

    public void randomCells()
    {
        Random random=new Random();
        while(getcountBomb()<10)
        {
            int x=random.nextInt(10),y=random.nextInt(10);
            mass[x][y].isBomb=true;
            mass[x][y].numberbombaround=99;
        }

    }
    public int getcountBomb()
    {
        int count=0;
        for (int i=0;i<10;i++)
        {
            for (int j=0;j<10;j++)
            {
                if(mass[i][j].isBomb)
                    count++;
            }

        }
        return count;
    }



    public void setnumber2()
    {
        for(int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {

                mass[i][j].setnumber(mass,i,j);
            }
        }

    }
}
