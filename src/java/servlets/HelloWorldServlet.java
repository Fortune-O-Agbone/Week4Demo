package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Person;

/**
 *
 * @author awarsyle
 */
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the two parameters from the POST request
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        
        
        // validation: if the parameters don't exist or are empty, show the first page again
        if (firstname == null || firstname.equals("") || lastname == null || lastname.equals("")) {
            // grabbing firstname and lastname from the form and
            // setting the attributes for the JSP
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
        
            /* set an attribute message for an invalid user input entry
            when it is empty */
            request.setAttribute("invalid", true);       
            
            // forward the request and response objects (the attributes) to the JSP
            // display the form again
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp")
                    .forward(request, response);
            return; // very important!
        }
        
        //if everything is good, the constructor starts a new object called person
        Person person = new Person(firstname, lastname);
        //sets a new attribute person of the object person
        request.setAttribute("person", person);

        /*
        connect sayHello.jsp with the person attribute in the sayHello.jsp
        by including
        
        imports models.Person;
        
        ${person.firstname}; and
        ${person.lastname};
        
        */
        // display the second page
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp")
                .forward(request, response);
    }
}
