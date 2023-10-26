package org.example;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Bord
{
    private final JavaCSG csg;
    private final double length = 12.0;
    private final double width = 12.0;
    private final double heigth = 3.0;
    private final boolean mid = false;

    private final double bigBoyL = 45.0;
    private final double bigBoyW = 45.0;



    public Bord (JavaCSG csg)
    {
        this.csg = csg;

    }

    public Geometry3D comHerBord()
    {
        var gridBox = csg.box3D(bigBoyL,bigBoyL,heigth,mid);

        var cutBox1 = csg.box3D(12,12,3,false);
        var cutBox2 = csg.box3D(12,12,3,false);
        var cutBox3 = csg.box3D(12,12,3,false);
        var cutBox4 = csg.box3D(12,12,3,false);
        var cutBox5 = csg.box3D(12,12,3,false);
        var cutBox6 = csg.box3D(12,12,3,false);
        var cutBox7 = csg.box3D(12,12,3,false);
        var cutBox8 = csg.box3D(12,12,3,false);
        var cutBox9 = csg.box3D(12,12,3,false);

        cutBox1 = csg.translate3D(14,14,1).transform(cutBox1);
        cutBox2 = csg.translate3D(0,14,1).transform(cutBox2);
        cutBox3 = csg.translate3D(14,0,1).transform(cutBox3);
        cutBox4 = csg.translate3D(-14,-14,1).transform(cutBox4);
        cutBox5 = csg.translate3D(0,-14,1).transform(cutBox5);
        cutBox6 = csg.translate3D(-14,0,1).transform(cutBox6);
        cutBox7 = csg.translate3D(0,0,1).transform(cutBox7);
        cutBox8 = csg.translate3D(-14,14,1).transform(cutBox8);
        cutBox9 = csg.translate3D(14,-14,1).transform(cutBox9);


        var cutShape = csg.difference3D(gridBox,cutBox1,cutBox2,cutBox3,cutBox4,cutBox5,cutBox6,cutBox7,cutBox8,cutBox9);
        var union = csg.union3D(cutShape);
        csg.view(union);

        return union;
    }




}
