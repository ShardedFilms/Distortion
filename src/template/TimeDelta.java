package template;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.gl.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import arc.util.pooling.Pool.*;
import mindustry.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

import static mindustry.Vars.*;
import static arc.Core.*;

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
