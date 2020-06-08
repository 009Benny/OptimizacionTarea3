
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
public final class MG1 {
    private final Scanner in;
    private final float lambda;
    private final float miu;
    private final float sigma;
    private final float ro;
    private final float lq;
    private final float ls;
    private final float Wq;
    private final float Ws;
    private final float P0;
    private final float Pw;
    
    public MG1(){
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
        System.out.print("Ingresa el numero de sigma: ");
        float numSigma = this.in.nextFloat();
        
        this.lambda = numClientes / numServicios;
        this.miu = tiempoServicio;
        this.sigma = numSigma;
        this.ro = this.lambda / this.miu;
        this.lq = this.calculaLq();
        this.ls = this.calculaLs();
        this.Wq = this.calculaWq();
        this.Ws = this.calculaWs();
        //probabilidad
        this.P0 = this.calculaP0();
        this.Pw = this.calculaPw();
        this.imprimirResultados();
    }
    
    public float calculaLq(){
    //(lambda)2*(sigma)2 + (ro)2 / 1(1-ro)
        float result = (float) ( ( Math.pow(this.lambda,2)*Math.pow(this.sigma, 2)) + Math.pow(this.ro, 2) );
        result  = result / (2*(1-this.ro));
        return (float) Math.ceil(result);
    }
    
    public float calculaLs(){
    // lq + ro
        float result = this.lq + this.ro;
        return (float) Math.ceil(result);
    }
    
    public float calculaWq(){
    //lq / lambda
        float result = this.lq / this.lambda;
        return result;
    }
    
    public float calculaWs(){
    //  Wq + (1 / miu)
        float result = this.Wq + (1 / this.miu);
        return result;
    }
    
    public float calculaP0(){
        // 1 - ro
        float result = 1 - this.ro;
        return result;
    }
    
    public float calculaPw(){
        // ro elevado a n+1
        float result = this.ro;
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
        System.out.println("P0: " + this.P0);
        System.out.println("Pw: " + this.Pw);
    }
}
