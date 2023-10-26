package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class TorsdagsHolder
{

    private final JavaCSG csg;
    private final double length = 10.0;
    private final int width = 10;
    private final  double heigth = 1.5;
    private final boolean mid = false;

    private final double smallwallLength = 10.0;
    private final int smallWallWidth = 2;
    private final double smallWallHeigth = 0.5;

    private final double cyl1 = 2.0;
    private final double cyl2 = 2.0;
    private final int cyl3 = 32;


    public TorsdagsHolder(JavaCSG csg)
    {
        this.csg = csg;
    }


    public Geometry3D Holder()
    {

        Geometry3D shelf = csg.box3D(length,width,heigth,mid);


        Geometry3D wall = csg.box3D(length,width-3,heigth,mid);
        wall = csg.rotate3DX(csg.degrees(90)).transform(wall);
        wall = csg.translate3DY(5).transform(wall);
        wall = csg.translate3DZ(5).transform(wall);

        Geometry3D smallWallFornt = csg.box3D(smallwallLength,smallWallWidth,smallWallHeigth,mid);
        smallWallFornt  = csg.rotate3DX(csg.degrees(90)).transform(smallWallFornt);
        smallWallFornt = csg.translate3DY(-5).transform(smallWallFornt);
        smallWallFornt = csg.translate3DZ(1).transform(smallWallFornt);

        Geometry3D disco = csg.sphere3D(length-6,width-6,mid);


        Geometry3D P1 = csg.cylinder3D(cyl1,cyl2+2,cyl3,mid);
        P1 = csg.translate3DX(3).transform(P1);

        Geometry3D P2 = csg.cylinder3D(cyl1,cyl2+2,cyl3,mid);
        P2 = csg.translate3DX(-3).transform(P2);


        Geometry3D hol = csg.cylinder3D(cyl1,cyl2,cyl3,mid);
        hol = csg.rotate3DX(csg.degrees(90)).transform(hol);
        hol = csg.translate3DY(5).transform(hol);
        hol = csg.translate3DZ(5).transform(hol);
        hol = csg.translate3DX(2).transform(hol);

        Geometry3D hol2 = csg.cylinder3D(cyl1,cyl2,cyl3,mid);
        hol2 = csg.rotate3DX(csg.degrees(90)).transform(hol2);
        hol2 = csg.translate3DY(5).transform(hol2);
        hol2 = csg.translate3DZ(5).transform(hol2);
        hol2 = csg.translate3DX(-2).transform(hol2);


        wall = csg.difference3D(wall,hol,hol2);

        Geometry3D show = csg.union3D(shelf,wall,smallWallFornt,disco,P1,P2);

        csg.view(show);

        return show;

    }


}
