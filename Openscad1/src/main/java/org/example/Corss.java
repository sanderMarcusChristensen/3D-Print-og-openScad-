package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Corss {

    private final  JavaCSG csg;
    private final double length = 5.0;
    private final double width = 1.0;
    private final double heigth = 6.0;
    private final boolean mid = false;


    public Corss (JavaCSG csg)
    {
        this.csg = csg;

    }





    public Geometry3D ComHerCorss()
    {
        var line1 = csg.box3D(length,width,heigth,mid);
        var line2 = csg.rotate3D(csg.degrees(0), csg.degrees(0), csg.degrees(90)).transform(line1);

        var shape = csg.union3D(line1,line2);
        csg.view(shape);

        return shape;
    }




}
