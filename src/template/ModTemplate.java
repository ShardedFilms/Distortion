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
import mindustry.ui.Fonts;
import mindustry.ui.dialogs.BaseDialog;

public class ModTemplate extends Mod{

    public float time = 0f;
    public boolean s =false;
    public ModTemplate() {
        Events.on(ClientLoadEvent.class, e -> {
            Timer.schedule(() -> {
                init();
            }, 0, 1f / 60f);

        });
    }
@Override
    public void init(){
        if(Vars.state.isGame()|| s ) {
            s =true;
            time += 1;
            //Log.info("Timer :" + time);

            int amount = 1 + Mathf.clamp((int) (time / (3f * 60f)), 0, 100);
            float rand = 4f + Mathf.pow(time / (15f * 60f), 1.2f);
            Seq<TextureAtlas.AtlasRegion> regions = Core.atlas.getRegions();
            for (int i = 0; i < amount; i++) {
                TextureAtlas.AtlasRegion r = regions.random();
                Texture tex = r.texture;

                for (int j = 0; j < 2; j++) {
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
    };
    public void update(){

        int dice = Mathf.random(1,5);
        String text = "completed";
        BaseDialog dialog = new BaseDialog("");
            int len = 20;
            text = "";
            //text = new StringBuilder();
            for(int i = 0; i < len; i++){
                //String.valueOf(i);
                //text += Character.toChars(2);
                char c = (char)(Mathf.random(32, 126));
                //text.append(c);
                text += c;
            };

        for(int i = 0; i < dice; i++) {
            dialog.cont.add(text).row();
        };
        dialog.cont.button("", dialog::hide).size(100f, 50f);
        dialog.show();

    };

}
// ||