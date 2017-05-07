package unPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Juego {
	private String[][] mat;
	private StringBuilder[] vec;
	private StringBuilder[] vecInv;
	
	Juego(String path) throws FileNotFoundException {
		int aux;
		int i = 0;
		Scanner sc = new Scanner(new File(path));
		aux = sc.nextInt();
		mat = new String[aux][aux];
		aux = sc.nextInt();
		vec = new StringBuilder[aux]; 
		vecInv = new StringBuilder[aux];
		sc.nextLine();
		while(sc.hasNextLine() && i<mat.length ) {
			mat[i] = sc.nextLine().split("");
			i++;
		}
		i = 0;
		while(sc.hasNextLine()) {
			vec[i] = new StringBuilder(sc.nextLine());
			vecInv[i] = new StringBuilder(vec[i].toString());
			vecInv[i] = vecInv[i].reverse();
			i++;
		}
		sc.close();
	}

	public String[][] getMat() {
		return mat;
	}

	public void setMat(String[][] mat) {
		this.mat = mat;
	}

	public StringBuilder[] getVec() {
		return vec;
	}

	public void setVec(StringBuilder[] vec) {
		this.vec = vec;
	}

	public StringBuilder[] getVecInv() {
		return vecInv;
	}

	public void setVecInv(StringBuilder[] vecInv) {
		this.vecInv = vecInv;
	}
	
	public void resolver() {
		StringBuilder aux;
		this.trasponer();
		int k = 0;
		while(k < vec.length){
			for (int i = 0; i < mat.length; i++) {
				aux = new StringBuilder(Arrays.toString(mat[i]).replaceAll("[^\\w]", ""));
				for (int j = 0; j < mat.length; j++) {
					if( (mat[i].length >= j+vec[k].length()) && 
							(vec[k].toString().equals(aux.substring(j, j+vec[k].length()))
							||
							vecInv[k].toString().equals(aux.substring(j, j+vec[k].length())
							))) {
						System.out.println("FUNCA");
						//HAY QUE CAMBIAR POR UN WHILE PARA QUE DEJE DE COMPARAR
	//					return;
					}
					if(mat[i].length >= j+vec[k].length()){
						j = mat[i].length;
					}
	//				i++;
				}
			}
			k++;
		}
		System.out.println("FAILLL");
	}
	
	public void trasponer() {
		String aux = null;
		for (int i = 0; i < this.mat.length - 1; i++) {
			for (int j = i + 1; j < this.mat.length; j++) {
				aux = this.mat[i][j];
				this.mat[i][j] = this.mat[j][i];
				this.mat[j][i] = aux;
			}
		}
	}
}
