package template;

import arc.*;
import arc.graphics.Texture;
import arc.graphics.g2d.TextureAtlas;
import arc.input.KeyCode;
import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.*;
import mindustry.*;
import mindustry.mod.*;
import mindustry.game.EventType.*;
import mindustry.ui.dialogs.*;

import template.gen.*;

public class ModTemplate extends Mod{

    float time = 0f;
    float interval = 5f;
    //public Clump activeState = new AtlasConfig();

    public ModTemplate() {
        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            BaseDialog dialog = new BaseDialog("entr");
            dialog.cont.add("runnin").row();
            //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
            dialog.cont.button("Oke", dialog::hide).size(100f, 50f);
            dialog.show();
            //new AtlasConfig();
            new TimeDelta();
            //activeState.update();
            run();
        });
    }

    public void run(){
        time += TimeDelta.timeDelta;

        Seq<TextureAtlas.AtlasRegion> regions = Core.atlas.getRegions();
        Log.info("Timer :"+time);

        int amount = 1 + Mathf.clamp((int)(time / (3f * 60f)), 0, 100);
        float rand = 4f + Mathf.pow(time / (15f * 60f), 1.2f);
        if((interval -= Time.delta) <= 0f){
            for(int i = 0; i < amount; i++){
                TextureAtlas.AtlasRegion r = regions.random();
                Texture tex = r.texture;

                for(int j = 0; j < 2; j++) {
                    float rx = Mathf.range(rand) / tex.width;
                    float ry = Mathf.range(rand) / tex.height;

                    if (j == 0) {
                        r.u += rx;
                        r.u = Mathf.clamp(r.u, 0f, 1f);
                        r.v += ry;
                        r.v = Mathf.clamp(r.v, 0f, 1f);
                    } else {
                        r.u2 += rx;
                        r.u2 = Mathf.clamp(r.u2, 0f, 1f);
                        r.v2 += ry;
                        r.v2 = Mathf.clamp(r.v2, 0f, 1f);
                    }
                }

            }
        }
    }
    @Override
    public void loadContent(){
        EntityRegistry.register();
        run();
    }
}
