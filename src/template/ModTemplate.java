package template;

import mindustry.mod.*;
import template.gen.*;

public class ModTemplate extends Mod{
    static AtlasConfig activeState;
    @Override
    public void loadContent(){
        EntityRegistry.register();
        activeState = new AtlasConfig();
        activeState.init();
    }
}
