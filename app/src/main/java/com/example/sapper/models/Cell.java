package com.example.sapper.models;

public class Cell {

    public boolean isBomb;
    public int numberbombaround;

    public Cell()
    {
        numberbombaround=100;
        isBomb=false;
    }

    public void setnumber(Cell [][]cells,int id)
    {
        if(!this.isBomb) {
            int i = id / 10, j = id % 10, count = 0;
            if (j + 1 < 10 && cells[i][j + 1].isBomb) {
                count++;
            }
            if (j - 1 >= 0 && cells[i][j - 1].isBomb) {
                count++;
            }
            if (i + 1 < 10 && cells[i + 1][j].isBomb) {
                count++;
            }
            if (i - 1 >= 0 && cells[i - 1][j].isBomb) {
                count++;
            }
            if (j + 1 < 10 && i + 1 < 10 && cells[i + 1][j + 1].isBomb) {
                count++;
            }
            if (j - 1 >= 0 && i - 1 >= 0 && cells[i - 1][j - 1].isBomb) {
                count++;
            }
            if (j - 1 >= 0 && i + 1 < 10 && cells[i + 1][j - 1].isBomb) {
                count++;
            }
            if (j + 1 < 10 && i - 1 >= 0 && cells[i - 1][j + 1].isBomb) {
                count++;
            }

            if (count > 0)
                numberbombaround = count;
        }
    }


    public void setnumber(Cell [][]cells,int i,int j)
    {
        if(!this.isBomb) {
            int count = 0;
            if (j + 1 < 10 && cells[i][j + 1].isBomb) {
                count++;
            }
            if (j - 1 >= 0 && cells[i][j - 1].isBomb) {
                count++;
            }
            if (i + 1 < 10 && cells[i + 1][j].isBomb) {
                count++;
            }
            if (i - 1 >= 0 && cells[i - 1][j].isBomb) {
                count++;
            }
            if (j + 1 < 10 && i + 1 < 10 && cells[i + 1][j + 1].isBomb) {
                count++;
            }
            if (j - 1 >= 0 && i - 1 >= 0 && cells[i - 1][j - 1].isBomb) {
                count++;
            }
            if (j - 1 >= 0 && i + 1 < 10 && cells[i + 1][j - 1].isBomb) {
                count++;
            }
            if (j + 1 < 10 && i - 1 >= 0 && cells[i - 1][j + 1].isBomb) {
                count++;
            }

            if (count > 0)
                numberbombaround = count;
        }
    }
}