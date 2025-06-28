
import java.io.StringWriter;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.openehealth.coala.domain.Patient;
import org.openehealth.coala.domain.PatientConsentPolicy;
import org.openehealth.coala.exception.CDACreationException;
import org.openehealth.coala.util.PXSDateConverter;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.slf4j.Logger;
public class CDABuilder {
	private static final Logger LOG = org.slf4j.LoggerFactory
			.getLogger(CDABuilder.class);
	private static final String TAG_CDA_FAMILY = "family";
	private static final String TAG_CDA_GIVEN = "given";
	private static final String TAG_CDA_BIRTHDATE = "birthTime";
	private static final String TAG_CDA_VALIDFROM = "lowvalue";
	private static final String TAG_CDA_VALIDUNTIL = "highvalue";
	private static final String TAG_CDA_ADDRESS_STREET = "streetAddressLine";
	private static final String TAG_CDA_ADDRESS_CITY = "city";
	private static final String TAG_CDA_ADDRESS_STATE = "state";
	private static final String TAG_CDA_ADDRESS_POSTALCODE = "postalCode";
	private static final String TAG_CDA_ADDRESS_COUNTRY = "country";
	private static final String TAG_CDA_PATIENT_ID = "pID";
	private static final String TAG_CDA_PATIENT_GENDER = "administrativeGenderCode";
	private static final String TAG_CDA_PATIENT_ID_ROOT = "pRoot";
	private static final String TAG_CDA_ID_ROOT = "idRoot";
	private static final String TAG_CDA_CODE_CODE = "cCode";
	private static final String TAG_CDA_CODE_DISPLAYNAME = "cDisplayName";
	private static final String TAG_CDA_CODE_CODESYSTEM = "cCodeSystem";
	private static final String TAG_CDA_CODE_CODESYSTEMNAME = "cCodeSystemName";
	private static final String TAG_CDA_TITlE = "title";
	private static final String TAG_CDA_EFFECTIVETIME = "effectiveTime";
	private static final String TAG_CDA_CONFIDENTIALTY_CODE = "confCode";
	private static final String TAG_CDA_CONFIDENTIALTY_DISPLAYNAME = "confDisplayName";
	private static final String TAG_CDA_CONFIDENTIALTY_CODESYSTEM = "confCodeSystem";
	private static final String TAG_CDA_CONFIDENTIALTY_CODESYSTEMNAME = "confCodeSystemName";
	private static final String TAG_CDA_LANGUAGECODE = "languageCode";
	private static final String TAG_CDA_COMPONENT_TITLE = "ComponentTitle";
	private static final String TAG_CDA_COMPONENT_TEXT = "ComponentText";
	private static final String TAG_CDA_Author_TITLE = "aTitle";
	private static final String TAG_CDA_Author_FAMILY = "aFamily";
	private static final String TAG_CDA_Author_GIVEN = "aGiven";
	private Template t;
	private static String CDA_CODE_CODESYSTEM_OID;
	private static String CDA_CONFIDENTIALTY_CODESYSTEM_OID;
	private PXSDateConverter pxsDateConverter;
	public void setPxsDateConverter(PXSDateConverter pxsDateConverter) {
		this.pxsDateConverter = pxsDateConverter;
	}
	public CDABuilder(String templateName) {
		try {
			ResourceBundle properties = ResourceBundle.getBundle("coala-document");
			CDA_CODE_CODESYSTEM_OID = properties
					.getString("coala.cda.code.codeSystem");
			CDA_CONFIDENTIALTY_CODESYSTEM_OID = properties
					.getString("coala.cda.confidentialty.codeSystem");
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class",
					ClasspathResourceLoader.class.getName());
			ve.init();
			t = ve.getTemplate(templateName);
		} catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage(), e);
		}
	}
	public String createConsentCDA(Patient patient,
			PatientConsentPolicy policy, DocumentEntry documentEntry) {
		if (patient == null)
			throw new IllegalArgumentException("Patient cannot be null.");
		if (policy == null)
			throw new IllegalArgumentException("policy cannot be null.");
		if (documentEntry == null)
			throw new IllegalArgumentException("documentEntry cannot be null.");
		StringWriter writer = new StringWriter();
		VelocityContext context = new VelocityContext();
		context = createMetaContext(context, patient, policy, documentEntry);
		context.put(TAG_CDA_ID_ROOT, documentEntry.getUniqueId());
		context.put(TAG_CDA_CODE_CODE, documentEntry.getTypeCode().getCode());
		context.put(TAG_CDA_CODE_DISPLAYNAME, documentEntry.getTypeCode()
				.getDisplayName().getValue());
		context.put(TAG_CDA_CODE_CODESYSTEM, CDA_CODE_CODESYSTEM_OID);
		context.put(TAG_CDA_CODE_CODESYSTEMNAME, documentEntry.getTypeCode()
				.getSchemeName());
		context.put(TAG_CDA_EFFECTIVETIME, documentEntry.getCreationTime());
		context.put(TAG_CDA_CONFIDENTIALTY_CODE, documentEntry
				.getConfidentialityCodes().get(0).getCode());
		context.put(TAG_CDA_CONFIDENTIALTY_DISPLAYNAME, documentEntry
				.getConfidentialityCodes().get(0).getDisplayName().getValue());
		context.put(TAG_CDA_CONFIDENTIALTY_CODESYSTEM,
				CDA_CONFIDENTIALTY_CODESYSTEM_OID);
		context.put(TAG_CDA_CONFIDENTIALTY_CODESYSTEMNAME, documentEntry
				.getConfidentialityCodes().get(0).getSchemeName());
		context.put(TAG_CDA_LANGUAGECODE, documentEntry.getLanguageCode());
		context.put(TAG_CDA_Author_TITLE, documentEntry.getAuthor()
				.getAuthorPerson().getName().getPrefix());
		context.put(TAG_CDA_Author_FAMILY, documentEntry.getAuthor()
				.getAuthorPerson().getName().getFamilyName());
		context.put(TAG_CDA_Author_GIVEN, documentEntry.getAuthor()
				.getAuthorPerson().getName().getGivenName());
		context.put(TAG_CDA_VALIDFROM, documentEntry.getServiceStartTime());
		context.put(TAG_CDA_VALIDUNTIL, documentEntry.getServiceStopTime());
		try {
			t.merge(context, writer);
		} catch (Exception e) {
			throw new CDACreationException(e.getLocalizedMessage(), e);
		}
		LOG.debug(writer.toString());
		return writer.toString();
	}
	private VelocityContext createMetaContext(VelocityContext context,
			Patient patient, PatientConsentPolicy policy,
			DocumentEntry documentEntry) {
		context.put(TAG_CDA_FAMILY, patient.getLastName());
		context.put(TAG_CDA_GIVEN, patient.getGivenName());
		context.put(TAG_CDA_BIRTHDATE,
				pxsDateConverter.DateToShortString(patient.getBirthdate()));
		context.put(TAG_CDA_ADDRESS_STREET, patient.getAddress()
				.getStreetAddress());
		context.put(TAG_CDA_ADDRESS_CITY, patient.getAddress().getCity());
		context.put(TAG_CDA_ADDRESS_STATE, patient.getAddress()
				.getStateOrProvince());
		context.put(TAG_CDA_ADDRESS_POSTALCODE, patient.getAddress()
				.getZipOrPostalCode());
		context.put(TAG_CDA_ADDRESS_COUNTRY, patient.getAddress().getCountry());
		context.put(TAG_CDA_PATIENT_ID, patient.getPatientID());
		context.put(TAG_CDA_PATIENT_ID_ROOT,
				patient.getPatientIDAssigningAuthorityUniversalId());
		context.put(TAG_CDA_TITlE, documentEntry.getTitle().getValue());
		context.put(TAG_CDA_PATIENT_GENDER, patient.getSex());
		context.put(TAG_CDA_COMPONENT_TITLE, policy.name());
		context.put(TAG_CDA_COMPONENT_TEXT, policy.getShortName());
		return context;
	}
}
