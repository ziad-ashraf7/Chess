package org.example.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Knight extends Piece {

    Knight(Color color, int row, int col) {
        super(color, row, col);
        this.piece_type = "knight";

        if(color == Color.WHITE){
            setImage(new Image("Piecs Imgs/White/White_Knight.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
        else {
            setImage(new Image("Piecs Imgs/Black/Black_Knight.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
    }

    @Override
    public boolean searchForKing() {
        String move ;
        move = (this.row+2)+" "+(this.col-1);
        if(isValid((this.row+2) , (this.col-1))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }
        }

        move = (this.row+2)+" "+(this.col+1);
        if(isValid((this.row+2) , (this.col+1))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }


        }




        move = (this.row-2)+" "+(this.col-1);
        if(isValid((this.row-2), (this.col-1))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }


        }




        move = (this.row-2)+" "+(this.col+1);
        if(isValid((this.row-2) , (this.col+1))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }


        }



        move = (this.row+1)+" "+(this.col+2);
        if(isValid((this.row+1) , (this.col+2))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }

        }





        move = (this.row-1)+" "+(this.col+2);
        if(isValid((this.row-1) , (this.col+2))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }


        }



        move = (this.row+1)+" "+(this.col-2);
        if(isValid((this.row+1) , (this.col-2))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }


        }



        move = (this.row-1)+" "+(this.col-2);
        if(isValid((this.row-1) , (this.col-2))){
            if(getTielByName(move).isoOccupied && getTielByName(move).getPiece().color!=this.color){
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    return true;
                }

            }


        }
        return false;
    }

    @Override
    protected void storeAllPossibleMoves() {

        /* Moves :
         *  row+2 -> ( col-1 , col+1 )
         *  row-2 -> ( col-1 , col+1 )
         *  col+2 -> ( row-1 , row+1 )
         *  col-2 -> ( row-1 , row+1 )
         *
         *
         * */
        String move ;
        move = (this.row+2)+" "+(this.col-1);
        if(isValid((this.row+2) , (this.col-1))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }


        }

        move = (this.row+2)+" "+(this.col+1);
        if(isValid((this.row+2) , (this.col+1))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }



        }




        move = (this.row-2)+" "+(this.col-1);
        if(isValid((this.row-2), (this.col-1))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }



        }




        move = (this.row-2)+" "+(this.col+1);
        if(isValid((this.row-2) , (this.col+1))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }


        }



        move = (this.row+1)+" "+(this.col+2);
        if(isValid((this.row+1) , (this.col+2))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }

        }





        move = (this.row-1)+" "+(this.col+2);
        if(isValid((this.row-1) , (this.col+2))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }


        }



        move = (this.row+1)+" "+(this.col-2);
        if(isValid((this.row+1) , (this.col-2))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }


        }



        move = (this.row-1)+" "+(this.col-2);
        if(isValid((this.row-1) , (this.col-2))){
            if(isValid(move)){
                if(getTielByName(move).isoOccupied){
                    if(getTielByName(move).getPiece().color!=this.color){
                        if(getTielByName(move).getPiece().piece_type.equals("king")){
                            possMoves.add(move+"kng");
                        }
                        else{
                            possMoves.add(move+'k');

                        }
                    }
                }
                else{
                    possMoves.add(move);



                }

            }


        }


    }

    @Override
    public void calcProtectedTiels() {
        String move ;
        move = (this.row+2)+" "+(this.col-1);
        if(isValid((this.row+2) , (this.col-1))){

            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;
            }

        }

        move = (this.row+2)+" "+(this.col+1);
        if(isValid((this.row+2) , (this.col+1))){
            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            } else{
                getTielByName(move).isProtected = true;


            }


        }




        move = (this.row-2)+" "+(this.col-1);
        if(isValid((this.row-2), (this.col-1))){
            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;


            }


        }




        move = (this.row-2)+" "+(this.col+1);
        if(isValid((this.row-2) , (this.col+1))){

            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;


            }


        }



        move = (this.row+1)+" "+(this.col+2);
        if(isValid((this.row+1) , (this.col+2))){

            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;


            }

        }





        move = (this.row-1)+" "+(this.col+2);
        if(isValid((this.row-1) , (this.col+2))){

            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;


            }


        }



        move = (this.row+1)+" "+(this.col-2);
        if(isValid((this.row+1) , (this.col-2))){

            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;


            }


        }



        move = (this.row-1)+" "+(this.col-2);
        if(isValid((this.row-1) , (this.col-2))){
            if (getTielByName(move).isoOccupied && getTielByName(move).getPiece().color==this.color) {
                getTielByName(move).isProtected=true;

            }
            else{
                getTielByName(move).isProtected = true;


            }


        }
    }

    private boolean isValid(int row , int col){
        String move = row+" "+col;
        return  (row < 8 && row >= 0) && (col < 8 && col >= 0)  ;
    }

}
