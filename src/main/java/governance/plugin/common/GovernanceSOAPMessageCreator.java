package governance.plugin.common;

/**
 * Create SOAP messages/request required to create "Module"  and 
 * assets and related assets in Governance Registry.
 */
public class GovernanceSOAPMessageCreator {
	
	public static final int TIME_STRING_LENGTH = 20;

	public static String  createAddModuleRequest(String name, String version, String path, String type){
		StringBuffer soapRequest = new StringBuffer();
		soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
		soapRequest.append("xmlns:ser='http://services.add.module.governance.carbon.wso2.org'>");
		soapRequest.append("<soapenv:Header/>");
		soapRequest.append("<soapenv:Body>");
		soapRequest.append("<ser:addModule>");
		soapRequest.append("<ser:info><![CDATA[<metadata xmlns='http://www.wso2.org/governance/metadata'><overview>");
		soapRequest.append("<name>");
		soapRequest.append(name);
		soapRequest.append("</name><version>");
		soapRequest.append(version);
		soapRequest.append("</version><type>"); 
		soapRequest.append(type);
		soapRequest.append("</type><description>");
		soapRequest.append("Module generated by maven-governance-plugin");
		soapRequest.append("</description><sourcePath>");
		soapRequest.append(path);
		soapRequest.append("</sourcePath>");
		soapRequest.append(GovernanceSOAPMessageCreator.getMetaDataTags());
		soapRequest.append("</overview>");
		soapRequest.append(GovernanceSOAPMessageCreator.getImageTags());
		soapRequest.append("</metadata>]]></ser:info>");
		soapRequest.append("</ser:addModule>");
		soapRequest.append("</soapenv:Body>");
		soapRequest.append("</soapenv:Envelope>");
		return soapRequest.toString();
	}
	
	public static String createGetArtifactContentRequest(String path){
		StringBuffer soapRequest = new StringBuffer();
		soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
		soapRequest.append("xmlns:ser='http://services.generic.governance.carbon.wso2.org'>");
		soapRequest.append("<soapenv:Header/>");
		soapRequest.append("<soapenv:Body>");
		soapRequest.append("<ser:getArtifactContent>");
		soapRequest.append("<ser:path>");
		soapRequest.append(path);
		soapRequest.append("</ser:path>");
		soapRequest.append("</ser:getArtifactContent>");
		soapRequest.append("</soapenvBody>");
		soapRequest.append("</soapenv:Envelope>");
		return soapRequest.toString();

	}
	// TODO : Change this to adopt changes required for ES
	public static String createAddArtifactRequest(String groupId, String artifactId, String version){
		StringBuffer soapRequest = new StringBuffer();
		soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
		soapRequest.append("xmlns:ser='http://services.add.artifact.governance.carbon.wso2.org'>");
        soapRequest.append("<soapenv:Header/>");
        soapRequest.append("<soapenv:Body>");
        soapRequest.append("<ser:addArtifact>");   
        soapRequest.append("<ser:info>");
        soapRequest.append("<![CDATA[<metadata xmlns='http://www.wso2.org/governance/metadata'><overview><group>");
        soapRequest.append(groupId);
        soapRequest.append("</group><name>");
        soapRequest.append(artifactId);
        soapRequest.append("</name>");
        soapRequest.append("<version>");
        soapRequest.append(version);
        soapRequest.append("</version>");
        soapRequest.append("<description>");
		soapRequest.append("Artifact generated by maven-governance-plugin");
		soapRequest.append("</description>");
        soapRequest.append(GovernanceSOAPMessageCreator.getMetaDataTags());
        soapRequest.append("</overview>");
        soapRequest.append(GovernanceSOAPMessageCreator.getImageTags());
        soapRequest.append("</metadata>]]></ser:info>");
        soapRequest.append("</ser:addArtifact>");
        soapRequest.append("</soapenv:Body>");
		soapRequest.append("</soapenv:Envelope>");
		return soapRequest.toString();
	}
	
	public static String createAssociationRequst(String sourcePath, String destinationPath, String type, String todo){
		StringBuffer soapRequest = new StringBuffer();
		soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
		soapRequest.append("xmlns:ser='http://services.relations.registry.carbon.wso2.org'>");
		soapRequest.append("<soapenv:Header/>");
        soapRequest.append("<soapenv:Body>");
        soapRequest.append("<ser:addAssociation><ser:path>");
        soapRequest.append(sourcePath);
        soapRequest.append("</ser:path><ser:type>");
        soapRequest.append(type);
        soapRequest.append("</ser:type><ser:associationPaths>");
        soapRequest.append(destinationPath);
        soapRequest.append("</ser:associationPaths><ser:todo>");
        soapRequest.append(todo);
        soapRequest.append("</ser:todo></ser:addAssociation>");
        soapRequest.append("</soapenv:Body>");
        soapRequest.append("</soapenv:Envelope>");
        return soapRequest.toString();
	}
	
	public static String createGetDependencyTreeRequest(String absoluteResourcePath, String type){
		StringBuffer soapRequest = new StringBuffer();
		soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
		soapRequest.append("xmlns:ser='http://services.relations.registry.carbon.wso2.org'>");
		soapRequest.append("<soapenv:Header/>");
		soapRequest.append("<soapenv:Body>");
		soapRequest.append("<ser:getAssociationTree>");
		soapRequest.append("<ser:path>");
		soapRequest.append(absoluteResourcePath);
		soapRequest.append("</ser:path><ser:type>");
		soapRequest.append(type);
        soapRequest.append("</ser:type></ser:getAssociationTree>");
        soapRequest.append("</soapenv:Body>");
        soapRequest.append("</soapenv:Envelope>");
        return soapRequest.toString();
	}

    public static String  createAddServiceRequest(String name, String namespace, String version, String type, String description){
        StringBuffer soapRequest = new StringBuffer();
        soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
        soapRequest.append("xmlns:ser='http://services.add.service.governance.carbon.wso2.org'>");
        soapRequest.append("<soapenv:Header/>");
        soapRequest.append("<soapenv:Body>");
        soapRequest.append("<ser:addService>");
        soapRequest.append("<ser:info><![CDATA[<metadata xmlns='http://www.wso2.org/governance/metadata'><overview><name>");
        soapRequest.append(name);
        soapRequest.append("</name>");
        soapRequest.append("<namespace>");
        soapRequest.append(namespace);
        soapRequest.append("</namespace>");
        soapRequest.append("<version>");
        soapRequest.append(version);
        soapRequest.append("</version>");
        soapRequest.append("<types>");
        soapRequest.append(type);
        soapRequest.append("</types>");
        soapRequest.append("<description>");
        soapRequest.append(description);
        soapRequest.append("</description>");
        soapRequest.append(GovernanceSOAPMessageCreator.getMetaDataTags());
        soapRequest.append("</overview>");
        soapRequest.append(GovernanceSOAPMessageCreator.getImageTags());
        soapRequest.append("</metadata>]]></ser:info>");
        soapRequest.append("</ser:addService>");
        soapRequest.append("</soapenv:Body>");
        soapRequest.append("</soapenv:Envelope>");
        return soapRequest.toString();
    }

    public static String  createAddWebAppRequest(String name, String namespace, String serviceclass, String displayname, String version, String description){
        StringBuffer soapRequest = new StringBuffer();
        soapRequest.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' ");
        soapRequest.append("xmlns:ser='http://services.add.webapp.governance.carbon.wso2.org'>");
        soapRequest.append("<soapenv:Header/>");
        soapRequest.append("<soapenv:Body>");
        soapRequest.append("<ser:addWebapp>");
        soapRequest.append("<ser:info><![CDATA[<metadata xmlns='http://www.wso2.org/governance/metadata'><overview><name>");
        soapRequest.append(name);
        soapRequest.append("</name>");
        soapRequest.append("<namespace>");
        soapRequest.append(namespace);
        soapRequest.append("</namespace>");
        soapRequest.append("<serviceclass>");
        soapRequest.append(serviceclass);
        soapRequest.append("</serviceclass>");
        soapRequest.append("<displayname>");
        soapRequest.append(displayname);
        soapRequest.append("</displayname>");
        soapRequest.append("<version>");
        soapRequest.append(version);
        soapRequest.append("</version>");
        soapRequest.append("<description>");
        soapRequest.append(description);
        soapRequest.append("</description>");
        soapRequest.append(GovernanceSOAPMessageCreator.getMetaDataTags());
        soapRequest.append("</overview>");
        soapRequest.append(GovernanceSOAPMessageCreator.getImageTags());
        soapRequest.append("</metadata>]]></ser:info>");
        soapRequest.append("</ser:addWebapp>");
        soapRequest.append("</soapenv:Body>");
        soapRequest.append("</soapenv:Envelope>");
        return soapRequest.toString();
    }
	
	public static String  getCurrentTime(){
		long unformatedTime = System.currentTimeMillis();
		String time  = String.valueOf(unformatedTime);
		
		StringBuffer leadingZeros = new StringBuffer();
		for (int i = (TIME_STRING_LENGTH - time.length()); i == 0; i--){
			leadingZeros.append("0");
		}
		
		return (leadingZeros.toString() + time);
	}
	
	public static String getMetaDataTags(){
		StringBuffer metadataTags = new StringBuffer();
		metadataTags.append("<createdtime>");
		metadataTags.append(GovernanceSOAPMessageCreator.getCurrentTime());
		metadataTags.append("</createdtime>");
		metadataTags.append("<provider>governance-maven-plugin</provider>");
		return metadataTags.toString();
	}

	private static String getImageTags() {
		StringBuffer imageTags = new StringBuffer();
	    imageTags.append("<images>");
		imageTags.append("<thumbnail>/publisher/config/defaults/img/thumbnail.jpg</thumbnail>");
		imageTags.append("<banner>/publisher/config/defaults/img/banner.jpg</banner>");
		imageTags.append("</images>");
		return imageTags.toString();
    }
}