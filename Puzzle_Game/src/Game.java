

import enigma.core.Enigma;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import enigma.console.TextAttributes;
import java.awt.Color;

public class Game {

	private static final String[][] Board = null;
	public static enigma.console.Console cn = Enigma.getConsole("Game", 150, 45);
	public static int player1Score = 0;
	public static int player2Score = 0;
	public static String basHarf = "";
	public static int kontrolHarf = 0;
	public static int a = 2;
	public static String kelime = "";
	public static boolean kontrol = true;
	public static int up = 4;
	public static int left = 2;
	static DLL dll1=new DLL();    
	static DLL dll2=new DLL();
	static String[] myWord = read("src\\word_list.txt").split("\n");
    static String[] englishWords = new String[myWord.length];
    static String[] TurkishWords = new String[myWord.length];
    int counter = 0;
    int index =0;
    public static int word = 0;
    static SingleLinkedList sll = new SingleLinkedList();
    public  void dizi() {
        for (int i = 0; i < myWord.length; i++) {// ingilizce kelimeler
             index = myWord[i].indexOf(",");
            englishWords[counter] = myWord[i].substring(0,index);
            TurkishWords[counter]=myWord[i].substring(index+1);///Türkçe kelimeler burda 
            counter++;
        }
    }

	public static String read(String filepath) {
		try {
			File file = new File(filepath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			String finalStr = "";
			while ((st = br.readLine()) != null) {

				finalStr += st;
				finalStr += "\n";// satır satır okuma
			}
			return finalStr;
		} catch (Exception e) {
			System.out.println("This file not found!");
			return "";
		}
	}

	public static String[][] Board(String[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].equals("0"))
					board[i][j] = "█";
				else if (board[i][j].equals("1"))
					board[i][j] = " ";

			}
		}
		
		int count = 0;

		cn.getTextWindow().setCursorPosition(0, 0);
		System.out.println("Word:" + word);

		cn.getTextWindow().setCursorPosition(1, 2);
		cn.getTextWindow().output("012345678901234", new TextAttributes(Color.white));

		for (int i = 0; i < board.length; i++) {

			System.out.print("\n");
			if (count == 10)
				count = 0;
			cn.getTextWindow().output(String.valueOf(count), new TextAttributes(Color.white));
			for (int j = 0; j < board.length; j++) {
				cn.getTextWindow().output(board[i][j], new TextAttributes(Color.BLACK, Color.YELLOW));
			}
			count++;
		}
		cn.getTextWindow().setCursorPosition(23, 4);
		System.out.println("-----------Word List------------");
		for (int i = 0; i < board.length; i++) {
			cn.getTextWindow().setCursorPosition(23, i + 5);
			System.out.println("|");
		}
		for (int i = 0; i < board.length; i++) {
			cn.getTextWindow().setCursorPosition(54, i + 5);
			System.out.println("|");
		}
		cn.getTextWindow().setCursorPosition(23, 20);
		System.out.println("--------------------------------");

		return board;

	}

	public static void AltAltaDisplay(String[][] board) {

		String kelime = "";
		int a = 1;
		int y = 8;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (!(board[i][j].equals("0"))) {
					kelime = kelime + board[i][j];
					if (!(board[i + 1][j].equals("0"))) {

						while (!(board[i + a][j].equals("0"))) {
							kelime = kelime + board[i + a][j];
							board[i + a][j] = "0";
							a++;
						}
					}

				}
				a = 1;
				cn.getTextWindow().setCursorPosition(25, y);
				if (kelime.length() > 3) {
					y++;
					//System.out.println("(   )" + " " + kelime);
					sll.sortedInsert("(  )"+kelime);
				}
				kelime = "";
			}
		}

	}

	public static void YanyanaDisplay(String[][] board) {
		String kelime = "";
		int a = 1;
		int y = 13;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (!(board[i][j].equals("0"))) {
					kelime = kelime + board[i][j];
					if (j < 14) {
						if (!(board[i][j + 1].equals("0"))) {

							while (!board[i][j + a].equals("0")) {
								kelime = kelime + board[i][j + a];
								board[i][j + a] = "0";
								if (j + a < 14)
									a++;
							}

						}
					}
				}
				a = 1;
				cn.getTextWindow().setCursorPosition(25, y);
				if (kelime.length() > 3) {
					y++;
					//System.out.println("(   )" + " " + kelime);
					sll.sortedInsert("(  )"+kelime);
				}
				kelime = "";

			}
		}

	}
	
	public static void Player1oyunKontrol(MultiLinkedList m1, String[][] arr1, int z, String[][] arr2) {
		
		String harf = "";
		Move move = new Move();
		RowNode temp = m1.getHead();
		RowNode temp2 = null;
		Node temp3 = null;
		
		if (kontrolHarf < 1) {
			a=2;
		 
			if(move.py == 4 ) {	
				if (!(arr1[move.py - 4][move.px - 1].equals(" ")) && !(arr1[move.py - 4][move.px - 1].equals("█")) && (arr1[move.py - 2][move.px - 1].equals(" "))) {//üstte kalan baş harfi alma
					basHarf = arr1[move.py - 4][move.px - 1];
					kelime = kelime + basHarf;
				}
			
			}
			else if(move.py > 3 ) {
			if (!(arr1[move.py - 4][move.px - 1].equals(" ")) && !(arr1[move.py - 4][move.px - 1].equals("█")) && ((arr1[move.py - 5][move.px - 1].equals("█")) || (arr1[move.py - 5][move.px - 1].equals(" ")))) {//üstte kalan baş harfi alma
				basHarf = arr1[move.py - 4][move.px - 1];
				kelime = kelime + basHarf;
			}
		 }	
		 
		   if(move.px > 1) {	
			 if (!(arr1[move.py - 3][move.px-2].equals(" ")) && !(arr1[move.py - 3][move.px-2].equals("█")) && ((arr1[move.py - 2][move.px-2].equals("█")) || (arr1[move.py - 2][move.px-2].equals(" ")))) {//solda kalan baş harfi alma
					basHarf = arr1[move.py - 3][move.px - 2];
					kelime = kelime + basHarf;	
			
		 }
	   }
	}
		while (temp != null) {// listenin içinde istenilen harf konumuna getirme

			if (temp.getRowCode().equalsIgnoreCase(basHarf)) {
				temp2 = temp;
				temp3 = temp2.getRight();
				break;
			} else
				temp = temp.getDown();
		}

		harf = (String.valueOf(Character.toChars(z)).toLowerCase());
		kelime = kelime + harf;
		
		arr1[move.py-3][move.px-1] = harf;
	if(move.px < 15) {	
		if(!arr1[move.py-2][move.px-1].equals(" ") && !arr1[move.py-2][move.px-1].equals("█") &&  !arr1[move.py-1][move.px-1].equals("█")) {//aşağı doğru giden yolda harf varsa ekleme
			kelime=kelime+arr1[move.py-2][move.px-1];
			a++;
		}
		else if(!arr1[move.py-3][move.px].equals(" ") && !arr1[move.py-3][move.px].equals("█") ) {//sağa doğru giden yolda harf varsa ekleme
			kelime=kelime+arr1[move.py-3][move.px];
			a++;
		}
	}	
		kontrolHarf++;
		while (kontrol) {

			for (int i = 0; i < m1.sizeCell(basHarf); i++) {
			if(temp3.getData().length() >= kelime.length()) {	
				if (kelime.substring(a-1, a).equals(temp3.getData().substring(a - 1, a))) {
					kontrol = true;
					break;
					}
				 
				  else {
					kontrol = false;
					temp3 = temp3.getNext();
				  }
				}
			else
				temp3=temp3.getNext();
			
			}
			if (kontrol)
				break;
		}
		
		if (kontrol && kelime.length() != temp3.getData().length()) {
			player1Score++;
			cn.getTextWindow().setCursorPosition(30, 0);
			System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);
			cn.getTextWindow().setCursorPosition(0, 22);
			System.out.print("Answer is correct. Player1 gets extra 1 points.");
		
		
		} else if (kontrol && kelime.length() == temp3.getData().length()) {
			if (kelime.substring(a-1 ,a ).equals(arr2[Move.py - 3][Move.px - 1]) || kelime.substring(a-1 ,a ).equals(arr2[Move.py - 3][Move.px])) {
				player1Score += 10;
				cn.getTextWindow().setCursorPosition(30, 0);
				System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);
			
				sll.Search3("(  )"+kelime);
				int indexofarr=linearSearch(englishWords,kelime);
	            
				if(find_word(TurkishWords, indexofarr, kelime) == true) {
					player1Score+=10;
					cn.getTextWindow().setCursorPosition(30, 0);
					System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);
				}
				m1.delete(kelime);
				kelime ="";
				kontrolHarf=0;
				a=2;
				word++;
				cn.getTextWindow().setCursorPosition(0, 0);
				System.out.println("Word:" + word);
			}
		}
		a++;
			if(!kontrol){
				player1Score -= 2;
				cn.getTextWindow().setCursorPosition(30, 0);
				System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);	
				
			cn.getTextWindow().setCursorPosition(60, 10);
			System.out.println("ANSWER IS INCORRECT!!");
			  kontrolHarf=0;
			  kelime ="";
			  a=2;
			  arr1[move.py-3][move.px-1] = " ";
			if(move.py > 3) {
			  while(!arr1[move.py-up][move.px-1].equals(" ") && !arr1[move.py-up][move.px-1].equals(basHarf) && !arr1[move.py-up][move.px-1].equals("█")) {//yukarı doğru silme
				  	 arr1[move.py-up][move.px-1] = " ";
				  	 up++;
			  }
			} 
			 if(move.px > 1) { 
			  while(!arr1[move.py-3][move.px-left].equals(" ") && !arr1[move.py-3][move.px-left].equals(basHarf) && !arr1[move.py-3][move.px-left].equals("█")) {//yukarı doğru silme
				  	 arr1[move.py-3][move.px-left] = " ";
				  	 left++;
			  }
			 }
			  up = 4;
			  left=2;
			
		}	 
			Game.Board(arr1);
			
		
	}
	public static void Player2oyunKontrol(MultiLinkedList m1, String[][] arr1, int z, String[][] arr2) {

		String harf = "";
		Move move = new Move();
		RowNode temp = m1.getHead();
		RowNode temp2 = null;
		Node temp3 = null;
		
		if (kontrolHarf < 1) {
			a=2;
		 
			if(move.py == 4 ) {	
				if (!(arr1[move.py - 4][move.px - 1].equals(" ")) && !(arr1[move.py - 4][move.px - 1].equals("█")) && (arr1[move.py - 2][move.px - 1].equals(" "))) {//üstte kalan baş harfi alma
					basHarf = arr1[move.py - 4][move.px - 1];
					kelime = kelime + basHarf;
				}
			
			}
			else if(move.py > 3 ) {
			if (!(arr1[move.py - 4][move.px - 1].equals(" ")) && !(arr1[move.py - 4][move.px - 1].equals("█")) && ((arr1[move.py - 5][move.px - 1].equals("█")) || (arr1[move.py - 5][move.px - 1].equals(" ")))) {//üstte kalan baş harfi alma
				basHarf = arr1[move.py - 4][move.px - 1];
				kelime = kelime + basHarf;
			}
		 }	
		 
		   if(move.px > 1) {	
			 if (!(arr1[move.py - 3][move.px-2].equals(" ")) && !(arr1[move.py - 3][move.px-2].equals("█")) && ((arr1[move.py - 2][move.px-2].equals("█")) || (arr1[move.py - 2][move.px-2].equals(" ")))) {//solda kalan baş harfi alma
					basHarf = arr1[move.py - 3][move.px - 2];
					kelime = kelime + basHarf;	
			
		 }
	   }
	}
		while (temp != null) {// listenin içinde istenilen harf konumuna getirme

			if (temp.getRowCode().equalsIgnoreCase(basHarf)) {
				temp2 = temp;
				temp3 = temp2.getRight();
				break;
			} else
				temp = temp.getDown();
		}

		harf = (String.valueOf(Character.toChars(z)).toLowerCase());
		kelime = kelime + harf;
		
		arr1[move.py-3][move.px-1] = harf;
	if(move.px < 15) {	
		if(!arr1[move.py-2][move.px-1].equals(" ") && !arr1[move.py-2][move.px-1].equals("█") &&  !arr1[move.py-1][move.px-1].equals("█")) {//aşağı doğru giden yolda harf varsa ekleme
			kelime=kelime+arr1[move.py-2][move.px-1];
			a++;
		}
		else if(!arr1[move.py-3][move.px].equals(" ") && !arr1[move.py-3][move.px].equals("█") ) {//sağa doğru giden yolda harf varsa ekleme
			kelime=kelime+arr1[move.py-3][move.px];
			a++;
		}
	}	
		kontrolHarf++;
		while (!kontrol) {

			for (int i = 0; i < m1.sizeCell(basHarf); i++) {
			if(temp3.getData().length() >= kelime.length()) {	
				if (kelime.substring(a-1, a).equals(temp3.getData().substring(a - 1, a))) {
					kontrol = false;
					break;
					}
				 
				  else {
					kontrol = true;
					temp3 = temp3.getNext();
				  }
				}
			else
				temp3=temp3.getNext();
			
			}
			if (!kontrol)
				break;
		}
		
		if (!kontrol && kelime.length() != temp3.getData().length()) {
			player2Score++;
			cn.getTextWindow().setCursorPosition(30, 0);
			System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);

		} else if (!kontrol && kelime.length() == temp3.getData().length()) {
			if (kelime.substring(a-1 ,a ).equals(arr2[Move.py - 3][Move.px - 1]) || kelime.substring(a-1 ,a ).equals(arr2[Move.py - 3][Move.px])) {
				player2Score += 10;
				cn.getTextWindow().setCursorPosition(30, 0);
				System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);
			
				sll.Search3("(  )"+kelime);
				int indexofarr=linearSearch(englishWords,kelime);
	            
				if(find_word(TurkishWords, indexofarr, kelime) == true) {
					player2Score+=10;
					cn.getTextWindow().setCursorPosition(30, 0);
					System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);
				}
				m1.delete(kelime);
				kelime ="";
				kontrolHarf=0;
				a=2;
				
				word++;
				cn.getTextWindow().setCursorPosition(0, 0);
				System.out.println("Word:" + word);
			}
		}
		a++;
			if(kontrol){
				
			  player2Score -= 2;
			  cn.getTextWindow().setCursorPosition(30, 0);
			  System.out.print("SCORE : PLAYER1 =" + player1Score + "  PLAYER2 =" + player2Score);
			
			  cn.getTextWindow().setCursorPosition(60, 10);
			
			  System.out.println("ANSWER IS INCORRECT!!");
			  
			  kontrolHarf=0;
			  kelime ="";
			  a=2;
			  arr1[move.py-3][move.px-1] = " ";
			if(move.py > 3) {
			  while(!arr1[move.py-up][move.px-1].equals(" ") && !arr1[move.py-up][move.px-1].equals(basHarf) && !arr1[move.py-up][move.px-1].equals("█")) {//yukarı doğru silme
				  	 arr1[move.py-up][move.px-1] = " ";
				  	 up++;
			  }
			} 
			 if(move.px > 1) { 
			  while(!arr1[move.py-3][move.px-left].equals(" ") && !arr1[move.py-3][move.px-left].equals(basHarf) && !arr1[move.py-3][move.px-left].equals("█")) {//yukarı doğru silme
				  	 arr1[move.py-3][move.px-left] = " ";
				  	 left++;
			  }
			 }
			  up = 4;
			  left=2;
			
		}	 
			Game.Board(arr1);
			
		
	}
	
	public static boolean level2Kontrol(String[][] puzzle,String[][] solution) {
		boolean flag = false;
		
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < solution.length; j++) {
			  if(!puzzle[i][j].equals("█")) {	
				if(puzzle[i][j].equals(solution[i][j])) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
				
			  }
	    
			}		  
			if(!flag)
				break;
		}
		
		
		return flag;
	}
	
	static int linearSearch(String arr[], String n) 
    { 
        int i; 
        for(i = 0; i < arr.length; i++) 
        { 
            if(n.equals(arr[i])) 
                return i; 
        } 
        return -1; 
    } 
	static boolean find_word(String arr[], int n,String eng) {
		boolean flag=false;
     
       String answer=" ",option2="",option3=""; Scanner scn=new Scanner(System.in);		
       Game game1 = new Game();
        for(int i = 0; i <arr.length; i++) 
        { 
           answer= arr[n];
           if (n>4) {
        	   option3=arr[n-2];
        	   option2=arr[n-3];
		}
           else if (n<4) {
        	   option3=arr[n+2];
        	   option2=arr[n+3];
		}
        } String userans="";
		game1.cn.getTextWindow().setCursorPosition(0, 22);
        System.out.println("What is the meaning of "+eng+" in Turkish? Please enter your option. ");
        Random r = new Random();int score=0;
        int rndnmbr = r.nextInt(3) +1;
		if (rndnmbr==1) {
	        System.out.println("a)"+answer+" "+"b)"+option3+" "+"c)"+option2);
	        System.out.print("Answer:");
	        userans=scn.next();
	        if (userans.equalsIgnoreCase("a")||userans.equalsIgnoreCase("A")) {
	        	score=score+10;
	    		game1.cn.getTextWindow().setCursorPosition(0, 22);
				System.out.println("Answer is correct. Player gets extra 10 points.                                ");//score+10ekle	
				System.out.println("                                                                                                                                                                     ");System.out.println("                                        ");
				flag = true;
				}
	        else {
	        	game1.cn.getTextWindow().setCursorPosition(0, 22);
				System.out.println("Answer is incorrect.                                                                                                                                ");
				System.out.println("                                                                                                                                                  ");System.out.println("                                        ");

			}
		}
		if (rndnmbr==2) {
			System.out.println("a)"+option3+" "+"b)"+option2+" "+"c)"+answer+" ");
			System.out.print("Answer:");
	        userans=scn.next();
	        if (userans.equalsIgnoreCase("c")||userans.equalsIgnoreCase("C")) {
	        	score=score+10;
	    		game1.cn.getTextWindow().setCursorPosition(0, 22);
				System.out.println("Answer is correct.Player gets extra 10 points.                                    ");//score+10ekle	
				System.out.println("                                                                                                                                                                ");System.out.println("                                        ");
				flag = true;
	        }
	        else {
	        	game1.cn.getTextWindow().setCursorPosition(0, 22);
				System.out.println("Answer is incorrect.                                                                                                                                ");
				System.out.println("                                                                                                                                                  ");System.out.println("                                        ");

			}
			
		}
		if (rndnmbr==3) {
			System.out.println("a)"+option2+" "+"b)"+answer+" "+"c)"+option3+" ");
			System.out.print("Answer:");
	        userans=scn.next();
	        if (userans.equalsIgnoreCase("b")||userans.equalsIgnoreCase("B")) {
	    		score=score+10;
	    		game1.cn.getTextWindow().setCursorPosition(0, 22);
				System.out.println("Answer is correct.Player gets extra 10 points.                                           ");//score+10ekle
				System.out.println("                                                                                                                                                 ");System.out.println("                                        ");
				flag = true;
	        }
	        else {
	    		game1.cn.getTextWindow().setCursorPosition(0, 22);
				System.out.println("Answer is incorrect.                                                                                                                                ");
				System.out.println("                                                                                                                                                  ");System.out.println("                                        ");

			}
			
		}
		
		//game1.cn.getTextWindow().setCursorPosition(0, 22); metodu kullandıktan sonra bu koordinata boşluk atarız.
		return flag;
    	} 
	
 	public static void fordll(DLL dll1) {

    Node current=dll1.head;
    dll2.head=null;
   while (current != null)
   { 
        dll2.sortedInsert(current.getNumber(), current.getData()); ///aynıysa alfabetik sıralıyor.Bu işlemi yapmazsak eğer oyuncunun skoruna göre sıralıyor ,aynı puan gelirse yeni yapılmış olanı önce yazıyor.
           current= current.getNext(); 
   }
}
}
