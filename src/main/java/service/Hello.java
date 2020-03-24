/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

// Plain old Java Object it does not extend as class or implements 
// an interface
// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 
// The browser requests per default the HTML MIME type.
//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {

    // This method is called if HTML is request
    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayJsonHello() {
        return "{\"name\":\"ahmed\"}";
    }

    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(@Context HttpServletRequest request) {
        request.getSession().getAttribute("");
        return "Hello Jersey FD";
    }

    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello(@Context UriInfo ui, 
            @Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        System.out.println(headerParams.get("Accept"));
        System.out.println(ui.getAbsolutePath());
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello Rest" + "</body></h1>" + "</html> ";
    }
}
