
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jbehave.core.annotations.weld.WeldConfiguration;
import org.jbehave.core.annotations.weld.WeldStep;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.steps.AbstractStepsFactory;
import org.jbehave.core.steps.InjectableStepsFactory;
@Singleton
public class WeldStepsFactory extends AbstractStepsFactory {
    @Inject
    @Any
    @WeldStep
    private Instance<Object> instances;
    @Inject
    public WeldStepsFactory(@WeldConfiguration Configuration configuration) {
        super(configuration);
    }
    @Override
    protected List<Class<?>> stepsTypes() {
        List<Class<?>> types = new ArrayList<>();
        for (Object o : instances) {
            types.add(o.getClass());
        }
        return types;
    }
    @Override
    public Object createInstanceOfType(Class<?> type) {
        for (Object o : instances) {
            if (type.equals(o.getClass())) {
                return o;
            }
        }
        throw new StepsInstanceNotFound(type, this);
    }
}
