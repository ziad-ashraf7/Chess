package org.example.chess;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Game {

    static boolean playerWhiteTurn;
    boolean PlayerBlackTurn = false;

    boolean gameOver = false;
    public static Piece currPiece;

    static boolean isKingChecked = false;


    Board board;

    public void startGame() {
        Board board = new Board();
        board.creatBoard();
//        calcProtectedPieces();
        calcProtectedTiels();
    }

    Game() {
        currPiece = null;
        isKingChecked = false;
        playerWhiteTurn = true;
        addEventHandlers(Board.chessBoard);
    }

    private void addEventHandlers(GridPane chessBoard) {

        chessBoard.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                EventTarget target = event.getTarget();
                if (event.getSource().equals(Board.chessBoard)) {
                    if (currPiece == null) {
//                        System.out.println();
                    } else {
                        System.out.println(currPiece.piece_type);
                    }
                    Tiel tiel;
                    try {
                        tiel = (Tiel) target;
                    } catch (Exception e) {
                        Piece newPiece = (Piece) target;
                        tiel = (Tiel) newPiece.getParent();
                    }


                    if (true) {
//                        Game.isKingChecked();

                        if (tiel.isoOccupied) {

                            Piece newPiece = (Piece) tiel.getChildren().get(0);
                            if (currPiece == null) {
                                currPiece = newPiece;
                                if ((currPiece.color == Color.WHITE && !playerWhiteTurn) || (currPiece.color == Color.BLACK && playerWhiteTurn)) {
                                    currPiece = null;
                                    return;
                                }
                                selectPiece(newPiece);
                            } else {
                                // Selecting a Piece with smae Color
                                if (currPiece.color == newPiece.color) {
                                    deselectPiece(currPiece);
                                    selectPiece(newPiece);

                                } else {
                                    if (currPiece.isFromThePossMoves(tiel)) {
                                        killPiece(tiel);
                                        changPlayer(true);
                                        checkFroPeromtions();
                                        isKingChecked();
                                        if (isKingChecked) {
                                            isGameOver();
                                        }
                                    }
                                    System.out.println("this is the " + (playerWhiteTurn ? "White turn" : "Black Turn"));
                                }
                            }


                        } else {
                            if (currPiece != null && currPiece.isFromThePossMoves(tiel)) {

                                if (currPiece.piece_type.equals("king")) {
                                    System.out.println("Castling");
                                    King king = (King) currPiece;
                                    if (king.isCaslingMove(tiel)) {
                                        boolean to_right = (tiel.col > currPiece.col);
                                        movePiece(tiel);
                                        int row = tiel.row;
                                        int col = tiel.col;
                                        if (to_right) {
                                            Tiel rookTiel = Piece.getTielByName(row + " " + (col + 1));
                                            currPiece = rookTiel.getPiece();
                                            movePiece(Piece.getTielByName(row + " " + (col - 1)));
                                            changPlayer(true);
                                        } else {
                                            Tiel rookTiel = Piece.getTielByName(row + " " + (col - 2));
                                            currPiece = rookTiel.getPiece();
                                            movePiece(Piece.getTielByName(row + " " + (col + 1)));
                                            changPlayer(true);
                                        }


                                        isKingChecked();
                                        if (isKingChecked()) {
                                            isGameOver();
                                        }
                                        System.out.println("After Castling");
                                    } else {


                                        movePiece(tiel);
                                        changPlayer(true);
                                        checkFroPeromtions();
                                        isKingChecked();
                                        if (isKingChecked()) {
                                            isGameOver();
                                        }
                                    }
                                } else {


                                    movePiece(tiel);
                                    changPlayer(true);
                                    checkFroPeromtions();
                                    isKingChecked();
                                    if (isKingChecked()) {
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

    private static void reverseBoard() {
        System.out.println("Revesing");
        if (Board.root.getRotate() == 180) {
            Board.root.setRotate(0);
        } else {
            Board.root.setRotate(180);

        }
        for (int row = 0; row < 8; row++) {
            for (int coll = 0; coll < 8; coll++) {
                if (Board.board_tiels[row][coll].getRotate() == 180) {
                    Board.board_tiels[row][coll].setRotate(0);
                } else {

                    Board.board_tiels[row][coll].setRotate(180);
                }

            }
        }

        System.out.println("Revesed");
        Tiel[][] temp = new Tiel[8][8];

//        for (int row = 0; row < 8; row++) {
//            for (int col = 0; col < 8; col++) {
//                temp[col][row] = Board.board_tiels[row][col];
//            }
//        }
//        for (int row = 0; row < 8; row++) {
//            for (int coll = 0; coll < 8; coll++) {
//                 Board.board_tiels[row][coll] = temp[row][coll];
//            }
//        }

    }

    private void checkFroPeromtions() {
        if (playerWhiteTurn) {
            promotBlack();
        } else {
            promotWhite();
        }


    }

    private void promotWhite() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                final String[] selected_choic = {""};
                if (Board.board_tiels[row][col].isoOccupied &&
                    Board.board_tiels[row][col].getPiece().color == Color.WHITE &&
                    Board.board_tiels[row][col].getPiece().piece_type.equals("pawn") &&
                    Board.board_tiels[row][col].getPiece().row == 0) {
                    Pane root = new Pane();
                    Tiel[] choices = new Tiel[4];
                    GridPane Pieces = new GridPane();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 405, 100);
                    root.getChildren().addAll(Pieces);

                    stage.setScene(scene);
                    stage.show();
                    for (int col1 = 0; col1 < 4; col1++) {
                        Tiel tiel = new Tiel();
                        tiel.setPrefWidth(100);
                        tiel.setPrefHeight(100);
                        tiel.setStyle("-fx-background-color: rgb(5, 20 , 50); -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-end-margin: 10px");

                        Pieces.add(tiel, col1, 1);
                        choices[col1] = tiel;
                        int finalCol1 = col1;
                        int finalRow = row;
                        int finalCol = col;
                        choices[col1].setOnMouseClicked(event -> {
                            System.out.println(choices[finalCol1].getPiece().piece_type);
                            selected_choic[0] = choices[finalCol1].getPiece().piece_type;
                            System.out.println(selected_choic[0]);
                            if (selected_choic[0].equals("queen")) {
                                System.out.println("entede the if");
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Queen(Color.WHITE, finalRow, finalCol));
                            } else if (selected_choic[0].equals("rook")) {
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Rook(Color.WHITE, finalRow, finalCol));
                            } else if (selected_choic[0].equals("bishop")) {
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Bishop(Color.WHITE, finalRow, finalCol));
                            } else {
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Knight(Color.WHITE, finalRow, finalCol));
                            }
                            stage.close();
                            if (isKingChecked()) {
                                isGameOver();
                            }
                            return;
                        });
                    }
                    choices[0].addPiece(new Queen(Color.WHITE, 1, 0));
                    choices[1].addPiece(new Rook(Color.WHITE, 1, 1));
                    choices[2].addPiece(new Knight(Color.WHITE, 1, 2));
                    choices[3].addPiece(new Bishop(Color.WHITE, 1, 3));


                }


            }
        }
    }

    private void promotBlack() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                final String[] selected_choic = {""};
                if (Board.board_tiels[row][col].isoOccupied &&
                    Board.board_tiels[row][col].getPiece().color == Color.BLACK &&
                    Board.board_tiels[row][col].getPiece().piece_type.equals("pawn") &&
                    Board.board_tiels[row][col].getPiece().row == 7) {
                    Pane root = new Pane();
                    Tiel[] choices = new Tiel[4];
                    GridPane Pieces = new GridPane();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 405, 100);
                    root.getChildren().addAll(Pieces);

                    stage.setScene(scene);
                    stage.show();
                    for (int col1 = 0; col1 < 4; col1++) {
                        Tiel tiel = new Tiel();
                        tiel.setPrefWidth(100);
                        tiel.setPrefHeight(100);
                        tiel.setStyle("-fx-background-color: rgb(12,210,205); -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-end-margin: 10px");

                        Pieces.add(tiel, col1, 1);
                        choices[col1] = tiel;
                        int finalCol1 = col1;
                        int finalRow = row;
                        int finalCol = col;
                        choices[col1].setOnMouseClicked(event -> {
                            System.out.println(choices[finalCol1].getPiece().piece_type);
                            selected_choic[0] = choices[finalCol1].getPiece().piece_type;
                            System.out.println(selected_choic[0]);
                            if (selected_choic[0].equals("queen")) {
                                System.out.println("entede the if");
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Queen(Color.BLACK, finalRow, finalCol));
                            } else if (selected_choic[0].equals("rook")) {
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Rook(Color.BLACK, finalRow, finalCol));
                            } else if (selected_choic[0].equals("bishop")) {
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Bishop(Color.BLACK, finalRow, finalCol));
                            } else {
                                Board.board_tiels[finalRow][finalCol].getChildren().remove(0);
                                Board.board_tiels[finalRow][finalCol].addPiece(new Knight(Color.BLACK, finalRow, finalCol));
                            }
                            stage.close();
                            if (isKingChecked()) {
                                isGameOver();
                            }
                            return;
                        });
                    }
                    choices[0].addPiece(new Queen(Color.BLACK, 1, 0));
                    choices[1].addPiece(new Rook(Color.BLACK, 1, 1));
                    choices[2].addPiece(new Knight(Color.BLACK, 1, 2));
                    choices[3].addPiece(new Bishop(Color.BLACK, 1, 3));

                }
            }
        }
    }


    private void killPiece(Tiel tiel) {
        tiel.getChildren().remove(0);
        tiel.isoOccupied = true;
        selectPiece(currPiece);
        movePiece(tiel);

    }

    private void deselectPiece(Piece p) {
        currPiece.hidePossMoves();
        currPiece = null;

    }

    public static void movePiece(Tiel toTiel) {

        Tiel oldTiel = (Tiel) currPiece.getParent();
        toTiel.getChildren().add(currPiece);
        toTiel.isoOccupied = true;
        toTiel.setPiece(currPiece);
        oldTiel.getChildren().removeAll();
        oldTiel.setPiece(null);
        oldTiel.isoOccupied = false;
        currPiece.hidePossMoves();
        currPiece.col = toTiel.col;
        currPiece.row = toTiel.row;
        reverseBoard();
        if (currPiece.piece_type.equals("rook")) {
            Rook rook = (Rook) currPiece;
            rook.moved_before = true;
        } else if (currPiece.piece_type.equals("king")) {
            King king = (King) currPiece;
            king.moved_before = true;

        }
        currPiece = null;
//        calcProtectedPieces();
        calcProtectedTiels();

    }

    public static boolean searchForBlackCheck() {
        isKingChecked = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color == Color.BLACK) {
//                        Board.board_tiels[row][col].getPiece().possMoves.clear();
//                        Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
//                        for(String i : Board.board_tiels[row][col].getPiece().possMoves){
                    if (Board.board_tiels[row][col].getPiece().searchForKing() != null) {
                        System.out.println("White King Checked");
                        Game.isKingChecked = true;
                        Piece king = Board.board_tiels[row][col].getPiece().searchForKing();
                        Board.board_tiels[king.row][king.col].setBackground(new Background(new BackgroundFill(Color.rgb(200, 7, 7), CornerRadii.EMPTY, Insets.EMPTY)));

                        return true;
                    }
                    Board.board_tiels[row][col].getPiece().possMoves.clear();

//                        }
                }
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    Board.board_tiels[row][col].setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    Board.board_tiels[row][col].setBackground(new Background(new BackgroundFill(Color.rgb(60, 20, 4), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
        Game.isKingChecked = false;
        return false;
    }

    public static boolean isKingChecked() {
        if (playerWhiteTurn) {
//            System.out.println("*********calc Black check************* ");
            return searchForBlackCheck();
        } else {
            return searchWhiteCheck();
        }
    }

    public static boolean searchWhiteCheck() {
//        System.out.println("*********calc white check*************");
        isKingChecked = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color == Color.WHITE) {
//                    Board.board_tiels[row][col].getPiece().possMoves.clear();
//                    Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
//                    for(String i : Board.board_tiels[row][col].getPiece().possMoves){
                    Piece king = Board.board_tiels[row][col].getPiece().searchForKing();
                    if (king != null) {
                        System.out.println("Black King Checked");
                        Board.board_tiels[king.row][king.col].setBackground(new Background(new BackgroundFill(Color.rgb(200, 7, 7), CornerRadii.EMPTY, Insets.EMPTY)));

                        Game.isKingChecked = true;

                        Board.board_tiels[row][col].getPiece().possMoves.clear();
                        return true;
                    }
                    Board.board_tiels[row][col].getPiece().possMoves.clear();


//                    }
                }
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    Board.board_tiels[row][col].setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    Board.board_tiels[row][col].setBackground(new Background(new BackgroundFill(Color.rgb(60, 20, 4), CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }
        Game.isKingChecked = false;

        return false;

    }


    private void selectPiece(Piece p) {
        currPiece = p;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece() != null) {
                    Board.board_tiels[row][col].getPiece().possMoves.clear();
                }
            }
        }
        System.out.println("SLECTing ");
        currPiece.storeAllPossibleMoves();
        System.out.println("SLECTED ");
        currPiece.showAllPossMoves();

    }

    private static void changPlayer(boolean b) {
        if (b) {
            if (playerWhiteTurn) {
                playerWhiteTurn = false;
                currPiece = null;
            } else {
                playerWhiteTurn = true;
                currPiece = null;
            }
        }
    }


    void isGameOver() {
        if (playerWhiteTurn) {
            boolean kingCanMove = false;
            boolean piecesCanMove = false;
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color == Color.WHITE && Board.board_tiels[row][col].getPiece().piece_type.equals("king")) {
                        Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        if (!Board.board_tiels[row][col].getPiece().possMoves.isEmpty()) {
                            kingCanMove = true;
                        } else {
                            Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        }
                    }
                }
            }
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color == Color.WHITE) {
                        Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        if (!Board.board_tiels[row][col].getPiece().possMoves.isEmpty()) {
                            piecesCanMove = true;
                        } else {
                            Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        }
                    }
                }
            }


            if (!kingCanMove && !piecesCanMove) {
                System.out.println("GAME OVER Player Black Win");
                Stage stage = new Stage();
                Pane clossing = new Pane();
                Scene scene = new Scene(clossing);
                stage.setScene(scene);
                Text text = new Text();
                text.setText("Game Over");
                stage.show();
                Board.stage.close();
            }

        } else {
            boolean kingCanMove = false;
            boolean piecesCanMove = false;
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color == Color.BLACK && Board.board_tiels[row][col].getPiece().piece_type.equals("king")) {
                        Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        if (!Board.board_tiels[row][col].getPiece().possMoves.isEmpty()) {
                            kingCanMove = true;
                        } else {
                            Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        }
                    }
                }
            }
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color == Color.BLACK) {
                        Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        if (!Board.board_tiels[row][col].getPiece().possMoves.isEmpty()) {
                            piecesCanMove = true;
                        } else {
                            Board.board_tiels[row][col].getPiece().storeAllPossibleMoves();
                        }
                    }
                }
            }


            if (!kingCanMove && !piecesCanMove) {
                System.out.println("GAME OVER Player White Win");
                Stage stage = new Stage();
                Pane clossing = new Pane();
                Scene scene = new Scene(clossing);
                clossing.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                stage.setScene(scene);
                Text text = new Text();
                text.setText("GAME OVER Player White Win");
                clossing.getChildren().add(text);
                text.setFill(Color.WHITE);
                text.setTextAlignment(TextAlignment.CENTER);

                text.setLayoutY(100);
                text.setFont(new Font(60));
                stage.show();
                Board.stage.close();
            }
        }
    }

    private static void calcProtectedPieces() {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (Board.board_tiels[row][col].isoOccupied) {
                    Board.board_tiels[row][col].getPiece().isProtected = false;
                }
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (Board.board_tiels[row][col].isoOccupied) {
                    Board.board_tiels[row][col].getPiece().calcProtectedTiels();
                }
            }
        }
    }

    private static void calcProtectedTiels() {
        if (playerWhiteTurn) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Board.board_tiels[row][col].isProtected = false;

                }
            }

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color != Color.WHITE) {
                        Board.board_tiels[row][col].getPiece().calcProtectedTiels();
                    }
                }
            }
        } else {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Board.board_tiels[row][col].isProtected = false;

                }
            }

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (Board.board_tiels[row][col].isoOccupied && Board.board_tiels[row][col].getPiece().color != Color.BLACK) {
                        Board.board_tiels[row][col].getPiece().calcProtectedTiels();
                    }
                }
            }
        }

    }


}
