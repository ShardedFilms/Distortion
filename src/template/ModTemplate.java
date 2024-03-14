package template;

import arc.*;
import mindustry.*;
import mindustry.mod.*;
import mindustry.game.EventType.*;

import template.gen.*;

public class ModTemplate extends Mod{
    static AtlasConfig activeState;
    public ModTemplate() {

        new TimeDelta();
        activeState.init();
        activeState = new AtlasConfig();
        if (activeState != null) {
            activeState.init();
        }
        ;
        Events.on(FileTreeInitEvent.class, e -> Core.app.post(() -> {
            if (!Vars.headless) {
                activeState.init();
            }
        }));
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();


    }
}
