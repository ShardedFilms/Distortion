package template;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.input.*;
import arc.struct.*;
import arc.util.*;

public class FlameTest{
    public static ObjectMap<String, TextureRegion> regions = new ObjectMap<>();
    public static Seq<TextureRegion> regionSeq = new Seq<>();
    static Texture main;
    static Clump activeState;

    private static int state = 0;

    public static void update(){
        if(activeState != null){
            activeState.update();
        }
    }
    public static void updateTest(){
        if(Core.input.keyTap(KeyCode.z)){
            Log.info("Set Zero");
            state = 0;
            Core.settings.put("flame-special", state);
        }
        if(Core.input.keyTap(KeyCode.x)){
            increment(false);
            Log.info("Stage: " + state);
        }
    }

    public static void increment(){
        increment(true);
    }
    public static void increment(boolean change){
        if(main == null) return;
        state++;
        Core.settings.put("flame-special", state);
        if(change) loadState();
    }

    public static int getStage(){
        return state;
    }
    public static boolean validEmpathySpawn(){
        return state == 0 || state >= 5;
    }

    public static void dispose(){
        main.dispose();

        activeState = null;
    }

    static void loadState(){
        if(activeState != null){
            activeState.init();
        }
    }
}