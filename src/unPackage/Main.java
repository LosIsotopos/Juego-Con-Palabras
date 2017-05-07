package unPackage;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String number = new String("2");
		String j = new String("juego" + number + ".in");
		Juego j1 = new Juego(j);
//		String[][] m1 = j1.getMat();
//		for (int i = 0; i < m1.length; i++) {
//			for (int j = 0; j < m1.length; j++) {
//				System.out.print(m1[i][j]);
//			}
//			System.out.println();
//		}
		
//		for (int i = 0; i < j1.getVec().length; i++) {
//			System.out.println(j1.getVec()[i].toString());
//		}
		j1.resolver();
	}

}
