package com.learning.ws.rest;

import javax.ws.rs.core.*;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Nov 23, 2011
 * Time: 4:58:08 AM
 */
public class RestDataManagerImpl implements RestDataManager {

    public String getCommmonInfo(UriInfo uriInfo,
                                 HttpHeaders headers,
                                 HttpServletRequest req) {

        //http://localhost:8080/wsbook/services/dataservice/restinfo
        //Example: http://localhost:8080/wsbook/services/dataservice/restinfo?name=srinivas&id=15

        //Using @Context UriInfo uriInfo - Obtaining the URI related info like, port, host, query parameters etc.
        //path
        String path = uriInfo.getPath();    ///dataservice/restinfo
        System.out.println("--------- path --------" + path);

        //Aboslute path
        URI uriPath = uriInfo.getAbsolutePath(); //http://localhost:8080/wsbook/services/dataservice/restinfo
        System.out.println("--------- uriPath --------" + uriPath);

        //host andf port
        URI requestUri = uriInfo.getRequestUri();
        System.out.println("--------- Host and Port --------" + requestUri.getHost() + ":" + requestUri.getPort());  //localhost:8080

        //Matched uri
        List<String> matchedUri = uriInfo.getMatchedURIs();
        System.out.println("--------- matchedUri --------" + matchedUri);

        URI baseUri = uriInfo.getBaseUri();   //http://localhost:8080/wsbook/services/
        System.out.println("--------- baseUri --------" + baseUri);

        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        System.out.println("--------- name --------" + uriBuilder.queryParam("name"));

        //Query Parameters
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        System.out.println("--------- queryParams --------" + queryParams);  //{name=[srinivas], id=[15]}
        for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
            System.out.println("---- query param ----" + entry.getValue());    // [srinivas] and [15]
        }

        //Path Parameters
        MultivaluedMap<String, String> pathParams = uriInfo.getPathParameters();
        System.out.println("--------- pathParams --------" + pathParams);   //null in this case

        //Using @Context HttpHeaders headers  - Obtaining the header information like cookies, locale etc.
        MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
        System.out.println("--------- requestHeaders --------" + requestHeaders);

        //Obrtaining the cookies related information.
        Map<String, Cookie> cookie = headers.getCookies();
        System.out.println("--------- cookie --------" + cookie);

        //Obrtaining the locale information.
        Locale locale = headers.getLanguage();
        System.out.println("--------- locale --------" + locale);

        //@Context HttpServletRequest req - Obtaining the http request parameters values
        String paramName = req.getParameter("name");
        System.out.println("--------- paramName --------" + paramName);

        return path;
    }

}
