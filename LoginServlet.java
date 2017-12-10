import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        
        response.setContentType("text/html");  //inizializza l'header della risposta http
        PrintWriter out=response.getWriter(); //scrive il contenuto della risposta http
        request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name"); //prende il contenuto della input con name="name"
        String password=request.getParameter("password");  // prende il contenuto della input con name="password"
          
        if(password.equals("admin123")){  
            out.print("Welcome, "+name); //messaggio di benvenuto 
            HttpSession session=request.getSession(); //apertura della sessione 
            session.setAttribute("name",name); //setta l'attributo all'interno della sessione 
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}  