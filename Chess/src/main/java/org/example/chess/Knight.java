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
        return false;
    }

    @Override
    protected void storeAllPossibleMoves() {

    }

    @Override
    public void calcProtectedTiels() {

    }

}
