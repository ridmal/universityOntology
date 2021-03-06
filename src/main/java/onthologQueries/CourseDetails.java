/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onthologQueries;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import static onthologQueries.UniversityDetails.NS;
import static onthologQueries.UniversityDetails.createModel;
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
import org.json.*;
/**
 *
 * @author Rid
 */
public class CourseDetails { 
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
    public JSONObject getCourseDetails(String cid) { // get course details from course Id 
        String da;
        JSONObject ja;
        OntModel m = createModel();
        String count = "";
        String queryString = "";
        
            queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> base <http://www.semanticweb.org/rid/ontologies/2017/10/universityCoursesNew> "
                + "SELECT ?courses ?lec ?lecfName ?lecemail ?lectelno ?dep ?ins ?courceName { <#"+cid+"> <#hasLecturer> ?lec ; rdf:type ?courses ; <#name> ?courceName ; <#hasDepartment> ?dep ."+
                "?lec <#fullName> ?lecfName ; <#email> ?lecemail ; <#telNo> ?lectelno .}";
 

        
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
        JSONObject newjo = new JSONObject();
        JSONObject lecobj = new JSONObject();
        JSONArray binding = ja.getJSONObject("results").getJSONArray("bindings");
       
         lecobj.put("lectureName",binding.getJSONObject(0).getJSONObject("lecfName").getString("value")) ;
         lecobj.put("lectureEmail",binding.getJSONObject(0).getJSONObject("lecemail").getString("value")) ;
         lecobj.put("lectureTelNo",binding.getJSONObject(0).getJSONObject("lectelno").getString("value")) ;
            newjo.put("lectureDetails", lecobj);
            newjo.put("Department",binding.getJSONObject(0).getJSONObject("dep").getString("value").split(NS)[1]) ;
            newjo.put("CourseName",binding.getJSONObject(0).getJSONObject("courceName").getString("value"));
           
            count = getStudentCount(cid,m);
            newjo.put("StudentCount", count);
            for( int i=0; i< binding.length(); i++){
                   if(binding.getJSONObject(i).getJSONObject("courses").getString("value").split(NS).length==2){
                         newjo.put("CourseType",binding.getJSONObject(i).getJSONObject("courses").getString("value").split(NS)[1]);
                        break;
                   }
            }
         System.out.println(newjo);
        return newjo;
    }
    public static void main(String[] args) {
    }
    public String getStudentCount(String cid,OntModel m){ // get student count for each subject
            String studentcount;
          String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> base <http://www.semanticweb.org/rid/ontologies/2017/10/universityCourses> "
                + "SELECT ?couseName (COUNT (DISTINCT ?students)as ?con) { ?students <#enrolls> <#"+cid+"> . <#"+cid+"> <#name> ?couseName .} GROUP BY ?couseName";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, m);
        try {
            ResultSetRewindable results = ResultSetFactory.makeRewindable(qexec.execSelect());
            //System.out.println("\n---- JSON ----");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ResultSetFormatter.outputAsJSON(outputStream, results);
            String da = new String(outputStream.toByteArray());
            JSONObject ja = new JSONObject(da);
            JSONArray binding = ja.getJSONObject("results").getJSONArray("bindings");
            studentcount = binding.getJSONObject(0).getJSONObject("con").getString("value");
        } finally {
            qexec.close();
        }
        return studentcount;
        }
    
    public ArrayList<ArrayList> getCourses(String facId) { // get list of course id and course names
        String da;
        JSONObject ja;
        OntModel m = createModel();
        String count = "";
        String queryString = "";
        
        queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> base <http://www.semanticweb.org/rid/ontologies/2017/10/universityCoursesNew> "
                + "SELECT ?courseId ?courseName { ?department <#hasFaculty> <#"+facId+"> .?courseId <#hasDepartment> ?department ; <#name> ?courseName }";
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
            uniId.add(binding.getJSONObject(i).getJSONObject("courseId").getString("value").split(NS)[1]);
            uniName.add(binding.getJSONObject(i).getJSONObject("courseName").getString("value"));   
        }
        dataobj.add(0,uniId);
        dataobj.add(1,uniName);
        return dataobj;
    }
}
