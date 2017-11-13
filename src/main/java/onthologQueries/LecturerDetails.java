/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthologQueries;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Rid
 */
public class LecturerDetails {
         
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
       // where the ontology should be
    public static final String SOURCE_URL = "http://www.semanticweb.org/rid/ontologies/2017/10/universityCoursesNew";

    // where we've stashed it on disk for the time being
    protected static final String SOURCE_FILE = "UniversityCourcesNew.owl";

    // the namespace of the ontology
    public static final String NS = SOURCE_URL + "#";
    
    public static OntModel createModel(){ // create the onto model.
        OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        FileManager.get().getLocationMapper().addAltEntry(SOURCE_URL, SOURCE_FILE);
        Model baseOntology = FileManager.get().loadModel(SOURCE_URL);
        m.addSubModel(baseOntology);
        return m;
    }
    public ArrayList<ArrayList> getLecturerDetails(String facId) { // get course details from course Id 
        String da;
        JSONObject ja;
        OntModel m = createModel();
        String count = "";
        String queryString = "";
        
            queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> base <http://www.semanticweb.org/rid/ontologies/2017/10/universityCoursesNew> "
                + "SELECT ?lecId ?lecName ?courseId ?courseName ?department ?faculty ?university  { ?department <#hasFaculty> <#"+facId+"> .?lecId <#worksForDepartment> ?department ; <#fullName> ?lecName }";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, m);
        try {
            ResultSetRewindable results = ResultSetFactory.makeRewindable(qexec.execSelect());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ResultSetFormatter.outputAsJSON(outputStream, results);
            da = new String(outputStream.toByteArray());
            System.out.println(da);
        } finally {
            qexec.close();
        }
        ja = new JSONObject(da);
        JSONArray binding = ja.getJSONObject("results").getJSONArray("bindings");
        ArrayList<ArrayList> dataobj = new ArrayList<>();
        ArrayList<String> uniId = new ArrayList<String>();
        ArrayList<String> uniName = new ArrayList<String>();
        for(int i=0; i<binding.length();i++)
        {   
            uniId.add(binding.getJSONObject(i).getJSONObject("uni").getString("value").split(NS)[1]);
            uniName.add(binding.getJSONObject(i).getJSONObject("uniName").getString("value"));   
        }
        dataobj.add(0,uniId);
        dataobj.add(1,uniName);
        return dataobj;
    }
}
