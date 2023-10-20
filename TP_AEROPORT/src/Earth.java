import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

public class Earth extends Group {
    private Rotate ry = new Rotate (0, 0, 0);
    private Sphere sph;
    private ArrayList<Sphere> yellowSphere = new ArrayList<> ();
    private PhongMaterial phongMaterial;

    public Earth () {
        sph = new Sphere ( 300 );
        phongMaterial = new PhongMaterial ();

        this.getChildren ().add ( sph );
        phongMaterial.setDiffuseMap( new Image ( "C:\\Users\\ihsan\\Desktop\\ENSEA 3D\\JAVA\\TP_EARTH\\TP_JAVA_3D_ENSEA_EARTH\\TP_AEROPORT\\earth_lights_4800.png" ));
        sph.setMaterial ( phongMaterial );
        ry.setAxis (Rotate.Y_AXIS );
        this.getTransforms ().add ( ry );

        AnimationTimer animationTimer = new AnimationTimer () {
            private final long starttime = System.nanoTime ();
            @Override
            public void handle ( long time ) {
                //System.out.println("Valeur de time : " + time);
                double timeElapsed = (time - starttime)/1e9;
                ry.setAngle ( timeElapsed * 24.0 );
            }
        };
        //animationTimer.start();
    }

    public Sphere createSphere(Aeroport a,Color color){
        sph = new Sphere ( 2);
        phongMaterial = new PhongMaterial ();

        double X =  301 * Math.cos(Math.toRadians(a.getLatitude ())) * Math.sin(Math.toRadians(a.getLongitude ()));
        double Y = -301 * Math.sin(Math.toRadians(a.getLatitude ())) + Math.toRadians(a.getLongitude ());
        double Z = -301 * Math.cos(Math.toRadians(a.getLatitude ())) * Math.cos(Math.toRadians(a.getLongitude ()));

        sph.getTransforms ().add(new Translate ( X, Y, Z));

        phongMaterial.setDiffuseColor ( color );
        sph.setMaterial ( phongMaterial );

        return sph;
    }

    public void displayRedSphere(Aeroport a){
        Sphere sphere = createSphere(a,Color.RED);
        this.getChildren ().add ( sphere );
    }

    public void displayYellowSphere(Aeroport a){
        Sphere sphere = createSphere(a,Color.YELLOW);
        this.getChildren ().add ( sphere );
    }

    public void getEarth(){

    }
}
