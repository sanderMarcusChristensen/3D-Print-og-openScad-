package org.example;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.JavaCSG;

public class Circle
{
    private final JavaCSG csg;

    private final double x = 5.0;
    private final double y = 1.0;
    private final int radius = 128;
    private final boolean mid = false;


    public Circle(JavaCSG csg)
    {
        this.csg = csg;
    }


    public Geometry comHerCircel()
    {
        var b1 = csg.cylinder3D(x,y,radius,mid);

        var b2 = csg.cylinder3D(x,y,radius -28,mid);

        var B = csg.difference3D(b1,b2);

        var shape = csg.union3D(B);

        csg.view(shape);

        return shape;
    }







}
