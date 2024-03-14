package template;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.TextureAtlas.*;
import arc.math.*;
import arc.struct.*;

public class AtlasConfig extends Clump {
    //Load
    //public void update(){}
    float time = 0f;
    float interval = 0f;

    @Override
    public void update(){
            time += TimeDelta.timeDelta;

            Seq<AtlasRegion> regions = Core.atlas.getRegions();

            int amount = 1 + Mathf.clamp((int)(time / (3f * 60f)), 0, 100);
            float rand = 4f + Mathf.pow(time / (15f * 60f), 1.2f);
            if((interval -= TimeDelta.timeDelta) <= 0f){
                for(int i = 0; i < amount; i++){
                    AtlasRegion r = regions.random();
                    if(r != null){
                        Texture tex = r.texture;

                        for(int j = 0; j < 2; j++){
                            float rx = Mathf.range(rand) / tex.width;
                            float ry = Mathf.range(rand) / tex.height;

                            if(j == 0){
                                r.u += rx;
                                r.u = Mathf.clamp(r.u, 0f, 1f);
                                r.v += ry;
                                r.v = Mathf.clamp(r.v, 0f, 1f);
                            }else{
                                r.u2 += rx;
                                r.u2 = Mathf.clamp(r.u2, 0f, 1f);
                                r.v2 += ry;
                                r.v2 = Mathf.clamp(r.v2, 0f, 1f);
                            }
                        }
                    }
                }
                interval = 1f;
            }

    }







}
