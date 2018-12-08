package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine();   //дедушка
        Cat catGrandpa = new Cat(grandpaName, null, null);

        String grandmaName = reader.readLine();   // бабушка
        Cat catGrandma = new Cat(grandmaName, null, null);

        String papaName = reader.readLine();    //папа
        Cat catPapa = new Cat(papaName, null,catGrandpa);

        String mamaName = reader.readLine();   //мама
        Cat catMama = new Cat(mamaName, catGrandma, null);

        String soonName = reader.readLine();  //сын
        Cat catSoon = new Cat(soonName, catMama, catPapa);

        String daughterName = reader.readLine();  //дочь
        Cat catDaughter = new Cat(daughterName, catMama, catPapa);

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catPapa);
        System.out.println(catMama);
        System.out.println(catSoon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentfemale;
        private Cat parentmale;



        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentfemale, Cat parentmale) {
            this.name = name;
            this.parentfemale = parentfemale;
            this.parentmale = parentmale;




        }

        @Override
        public String toString() {
            if (parentfemale == null && parentmale == null) {
                return "The cat's name is " + name + ", no mother, no father ";
            }
            if (parentfemale == null && parentmale != null) {
                return "The cat's name is " + name + ", no mother, father is " + parentmale.name;
            }
            if(parentfemale != null && parentmale == null){
                return "The cat's name is " + name + ", mother is " + parentfemale.name + " , no father ";

            }
            if (parentmale != null && parentfemale != null) {
                return "The cat's name is " + name + ", mother is " + parentfemale.name + ", father is " + parentmale.name;
            }
            return null;
        }
    }

}
