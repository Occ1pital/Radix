/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radix;

import java.util.*;
class RadixSort {
 public static void main (String [] args){
    String[] arreglo = {"$","Alemania","alemania","7"};
    radixSort(arreglo,' ','z');
    for(int i=0;i<arreglo.length;i++){
      System.out.println(arreglo[i]);
    }
  }
 
  public static void Ordenamiento(String[] arreglo,int indice,char m,char M){
    int[] ArregloContador = new int[(M-m)+2];
    String[] ArregloTemporal = new String[arreglo.length];
    Arrays.fill(ArregloContador,0);
 
 
    for(int i=0;i<arreglo.length;i++){
      int charindice = (arreglo[i].length()-1 < indice) ? 0 : ((arreglo[i].charAt(indice) - m)+1);
      ArregloContador[charindice]++;
    }
 
 
    for(int i=1;i<ArregloContador.length;i++){
      ArregloContador[i] += ArregloContador[i-1];
    }
 
    for(int i=arreglo.length-1;i>=0;i--){
      int charindice = (arreglo[i].length()-1 < indice) ? 0 : (arreglo[i].charAt(indice) - m)+1;
      ArregloTemporal[ArregloContador[charindice]-1] = arreglo[i];
      ArregloContador[charindice]--;
    }
 
    for(int i=0;i<ArregloTemporal.length;i++){
      arreglo[i] = ArregloTemporal[i];
    }
  }
 
  public static void radixSort(String[] arreglo,char m,char M){
    int maxindice = 0;
    for(int i=0;i<arreglo.length;i++){
      if(arreglo[i].length()-1 > maxindice){
        maxindice = arreglo[i].length()-1;
      }
    }
 
    for(int i=maxindice;i>=0;i--){
      Ordenamiento(arreglo,i,m,M);
    }
  }
}