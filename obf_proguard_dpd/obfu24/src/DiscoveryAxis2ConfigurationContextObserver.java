
import org.wso2.carbon.registry.api.RegistryException;
import org.wso2.carbon.utils.AbstractAxis2ConfigurationContextObserver;
import org.wso2.carbon.discovery.util.Util;
import org.wso2.carbon.discovery.util.DiscoveryMgtUtils;
import org.wso2.carbon.core.multitenancy.SuperTenantCarbonContext;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class DiscoveryAxis2ConfigurationContextObserver extends AbstractAxis2ConfigurationContextObserver {
    private static final Log log = LogFactory.getLog(DiscoveryAxis2ConfigurationContextObserver.class);
    public void createdConfigurationContext(ConfigurationContext configurationContext) {
        AxisConfiguration axisConfig = configurationContext.getAxisConfiguration();
        try {
            if (DiscoveryMgtUtils.isServiceDiscoveryEnabled(axisConfig)) {
                if (log.isDebugEnabled()) {
                    String domain = SuperTenantCarbonContext.getCurrentContext(configurationContext).
                            getTenantDomain(true);
                    log.debug("Registering the Axis observer for WS-Discovery in tenant: " + domain);
                }
                Util.registerServiceObserver(axisConfig);
            }
        } catch (RegistryException e) {
            log.error("Checking whether service discovery is enabled for a tenant", e);
        }
    }
    public void terminatingConfigurationContext(ConfigurationContext configurationContext) {
        AxisConfiguration axisConfig = configurationContext.getAxisConfiguration();
        Util.unregisterServiceObserver(axisConfig, true);
    }
}
