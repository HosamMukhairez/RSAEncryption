package rsa;

/*
 * NearestNeighbor.java
 *
 * (C) 2008, Alex S.
 */
 
import java.awt.*;
import java.util.*;

/**
 * k-Nearest Neighbor, with k=1.
 */
public class NearestNeighbor extends BufferedApplet
{
    private int width,height;

    // points are read into this thing.
    private Vector points = new Vector();

    // matrices to easily move from model to screen and vice versa.
    private pMatrix toscreen = null;
    private pMatrix tomodel = null;

    /**
     * initialize things
     */
    public void init(){
        super.init();
        width = bounds().width;
        height = bounds().height;
        tomodel = pMatrix.reflecty3d().mult(pMatrix.translate3d(-width/2,-height/2,0));
        toscreen = tomodel.inv3d();
    }

    /**
     * function that gets called whenever something needs to be
     * rendered.
     */
    public void render(Graphics g) {
        if (damage) {
            // clear screen
            g.setColor(Color.white);
            g.fillRect(0, 0, width, height);

            // shade background according to classification.
            for(int y=0;y<=height;y+=4){
                for(int x=0;x<=width;x+=4){
                    double[] p = tomodel.mult(new double[] { x-2, y-2,0,1} );
                    double nn = 0,nndist = 999999999;
                    // find the one ``nearest neighbor'', and use their value.
                    Enumeration e = points.elements();
                    while(e.hasMoreElements()){
                        double[] q = (double[])e.nextElement();
                        double dist = (p[0]-q[0])*(p[0]-q[0]) + (p[1]-q[1])*(p[1]-q[1]);
                        if(dist < nndist){
                            nn = q[2];
                            nndist = dist;
                        }
                    }
                    g.setColor(nn < 0 ? Color.gray : Color.lightGray);
                    g.fillRect(x-2, y-2, 4, 4);
                }
            }

            // draw axis
            g.setColor(Color.black);
            g.drawLine(width/2,0,width/2,height);
            g.drawLine(0,height/2,width,height/2);

            // draw x/o
            g.setColor(Color.black);
            Enumeration e = points.elements();
            while(e.hasMoreElements()){
                double[] p = toscreen.mult((double[])e.nextElement());
                g.drawString(p[2] > 0 ? "x" : "o",(int)p[0],(int)p[1]);
            }

            g.setColor(Color.green);
            g.drawRect(0, 0, width-1, height-1);
        }
    }

    // mouse click adds point.
    public boolean mouseDown(Event evt, int x, int y){
        if((evt.modifiers & Event.META_MASK) == 0){ // left
            points.addElement(tomodel.mult(new double[] { x, y, +1, 1 }));
        }else{  // right
            points.addElement(tomodel.mult(new double[] { x, y, -1, 1 }));
        }
        return damage = true;
    }

    // any key resets
    public boolean keyDown(Event evt, int key){
        points.removeAllElements();
        return damage = true;
    }
}

