package template;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.mod.*;
import mindustry.game.EventType.*;


import template.gen.*;

public class ModTemplate extends Mod{
    static Clump activeState;
    public ModTemplate() {
        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                new TimeDelta();
                //activeState.init();
                activeState = new AtlasConfig();
                //if (activeState != null) {
                activeState.init();
                //}
            });
        });


        Events.on(FileTreeInitEvent.class, e -> Core.app.post(() -> {
            FlameTest.updateTest();
            if (!Vars.headless) {
                //activeState.init();
            }
        }));
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();


    }
}
