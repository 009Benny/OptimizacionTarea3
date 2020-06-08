/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author Benny Reyes Sosa
 */
public final class Markov {
    private Scanner in;
    private String[] statesNames;
    private double[][] matriz;
    private double[] initialValues;
    private int r, iteraciones;
    private double[][] matrizActual;
    private double[] actualValues;
    
    
    public Markov(){
        this.in = new Scanner(System.in);
        int r = 3; // numero de estados
        System.out.println("");
        System.out.println(" Cadenas de Markov");
        System.out.println("");
        do{
            if (r < 2){
                System.out.println("Numero invalido, tiene que ser al menos 2 estados");
            }
            System.out.println("Ingresa el numero de estatdos: ");
            r = this.in.nextInt();
        }while(r < 2);
        this.r = r;
        this.nombrarEstados();
        this.llenarMatriz();
        this.valoresIniciales();
        this.calcularCadena();
    }
    
    public void nombrarEstados(){
        this.statesNames = new String[this.r];
        for (int i = 0; i < this.r; i++) {
            System.out.println("");
            System.out.print("Ingresa el nombre del estado " + i + ": ");
            this.statesNames[i] = this.in.next();
        }
    }
    
    public void llenarMatriz(){
        System.out.println("");
        System.out.println("Llenar matriz");
        this.matriz = new double[this.r][this.r];
        for (int i = 0; i < this.r; i++) {
            double suma = 0;
            for (int j = 0; j < this.r; j++) {
                double aux = 0;
                do{
                    if(aux < 0){
                        System.out.println("Solo se permiten valores positivos");
                    }
                    System.out.println("Ingresa el valor para la combinacion [" + this.statesNames[i] + ", " + this.statesNames[j] + "]: ");
                    aux = this.in.nextDouble();
                }while(aux < 0);
                this.matriz[i][j] = aux;
                suma += aux;
            }
            if (suma != 1){
                System.out.println("La suma de todos los elementos de una fila deben dar como resultado 1");
                exit();
                break;
            }
        }
        this.imprimirMatriz();
    }
    
    public void imprimirMatriz(){
        System.out.println("");
        System.out.print("  ");
        for (int i = 0; i < this.r; i++) {
            System.out.print("   "+this.statesNames[i]);
        }
        for (int i = 0; i < this.r; i++) {
            System.out.println("");
            System.out.print(this.statesNames[i]);
            for (int j = 0; j < this.r; j++) {
                System.out.print(" " + this.matriz[i][j]);
            }
        }
        System.out.println("");
        System.out.println("");
    }
    
    public void valoresIniciales(){
        System.out.println("");
        System.out.println("Valores iniciales");
        System.out.println("");
        int aux = 1;
        do{
            if(aux < 1){
                System.out.println("Tienes que ingresar un numero entero mayor a 0");
            }
            System.out.println("Ingresa el numero de iteraciones: ");
            aux = this.in.nextInt();
        }while(aux < 1);
        this.iteraciones = aux;
        
        double[] iniValues = new double[this.r];
        for (int i = 0; i < this.r; i++) {
            double value = 0;
            do{
                if (value < 0){
                    System.out.println("No puedes ingresar un valor negativo");
                }
                System.out.println("Ingresa el valor inicial para el estado [" + this.statesNames[i] + "]: ");
                value = this.in.nextDouble();
            }while(value < 0);
            iniValues[i] = value;
        }
        this.initialValues = iniValues;
    }
    
    public void calcularCadena(){
        this.matrizActual = matriz;
        for (int i = 0; i < this.iteraciones; i++) {
            System.out.println("Calculando iteracion "+i);
            System.out.println("");
            this.calcularIteracion();
            System.out.println("");
            this.calcularNuevaMatriz();
        }
    }
    
    public void calcularIteracion(){
        double[] results = new double[this.r];
        for (int i = 0; i < this.r; i++) {
            results[i] = 0;
        }
        for (int i = 0; i < this.r; i++) {
            for (int j = 0; j < this.r; j++) {
                results[j] += this.initialValues[i] * this.matrizActual[i][j];
            }
        }
        System.out.println("El resultado para esta iteracion es: ");
        System.out.println(Arrays.toString(results));
    }
    
    public void calcularNuevaMatriz(){
        double[][] results = new double[this.r][this.r];
        for (int i = 0; i < this.r; i++) {
            for (int j = 0; j < this.r; j++) {
                results[i][j] = 0;
            }
        }
        
        for (int k = 0; k < this.r; k++) {
            for (int i = 0; i < this.r; i++) {
                for (int j = 0; j < this.r; j++) {
                    double value = this.matrizActual[i][k] * this.matrizActual[k][j];
                    results[i][j] += value;
                }
            }
        }
        
        this.matrizActual = results;
        this.imprimirActualMatriz();
        
    }
    
    public void imprimirActualMatriz(){
        System.out.println("");
        System.out.print("  ");
        for (int i = 0; i < this.r; i++) {
            System.out.print("   "+this.statesNames[i]);
        }
        for (int i = 0; i < this.r; i++) {
            System.out.println("");
            System.out.print(this.statesNames[i]);
            for (int j = 0; j < this.r; j++) {
                System.out.print(" " + this.matrizActual[i][j]);
            }
        }
        System.out.println("");
        System.out.println("");
    }
    
}
