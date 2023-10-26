package org.example;

import org.abstractica.javacsg.Geometry;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.Transform3D;

import java.util.ArrayList;
import java.util.List;

public class TorsdagsBox
{
    private final JavaCSG csg;

    private final double length = 20.0;
    private final double width = 16.0;
    private final double heigth = 6.0;
    private final boolean mid = false;


    private final double cutLength = 18.0;
    private final double cutWidth = 12.0;
    private final double cutHeigth = 7.0;

    private final double cyl1 = 2.0;
    private final double cyl2 = 2.0;
    private final int cyl3 = 32;



    public TorsdagsBox(JavaCSG csg)
    {
        this.csg = csg;
    }


    public Geometry3D box()
    {
        var bigBox = csg.box3D(length, width,heigth,mid);
        var cutBox = csg.box3D(cutLength, cutWidth,cutHeigth,mid);
        cutBox = csg.translate3DZ(2).transform(cutBox);

        List<Geometry3D> Hols = new ArrayList<>();
        var h1 = csg.cylinder3D(cyl1, cyl2, cyl3, false);
        h1 = csg.rotate3DX(csg.degrees(90)).transform(h1);
        h1 = csg.translate3D(length/3, width/2, heigth/2).transform(h1);

        for( int i = 0; i < 3; i++)
        {
            Hols.add(csg.translate3DX (-i*(length/3)).transform(h1));
             csg.union3D(Hols);
        }

        Geometry3D uniHols = csg.union3D(Hols);

        var boxy = csg.difference3D(bigBox,cutBox,uniHols);




        csg.view(boxy);


        return boxy ;

    }


}
