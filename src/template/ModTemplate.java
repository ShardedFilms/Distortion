package template;

import mindustry.mod.*;
import template.gen.*;

public class ModTemplate extends Mod{
    static Clump activeState;
    static int lol =1;
    @Override
    public void loadContent(){
        EntityRegistry.register();
    }
    static void loadState(){
        switch(lol){
            case 1 -> activeState = new AtlasConfig();
        }

        if(activeState != null){
            activeState.init();
        }
    }

}
