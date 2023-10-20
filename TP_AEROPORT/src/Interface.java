import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Interface extends Application {

    private ArrayList<Flight> listOfFlight = new ArrayList<> ();
    private Translate tz;
    private double mousePosX;
    private double mousePosY;
    private double scrollY;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Nearest Airport");

        World w = new World ( "airport-codes_no_comma.csv" );
        Earth earth = new Earth ();
        PerspectiveCamera camera = new PerspectiveCamera(true);

        //create perspective
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);

        //create the scene
        Scene theScene = new Scene(earth, 1200, 800,true);
        theScene.setCamera ( camera );

        //Event Handler on left clic
        theScene.addEventHandler( MouseEvent.ANY, event -> {
            if (event.getEventType ( ) == MouseEvent.MOUSE_PRESSED) {
                System.out.println ( "Clicked on : (" + event.getSceneX ( ) + ", " + event.getSceneY ( ) + ")" );
                scrollY = event.getSceneY ( );
            }
            if (event.getButton ( ) == MouseButton.PRIMARY && event.getEventType ( ) == MouseEvent.MOUSE_DRAGGED) {
                camera.getTransforms ( ).add ( new Translate ( 0, 0, scrollY - event.getSceneY ( ) ) );
            }
            if (event.getButton ( ) == MouseButton.SECONDARY && event.getEventType ( ) == MouseEvent.MOUSE_CLICKED) {
                PickResult pickResult = event.getPickResult ( );
                if (pickResult.getIntersectedNode ( ) != null) {
                    Point2D click = pickResult.getIntersectedTexCoord ();

                    // on r´ecup`ere le point d'intersection
                    double X = click.getX ();
                    double Y = click.getY ();

                    // Conversion en longitude et lattitude
                    double longitude = 360 * (X - 0.5);
                    //          double latitude = 2 * Math.atan ( Math.exp ( (0.5 - Y) / 0.2678 ) ) - 90;
                    double latitude = 180 * (-Y + 0.5);
                    // Recherche dans l'objet w de la classe World de l'a´eroport le plus proche.
                    Aeroport aeroport = w.findNearestAirport ( longitude, latitude );

                    // Affichage dans la console
                    System.out.println ( "(X,Y) = (" + X + "," + Y + ")" );
                    System.out.println ( "(long,lat) = (" + longitude + "," + latitude + ")" );
                    System.out.println ( aeroport );

                    earth.displayRedSphere ( aeroport );

                }
            }
        });

        primaryStage.setScene(theScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}