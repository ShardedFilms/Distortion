package template;

import arc.*;
import arc.input.KeyCode;
import arc.util.*;
import mindustry.*;
import mindustry.mod.*;
import mindustry.game.EventType.*;
import mindustry.ui.dialogs.*;

import template.gen.*;

public class ModTemplate extends Mod{
    public Clump activeState = new AtlasConfig();

    public ModTemplate() {
        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            BaseDialog dialog = new BaseDialog("entr");
            dialog.cont.add("runnin").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
            dialog.cont.button("Oke", dialog::hide).size(100f, 50f);
            dialog.show();
            new AtlasConfig();
            new TimeDelta();
            activeState.update();
        });


        Events.on(FileTreeInitEvent.class, e -> Core.app.post(() -> {
            activeState.update();
        }));
    }
    //@Override
    //public void loadContent(){
    //    EntityRegistry.register();
    //}
}
