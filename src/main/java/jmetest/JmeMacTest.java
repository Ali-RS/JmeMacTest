package jmetest;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.ErrorDialog;

/**
 * This is the Main Class of your Game. It should boot up your game and do initial initialisation
 * Move your Logic into AppStates or Controls or other java classes
 */
public class JmeMacTest extends SimpleApplication {

    public static void main(String[] args) {
        JmeMacTest app = new JmeMacTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);

        ErrorDialog.showDialog("This is a test dialog! \nMetal Render Enabled: " + System.getProperty("sun.java2d.metal", "false"));
    }

    @Override
    public void simpleUpdate(float tpf) {
        //this method will be called every game tick and can be used to make updates
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //add render code here (if any)
    }
}
