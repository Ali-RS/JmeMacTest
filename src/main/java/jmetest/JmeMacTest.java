package jmetest;
/*
 *  Copyright (c) 2022, Ali-RS
 *  All rights reserved.
 *
 *  This source code is licensed under the BSD-style license found in the
 *  LICENSE file in the root directory of this source tree.
 */

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.ErrorDialog;

import javax.swing.*;

/**
 * A JME app for testing LWJGL3 + Swing (with JEP 382: New macOS Rendering Pipeline) issues on macOS.
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

        //Schedule dialog for the event-dispatching thread:
        SwingUtilities.invokeLater(() ->
                ErrorDialog.showDialog("This is a test error dialog! \nMetal Render Enabled: " + System.getProperty("sun.java2d.metal", "false")));
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
