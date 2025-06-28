
import io.milton.resource.Resource;
import io.milton.http.exceptions.BadRequestException;
import io.milton.http.exceptions.NotAuthorizedException;
public interface ResourceFactory {
    Resource getResource(String host, String path) throws NotAuthorizedException, BadRequestException;
}
