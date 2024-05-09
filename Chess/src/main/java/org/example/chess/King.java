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
        return false;
    }

    @Override
    protected void storeAllPossibleMoves() {

    }

    @Override
    public void calcProtectedTiels() {

    }

    public boolean isCaslingMove(Tiel tiel) {
        return false;
    }
}
