package com.inductiveautomation.ignition.msteams.client;

import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.common.script.hints.PropertiesFileDocProvider;
import com.inductiveautomation.vision.api.client.AbstractClientModuleHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client Hook for projects which target Vision
 *
 * @since <DATE>
 */
public class MsteamsClientHook extends AbstractClientModuleHook {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @Override
    public void initializeScriptManager(ScriptManager manager) {
        super.initializeScriptManager(manager);

        manager.addScriptModule(
                "system.msteams",
                new ClientScriptModule(),
                new PropertiesFileDocProvider()
        );
    }
	
}
