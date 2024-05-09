package org.example.chess;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Game {
    static boolean playerWhiteTurn;
    boolean PlayerBlackTurn = false;

    boolean gameOver=false;
    public static Piece currPiece;

    static boolean isKingChecked = false;






    public void startGame() {
        Board board = new Board();
        board.creatBoard();
//        calcProtectedPieces();
        calcProtectedTiels();
    }


    Game(){
        currPiece=null;
        isKingChecked = false;
        playerWhiteTurn=true;

        addEventHandlers(Board.chessBoard );
    }
    private void addEventHandlers(GridPane chessBoard ) {

        chessBoard.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                EventTarget target = event.getTarget();
                if(event.getSource().equals(Board.chessBoard)){
                    if(currPiece==null){
//                        System.out.println();
                    }
                    else {
                        System.out.println(currPiece.piece_type);
                    }
                    Tiel tiel;
                    try {
                        tiel = (Tiel) target;
                    }catch (Exception e){
                        Piece newPiece = (Piece) target;
                        tiel = (Tiel) newPiece.getParent();
                    }


                    if(true){
//                        Game.isKingChecked();

                        if(tiel.isoOccupied){

                            Piece newPiece = (Piece) tiel.getChildren().get(0);
                            if(currPiece == null){
                                currPiece = newPiece;
                                if((currPiece.color == Color.WHITE && !playerWhiteTurn) || (currPiece.color == Color.BLACK &&playerWhiteTurn)){
                                    currPiece = null;

                                    return;
                                }
                                selectPiece(newPiece);
                            }

                            else {
                                // Selecting a Piece with smae Color
                                if(currPiece.color == newPiece.color ){
                                    deselectPiece(currPiece);
                                    selectPiece(newPiece);

                                }

                                else {
                                    if(currPiece.isFromThePossMoves(tiel) ){
                                        killPiece(tiel);
                                        changPlayer(true);
                                        checkFroPeromtions();
                                        isKingChecked();
                                        if(isKingChecked){
                                            isGameOver();
                                        }
                                    }
                                    System.out.println("this is the "+(playerWhiteTurn? "White turn" : "Black Turn"));
                                }
                            }




                        }
                        else {
                            if(currPiece!=null && currPiece.isFromThePossMoves(tiel)){

                                if(currPiece.piece_type.equals("king") ){
                                    System.out.println("Castling");
                                    King king = (King) currPiece;
                                    if(king.isCaslingMove(tiel)){
                                        boolean to_right=(tiel.col > currPiece.col);
                                        movePiece(tiel);
                                        int row = tiel.row;
                                        int col = tiel.col;
                                        if(to_right){
                                            Tiel rookTiel = Piece.getTielByName(row+" " +(col+1));
                                            currPiece = rookTiel.getPiece();
                                            movePiece(Piece.getTielByName(row+" " +(col-1)));
                                            changPlayer(true);
                                        }
                                        else{
                                            Tiel rookTiel = Piece.getTielByName(row+" " +(col-2));
                                            currPiece = rookTiel.getPiece();
                                            movePiece(Piece.getTielByName(row+" " +(col+1)));
                                            changPlayer(true);
                                        }



                                        isKingChecked();
                                        if(isKingChecked()){
                                            isGameOver();
                                        }
                                        System.out.println("After Castling");
                                    }
                                    else{


                                        movePiece(tiel);
                                        changPlayer(true);
                                        checkFroPeromtions();
                                        isKingChecked();
                                        if(isKingChecked()){
                                            isGameOver();
                                        }
                                    }
                                }


                                else{


                                    movePiece(tiel);
                                    changPlayer(true);
                                    checkFroPeromtions();
                                    isKingChecked();
                                    if(isKingChecked()){
                                        isGameOver();
                                    }
                                }

                            }

                        }


                    }

                }

            }
        });



    }

    public static boolean isKingChecked() {
        return false;
    }

    private void selectPiece(Piece newPiece) {
    }

    private void deselectPiece(Piece currPiece) {
    }

    private void killPiece(Tiel tiel) {
    }

    private void isGameOver() {
    }

    private void checkFroPeromtions() {
    }

    private void changPlayer(boolean b) {
    }

    private void movePiece(Tiel tiel) {
    }
    private void calcProtectedTiels() {
    }


}
