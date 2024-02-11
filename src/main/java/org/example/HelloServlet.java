package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private final HelloService service;

    //Servlet Container needs it
    @SuppressWarnings("unused")
    public HelloServlet(){
        this(new HelloService());
    }

    HelloServlet(HelloService service){
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request got" + req.getParameterMap());

        resp.getWriter().write(service.prepareGreeting(req.getParameter("name")));

    }
}
