
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import enigma.console.Console;
import enigma.core.Enigma;
import enigma.core.Environment;

import java.awt.Color;
import enigma.console.*;
import enigma.core.Enigma;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Game game1 = new Game();
		Scanner scn = new Scanner(System.in);
		String[] myReader = game1.read("src\\puzzle.txt").split("\n");
		String[] myWord = game1.read("src\\word_list.txt").split("\n");
		String[] WordList = game1.read("src\\solution.txt").split("\n");
		String[] score= game1.read("src\\high_score_table.txt").split("\n");
        
		String[] myReader2 = game1.read("src\\puzzle2.txt").split("\n");
		String[] WordList2 = game1.read("src\\solution2.txt").split("\n");
		
		String[] usernames = new String[score.length];
        String[] userscore = new String[score.length];
        int[] transfer = new int[score.length];
		
		String[][] arr = new String[15][15];
		String[][] arr2 = new String[15][15];
		String[][] arr3 = new String[15][15];
		String[][] arr4 = new String[15][15];
		
		String[][] arrLevel2 = new String[15][15];
		String[][] arr2Level2 = new String[15][15];
		String[][] arr3Level2 = new String[15][15];
		String[][] arr4Level2 = new String[15][15];
		int counter = 0;
		int counter2=0;
		String[] englishWords = new String[myWord.length];
		int index ;
		
		for (int j = 0; j < 15; j++) {
			arr[j] = myReader[counter].split("	");
			counter++;
		}
		
		
		for (int j = 0; j < 15; j++) {
			arrLevel2[j] = myReader2[counter2].split("	");
			counter2++;
		}
		counter2 =0;
		
		for (int j = 0; j < 15; j++) {
			arr2Level2[j] = WordList2[counter2].split("	");
			counter2++;
		}
		counter2 = 0;
		for (int j = 0; j < 15; j++) {
			arr3Level2[j] = WordList2[counter2].split("	");
			counter2++;
		}
		counter2 = 0;
		for (int j = 0; j < 15; j++) {
			arr4Level2[j] = WordList2[counter2].split("	");
			counter2++;
		}
		
		counter2 = 0;
		counter = 0;
		for (int j = 0; j < 15; j++) {
			arr2[j] = WordList[counter].split("	");
			counter++;
		}
		counter = 0;
		for (int j = 0; j < 15; j++) {
			arr3[j] = WordList[counter].split("	");
			counter++;
		}
		counter = 0;
		for (int j = 0; j < 15; j++) {
			arr4[j] = WordList[counter].split("	");
			counter++;
		}
		
		counter = 0;
		
		for (int i = 0; i < myWord.length; i++) {// ingilizce kelimeler
			index = myWord[i].indexOf(",");	
			englishWords[counter] = myWord[i].substring(0,index);	
			counter++;
		}
		
		Game.Board(arr);
		Game.AltAltaDisplay(arr2);
		Game.YanyanaDisplay(arr3);
		Game.sll.printList2();
		game1.dizi();
		counter=0;index=0;///highscore txt deki verileri iki diziye aktardım.
        
		for (int i = 0; i < score.length; i++) {
            index = score[i].indexOf(";");
            usernames[counter] = score[i].substring(0,index);
            userscore[counter]=score[i].substring(index+1);
            counter++;
        }
        for (int i = 0; i < transfer.length; i++) {
            transfer[i] = Integer.valueOf(userscore[i]); //Integer a çevirdim başta stringdi substringi yapabilmek için. 
        }
        Node head = null;
        Node new_node;
        Node dnm=null;

        for (int i = 0; i < usernames.length; i++) {
               game1.dll1.sortedInsert2(transfer[i],usernames[i]); //
        }
          
		
		SingleLinkedList s1= new SingleLinkedList();
		
		for (int j = 0; j < englishWords.length; j++) {
		
			s1.sortedInsert(englishWords[j]);
	  }
		
		  //s1.printList();
		  MultiLinkedList m1 = new MultiLinkedList();	
		  Node temp = s1.getHead();
		int a = 0;
		int size = s1.size();
		
		while(a < size-1) {// single linked list içinden multiLinked liste atma
			
			if(a<1) {
				m1.addRow(temp.getData().substring(0,1));
			}
			
			if(!(temp.getData().substring(0,1).equals(temp.getNext().getData().substring(0,1)))) {
				
				m1.addRow(temp.getNext().getData().substring(0,1));
				m1.addElement(temp.getData().substring(0,1),temp.getData());
			}
		
			else {
				
				m1.addElement(temp.getData().substring(0,1),temp.getData());	
			
			}
		
			temp = temp.getNext();
			a++;
		}
			m1.addElement(temp.getData().substring(0,1),temp.getData());	
			
		
			
		Move move = new Move();
		int newrkey=0;
		while(true) {	
			
			move.MovementSettings();
			move.MoveKeys();
		if(move.rkey != 37 && move.rkey != 38 && move.rkey != 39 && move.rkey != 40 && move.rkey !=0 && move.rkey !=32)	
			
			if(move.rkey !=newrkey) {	
				
				if(Game.kontrol == true) {
					move.cn.getTextWindow().setCursorPosition(3, 20);
					System.out.println("PLAYING PLAYER1");
					Game.Player1oyunKontrol(m1, arr, move.rkey, arr4);
					newrkey = move.rkey;
				}
				else if(Game.kontrol == false) {
					move.cn.getTextWindow().setCursorPosition(60, 10);
					System.out.println("                             ");
				    move.cn.getTextWindow().setCursorPosition(3, 20);
					System.out.println("PLAYING PLAYER2");
					Game.Player2oyunKontrol(m1, arr, move.rkey, arr4);
					newrkey = move.rkey;
				}
			}
		
		if(Game.level2Kontrol(arr, arr4) == true && game1.kontrolHarf == 0) {
			game1.sll.head = null;
			for (int i = 8; i < 19; i++) {
				move.cn.getTextWindow().setCursorPosition(25, i);
				System.out.print("                                  ");
			}
			Game.Board(arrLevel2);
			Game.AltAltaDisplay(arr2Level2);
			Game.YanyanaDisplay(arr3Level2);
			Game.sll.printList2();
			//game1.dizi();
			//move.cn.getTextWindow().setCursorPosition(0, 25);
			//m1.display();
			while(true) {	
				
				move.MovementSettings();
				move.MoveKeys();
			if(move.rkey != 37 && move.rkey != 38 && move.rkey != 39 && move.rkey != 40 && move.rkey !=0 && move.rkey !=32)	
				
				if(move.rkey !=newrkey) {	
					
					if(Game.kontrol == true) {
						move.cn.getTextWindow().setCursorPosition(3, 20);
						System.out.println("PLAYING PLAYER1");
						Game.Player1oyunKontrol(m1, arrLevel2, move.rkey, arr4Level2);
						newrkey = move.rkey;
					}
					else if(Game.kontrol == false) {
						move.cn.getTextWindow().setCursorPosition(60, 10);
						System.out.println("                             ");
					    move.cn.getTextWindow().setCursorPosition(3, 20);
						System.out.println("PLAYING PLAYER2");
						Game.Player2oyunKontrol(m1, arrLevel2, move.rkey, arr4Level2);
						newrkey = move.rkey;
					}
				}
			}
		}	
	}
  }
}