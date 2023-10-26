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
        animationTimer.start();
    }

    public Sphere createSphere(double latitude, double longitude,Color color){
        PhongMaterial col = new PhongMaterial();
        col.setSpecularColor(color);
        col.setDiffuseColor(color);

        Sphere coloredSphere = new Sphere(5);
        coloredSphere.setMaterial(col);

        coloredSphere.setTranslateZ(-sph.getRadius());

        Rotate rPhi = new Rotate (-longitude,
                -coloredSphere.getTranslateX(),-coloredSphere.getTranslateY(),
                -coloredSphere.getTranslateZ(),Rotate.Y_AXIS);

        coloredSphere.getTransforms().add(rPhi);
        Rotate rTheta = new Rotate (-latitude*60.0/90.0,
                -coloredSphere.getTranslateX(),-coloredSphere.getTranslateY(),
                -coloredSphere.getTranslateZ(),Rotate.X_AXIS);
        coloredSphere.getTransforms().add(rTheta);

        return coloredSphere;
    }

    public void displayRedSphere(Aeroport a){
        Sphere redSphere = createSphere(a.getLatitude(),a.getLongitude(),Color.RED);
        this.getChildren().add(redSphere);
    }

    public void displayYellowSphere(Aeroport a){
        Sphere sphere = createSphere(a.getLatitude (), a.getLongitude (),Color.YELLOW);
        this.getChildren ().add ( sphere );
    }

    public void getEarth(){

    }
}
