package org.example.chess;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Tiel extends StackPane {
    public int row , col ;
    boolean isoOccupied;
    public boolean isProtected = false;

    Color color ;
    private Piece piece;


    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tiel(int row , int col){
        this.color = color;
        this.row=row;
        this.col=col;
        this.isoOccupied=false;
//        this.isLight = (row + col)%2==0 ;
        setPrefWidth(100);
        setPrefHeight(100);

        if((row+col)%2==0) {
            setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else{
            setBackground(new Background(new BackgroundFill(Color.rgb(60, 20 , 4), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public Tiel(){

    }



    public void addPiece(Piece piece) {
        this.getChildren().add(piece);
        this.piece = piece;
        this.isoOccupied=true;
    }
    public Piece getPiece(){
        return this.piece;
    }

    public Color getPieceColor() {
        if(this.piece!=null){
            return this.piece.color;
        }
        else return null;
    }




}
