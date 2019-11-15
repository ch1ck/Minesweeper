package com.cornez.paintscene;

public class Block {
    private boolean mine;
    private int numOfAdjacentMine;
    private boolean opened;


    public Block(){
        mine=false;
        numOfAdjacentMine=0;
    }

    public void setNumOfAdjacentMine(int numOfAdjacentMine) {
        this.numOfAdjacentMine = numOfAdjacentMine;
    }

    public int getNumOfAdjacentMine() {
        return numOfAdjacentMine;
    }

    public void setMine(){
        mine=true;
    }
    public boolean getMine(){
        return mine;
    }
    public void setOpened(){opened=true;}
    public boolean isOpened(){return opened;}
}
