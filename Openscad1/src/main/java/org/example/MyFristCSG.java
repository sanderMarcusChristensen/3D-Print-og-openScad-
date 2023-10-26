package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsg.Transform3D;

public class MyFristCSG {
    public static void main (String[] args)
    {
       JavaCSG csg = JavaCSGFactory.createNoCaching();

       //TorsdagsHolder Chad = new TorsdagsHolder(csg);
       //Chad.Holder();


        TorsdagsBox Dave = new TorsdagsBox(csg);
        Dave.box();


        //Corss Jens = new Corss(csg);
        //Jens.ComHerCorss();

        //Circle Mark = new Circle(csg);
        //Mark.comHerCircel();

        //Bord Steve = new Bord(csg);
        //Steve.comHerBord();









    }


}
