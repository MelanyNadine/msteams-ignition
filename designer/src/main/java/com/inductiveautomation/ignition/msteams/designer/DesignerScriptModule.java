package com.inductiveautomation.ignition.msteams.designer;

import com.inductiveautomation.ignition.client.gateway_interface.ModuleRPCFactory;
import com.inductiveautomation.ignition.msteams.common.MsteamsModule;
import com.inductiveautomation.ignition.msteams.common.PostChannel;

public class DesignerScriptModule extends MsteamsModule {

    private final PostChannel rpc;

    public DesignerScriptModule() {
        rpc = ModuleRPCFactory.create(
                "com.inductiveautomation.ignition.msteams.Msteams",
                PostChannel.class
        );
    }

    @Override
    protected String postImpl(String arg0, String arg1) {
        return rpc.post(arg0, arg1);
    }

}