package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe
{

    private final JavaCSG csg;
    private  final double lineWidth = 3.0;
    private final double heigth = 3.0;
    private final double squareSize = 15.0;
    private final double tolerance = 0.4;
    private final int angularRes = 64;

    public TicTacToe(JavaCSG csg)
    {
        this.csg = csg;
    }

    public Geometry3D Cross()
    {
        var line1 = csg.box3D(2*squareSize,lineWidth,heigth,false);
        var line2 = csg.rotate3D(csg.degrees(0), csg.degrees(0), csg.degrees(90)).transform(line1);

        var shape = csg.union3D(line1,line2);

        return shape;

    }

    public Geometry3D cirkel()
    {
        Geometry3D cirkel = csg.cylinder3D(squareSize - tolerance, heigth, angularRes,false);
        Geometry3D hole = csg.cylinder3D(squareSize-tolerance-lineWidth, heigth, angularRes, false);
        return csg.difference3D(cirkel,hole);
    }

    public Geometry3D bord()
    {

        List<Geometry3D> parts = new ArrayList<>();
        double beamLength = 3*squareSize + 4*lineWidth;
        Geometry3D hbeam = csg.box3D(beamLength,lineWidth,heigth,false);
        hbeam = csg.translate3D(0.5*beamLength,0.5*lineWidth,0).transform(hbeam);

        for(int i = 0; i< 4; i++)
        {
            parts.add(csg.translate3DY(i*(squareSize + lineWidth)).transform(hbeam));
        }

        return hbeam;
    }




}
