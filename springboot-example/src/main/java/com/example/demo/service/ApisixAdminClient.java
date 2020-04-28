package com.example.demo.service;

import org.apache.apisix.admin.AdminClient;
import org.apache.apisix.admin.model.K8sDeploymentInfo;
import org.apache.apisix.admin.model.Route;
import org.apache.apisix.admin.model.Upstream;
import org.apache.apisix.common.exception.ApisixSDKExcetion;
import org.apache.apisix.common.profile.Credential;
import org.apache.apisix.common.profile.DefaultCredential;
import org.apache.apisix.common.profile.DefaultProfile;
import org.apache.apisix.common.profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class ApisixAdminClient {

    public static boolean reg(){
        String endpoint =  System.getenv("APISIX_ADMIN_ENDPOINT");
        endpoint = endpoint == null || endpoint.equals("") ? "localhost:9080" : endpoint;

        System.out.println(endpoint);

        String version = "1.1";
        String apiKey = "edd1c9f034335f136f87ad84b625c8f1";

        Credential credential = new DefaultCredential(apiKey);
        Profile profile = DefaultProfile.getProfile(endpoint, version, credential);
        AdminClient adminClient = new AdminClient(profile);

        //创建upstream
        Upstream upstream = new Upstream();
        K8sDeploymentInfo k8sInfo = new K8sDeploymentInfo();

        k8sInfo.setNamespace("default");
        k8sInfo.setDeployName("java-example");
        k8sInfo.setPort(8080);
        k8sInfo.setBackendType("pod");

        String routeId = "1";
        Route route = new Route();

        List<String> methods = new ArrayList<>();

        methods.add("GET");
        upstream.setType("roundrobin");
        upstream.setK8sDeploymentInfo(k8sInfo);

        route.setUri("/helloworld");
        route.setDesc("route created by java sdk");
        route.setMethods(methods);
        route.setUpstream(upstream);

        try {
            adminClient.putRoute(routeId, route);
        }catch (ApisixSDKExcetion e){
            return false;
        }

        return true;
    }
}
