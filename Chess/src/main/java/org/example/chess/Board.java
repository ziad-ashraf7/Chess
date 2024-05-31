package org.example.chess;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Board {

    public static GridPane chessBoard = new GridPane();


    static Pane root = new Pane();
    public static Tiel[][] board_tiels =new Tiel[8][8];
    public static Stage stage=new Stage();







    public void creatBoard() {

        Scene scene = new Scene(root , 800, 800);
        root.getChildren().addAll(chessBoard);
        /* Creatin the Initial Board's Tiels*/
        makeTiels();

        /* Creating the Board's Piece in the initial positions */
        makePieces();




        stage.setScene(scene);
        stage.setTitle("Chess Game");
        Image image = new Image("Piecs Imgs/White/White_Knight.png");
        stage.getIcons().add(image);
        stage.show();

    }

    private void makePieces() {
        for (int col = 0; col < 8; col++) {
            board_tiels[6][col].addPiece(new Pawn(Color.WHITE , 6 , col));
            board_tiels[1][col].addPiece(new Pawn(Color.BLACK , 1 , col ));
        }
//////         Rook
        board_tiels[0][0].addPiece(new Rook(Color.BLACK , 0 , 0));
        board_tiels[0][7].addPiece(new Rook(Color.BLACK , 0 , 7));
        board_tiels[7][0].addPiece(new Rook(Color.WHITE , 7 , 0));
        board_tiels[7][7].addPiece(new Rook(Color.WHITE , 7 , 7));
//         Knight
        board_tiels[0][1].addPiece(new Knight(Color.BLACK , 0 , 1));
        board_tiels[0][6].addPiece(new Knight(Color.BLACK , 0 , 6));
        board_tiels[7][6].addPiece(new Knight(Color.WHITE , 7 , 6));
        board_tiels[7][1].addPiece(new Knight(Color.WHITE , 7 , 1));
//         Bishop
        board_tiels[0][2].addPiece(new Bishop(Color.BLACK , 0 , 2));
        board_tiels[0][5].addPiece(new Bishop(Color.BLACK , 0 , 5));
        board_tiels[7][2].addPiece(new Bishop(Color.WHITE , 7 , 2));
        board_tiels[7][5].addPiece(new Bishop(Color.WHITE , 7 , 5));
//         Queen
        board_tiels[7][3].addPiece(new Queen(Color.WHITE , 7 , 3));
        board_tiels[0][3].addPiece(new Queen(Color.BLACK , 0 , 3));
//        King
        board_tiels[7][4].addPiece(new King(Color.WHITE , 7 , 4));
        board_tiels[0][4].addPiece(new King(Color.BLACK , 0 , 4));
//






//        Test
//        board_tiels[7][7].addPiece(new Rook(Color.WHITE , 7 , 7));
//        board_tiels[0][5].addPiece(new Knight(Color.BLACK , 0 , 5));
//        board_tiels[6][2].addPiece(new Rook(Color.BLACK , 6 , 2));
//        board_tiels[3][4].addPiece(new Queen(Color.WHITE , 3 , 4));
//        board_tiels[7][4].addPiece(new King(Color.WHITE , 7 , 4));
//        board_tiels[0][7].addPiece(new King(Color.WHITE , 0 , 7));

//            board_tiels[6][4].addPiece(new Pawn(Color.BLACK , 6 , 4));
//            board_tiels[3][4].addPiece(new Pawn(Color.BLACK , 3 , 4 ));


    }

    private void makeTiels() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Tiel tiel = new Tiel(row , col);
                chessBoard.add(tiel, col , row );
                board_tiels[row][col] = tiel;
                int finalCol = col;
                int finalRow = row;
                board_tiels[row][col].setOnMouseClicked(event -> {
//                        System.out.println(board_tiels[finalRow][finalCol].isProtected+" "+board_tiels[finalRow][finalCol].getPiece()+"\n" +" is the king checked? "+Game.isKingChecked);
                    if(board_tiels[finalRow][finalCol].getPiece()!=null&&board_tiels[finalRow][finalCol].getPiece().piece_type.equals("rook")){
                        Rook rook = (Rook)board_tiels[finalRow][finalCol].getPiece();
                        System.out.println(rook.moved_before);
                    }

                    if(board_tiels[finalRow][finalCol].getPiece()!=null&&board_tiels[finalRow][finalCol].getPiece().piece_type.equals("king")){
                        King king = (King)board_tiels[finalRow][finalCol].getPiece();
                        System.out.println(king.moved_before);

                    }
//                    System.out.println(board_tiels[finalRow][finalCol].isoOccupied);
                    if(board_tiels[finalRow][finalCol].isoOccupied){

                        System.out.println("The piece row and col is: "+board_tiels[finalRow][finalCol].getPiece().row + " "+ board_tiels[finalRow][finalCol].getPiece().col);
                    }

                });
            }
        }
    }











}
