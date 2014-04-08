package governance.plugin.rxt.osgi;

import governance.plugin.common.GovernanceSOAPMessageCreator;
import governance.plugin.rxt.AbstractAssetCreator;
import governance.plugin.util.PathNameResolver;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by jayanga on 2/9/14.
 */
public class OSGiServiceCreator extends AbstractAssetCreator {

    public static final String GREG_SERVICE_RESOURCE_PATH = "/trunk/osgiservices/";

    Log logger;
    public OSGiServiceCreator(Log logger, String gregServiceUrl) throws MojoExecutionException {
        super(gregServiceUrl, "OSGiService.OSGiServiceHttpsSoap12Endpoint");
        this.logger = logger;
    }

    public boolean create(Map<String, String> parameters) throws MojoExecutionException {

        String name = parameters.get("name");
        String namespace = parameters.get("namespace");
        String version = parameters.get("version");
        String description = "generated by maven-governance-plugin.";
        namespace = PathNameResolver.reverseNamespace(namespace);

        String OSGiServicePath = getResourcePath(new String[]{name, namespace});

        String createServiceRequst =
                GovernanceSOAPMessageCreator.createAddOSGiServiceRequest(name
                        , namespace
                        , version
                        , description);

        logger.debug("OSGi Service creation request. [" + createServiceRequst + "]");

        boolean isOSGiServiceCreated = super.createAsset(OSGiServicePath, createServiceRequst);

        if (logger.isInfoEnabled()){
            if (isOSGiServiceCreated){
                logger.info("Request sent to create OSGi Service: "+ name);
            }else{
                logger.info("OSGi Service already available: " + name);
            }
        }

        return isOSGiServiceCreated;
    }

    @Override
    public boolean create(Object[] parameters) throws MojoExecutionException {
        return false;
    }

    @Override
    public String getResourcePath(String[] parameters) throws MojoExecutionException {
        String name = parameters[0];
        String namespace = parameters[1];

        return OSGiServiceCreator.GREG_SERVICE_RESOURCE_PATH + PathNameResolver.reverseNamespace(namespace).replace('.', File.separatorChar) + File.separator + name;
    }
}
