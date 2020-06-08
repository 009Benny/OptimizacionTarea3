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
public class MD1 {
    private Scanner in;
    private float lambda;
    private float miu;
    private float ro;
    private float lq;
    private float ls;
    private float Wq;
    private float Ws;
    
    public MD1(){
        this.in = new Scanner(System.in);
        System.out.println("");
        System.out.println(" M/M/1 ");
        System.out.println("");
        System.out.println("Ingresa el numero de clientes por hora: ");
        int numClientes = this.in.nextInt();
        System.out.print("Ingresa el numero de servicios: ");
        int numServicios = this.in.nextInt();
        System.out.print("Ingresa el numero promedio de tiempo que tarda el servicio: ");
        int tiempoServicio = this.in.nextInt();
        
        this.lambda = numClientes / numServicios;
        this.miu = tiempoServicio;
        this.ro = this.lambda / this.miu;
        this.lq = this.calculaLq();
        this.Wq = this.calculaWq();
        this.Ws = this.calculaWs();
        this.ls = this.calculaLs();
        this.imprimirResultados();
    }
    
    public float calculaLq(){
    // (ro)2 / (2(1-ro))
        float result = (float) (Math.pow(this.ro, 2) / (2*(1 - this.ro)));
        return (float) Math.ceil(result);
    }
    
    public float calculaLs(){
    // lambda*Ws
        float result = this.lambda * this.Ws;
        return (float) Math.ceil(result);
    }
    
    public float calculaWq(){
    // lq / lambda
        float result = this.lq / this.lambda;
        return result;
    }
    
    public float calculaWs(){
    // Wq + (1/miu)
        float result = Wq + (1/this.miu);
        return result;
    }
    
    public void imprimirResultados(){
        System.out.println("");
        System.out.println("Impresion de resultados");
        System.out.println("Lambda: " + this.lambda);
        System.out.println("Miu: " + this.miu);
        System.out.println("Ro: " + this.ro);
        System.out.println("Lq: " + this.lq);
        System.out.println("Ls: " + this.ls);
        System.out.println("Wq: " + this.Wq);
        System.out.println("Ws: " + this.Ws);
    }
}
