/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Scanner;

/**
 *
 * @author Benny Reyes Sosa
 */
public class Menu {
    public Menu() {
        int option = 0;
        do{
            option = this.printMenu();
            this.selectorAction(option);
        }while(option != 0);
    }
    
    private int printMenu(){
        int option = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Selecciona el la acción a realizar");
            System.out.println("0.-Salir");
            System.out.println("1.-Cadenas de Markov");
            System.out.println("Teorias de Filas:");
            System.out.println("2-M/M/1");
            System.out.println("3-M/G/1");
            System.out.println("4-M/D/1");
            System.out.println("5-M/Ek/1");
            System.out.println("");
            System.out.println("Ingresa tu opción: ");
            option = in.nextInt();
        }while(option > 5 || option < 0);
        return option;
    }
    
    private void selectorAction(int option){
        switch(option){
            case 1:
                Markov obj = new Markov();
                break;
            case 2:
                MM1 obj1 = new MM1();
                break;
            case 3:
                MG1 obj2 = new MG1();
                break;
            case 4:
                MD1 obj3 = new MD1();
                break;
            case 5:
                MEk1 obj4= new MEk1();
                break;
        }
    }
}
