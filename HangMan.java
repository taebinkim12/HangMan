package BeforeUni;
import java.util.*;

public class HangMan {

	private static int NumInctGuess = 0;
	// You can add more words here in "Library"
	private static String[] Library = {"first word", "second" , "banana"};
	static Random random = new Random();
	static int num = random.nextInt(Library.length-1);
	private static String Answer = Library[num];
	private static String Word = Answer.toLowerCase().replaceAll("[^ ]", "-");
	private static boolean[] revealed = new boolean [Answer.length()];

	public static void main(String[] args) {

		TakeSpaceOut();
		Scanner scan = new Scanner(System.in);
		System.out.println(Word);
		System.out.println("Enter your guess");
		char guess = scan.next().toLowerCase().charAt(0);

		while(NumInctGuess<=7) {
			if(Answer.indexOf(guess) != -1) {
				for(int a =0;a<Answer.length();a++) {
					if(Answer.charAt(a)==guess) {
						revealed[a]=true;
					}
				}

				printHangman();
				PrintRevealed();
				
				if(isDone()==false) {
				System.out.println("Enter your guess");
				guess = scan.next().toLowerCase().charAt(0);
				
				}else if(isDone()==true) {
					System.out.println("Congratulations!");
					return;
				}
			}else {
				NumInctGuess++;
				printHangman();
				if(NumInctGuess==7) {
					System.out.println("Game over");
					return;
				}
				PrintRevealed();
				
				if(isDone()==false) {
				System.out.println("Enter your guess");
				guess = scan.next().toLowerCase().charAt(0);
				}else if(isDone()==true) {
					System.out.println("Congratulations!");
					return;
				}

			}


		} //while loop
	} //main


	public static void printHangman () {

		if(NumInctGuess == 0){
			System.out.println("");
			System.out.println("");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");

		}else if(NumInctGuess == 1) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");

		}else if(NumInctGuess == 2) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println("  |");
			System.out.println(" ");
			System.out.println(" ");

		}else if(NumInctGuess == 3) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println(" /|");
			System.out.println("    ");
			System.out.println("   ");

		}else if(NumInctGuess == 4) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println(" /|\\");
			System.out.println("     ");
			System.out.println("  ");

		}else if(NumInctGuess == 5) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println(" /|\\");
			System.out.println("  |   ");
			System.out.println("   ");

		}else if(NumInctGuess == 6) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println(" /|\\");
			System.out.println("  |   ");
			System.out.println(" /  ");

		}else if(NumInctGuess == 7) {
			System.out.println("");
			System.out.println("  O   ");
			System.out.println(" /|\\");
			System.out.println("  |   ");
			System.out.println(" / \\  ");
		}

	} //method done

	public static void TakeSpaceOut () {
		for(int a =0;a<Answer.length();a++) {
			if(Answer.charAt(a)==' ') {
				revealed[a]=true;
			}
		}
	}

	public static void PrintRevealed () {
		for(int a = 0; a<Answer.length();a++) {
			if(revealed[a]==true) {
				System.out.print(Answer.charAt(a));
			}else {
				System.out.print(Word.charAt(a));
			}
		}
		System.out.println("");
	}

	public static boolean isDone() {
		for(int a=0; a<Answer.length();a++) {
			if(revealed[a]==false) {
				return false;
			}
		}
		return true;
	}
}
