package org.example.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Bishop extends Piece{

    Bishop(Color color, int row, int col) {

        super(color, row, col);
        this.piece_type = "bishop";
        if(color == Color.WHITE){
            setImage(new Image("Piecs Imgs/White/White_Bishop.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
        else {
            setImage(new Image("Piecs Imgs/Black/Black_Bishop.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
    }


    @Override
    public boolean searchForKing() {
        String move;
        int row = this.row-1 ; int col = this.col-1;
        while (row >= 0 && col >= 0){
            move=row+" "+col;

            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }
                    else{
                        break;
                    }


                } else {
                    break;
                }
            }

            row--;
            col--;
        }
        row = this.row-1;col = this.col+1;
        while (row >= 0 && col < 8){
            move = row+" "+col;
            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }
                    else{
                        break;
                    }


                } else {
                    break;
                }
            }
            row--;
            col++;
        }

        row = this.row+1 ; col = this.col+1;
        while (row < 8 && col < 8){
            move = row + " "+col;
            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }
                    else{
                        break;
                    }


                } else {
                    break;
                }
            }

            row++;
            col++;
        }


        row = this.row+1; col = this.col-1;
        while (row < 8 && col >= 0){
            move =row+" "+col;
            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return true;
                    }
                    else{
                        break;
                    }


                } else {
                    break;
                }
            }
            row++;
            col--;
        }
        return false;
    }

    @Override
    protected void storeAllPossibleMoves() {
        String move;
        int row = this.row-1 ; int col = this.col-1;
        while (row >= 0 && col >= 0){
            move=row+" "+col;
            if(!getTielByName(move).isoOccupied){
                if (isValid(move)){
                    possMoves.add(move);

                }
            }
            else{
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        possMoves.add(move+"kng");

                    }
                    else{
                        if(isValid(move)){
                            possMoves.add(move+'k');
                        }
                    }
                    break;

                } else if (getTielByName(move).getPiece().color == this.color) {
                    break;
                } else break;
            }

            row--;
            col--;
        }
        row = this.row-1;col = this.col+1;
        while (row >= 0 && col < 8){
            move = row+" "+col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);
                }

            }
            else{
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        possMoves.add(move+"kng");

                    }
                    else{
                        if(isValid(move)){
                            possMoves.add(move+'k');
                        }
                    }                    break;

                }
                else if (getTielByName(move).getPiece().color == this.color) {
                    break;
                }
                else break;

            }
            row--;
            col++;
        }

        row = this.row+1 ; col = this.col+1;
        while (row < 8 && col < 8){
            move = row + " "+col;
            if(!getTielByName(move).isoOccupied){
                if (isValid(move)){
                    possMoves.add(move);

                }

            }
            else{
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        possMoves.add(move+"kng");

                    }
                    else{
                        possMoves.add(move+"k");

                    }
                    break;

                }
                else if (getTielByName(move).getPiece().color == this.color) {
                    break;
                }
                else break;

            }

            row++;
            col++;
        }


        row = this.row+1; col = this.col-1;
        while (row < 8 && col >= 0){
            move =row+" "+col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);

                }

            }
            else{
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        possMoves.add(move+"kng");

                    }
                    else{
                        if(isValid(move)){

                            possMoves.add(move+'k');
                        }
                    }
                    break;

                }
                else if (getTielByName(move).getPiece().color == this.color) {
                    break;
                }
                else break;

            }
            row++;
            col--;
        }


    }

    @Override
    public void calcProtectedTiels() {
        String move;
        int row = this.row-1 ; int col = this.col-1;
        while (row >= 0 && col >= 0){
            move=row+" "+col;
            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;
            }
            else{
                if(getTielByName(move).getPiece().color != this.color){
                    break;
                } else if (getTielByName(move).getPiece().color == this.color) {
                    getTielByName(move).isProtected=true;
                    break;
                } else break;
            }

            row--;
            col--;
        }
        row = this.row-1;col = this.col+1;
        while (row >= 0 && col < 8){
            move = row+" "+col;
            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;

            }
            else{
                if(getTielByName(move).getPiece().color != this.color){
                    break;

                }
                else if (getTielByName(move).getPiece().color == this.color) {
                    getTielByName(move).isProtected=true;
                    break;
                }
                else break;

            }
            row--;
            col++;
        }

        row = this.row+1 ; col = this.col+1;
        while (row < 8 && col < 8){
            move = row + " "+col;
            if(!getTielByName(move).isoOccupied){
                possMoves.add(move);
                getTielByName(move).isProtected = true;

            }
            else{
                if(getTielByName(move).getPiece().color != this.color){

                    break;

                }
                else if (getTielByName(move).getPiece().color == this.color) {
                    getTielByName(move).isProtected=true;
                    break;
                }
                else break;

            }

            row++;
            col++;
        }


        row = this.row+1; col = this.col-1;
        while (row < 8 && col >= 0){
            move =row+" "+col;
            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;

            }
            else{
                if(getTielByName(move).getPiece().color != this.color){

                    break;

                }
                else if (getTielByName(move).getPiece().color == this.color) {
                    getTielByName(move).isProtected=true;
                    break;
                }
                else break;

            }
            row++;
            col--;
        }
    }
}
