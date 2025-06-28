
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SakaiAdapter extends AbstractAdapter {
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	private final static String EXT_SAKAI_PROVIDER_EID = "ext_sakai_provider_eid";
	@Override
	public Map<String, String> processLaunchData(Map<String, String> params) {
		log.debug("SakaiAdapter.processLaunchData() called");
		String tool_id = params.get("tool_id");
		String endpoint_url = params.get("endpoint_url");
		params.put("endpoint_url", endpoint_url + tool_id);
		String user_id = params.get("user_id");
		params.put(EXT_SAKAI_PROVIDER_EID, user_id);
		params.putAll(super.getDefaultParameters());
		return params;
	}
}
