// Scrivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, partendo da 20.

public class Es_2 {

	public static void main(String[] args) {
		for(int i = 20; i > 0; i--) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
	}

}