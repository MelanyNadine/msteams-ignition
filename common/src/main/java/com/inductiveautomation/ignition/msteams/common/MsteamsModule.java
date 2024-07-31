package com.inductiveautomation.ignition.msteams.common;

import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.script.hints.ScriptArg;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;

public abstract class MsteamsModule {
    public static final String MODULE_ID = "com.inductiveautomation.ignition.msteams.Msteams";
    
    static {
        BundleUtil.get().addBundle(
                MsteamsModule.class.getSimpleName(),
                MsteamsModule.class.getClassLoader(),
                MsteamsModule.class.getName().replace('.', '/')
        );
    }
    
    @ScriptFunction(docBundlePrefix = "MsteamsModule")
    public String post(@ScriptArg("arg0") String arg0, @ScriptArg("arg1") String arg1) {
        return postImpl(arg0, arg1);
    }

    protected abstract String postImpl(String arg0, String arg1);

}
