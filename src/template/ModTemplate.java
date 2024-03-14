package template;

import mindustry.mod.*;
import template.gen.*;

public class ModTemplate extends Mod{
    static Clump activeState;
    @Override
    public void loadContent(){
        EntityRegistry.register();
    }
    static void loadState(){
            activeState = new AtlasConfig();
            activeState.init();

    }

}
