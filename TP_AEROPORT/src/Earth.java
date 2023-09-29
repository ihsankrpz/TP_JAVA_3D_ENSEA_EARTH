import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;

public class Earth extends Group {
    private Rotate ry = new Rotate (0, 0, 0);
    private Sphere sph = new Sphere ( 300 );
    private ArrayList<Sphere> yellowSphere = new ArrayList<> ();
    private PhongMaterial phongMaterial = new PhongMaterial ();

    public Earth () {
        this.getChildren ().add ( sph );
        phongMaterial.setDiffuseMap( new Image ( "C:\\Users\\ihsan\\Desktop\\ENSEA 3D\\JAVA\\TP_EARTH\\TP_JAVA_3D_ENSEA_EARTH\\TP_AEROPORT\\earth_lights_4800.png" ));
        sph.setMaterial ( phongMaterial );

        AnimationTimer animationTimer = new AnimationTimer () {
            private final long starttime = System.nanoTime ();
            @Override
            public void handle ( long time ) {
                //System.out.println("Valeur de time : " + time);
                double timeElapsed = (time - starttime)/1e9;
                ry.setAxis (Rotate.Y_AXIS );
                ry.setAngle ( timeElapsed * 24.0 );
                sph.getTransforms ().setAll ( ry );
            }
        };
        animationTimer.start();
    }

    public void createSphere(){
    }

    public void displayRedSphere(){

    }

    public void displayYellowSphere(){

    }

    public void getEarth(){

    }
}
