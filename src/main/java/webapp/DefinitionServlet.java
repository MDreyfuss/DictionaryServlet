package webapp;

import dictionary.ScrabbleDictionary;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefinitionServlet extends HttpServlet {
    private ScrabbleDictionary scrabbleDictionary;

    public DefinitionServlet() {
        scrabbleDictionary = new ScrabbleDictionary();
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        // http://localhost:8080/DefinitionServlet-1.0-SNAPSHOT/dictionary?lookupWord=hello

        String lookupWord = request.getParameter("lookupWord");

        response.setContentType("text/json");

        if (scrabbleDictionary.isWord(lookupWord))
        {
            response.getWriter().println(scrabbleDictionary.getDefinition(lookupWord));
        }
        else
        {
            response.getWriter().println("Not a word");
        }
    }
}
