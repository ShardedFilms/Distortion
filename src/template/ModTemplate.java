package template;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.mod.*;
import mindustry.game.EventType.*;
import mindustry.ui.dialogs.*;

import template.gen.*;

public class ModTemplate extends Mod{
    static Clump activeState;
    public ModTemplate() {
        FlameTest.load();
        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            activeState.loadClient();
                new TimeDelta();
                //activeState.init();
                activeState = new AtlasConfig();
                //if (activeState != null) {
                activeState.init();
                //}
            BaseDialog dialog = new BaseDialog("entr");
            dialog.cont.add("runnin").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
            dialog.cont.button("Oke", dialog::hide).size(100f, 50f);
            dialog.show();
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
