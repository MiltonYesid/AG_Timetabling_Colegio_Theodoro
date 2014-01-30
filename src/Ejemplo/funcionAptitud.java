/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

/**
 *
 * @author Salandrews
 */

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

public class funcionAptitud extends FitnessFunction {

    private double fitness; //La variable que llevará el valor de aptitud

    public funcionAptitud() {
        
    }

    @Override
    public double evaluate(IChromosome cromosoma) {
        //se establece el valor de cada funcion
        fitness = 0;
        verificarRepetidos(cromosoma);
        if(fitness!=0)
        {
        evaluarHorizontal1(cromosoma);
        evaluarHorizontal2(cromosoma);
        evaluarHorizontal3(cromosoma);

        evaluarVertical1(cromosoma);
        evaluarVertical2(cromosoma);
        evaluarVertical3(cromosoma);

        evaluarDiagonal1(cromosoma);
        evaluarDiagonal2(cromosoma);
        }
        

        return fitness;
    }

     //Funciones
    public void verificarRepetidos(IChromosome cromosoma) {
        //Verificamos que el valor de una casilla no se encuentre repetido, si es asi sumamos 5, sino no se suma nada

        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele();
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele();
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();
        Gene[] vector = cromosoma.getGenes();
        int cantidadRepetidos = 0;
        int c = -1;
//        for (int j = 0; j < 9; j++) {
//            c1.equals(j)
//        }


        if ((((c1.compareTo(c2) != 0) && (c1.compareTo(c3) != 0)) && ((c1.compareTo(c4) != 0) && (c1.compareTo(c5) != 0))) && (((c1.compareTo(c6) != 0) && (c1.compareTo(c7) != 0)) && ((c1.compareTo(c8) != 0) && (c1.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }

        if ((((c2.compareTo(c1) != 0) && (c2.compareTo(c3) != 0)) && ((c2.compareTo(c4) != 0) && (c2.compareTo(c5) != 0))) && (((c2.compareTo(c6) != 0) && (c2.compareTo(c7) != 0)) && ((c2.compareTo(c8) != 0) && (c2.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }
        if ((((c3.compareTo(c2) != 0) && (c3.compareTo(c1) != 0)) && ((c3.compareTo(c4) != 0) && (c3.compareTo(c5) != 0))) && (((c3.compareTo(c6) != 0) && (c3.compareTo(c7) != 0)) && ((c3.compareTo(c8) != 0) && (c3.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }
        if ((((c4.compareTo(c2) != 0) && (c4.compareTo(c3) != 0)) && ((c4.compareTo(c1) != 0) && (c4.compareTo(c5) != 0))) && (((c4.compareTo(c6) != 0) && (c4.compareTo(c7) != 0)) && ((c4.compareTo(c8) != 0) && (c4.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }
        if ((((c5.compareTo(c2) != 0) && (c5.compareTo(c3) != 0)) && ((c5.compareTo(c4) != 0) && (c5.compareTo(c1) != 0))) && (((c5.compareTo(c6) != 0) && (c5.compareTo(c7) != 0)) && ((c5.compareTo(c8) != 0) && (c5.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }
        if ((((c6.compareTo(c2) != 0) && (c6.compareTo(c3) != 0)) && ((c6.compareTo(c4) != 0) && (c6.compareTo(c5) != 0))) && (((c6.compareTo(c1) != 0) && (c6.compareTo(c7) != 0)) && ((c6.compareTo(c8) != 0) && (c6.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }
        if ((((c7.compareTo(c2) != 0) && (c7.compareTo(c3) != 0)) && ((c7.compareTo(c4) != 0) && (c7.compareTo(c5) != 0))) && (((c7.compareTo(c6) != 0) && (c7.compareTo(c1) != 0)) && ((c7.compareTo(c8) != 0) && (c7.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }

        if ((((c8.compareTo(c2) != 0) && (c8.compareTo(c3) != 0)) && ((c8.compareTo(c4) != 0) && (c8.compareTo(c5) != 0))) && (((c8.compareTo(c6) != 0) && (c8.compareTo(c7) != 0)) && ((c8.compareTo(c1) != 0) && (c8.compareTo(c9) != 0)))) {
            fitness = fitness + 5;
        }

        if ((((c9.compareTo(c2) != 0) && (c9.compareTo(c3) != 0)) && ((c9.compareTo(c4) != 0) && (c9.compareTo(c5) != 0))) && (((c9.compareTo(c6) != 0) && (c9.compareTo(c7) != 0)) && ((c9.compareTo(c8) != 0) && (c9.compareTo(c1) != 0)))) {
            fitness = fitness + 5;
        }
        

    }

    public void evaluarHorizontal1(IChromosome cromosoma) {
        //Casillas 1,2 y 3
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele();
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();

        if (c1 + c2 + c3 == 15)//Si la suma de la horizontal es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarHorizontal2(IChromosome cromosoma) {
        //Casillas 4,5 y 6
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();

        if (c4 + c5 + c6 == 15)//Si la suma de la horizontal es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarHorizontal3(IChromosome cromosoma) {
        //Casillas 7,8 y 9
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele();
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();

        if (c7 + c8 + c9 == 15) //Si la suma de la horizontal es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarVertical1(IChromosome cromosoma) {
        //Casillas 7,4 y 1
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele();
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();

        if (c7 + c4 + c1 == 15) //Si la suma de la vertical es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarVertical2(IChromosome cromosoma) {
        //Casillas 7,4 y 1
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele();

        if (c8 + c5 + c2 == 15) //Si la suma de la vertical es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarVertical3(IChromosome cromosoma) {
        //Casillas 7,4 y 1
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();

        if (c9 + c6 + c3 == 15) //Si la suma de la vertical es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarDiagonal1(IChromosome cromosoma) {
        //Casillas 7,5 y 3
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();

        if (c7 + c5 + c3 == 15) //Si la suma de la diagonal es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

    public void evaluarDiagonal2(IChromosome cromosoma) {
        //Casillas 1,5 y 9
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();

        if (c1 + c5 + c9 == 15) //Si la suma de la diagonal es 15, sumamos 15
        {
            fitness = fitness + 15;
        }
    }

}
