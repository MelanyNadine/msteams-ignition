package com.inductiveautomation.ignition.msteams.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This is the Designer-scope module hook.  The minimal implementation contains a startup method.
 */
public class MsteamsDesignerHook extends AbstractDesignerModuleHook {

    // override additonal methods as requried
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        // implelement functionality as required
    }
    
    @Override
    public void initializeScriptManager(ScriptManager manager) {
        super.initializeScriptManager(manager);

        manager.addScriptModule(
                "system.msteams",
                new DesignerScriptModule(),
                new PropertiesFileDocProvider()
        );
    }
    
}
