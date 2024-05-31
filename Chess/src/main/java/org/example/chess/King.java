package org.example.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class King extends Piece {

    public boolean moved_before=false;
    King(Color color, int row, int col) {
        super(color, row, col);
        this.piece_type = "king";
        if(color == Color.WHITE){
            setImage(new Image("Piecs Imgs/White/White_King.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
        else {
            setImage(new Image("Piecs Imgs/Black/Black_King.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
    }

    @Override
    public boolean searchForKing() {
        String move = (this.row+1)+" "+(this.col+1);
        if( isValid((this.row+1) ,(this.col+1))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }

        move = (this.row+1)+" "+(this.col-1);
        if(isValid((this.row+1) , (this.col-1))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }

        move = (this.row)+" "+(this.col+1);
        if(isValid((this.row) , (this.col+1))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }
        }


        move = (this.row)+" "+(this.col-1);
        if(isValid((this.row) , (this.col-1))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }


        move = (this.row+1)+" "+(this.col);
        if(isValid((this.row+1) , (this.col))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col);
        if(isValid((this.row-1) , (this.col))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col-1);
        if( isValid((this.row-1) , (this.col-1))  ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col+1);
        if( isValid((this.row-1) , (this.col+1)) ){
            if(getTielByName(move).isoOccupied ){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }

                }
            }

        }


        return false;


    }

    @Override
    protected void storeAllPossibleMoves() {
        /* Moves :
         *   row +1 , col + 1
         *  row +1 , col - 1
         *  row  , col + 1
         *  row  , col - 1
         *  row +1 , col
         * row -1 , col
         * row -1 , col -1
         * row -1 , col +1
         * */

        String move = (this.row+1)+" "+(this.col+1);
        if( isValid((this.row+1) ,(this.col+1))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied ){

                    possMoves.add(move);
                    getTielByName(move).isProtected=true;

                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }
                }
            }

        }

        move = (this.row+1)+" "+(this.col-1);
        if(isValid((this.row+1) , (this.col-1))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied ){

                    possMoves.add(move);
                    getTielByName(move).isProtected=true;

                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }

                }
            }

        }

        move = (this.row)+" "+(this.col+1);
        if(isValid((this.row) , (this.col+1))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied ){
                    possMoves.add(move);
                    getTielByName(move).isProtected=true;


                    move = (this.row)+" "+(this.col+2);
                    if(isValid((this.row) , (this.col+2))&&isValid(move) &&!moved_before &&
                            getTielByName(this.row+" "+(this.col+3)).getPiece()!=null&&
                            (!getTielByName(move).isoOccupied) &&
                            getTielByName(this.row+" "+(this.col+3)).getPiece().piece_type.equals("rook")){

                        System.out.println("GETTING the Castling Rook");
                        Rook rook = (Rook) getTielByName(this.row+" "+(this.col+3)).getPiece();
                        if(!rook.moved_before){
                            possMoves.add(move+"cast");
                        }
                        System.out.println("GOT IT");
                    }
                } else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }
                }
            }
        }



        move = (this.row)+" "+(this.col-1);
        if(isValid((this.row) , (this.col-1))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied){
                    possMoves.add(move);
                    getTielByName(move).isProtected=true;
                    move = (this.row)+" "+(this.col-2);
                    if(isValid((this.row) , (this.col-2))&&isValid(move) && !moved_before && getTielByName(this.row+" "+(this.col-4)).getPiece()!=null&&
                            (!getTielByName(move).isoOccupied) &&
                            getTielByName(this.row+" "+(this.col-4)).getPiece().piece_type.equals("rook")){

                        Rook rook = (Rook) getTielByName(this.row+" "+(this.col-4)).getPiece();
                        if(!rook.moved_before){
                            possMoves.add(move+"cast");
                        }
                    }
                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }

                }
            }

        }


        move = (this.row+1)+" "+(this.col);
        if(isValid((this.row+1) , (this.col))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied ){

                    possMoves.add(move);
                    getTielByName(move).isProtected=true;


                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col);
        if(isValid((this.row-1) , (this.col))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied ){

                    possMoves.add(move);
                    getTielByName(move).isProtected=true;


                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col-1);
        if( isValid((this.row-1) , (this.col-1))  ){
            if(isValid(move)){
                if(!getTielByName(move).isoOccupied ){

                    possMoves.add(move);
                    getTielByName(move).isProtected=true;

                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        if(!getTielByName(move).getPiece().isProtected){
                            possMoves.add(move+'k');
                        }
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col+1);
        if( isValid((this.row-1) , (this.col+1)) ){
            if (isValid(move)){
                if(!getTielByName(move).isoOccupied ){

                    possMoves.add(move);
                    getTielByName(move).isProtected=true;

                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        possMoves.add(move+'k');
                    }

                }
            }

        }





    }

    @Override
    public void calcProtectedTiels() {
        String move = (this.row+1)+" "+(this.col+1);
        if( isValid((this.row+1) ,(this.col+1))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }
                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }
                }
            }

        }

        move = (this.row+1)+" "+(this.col-1);
        if(isValid((this.row+1) , (this.col-1))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }
                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }

                }
            }

        }

        move = (this.row)+" "+(this.col+1);
        if(isValid((this.row) , (this.col+1))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }
                } else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }
                }


            }
        }


        move = (this.row)+" "+(this.col-1);
        if(isValid((this.row) , (this.col-1))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }
                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }

                }
            }

        }


        move = (this.row+1)+" "+(this.col);
        if(isValid((this.row+1) , (this.col))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }

                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col);
        if(isValid((this.row-1) , (this.col))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }

                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col-1);
        if( isValid((this.row-1) , (this.col-1))  ){
            if(!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }
                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                        if(!getTielByName(move).getPiece().isProtected){
                        }
                    }

                }
            }

        }


        move = (this.row-1)+" "+(this.col+1);
        if( isValid((this.row-1) , (this.col+1)) ){
            if (!getTielByName(move).isProtected){
                if(!getTielByName(move).isoOccupied ){
                    if(!getTielByName(move).isProtected){
                        getTielByName(move).isProtected=true;
                    }
                }
                else {
                    if(getTielByName(move).getPiece().color == color){
                        getTielByName(move).isProtected=true;
                    }
                    else if(getTielByName(move).getPiece().color != color){
                    }

                }
            }

        }
    }

    private boolean isValid(int row , int col ){
        if((row>=0 && row < 8) && (col >= 0 && col < 8))
            return true;
        else return false;
    }

    public boolean isCaslingMove(Tiel tiel){
        int col1 = tiel.col;
        int row1 = tiel.row;
        String tiel1 = (tiel.row+" " +col1+"cast");
        for(String i : possMoves){
            if(i.equals(tiel1)){
                return true;
            }
        }
        return false;
    }

}
