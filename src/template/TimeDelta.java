package template;

import arc.*;
import arc.func.*;
import arc.math.*;
import arc.util.*;
import mindustry.*;

public class TimeDelta implements ApplicationListener {
    public static float timeDelta = 1f;
    @Override
    public void update(){
        timeDelta = Math.max(trueDelta.get(), Time.delta);

        if(Vars.state.isPaused()) return;
    }
    Floatp trueDelta = () -> {
        float result = Core.graphics.getDeltaTime() * 60f;
        return (Float.isNaN(result) || Float.isInfinite(result)) ? 1f : Mathf.clamp(result, 0.0001f, 60f / 10f);
    };
}
