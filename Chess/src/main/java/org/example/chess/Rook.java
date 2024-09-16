package org.example.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Rook extends Piece{

    public boolean moved_before=false;
    Rook(Color color, int row, int col) {
        super(color, row, col);
        this.piece_type="rook";
        if(color == Color.WHITE){
            setImage(new Image("Piecs Imgs/White/White_Rook.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
        else {
            setImage(new Image("Piecs Imgs/Black/Black_Rook.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
    }


    @Override
    protected void storeAllPossibleMoves() {
        HMoves();
        VMoves();
    }


    @Override
    public void calcProtectedTiels() {
        for (int row = this.row+1; row <8 ; row++) {
            String move = row+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).isProtected=true;
                break;
            }
            else{
                break;
            }
        }
        for (int row = this.row-1; row >= 0 ; row--) {
            String move = row+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).isProtected=true;
                break;
            }
            else {
                break;
            }
        }


        for (int col = this.col+1; col <8 ; col++) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;


            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).isProtected=true;
                break;
            }
            else{
                break;
            }
            // another color of the piece


        }
        for (int col = this.col-1; col >= 0 ; col--) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).isProtected=true;
                break;
            }
            else {
                break;
            }


        }


    }


    private void HMoves() {
        for (int row = this.row+1; row <8 ; row++) {
            String move = row+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);
                }

            }
            else if(getTielByName(move).getPiece().color == this.color){
                break;
            }
            else{
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    possMoves.add(move+"kng");
                }
                else{
                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }
                }                break;
            }
        }





        for (int row = this.row-1; row >= 0 ; row--) {
            String move = row+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){

                    possMoves.add(move);
                }

            }
            else if(getTielByName(move).getPiece().color == this.color){
                break;
            }
            else{
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    possMoves.add(move+"kng");
                }
                else{
                    if (isValid(move)) {

                        possMoves.add(move+'k');

                    }
                }                break;
            }
        }
    }

    private void VMoves() {
        for (int col = this.col+1; col <8 ; col++) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);

                }


            }
            else if(getTielByName(move).getPiece().color == this.color){
                break;
            }
            // another color of the piece
            else{
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    possMoves.add(move+"kng");
                }
                else{
                    if(isValid(move)){
                        possMoves.add(move+'k');

                    }
                    break;
                }

            }

        }
        for (int col = this.col-1; col >= 0 ; col--) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);

                }

            }
            else if(getTielByName(move).getPiece().color == this.color){
                break;
            }
            else{
                if(getTielByName(move).getPiece().piece_type.equals("king")){
                    possMoves.add(move+"kng");
                }
                else{
                    if(isValid(move)){
                        possMoves.add(move+'k');
                    }

                    break;
                }
            }

        }
    }



    @Override
    public Piece searchForKing() {
        for (int row = this.row+1; row <8 ; row++) {
            String move = row+" "+this.col;
            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return getTielByName(move).getPiece();
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

        }
        for (int row = this.row-1; row >= 0 ; row--) {
            String move = row+" "+this.col;

            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return getTielByName(move).getPiece();
                    }
                    else{
                        break;
                    }
                }
                else break;
            }


        }
        for (int col = this.col+1; col <8 ; col++) {
            String move = this.row+" "+col;

            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return getTielByName(move).getPiece();
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

        }
        for (int col = this.col-1; col >= 0 ; col--) {
            String move = this.row+" "+col;

            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return getTielByName(move).getPiece();
                    }
                    else{
                        break;
                    }
                }
                else break;
            }

        }
        return null;


    }

}
