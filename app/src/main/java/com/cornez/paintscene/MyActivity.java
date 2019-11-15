package com.cornez.paintscene;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.cornez.paintscene.R.drawable.blankspace;
import static com.cornez.paintscene.R.drawable.hide;
import static com.cornez.paintscene.R.drawable.mine;
import static com.cornez.paintscene.R.drawable.one;
import static com.cornez.paintscene.R.drawable.two;


public class MyActivity extends Activity {

    ViewGroup paintingContainer;
    ArrayList<ImageView> blockViewsList=new ArrayList<>();
    ArrayList<Block> blocksList=new ArrayList<>();
    ArrayList<String> viewTagsList=new ArrayList<String>();
    TextView result;
    ArrayList<Integer> minesPos=randomMinesPositions(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);
        setContentView(R.layout.scene01);

        result=(TextView)findViewById(R.id.textView);

        for(int i=0;i<25;i++)
        {
            blocksList.add(new Block());
        }

        for(int i=0;i<25;i++){
            viewTagsList.add("r"+String.valueOf(i/5+1)+"c"
                    +String.valueOf(i%5+1));
        }

        blockViewsList.add((ImageView) findViewById(R.id.r1c1));
        blockViewsList.add((ImageView) findViewById(R.id.r1c2));
        blockViewsList.add((ImageView) findViewById(R.id.r1c3));
        blockViewsList.add((ImageView) findViewById(R.id.r1c4));
        blockViewsList.add((ImageView) findViewById(R.id.r1c5));
        blockViewsList.add((ImageView) findViewById(R.id.r2c1));
        blockViewsList.add((ImageView) findViewById(R.id.r2c2));
        blockViewsList.add((ImageView) findViewById(R.id.r2c3));
        blockViewsList.add((ImageView) findViewById(R.id.r2c4));
        blockViewsList.add((ImageView) findViewById(R.id.r2c5));
        blockViewsList.add((ImageView) findViewById(R.id.r3c1));
        blockViewsList.add((ImageView) findViewById(R.id.r3c2));
        blockViewsList.add((ImageView) findViewById(R.id.r3c3));
        blockViewsList.add((ImageView) findViewById(R.id.r3c4));
        blockViewsList.add((ImageView) findViewById(R.id.r3c5));
        blockViewsList.add((ImageView) findViewById(R.id.r4c1));
        blockViewsList.add((ImageView) findViewById(R.id.r4c2));
        blockViewsList.add((ImageView) findViewById(R.id.r4c3));
        blockViewsList.add((ImageView) findViewById(R.id.r4c4));
        blockViewsList.add((ImageView) findViewById(R.id.r4c5));
        blockViewsList.add((ImageView) findViewById(R.id.r5c1));
        blockViewsList.add((ImageView) findViewById(R.id.r5c2));
        blockViewsList.add((ImageView) findViewById(R.id.r5c3));
        blockViewsList.add((ImageView) findViewById(R.id.r5c4));
        blockViewsList.add((ImageView) findViewById(R.id.r5c5));

        setMine(minesPos);

    }


    public ArrayList<Integer> randomMinesPositions(int number){
        ArrayList<Integer> pos = new ArrayList<>();
        int val;
        java.util.Random r=new java.util.Random();
        for(int i=0;i<number;i++) {
            val = r.nextInt() % 25;
            if(val<0){
                val=-val;
            }
            if (pos.contains(val)) {
                i--;
            } else {
                pos.add(val);
            }

        }
        return pos;
    }
    public void setMine(ArrayList<Integer> minesPos){

        for(int i=0;i<minesPos.size();i++) {
            blocksList.get(minesPos.get(i)).setMine();
        }

        for(int i=0;i<minesPos.size();i++) {
            if(inRange(minesPos.get(i)-6)&&inLastCol(minesPos.get(i),minesPos.get(i)-6)&&inLastRow(minesPos.get(i),minesPos.get(i)-6)){
                blocksList.get(minesPos.get(i)-6).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)-6).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)-5)&&inSameCol(minesPos.get(i),minesPos.get(i)-5)&&inLastRow(minesPos.get(i),minesPos.get(i)-5)){
                blocksList.get(minesPos.get(i)-5).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)-5).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)-4)&&inNextCol(minesPos.get(i),minesPos.get(i)-4)&&inLastRow(minesPos.get(i),minesPos.get(i)-4)){
                blocksList.get(minesPos.get(i)-4).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)-4).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)-1)&&inLastCol(minesPos.get(i),minesPos.get(i)-1)&&inSameRow(minesPos.get(i),minesPos.get(i)-1)){
                blocksList.get(minesPos.get(i)-1).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)-1).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)+1)&&inNextCol(minesPos.get(i),minesPos.get(i)+1)&&inSameRow(minesPos.get(i),minesPos.get(i)+1)){
                blocksList.get(minesPos.get(i)+1).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)+1).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)+4)&&inLastCol(minesPos.get(i),minesPos.get(i)+4)&&inNextRow(minesPos.get(i),minesPos.get(i)+4)){
                blocksList.get(minesPos.get(i)+4).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)+4).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)+5)&&inSameCol(minesPos.get(i),minesPos.get(i)+5)&&inNextRow(minesPos.get(i),minesPos.get(i)+5)){
                blocksList.get(minesPos.get(i)+5).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)+5).getNumOfAdjacentMine()+1);
            }
            if(inRange(minesPos.get(i)+6)&&inNextCol(minesPos.get(i),minesPos.get(i)+6)&&inNextRow(minesPos.get(i),minesPos.get(i)+6)){
                blocksList.get(minesPos.get(i)+6).setNumOfAdjacentMine(blocksList.get(minesPos.get(i)+6).getNumOfAdjacentMine()+1);
            }
        }

    }

    public void judge(){
        int count=25;
        for(int i=0;i<25;i++)
        {
            if(blocksList.get(i).isOpened()){
                count-=1;
            }
        }
        if(count<=2){
            result.setText("You Win!");
        }
    }

    public void reset(View view){
        blocksList.clear();
        for(int i=0;i<25;i++)
        {
            blocksList.add(new Block());
        }
        for(int i=0;i<25;i++)
        {
            blockViewsList.get(i).setImageResource(hide);
        }
        result.setText("");
        minesPos.clear();
        minesPos=randomMinesPositions(2);
        setMine(minesPos);
    }

    public void clickBlock(View view){

        int positionInViewList=viewTagsList.indexOf(view.getTag().toString());
        if(blocksList.get(positionInViewList).getMine()){
            //blockViewsList.get(positionInViewList).setImageResource(mine);
            result.setText("You Lose!");
            for(int i=0;i<25;i++)
            {
                if(blocksList.get(i).getMine()){
                    blockViewsList.get(i).setImageResource(mine);
                }
            }
        }
        else if(blocksList.get(positionInViewList).getNumOfAdjacentMine()==1){
            blocksList.get(positionInViewList).setOpened();

            blockViewsList.get(positionInViewList).setImageResource(one);
        }
        else if(blocksList.get(positionInViewList).getNumOfAdjacentMine()==2){
            blocksList.get(positionInViewList).setOpened();

            blockViewsList.get(positionInViewList).setImageResource(two);
        }
        else {
            blocksList.get(positionInViewList).setOpened();

            blockViewsList.get(positionInViewList).setImageResource(blankspace);

            if(inRange(positionInViewList-6)&&inLastCol(positionInViewList,positionInViewList-6)&&inLastRow(positionInViewList,positionInViewList-6)){
                if(!blocksList.get(positionInViewList-6).getMine()) {
                    blocksList.get(positionInViewList-6).setOpened();
                    if(blocksList.get(positionInViewList-6).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList-6).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList-6).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList - 6).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList - 6).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList-5)&&inSameCol(positionInViewList,positionInViewList-5)&&inLastRow(positionInViewList,positionInViewList-5)){
                if(!blocksList.get(positionInViewList-5).getMine()) {
                    blocksList.get(positionInViewList-5).setOpened();
                    if(blocksList.get(positionInViewList-5).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList-5).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList-5).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList - 5).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList - 5).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList-4)&&inNextCol(positionInViewList,positionInViewList-4)&&inLastRow(positionInViewList,positionInViewList-4)){
                if(!blocksList.get(positionInViewList-4).getMine()) {
                    blocksList.get(positionInViewList-4).setOpened();
                    if(blocksList.get(positionInViewList-4).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList-4).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList-4).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList - 4).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList - 4).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList-1)&&inLastCol(positionInViewList,positionInViewList-1)&&inSameRow(positionInViewList,positionInViewList-1)){
                if(!blocksList.get(positionInViewList-1).getMine()) {
                    blocksList.get(positionInViewList-1).setOpened();
                    if(blocksList.get(positionInViewList-1).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList-1).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList-1).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList - 1).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList - 1).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList+1)&&inNextCol(positionInViewList,positionInViewList+1)&&inSameRow(positionInViewList,positionInViewList+1)){
                if(!blocksList.get(positionInViewList+1).getMine()) {
                    blocksList.get(positionInViewList+1).setOpened();
                    if(blocksList.get(positionInViewList+1).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList+1).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList+1).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList +1).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList +1).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList+4)&&inLastCol(positionInViewList,positionInViewList+4)&&inNextRow(positionInViewList,positionInViewList+4)){
                if(!blocksList.get(positionInViewList+4).getMine()) {
                    blocksList.get(positionInViewList+4).setOpened();
                    if(blocksList.get(positionInViewList+4).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList+4).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList+4).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList +4).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList +4).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList+5)&&inSameCol(positionInViewList,positionInViewList+5)&&inNextRow(positionInViewList,positionInViewList+5)){
                if(!blocksList.get(positionInViewList+5).getMine()) {
                    blocksList.get(positionInViewList+5).setOpened();
                    if(blocksList.get(positionInViewList+5).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList+5).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList+5).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList +5).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList +5).setImageResource(blankspace);
                    }
                }
            }
            if(inRange(positionInViewList+6)&&inNextCol(positionInViewList,positionInViewList+6)&&inNextRow(positionInViewList,positionInViewList+6)){
                if(!blocksList.get(positionInViewList+6).getMine()) {
                    blocksList.get(positionInViewList+6).setOpened();
                    if(blocksList.get(positionInViewList+6).getNumOfAdjacentMine()==1)
                    {
                        blockViewsList.get(positionInViewList+6).setImageResource(one);
                    }
                    else if(blocksList.get(positionInViewList+6).getNumOfAdjacentMine()==2)
                    {
                        blockViewsList.get(positionInViewList +6).setImageResource(two);
                    }
                    else
                    {
                        blockViewsList.get(positionInViewList +6).setImageResource(blankspace);
                    }
                }
            }
        }
        judge();

    }


    public boolean inNextRow(int currentPos,int targetPos){
        if(targetPos/5==currentPos/5+1)
            return true;
        else
            return false;
    }

    public boolean inLastRow(int currentPos,int targetPos){
        if(targetPos/5==currentPos/5-1)
            return true;
        else
            return false;
    }

    public boolean inSameRow(int currentPos,int targetPos){
        if(targetPos/5==currentPos/5)
            return true;
        else
            return false;
    }

    public boolean inNextCol(int currentPos,int targetPos){
        if(targetPos%5==currentPos%5+1)
            return true;
        else
            return false;
    }

    public boolean inRange(int targetPos){
        return targetPos>=0&&targetPos<25;
    }

    public boolean inLastCol(int currentPos,int targetPos){
        if(targetPos%5==currentPos%5-1)
            return true;
        else
            return false;
    }

    public boolean inSameCol(int currentPos,int targetPos){
        if(targetPos%5==currentPos%5)
            return true;
        else
            return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
