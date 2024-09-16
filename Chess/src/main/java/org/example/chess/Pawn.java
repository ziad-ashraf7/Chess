package org.example.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Pawn extends Piece{







    /* The constaractor is taking the Color of the Piece and the position of it
    *
    *
    *
    * */
    public Pawn(Color color , int row , int col){
        super(color , row , col);
        this.piece_type = "pawn";

        if(color == Color.WHITE){
            setImage(new Image("Piecs Imgs/White/White_Pawn.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
        else {
            setImage(new Image("Piecs Imgs/Black/Black_Pawn.png"));
            setFitHeight(100);
            setFitWidth(100);
        }

    }
    @Override
    public Piece searchForKing() {
        return null;
    }

    @Override
    protected void storeAllPossibleMoves() {
        if(this.color == Color.WHITE){
            storeWhiteMoves();
        }
        else if(this.color == Color.BLACK ){
            storeBlackMoves();



        }


    }

    private void storeBlackMoves(){
        if(this.row == 1){
            // first Move for the Black pawn
            String move = (this.row+1)+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);
                }

                move = (this.row+2)+" "+this.col;
                if(!getTielByName(move).isoOccupied){
                    if(isValid(move)){
                        possMoves.add(move);
                    }

                }
            }


            // Killing Moves
            if((col-1) >= 0 ){
                move = (this.row+1)+" "+(this.col-1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){
                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }

                }

            }
            if((col+1) < 8 ){
                move = (this.row+1)+" "+(this.col+1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){
                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }

                }

            }
        }

        else {
            // Moving one move
            if((row+1) < 8 ){
                String move = (this.row+1)+" "+this.col;
                if(!getTielByName(move).isoOccupied){
                    if (isValid(move)){
                        possMoves.add(move);
                    }

                }

            }


            if((row+1) < 8 && (col-1)>=0){
                String move = (this.row+1)+" "+(this.col-1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){
                    if(isValid(move)){
                        possMoves.add(move+'k');

                    }
                }

            }
            if((row+1) < 8 && (col+1) < 8){
                String move = (this.row+1)+" "+(this.col+1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){
                    if(isValid(move)){
                        possMoves.add(move+'k');

                    }
                }

            }
        }



    }

    private void storeWhiteMoves(){
        if(this.row==6){
            String move= (this.row-1)+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);
                }


                move = (this.row-2)+" "+this.col;
                if(!getTielByName(move).isoOccupied){
                    if(isValid(move)){
                        possMoves.add(move);
                    }
                }
            }

            // Killing Moves
            if((col-1) >= 0 ){
                move = (this.row-1)+" "+(this.col-1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){

                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }


                }

            }
            if((col+1) < 8 ){
                move =(this.row-1)+" "+(this.col+1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){

                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }


                }

            }
        }

        // in any other row
        else {
            if((row-1) >=0 ){
                String move = (this.row-1)+" "+this.col;
                if(!getTielByName(move).isoOccupied){
                    if(isValid(move)){
                        possMoves.add(move);
                        if((row-1) == 0){
                            promotes(this);
                        }
                    }

                }

            }
            if((row-1) >= 0 && (col-1) >= 0){
                String move =(this.row-1)+" "+(this.col-1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){


                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }


                }

            }
            if((row-1) >= 0 && (col+1) < 8 ){
                String move =(this.row-1)+" "+(this.col+1);
                if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color != this.color){


                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }


                }

            }

        }
    }
    private void promotes(Pawn pawn) {

    }

    @Override
    public void calcProtectedTiels() {

    }
}
