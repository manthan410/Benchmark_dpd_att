
import org.eclipse.emf.ecore.EFactory;
public interface SRMFactory extends EFactory {
	SRMFactory eINSTANCE = SRM.impl.SRMFactoryImpl.init();
	SRMmodel createSRMmodel();
	Role createRole();
	Activity createActivity();
	Capability createCapability();
	Functionality createFunctionality();
	SRMPackage getSRMPackage();
} 
