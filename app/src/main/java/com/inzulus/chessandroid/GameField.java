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

    int[][] field = new int[7][7];
    boolean selectFigure = false;
    int figureID = 99;
    int positionOld = 0;

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
                    ((ImageAdapter) gridView.getAdapter()).setFigure(position, figureID);
                    ((ImageAdapter) gridView.getAdapter()).setEmpty(positionOld);
                    selectFigure = false;
                }

                //((ImageAdapter) gridView.getAdapter()).setFigure(position, 1);
            }
        });
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
