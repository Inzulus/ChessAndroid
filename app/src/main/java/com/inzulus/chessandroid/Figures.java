package com.inzulus.chessandroid;

/**
 * Created by Julius on 23.09.2015.
 */
public class Figures {

    private int position = -1;
    private int positionX = -1;
    private int positionY = -1;
    private int figureID = -1;


    public void convertToPositionXY(){
        positionY = position/8;
        positionX = position - positionY*8;
    }

    public void convertToPosition(){
        position = positionX + 8 * positionY;
    }
    //Getter and Setter

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getFigureID() {
        return figureID;
    }

    public void setFigureID(int figureID) {
        this.figureID = figureID;
    }
}
