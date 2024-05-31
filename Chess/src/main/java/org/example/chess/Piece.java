package org.example.chess;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import static org.example.chess.Board.*;

import java.util.ArrayList;


abstract public class Piece extends ImageView {

    Color color ;
    int row , col ;
    public boolean isProtected = false;

    ArrayList<String> possMoves = new ArrayList<>();

    public String piece_type;

    Piece(Color color , int row , int col){
        this.row = row ;
        this.col = col ;
        this.color = color;

    }

    boolean isValid(String move){
        if(!getTielByName(move).isoOccupied){
            getTielByName(move).isoOccupied=true;
            getTielByName(move).setPiece(this);
            getTielByName((this.row+" "+this.col)).isoOccupied=false;
            boolean changed=false;
            if(Game.isKingChecked()){
                getTielByName(move).isoOccupied=false;
                getTielByName(move).setPiece(null);

                getTielByName((this.row+" "+this.col)).isoOccupied=true;
                changed=true;
                return false;
            }
            else{
                getTielByName(move).isoOccupied=false;
                getTielByName(move).setPiece(null);

                getTielByName((this.row+" "+this.col)).isoOccupied=true;
                return true;
            }
        }
        else{
            Piece oldPiece = getTielByName(move).getPiece();
            getTielByName(move).setPiece(this);
            getTielByName((this.row+" "+this.col)).setPiece(null);
            getTielByName((this.row+" "+this.col)).isoOccupied=false;
            if(Game.isKingChecked()){
                getTielByName(move).setPiece(oldPiece);
                getTielByName((this.row+" "+this.col)).setPiece(this);
                getTielByName((this.row+" "+this.col)).isoOccupied=true;
                return false;
            }
            getTielByName(move).setPiece(oldPiece);
            getTielByName((this.row+" "+this.col)).setPiece(this);
            getTielByName((this.row+" "+this.col)).isoOccupied=true;
            return true;




        }
    }
    abstract public boolean searchForKing();
    abstract protected void storeAllPossibleMoves();

    public static Tiel getTielByName(String search ){
        int row = search.charAt(0) - '0';
        int col = search.charAt(2) - '0';
        return board_tiels[row][col];
    }


    public void showAllPossMoves(){
        for(String move : possMoves){
            Tiel tiel;
            Glow glow = new Glow();
            glow.setLevel(0.8);

            // Normal move
            if(move.length()==3){
                tiel = getTielByName(move);
                if(!tiel.isoOccupied){
                    tiel.setEffect(glow);

                }
            }
            else if(move.length()==4){
                tiel=getTielByName(move);
                if( tiel.isoOccupied && tiel.getPieceColor()!=this.color){
                    tiel.setBackground(new Background(new BackgroundFill(Color.rgb(200, 7 , 7), CornerRadii.EMPTY, Insets.EMPTY)));
                }


            }
            else if(move.length()==7){
                tiel=getTielByName(move);
                tiel.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }


    public void hidePossMoves() {
        for(String move : possMoves){
            Tiel tiel = getTielByName(move);
            tiel.setEffect(null);
            if((tiel.row+tiel.col)%2==0) {
                tiel.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else{
                tiel.setBackground(new Background(new BackgroundFill(Color.rgb(60, 20 , 4), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
        possMoves.clear();
    }

    public boolean isFromThePossMoves(Tiel tiel){
        for (String move : possMoves){
            if(tiel == getTielByName(move)) {
                return true;
            }

        }
        return false;
    }
    abstract public void calcProtectedTiels();


}
