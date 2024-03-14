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
        activeState = new AtlasConfig();
        if (activeState != null) {
            activeState.init();
        }
        ;
        Events.on(FileTreeInitEvent.class, e -> Core.app.post(() -> {
            FlameTest.updateTest();
        }));
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();


    }
}
