package com.inzulus.chessandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class GameField extends Activity implements View.OnTouchListener {

    boolean selectFigure = false;
    int figureID = 99;
    int positionOld = 0;

    int[][] field = {{5,4,3,2,1,3,4,5},{6,6,6,6,6,6,6,6},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}
                    ,{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{12,12,12,12,12,12,12,12},{11,10,9,8,7,9,10,11}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        final GridView gridViewBackground = (GridView) findViewById(R.id.gridView1);
        FieldAdapter fieldAdapter = new FieldAdapter(this);
        gridViewBackground.setAdapter(fieldAdapter);

        final GridView gridView = (GridView) findViewById(R.id.gridView2);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(GameField.this, "" + position, Toast.LENGTH_SHORT).show();

                if (((ImageAdapter) gridView.getAdapter()).checkEmpty(position) == false) {
                    figureID = ((ImageAdapter) gridView.getAdapter()).getFigureId(position);
                    positionOld = position;
                    selectFigure = true;
                }

                if (((ImageAdapter) gridView.getAdapter()).checkEmpty(position) == true && selectFigure == true) {
                    if (turnValid(positionOld,position,figureID) ==true) {
                        ((ImageAdapter) gridView.getAdapter()).setFigure(position, figureID);
                        ((ImageAdapter) gridView.getAdapter()).setEmpty(positionOld);
                        selectFigure = false;
                    }
                }

                //((ImageAdapter) gridView.getAdapter()).setFigure(position, 1);
            }
        });
    }

    public boolean turnValid(int positionOld, int position, int figID){
        //converting postion into x,y
        int yOld = positionOld/8;
        int xOld = positionOld - yOld*8;

        int y = position/8;
        int x = position - y*8;

        //Black Pawn
        if(figID == 12) {
            if (y - yOld == 1 && x - xOld == 0 ){
                return true;
            }
        }
        //White Pawn
        if(figID == 6){
            if (y - yOld == -1 && x - xOld == 0 ){
                return true;
            }
        }

        //King
        if(figID == 1 || figID == 7){
            if (y - yOld >= -1 && y - yOld <= 1 && x - xOld <= 1 && x - xOld >= -1) {
                return true;
            }
        }
        //Queen
        if(figID == 2 || figID == 8){
            return true;
        }
        //Bishop
        if(figID == 3 || figID == 9){
            return true;
        }
        //Knight
        if(figID == 4 || figID == 10){
            return true;
        }
        //Rook
        if(figID == 5 || figID == 11){
            if(y-yOld == 0 || x-xOld == 0) {
                return true;
            }
        }

        return false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_field, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ScaleGestureDetector sgc = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                return false;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return false;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

            }
        });
        sgc.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
