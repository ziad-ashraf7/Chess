package org.example.chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Queen extends Piece {

    Queen(Color color, int row, int col) {
        super(color, row, col);
        this.piece_type = "queen";
        if(color == Color.WHITE){
            setImage(new Image("Piecs Imgs/White/White_Queen.png"));
            setFitHeight(100);
            setFitWidth(100);
        }
        else {
            setImage(new Image("Piecs Imgs/Black/Black_Queen.png"));
            setFitHeight(100);
            setFitWidth(100);
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
                }else {
                    break;
                }
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
                else
                    break;
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







        String move;
        int row = this.row-1 ; int col = this.col-1;
        while (row >= 0 && col >= 0){
            move=row+" "+col;

            if(getTielByName(move).isoOccupied){
                if(getTielByName(move).getPiece().color != this.color){
                    if(getTielByName(move).getPiece().piece_type.equals("king")){
                        return getTielByName(move).getPiece();
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
                        return getTielByName(move).getPiece();
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
                        return getTielByName(move).getPiece();
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
                        return getTielByName(move).getPiece();
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


        return null;
    }

    @Override
    protected void storeAllPossibleMoves() {
        bishopBasedMoves();
        rookBasedMoves();

    }

    @Override
    public void calcProtectedTiels() {
        calcBishopBasedProtectedTiels();
        calcRookBasedProtectedTiels();

    }

    private void bishopBasedMoves(){
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
                        if (isValid(move)){
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

    private void rookBasedMoves(){
        for (int col = this.col+1; col <8 ; col++) {
            String move = this.row+" "+col;
//

            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);

                }
//                getTielByName(move).isProtected = true;


            }
            else if(getTielByName(move).getPiece().color == this.color){
//                getTielByName(move).getPiece().isProtected=true;
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
                }
                break;
            }

        }
        for (int col = this.col-1; col >= 0 ; col--) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);
                }
//                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
//                getTielByName(move).getPiece().isProtected=true;
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

        // H moves

        for (int row = this.row+1; row <8 ; row++) {
            String move = row+" "+this.col;
            if(!getTielByName(move).isoOccupied){
                if(isValid(move)){
                    possMoves.add(move);
                }
//                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
//                getTielByName(move).getPiece().isProtected=true;
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
//                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
//                getTielByName(move).getPiece().isProtected=true;
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
    }

    public void protectedPieces(){
        for (int col = this.col+1; col <8 ; col++) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                possMoves.add(move);
                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).getPiece().isProtected=true;
                break;
            }
            else{
                possMoves.add(move+'k');
                break;
            }

        }
        for (int col = this.col-1; col >= 0 ; col--) {
            String move = this.row+" "+col;

            if(!getTielByName(move).isoOccupied){
                possMoves.add(move);
                getTielByName(move).isProtected = true;

            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).getPiece().isProtected=true;
                break;
            }
            else{
                possMoves.add(move+'k');
                break;
            }

        }

    }

    private void calcBishopBasedProtectedTiels(){
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
    private void calcRookBasedProtectedTiels(){

        // Rook Moves
        for (int col = this.col+1; col <8 ; col++) {
            String move = this.row+" "+col;
//

            if(!getTielByName(move).isoOccupied){
                getTielByName(move).isProtected = true;


            }
            else if(getTielByName(move).getPiece().color == this.color){
                getTielByName(move).isProtected=true;
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


        }

        // H moves

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

    }
}
