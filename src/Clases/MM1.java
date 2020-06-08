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
public class MM1 {
    private Scanner in;
    private float lambda;
    private float miu;
    private int n;
    private float t;
    private float ro;
    private float lq;
    private float ls;
    private float Wq;
    private float Ws;
    private float Pn;
    private float Pls;
    private float PWs;
    private float PWq;
    
    public MM1(){
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
        System.out.print("Ingresa el numero de n para probabilidad: ");
        int num = this.in.nextInt();
        System.out.print("Ingresa el numero de t para probabilidad: ");
        int numt = this.in.nextInt();
        
        this.lambda = numClientes / numServicios;
        this.miu = tiempoServicio;
        this.n = num;
        this.t = numt;
        this.ro = this.lambda / this.miu;
        this.lq = this.calculaLq();
        this.ls = this.calculaLs();
        this.Wq = this.calculaWq();
        this.Ws = this.calculaWs();
        //probabilidad
        this.Pn = this.calculaPn();
        this.Pls = this.calculaPls();
        this.PWs = this.calculaPWs();
        this.PWq = this.calculaPWq();
        this.imprimirResultados();
    }
    
    public float calculaLq(){
    //(lambda)2 / (miu(miu - lambda)
        float result = (this.lambda * this.lambda) / ( this.miu * (this.miu - this.lambda));
        return result;
    }
    
    public float calculaLs(){
    // lambda / (lambda - miu)
        float result = this.lambda / ( this.lambda - this.miu);
        return result;
    }
    
    public float calculaWq(){
    //lambda / miu(miu - lambda)
        float result = this.lambda / (this.miu * (this.miu - this.lambda));
        return result;
    }
    
    public float calculaWs(){
    //  1 / miu - lambda
        float result = 1 / (this.miu - this.lambda);
        return result;
    }
    
    public float calculaPn(){
        // (1-ro)*ro2
        float result = (1 - this.ro) * (this.ro * this.ro);
        return result;
    }
    
    public float calculaPls(){
        // ro elevado a n+1
        int value = this.n + 1;
        float result = (float) Math.pow(this.ro, value);
        System.out.println("Base: "+this.ro+ " con potencia: "+value);
        return result;
    }
    
    public float calculaPWs(){
        //euler elevado a -miu*(1-ro)t
        float potencia = (this.miu * -1)*(1 - this.ro)* this.t;
        float result = (float) Math.exp(potencia);
        return result;
    }
    
    public float calculaPWq(){
        //ro * euler elevado a -miu*(1-ro)t
        float potencia = (this.miu * -1)*(1 - this.ro)* this.t;
        float result = (float) (this.ro * Math.exp(potencia));
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
        System.out.println("Probabilidaid");
        System.out.println("Pn: " + this.Pn);
        System.out.println("Pls: " + this.Pls);
        System.out.println("PWs: " + this.PWs);
        System.out.println("PWq: " + this.PWq);
    }
    
}
