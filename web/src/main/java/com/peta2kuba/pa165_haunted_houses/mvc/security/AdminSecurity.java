package com.peta2kuba.pa165_haunted_houses.mvc.security;

import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author petr.melicherik
 */
@WebFilter(urlPatterns = {"/ability/add", "/ability/delete/*", "/ability/edit/*", "/haunter/add", "/haunter/delete/*", "/haunter/edit/*", "/person/add"})
public class AdminSecurity implements Filter {

    final static Logger log = LoggerFactory.getLogger(AdminSecurity.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String auth = httpRequest.getHeader("Authorization");
        if (auth == null) {
            response401(httpResponse, "Restricted area. (missing authorization)");
            return;
        }

        String[] creds = new String(DatatypeConverter.parseBase64Binary(auth.split(" ")[1])).split(":", 2);
        String email = creds[0];
        String pass = creds[1];

        log.error("User name:" + email);
        log.error("User password:" + pass);

        if (!"a".equals(email)) {
            response401(httpResponse, "Restricted area. (name mismatch)");
            return;
        }

        request.setAttribute("authenticatedPerson", new PersonDTO());
        chain.doFilter(request, response);
    }

    private void response401(HttpServletResponse response, String responseMsg) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "Basic realm=\"type email and password\"");
        response.getWriter().println("<html><body><h1>401 Unauthorized</h1>" + responseMsg + "</body></html>");
    }
}
