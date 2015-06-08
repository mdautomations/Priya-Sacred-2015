package com.spring;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import javax.jdo.PersistenceManager;
import java.util.ResourceBundle;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mortbay.log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.Entry;

import javax.jdo.Query;

import com.spring.PMF;
import com.google.appengine.labs.repackaged.org.json.JSONException;

@Controller
public class SpringServlet 
{
		private static final ServletResponse response = null;

@RequestMapping(value="/",method=RequestMethod.GET)	
public String userdefined(HttpServletRequest req, HttpServletResponse resp) throws IOException 
{
	return "login";
}
@RequestMapping(value="/checkentry",method=RequestMethod.POST)
public @ResponseBody String checkentry(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws IOException, JSONException
{
	PersistenceManager  pm         = 	PMF.get().getPersistenceManager();
	Entry 		enter 			   =  	new Entry();
	String 		keyword			   =   	request.getParameter("email");
	String 		password		   =   	request.getParameter("password");
	Query 		queryUserDetails1  =	pm.newQuery(Entry.class," email == '"+keyword+"' && password == '"+password+"'");
	List<Entry> usersInfo1 		   = 	(List<Entry>)queryUserDetails1.execute();
	if(usersInfo1.size()!=0)
	{
	  	return "success";
	}
	else
	{
		return "failure";
	}
}
@RequestMapping(value="/fileload",method=RequestMethod.POST)
public void fileload(@RequestParam(value="filteredPDFone",required=false)String filteredPDFone,@RequestParam(value="filenumber",required=false)String filenumber,HttpServletResponse response,HttpSession session)throws IOException, JSONException
{
	System.out.println("the received pdf is this :: "+filteredPDFone);
	session.setAttribute("pdf"+filenumber, filteredPDFone);
}
@RequestMapping(value="/registeration",method=RequestMethod.POST)
public void registeration(@RequestParam(value="firstname",required=false)String name,@RequestParam(value="email",required=false)String email,@RequestParam(value="password",required=false)String password,@RequestParam(value="phonenumber",required=false)String phonenumber,@RequestParam(value="dates",required=false)String dates,HttpServletResponse response,HttpSession session)throws IOException, JSONException
{
	DateFormat dateFormat   		= 		new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	PersistenceManager  pm          = 		PMF.get().getPersistenceManager();
	try
	{
		Entry 		enter 			=  	new Entry();
		UUID uniqueKey				= 		UUID.randomUUID();
		enter.setemail(email);
		enter.setname(name);
		enter.setKey(uniqueKey.toString());
		enter.setpassword(password);
		enter.setDate(dates);;
		enter.setphonenumber(phonenumber);
		pm.currentTransaction().begin();
		pm.makePersistent(enter);
		pm.currentTransaction().commit();
	}
	catch(Exception e)
	{
		e.getStackTrace();
		System.out.println("the exception is this :: "+e);
	}
	finally
	{
		pm.close();
	}
}
@RequestMapping(value="/profile",method=RequestMethod.POST)
public void registeration(@RequestParam(value="email",required=false)String email,@RequestParam(value="degree",required=false)String degree,@RequestParam(value="name",required=false)String name,@RequestParam(value="greatness",required=false)String greatness,@RequestParam(value="inlineRadio1",required=false)String inlineRadio1,@RequestParam(value="referal",required=false)String referal,@RequestParam(value="department",required=false)String department,@RequestParam(value="yop",required=false)String yop,@RequestParam(value="goal",required=false)String goal,HttpServletResponse response,HttpSession session)throws IOException, JSONException
{
	System.out.println(" email  " +email);
	System.out.println(" degree :: " +degree);
	System.out.println(" greatness :: " +greatness);
	System.out.println(" goal :: " +goal);
	System.out.println(" genfer :: " +inlineRadio1);
	System.out.println(" department :: " +department);
	System.out.println(" referal :: " +referal);
	System.out.println(" yop :: " +yop);
	System.out.println(" name :: " +name);
	DateFormat dateFormat   	   = 	new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	PersistenceManager  pm         = 	PMF.get().getPersistenceManager();
		 try
			{
			    Profile enter =  new Profile();
				UUID uniqueKey	= UUID.randomUUID();
				enter.setDegree(degree);
				enter.setDepartment(department);
				enter.setName(name);
				enter.setEmail(email);
				enter.setGender(inlineRadio1);
				enter.setGoal(goal);
				enter.setGreatness(greatness);
				enter.setKey(uniqueKey.toString());
				enter.setReferal(referal);
				enter.setYop(yop);
				pm.currentTransaction().begin();
				pm.makePersistent(enter);
				pm.currentTransaction().commit();
			}
			catch(Exception e)
			{
				e.getStackTrace();
				System.out.println("the exception is this :: "+e);
			}
		 	finally
			{
				pm.close();
			}
			
	 }
@SuppressWarnings("unchecked")
@RequestMapping(value = "/subjects", method = RequestMethod.POST)
public @ResponseBody String subjects (HttpServletRequest request,@RequestParam(value="goal",required=false)String goal, Model model, HttpSession session)
{
	
	   String 				status 					= 		null;
	   PersistenceManager  	pm 						= 		null;
	   Query                queryUserDetails		=		null;
	   List<Subjects> 		usersInfo				=		null;
	   try
	   {
	        pm             								   	 =      PMF.get().getPersistenceManager();
	        queryUserDetails        				   	   	 =  	 pm.newQuery(Subjects.class);
	        usersInfo           					   	   	 =      (List<Subjects>) queryUserDetails.execute();
	        if( usersInfo != null && !usersInfo.isEmpty() )
	   	 	{
	   		   for( Subjects values:usersInfo )
	   		   {
	   			   if(values!=null)
	   			   {
	   			    	   pm.deletePersistentAll(values);
	   			   }
	   		   }
	   	 	}
	   }
	   catch(Exception e)
	   {
		   System.out.println("Exception while deleting");
	   }
	   finally
	   {
		   pm.close();
	   }
	
	
	 PersistenceManager      pms			= 			null;
	 pms     	    						=  			PMF.get().getPersistenceManager();
	 Query 			QueryLists  			=			null;
	 List<Profile> 	listEntry 				=			null;
	 QueryLists     						= 			pms.newQuery(Profile.class,"goal == '"+goal+"'");
	 listEntry 								= 			(List<Profile>)QueryLists.execute();
	 if( listEntry != null && !listEntry.isEmpty() )
	 {
		   for( Profile values:listEntry )
			 {
			        if(values.getSyllabus()!=null)
			        {
			        	String 		spittedcourse 	= 			values.getSyllabus().trim();
				 		System.out.println("The syllabus obtained from profile table :: "+spittedcourse);
				 		System.out.println(" ");
				 		System.out.println(" ");
				 		if(spittedcourse!=null)
				 		{
						 	String[] 	finalcourse 			= 			values.getSyllabus().split(",");
						 	for(int i=0; i<finalcourse.length;i++)
							{
									Query 	QueryListing1  		=			null;
									List<Subjects>  listEnter1	=			null;
									QueryListing1     			= 			pms.newQuery(Subjects.class,"subjects == '"+finalcourse[i].trim()+"'");
									listEnter1 					= 			(List<Subjects>)QueryListing1.execute();
						 			if(listEnter1.size()>0)
						 			{
						 				 for( Subjects values1	:listEnter1 )
						 				 {
						 					  if(values1.getGoal().trim().equalsIgnoreCase(goal))
						 					  {
						 						  System.out.println("the subject :: "+finalcourse[i]+"  already exists so incrementing ");
						 						  System.out.println(" ");
  					 						      int count 		= 			values1.getCount();
						 						  System.out.println("count is this  "+count);
						 						  values1.setCount(count+1);
						 						  values1.setClickRate(count+1);
						 						  pms.currentTransaction().begin();
												  pms.makePersistent(values1);
												  pms.currentTransaction().commit();
											  }
										  }
									}
									else
									{
										System.out.println("the subject :: "+finalcourse[i]+"  doent exists so adding ");
										System.out.println(" ");
										System.out.println(" ");
										PersistenceManager      pmo		= 		null;
										pmo     	   					=  	PMF.get().getPersistenceManager();
									    Subjects enter 					=  	new Subjects();
									    UUID uniqueKey					=		 UUID.randomUUID();
										enter.setGoal(goal);
										enter.setKey(uniqueKey.toString());
										enter.setSubjects(finalcourse[i]);
										enter.setCount(1);
										enter.setClickRate(1);
										pmo.currentTransaction().begin();
										pmo.makePersistent(enter);
										pmo.currentTransaction().commit();
									}
								}
							}
			          }
				}
	}
	 return "success";
}
@RequestMapping(value = "/setfeedback", method = RequestMethod.POST)
public @ResponseBody String setfeedback(HttpServletRequest request,
		@RequestParam(value="email",required=false)String email,
		@RequestParam(value="degree",required=false)String degree,
		@RequestParam(value="yop",required=false)String yop,
		@RequestParam(value="department",required=false)String department,
		@RequestParam(value="greatness",required=false)String greatness, 
		@RequestParam(value="goal",required=false)String goal,
		@RequestParam(value="electives",required=false)String electives,
		@RequestParam(value="name",required=false)String name, 
		Model model, HttpSession session)
{
	PersistenceManager    pmfeed					    = 		null;
	try
	{
		pmfeed     	   					=  	PMF.get().getPersistenceManager();
		testimonial 		testi 			=  	new testimonial();
		UUID uniqueKey				= 		UUID.randomUUID();
		testi.setKey(uniqueKey.toString());
		testi.setDegree(degree);
		testi.setDepartment(department);
		testi.setElectives(electives);
		testi.setEmail(email);
		testi.setGreatness(greatness);
		testi.setName(name);
		testi.setYop(yop);
		testi.setGoal(goal);
		pmfeed.currentTransaction().begin();
		pmfeed.makePersistent(testi);
		pmfeed.currentTransaction().commit();
	}
	catch(Exception e)
	{
		e.getStackTrace();
		System.out.println("the exception is this :: "+e);
	}
	finally
	{
		pmfeed.close();
	}
	 return "success";
}
@RequestMapping(value = "/setprofile", method = RequestMethod.POST)
public @ResponseBody String  setprofile(HttpServletRequest request,@RequestParam(value="email",required=false)String email,@RequestParam(value="creditvalue",required=false)String creditvalue,@RequestParam(value="finalcourse",required=false)String finalcourse,@RequestParam(value="goal",required=false)String goal, Model model, HttpSession session)
{
	 PersistenceManager    pmff					    = 		null;
	 PersistenceManager    visitpmf					    = 		null;
	 Query 							QueryLists  			=		null;
	 Query 							QueryListsforcount  			=		null;
	 Query 							visitQuery  			=		null;
	 List<Profile> 					listEntry 				=		null;
	 List<visitation> 				visitEntry 				=		null;
	 List<Profile> 					queryEntry 				=		null;
	 List<Profile> 					queryEntryforCount 				=		null;
	 List<Subjects> 				sublists 				=		null;
	 String 			status 										= 		"";
	 String[]	    listOfName ;
	 System.out.println("THE EMAIL OF THE CANDIATE :: " +email);
	 System.out.println("THE FINAL COURSE RECEIVED :: " +finalcourse);
	 System.out.println("THE CREDIT VALUE FOR THE SUBJECTS  :: " +creditvalue);
	 try
	 {
		 pmff     	    		=  	PMF.get().getPersistenceManager();
		 QueryLists     		= 		pmff.newQuery(Profile.class,"email == '"+email+"'");
		 listEntry 				= 		(List<Profile>)QueryLists.execute();
		 int totalCredit    	= 		Integer.parseInt(creditvalue);
		
		 if( listEntry != null && !listEntry.isEmpty() )
 		 {
	 			 for( Profile value:listEntry )
	 			 {
		 				 listOfName 			= 		finalcourse.trim().split(",");
		 				 StringBuffer sBuffer = new StringBuffer();
		 				 for(int hen=0; hen<listOfName.length;hen++)
		 				 {
		 					   String listtoadd = listOfName[hen];
		 					   listtoadd = listtoadd.replaceAll("\\s+", "");
		 					   if(hen==listOfName.length -1)
		 					   {
		 						  sBuffer.append(listtoadd);
		 					   }
		 					   else
		 					   {
		 						  sBuffer.append(listtoadd+",");
		 					   }
		 				 }
		 				 System.out.println("THE SUBJECTS AFTER SPLLITING :: "+listOfName);
		 				System.out.println("TOTAL SUBJECTS CHOSEN "+listOfName.length);
		 				System.out.println("TOTAL SUBJECTS CHOSEN "+sBuffer.toString());
		 				visitpmf     	    =  	PMF.get().getPersistenceManager();
		 				visitQuery     		= 	visitpmf.newQuery(visitation.class," subjects == '"+sBuffer.toString()+"' && goal == '"+goal+"'");
		 				visitEntry 			= 	(List<visitation>)visitQuery.execute();
		 				System.out.println("visitEntry count :: "+visitEntry.size());
		 				if( visitEntry != null && !visitEntry.isEmpty() )
			 		 	{
	 						QueryLists     			= 	pmff.newQuery(Profile.class," syllabus == '"+sBuffer.toString()+"' && goal == '"+goal+"'");
	 						queryEntry 				= 	(List<Profile>)QueryLists.execute();
	 						System.out.println("dey machaan ::"+queryEntry.size());
		 					for(visitation valueentry:visitEntry)
		 					{
		 						for(Profile values:queryEntry)
		 						{
		 							String obtainedgoal = values.getGoal();
		 							if(goal.equalsIgnoreCase(obtainedgoal))
		 							{
		 								System.out.println("MAKING A already ENTRY PA");
		 								valueentry.setCount(queryEntry.size()+1);
				 						valueentry.setSubjects(sBuffer.toString());
		 								valueentry.setGoal(values.getGoal());
		 								visitpmf.makePersistent(valueentry);
		 							}
		 						}
		 						
		 						break;
		 					}
		 					
			 		 	}
		 				else
		 				{
		 					System.out.println("MAKING A NEW new ENTRY PA");
	 						QueryLists     			= 	pmff.newQuery(Profile.class,"email == '"+email.toString()+"'");
	 						queryEntry 				= 	(List<Profile>)QueryLists.execute();
	 						QueryListsforcount     	= 	pmff.newQuery(Profile.class,"syllabus == '"+sBuffer.toString()+"'");
	 						queryEntryforCount 		= 	(List<Profile>)QueryListsforcount.execute();
		 					UUID uniqueKey			=		UUID.randomUUID();
		 					visitation enter 		=  	new visitation();
		 					enter.setCount(1);
		 					enter.setKey(uniqueKey.toString());
		 					enter.setSubjects(sBuffer.toString());
		 					for(Profile values:queryEntry)
		 					{
		 						enter.setGoal(values.getGoal());
		 					}
		 					visitpmf.makePersistent(enter);
		 				}
		 				visitpmf.close();
		 				value.setTotalCredit(totalCredit);
		 				value.setSyllabus(sBuffer.toString());
		 				pmff.currentTransaction().begin();
		 				pmff.makePersistent(value);
		 				pmff.currentTransaction().commit();
	 			 }
 		 }
	 }
	 catch(Exception e)
	 {
		 		System.out.println("Exception Arised :: "+e);
	 }
	 finally
	 {
		 if(pmff!=null)
			 pmff.close();
	 }
	 return "success";
}

@RequestMapping(value = "/getNewDesignAccessList", method = RequestMethod.POST)
public @ResponseBody String fetchtable(HttpServletRequest request, Model model, HttpSession session)
{
	   String 					status 	= 		null;
	   PersistenceManager 	pm 			= 		null;
	   Query 		queryUserDetails	=		null;
	   List<Entry> usersInfo			=		null;
	   
	   try
	   {
	        pm             						=      PMF.get().getPersistenceManager();
	        HashMap<String, Entry> tableEntry 	=      new HashMap<String,  Entry>();
	        queryUserDetails        			=  	  pm.newQuery(Entry.class);
	        usersInfo           				=      (List<Entry>) queryUserDetails.execute();
	      
	        for( Entry value:usersInfo )
	        {
	        	tableEntry.put( value.getKey().toString(), value );
	        }  
	        
	        status               				=   	  new ObjectMapper().writeValueAsString(tableEntry);
	        System.out.println("the status is this :: "+status);
	   }
	   catch(Exception e)
	   {
		      System.out.println("the error occured is this :: "+e);
	   }
	return status;
}

@RequestMapping(value = "/getprofdetails", method = RequestMethod.POST)
public @ResponseBody String getprofdetails(HttpServletRequest request, Model model, HttpSession session)
{
	   String 			   status 							= 		null;
	   PersistenceManager  pm 								= 		null;
	   Query               queryUserDetails					=		null;
	   List<Profile> 	   usersInfo						=		null;
	   try
	   {
	        pm             							  =      PMF.get().getPersistenceManager();
	        HashMap<String, Profile> tableEntry 	  =      new HashMap<String,  Profile>();
	        queryUserDetails        				  =  	  pm.newQuery(Profile.class);
	        usersInfo           					  =      (List<Profile>) queryUserDetails.execute();
	      
	        for( Profile value:usersInfo )
	        {
	        	tableEntry.put( value.getKey().toString(), value );
	        }  
	        status               						   				  =   	  new ObjectMapper().writeValueAsString(tableEntry);
	        System.out.println("the statudfsdfsds is this :: "+status);
	   }
	   catch(Exception e)
	   {
		   	System.out.println("the entry is this ::"+e);
	   }
	return status;
}
@SuppressWarnings("unchecked")
@RequestMapping(value = "/autocourse", method = RequestMethod.POST)
public @ResponseBody String autocourse(HttpServletRequest request,@RequestParam(value="email",required=false)String email, Model model, HttpSession session) throws JsonGenerationException, JsonMappingException, IOException
{
	   String 				status 					= 		null;
	   PersistenceManager 	pm 						= 		null;
	   Query 				queryUserDetails		=		null;
	   List<Subjects> 		usersInfo				=		null;
	   try
	   {
	        pm             							=      PMF.get().getPersistenceManager();
	        HashMap<String, Subjects> tableEntry 	=      new HashMap<String,  Subjects>();
	        queryUserDetails        				=  	  pm.newQuery(Subjects.class);
	        usersInfo           					=      (List<Subjects>) queryUserDetails.execute();

	        for( Subjects value:usersInfo )
	        {
	        	tableEntry.put( value.getKey().toString(), value );
	        }  
	        
	        status               						   					=   	  new ObjectMapper().writeValueAsString(tableEntry);
	        System.out.println("the statudfsdfsds is this :: "+status);
	   }
	   catch(Exception e)
	   {
		   System.out.println("the entry is this ::"+e);
	   }
	return status;
}
@SuppressWarnings("unchecked")
@RequestMapping(value = "/visitationjs", method = RequestMethod.POST)
public @ResponseBody String visitation(HttpServletRequest request,@RequestParam(value="email",required=false)String email, Model model, HttpSession session) throws JsonGenerationException, JsonMappingException, IOException
{
	   String 				status 					= 		null;
	   
	   PersistenceManager 	pm 						= 		null;
	   PersistenceManager 	pmff 					= 		null;
	   PersistenceManager 	subjectpmf 				= 		null;
	   PersistenceManager 	visitPMF 				= 		null;
	   PersistenceManager 	maxsubjectDetailsPMF 	= 		null;
	   
	   Query 				queryUserDetails		=		null;
	   Query 				visterDetails			=		null;
	   Query 				subjectdetail			=		null;
	   Query 				QueryLists				=		null;
	  
	   
	   List<Profile> 		usersInfo				=		null;
	   List<visitation> 	visitinfo				=		null;
	   List<Profile> 		queryEntry				=		null;
	   List<Subjects> 		subjectQuery			=		null;
	  
	   
	   String 				goal 					= 		null;
	   try
	   {
		   	pm             							=      PMF.get().getPersistenceManager();
		   	subjectpmf             					=      PMF.get().getPersistenceManager();
		   	visitPMF             					=      PMF.get().getPersistenceManager();
		   	maxsubjectDetailsPMF					=      PMF.get().getPersistenceManager();
		   	
	        HashMap<String, String> tableEntry 		=      new HashMap<String,  String>();
	        HashMap<String, String> subjectEntry 	=      new HashMap<String,  String>();
	        HashMap<String, String> visitEntry 		=      new HashMap<String,  String>();
	        HashMap<String, Object> sethigh 		=      new HashMap<String,  Object>();
	        HashMap<String, Object> newentry 		=      new HashMap<String,  Object>();
	        HashMap<String, Object> maxentry 		=      new HashMap<String,  Object>();
	        
	        QueryLists     							= 	   pm.newQuery(Profile.class,"email == '"+email+"'");
	        queryEntry           					=      (List<Profile>) QueryLists.execute();
	        
	        subjectdetail        					=  	   subjectpmf.newQuery(Subjects.class);
	        subjectQuery           					=      (List<Subjects>) subjectdetail.execute();
	        
	        visterDetails           				=      visitPMF.newQuery(visitation.class);
	        visitinfo           					=      (List<visitation>) visterDetails.execute();
	       
	        
	        System.out.println("visit count i sthis :: "+visitinfo);
	        
	        for(Subjects plswork:subjectQuery)
	        {
	        	tableEntry.put(plswork.getSubjects(), String.valueOf(plswork.getCount()));
	        }
	        newentry.put("visit", tableEntry);
	        
	        for(Profile values:queryEntry)
	        {
	        	goal=values.getGoal();
	        	break;
	        }
	        
	        queryUserDetails						=	  pm.newQuery(Profile.class,"goal == '"+goal+"'");
	        usersInfo           					=      (List<Profile>) queryUserDetails.execute();
	        
	        for( Profile value:usersInfo )
	        {
	        	subjectEntry.put(value.getEmail(), value.getSyllabus());
	        }
	        newentry.put("syllabus", subjectEntry);
	        
	        int count,tempcount=0;
	        for( visitation value:visitinfo )
	        {
	        	if(tempcount==0)
	        	{
	        		tempcount = value.getCount();
	        		sethigh.put("highvalue", value.getSubjects());
	        		sethigh.put("tieupfound", false);
	        	}
	        	else if(value.getCount()>tempcount)
	        	{
	        		tempcount = value.getCount();
	        		sethigh.put("highvalue", value.getSubjects());
	        		sethigh.put("tieupfound", false);
	        	}
	        	else if(value.getCount()==tempcount)
	        	{
	        		sethigh.put("highvalue", value.getSubjects());
	        		sethigh.put("tieupfound", true);
	        	}
	        	UUID unique = UUID.randomUUID();
	        	visitEntry.put(String.valueOf(value.getCount()+"##"+unique.toString()),value.getSubjects()) ;
	        	
	        }
	        String[] maxsubjects = sethigh.get("highvalue").toString().split(",");
	        for(int ints=0;ints<maxsubjects.length;ints++)
	        {
	        	Query 				maxsubjectDetails		=		null;
	        	List<Subjects> 		maxsubjectDetailsList	=		null;
	        	maxsubjectDetails     						= 	   maxsubjectDetailsPMF.newQuery(Subjects.class,"subjects == '"+maxsubjects[ints]+"'");
	 	        maxsubjectDetailsList           			=      (List<Subjects>) maxsubjectDetails.execute();
	 	        for (Subjects getitwork : maxsubjectDetailsList)
	 	        {
	 	        	maxentry.put(getitwork.getSubjects(), getitwork.getCount());
	 	        }
	        }
	        if(sethigh.containsKey("tieupfound"))
	        {
	        	newentry.put("tieupfound", sethigh.get("tieupfound"));	
	        }
	        newentry.put("maxentry", maxentry);
	        System.out.println("infor this is ::"+visitEntry);
	        newentry.put("pathvisit", visitEntry);
	        status               						   					=   	  new ObjectMapper().writeValueAsString(newentry);
	        System.out.println("the statudfsdfsds is this :: "+status);
	   }
	   catch(Exception e)
	   {
		   System.out.println("the entry is this ::"+e);
	   }
	return status;
}
@SuppressWarnings("unchecked")
@RequestMapping(value = "/fetchtestimonial", method = RequestMethod.POST)
public @ResponseBody String testimonial(HttpServletRequest request,@RequestParam(value="goal",required=false)String goal, Model model, HttpSession session) throws JsonGenerationException, JsonMappingException, IOException
{
		String 				status 					= 		null;
	   PersistenceManager 	pm 						= 		null;
	   Query 				queryUserDetails		=		null;
	   List<testimonial> 		usersInfo				=		null;
	   try
	   {
	        pm             							=      PMF.get().getPersistenceManager();
	        HashMap<String, testimonial> tableEntry 	=      new HashMap<String,  testimonial>();
	        queryUserDetails        				=  	  pm.newQuery(testimonial.class,"goal == '"+goal+"'");
	        usersInfo           					=      (List<testimonial>) queryUserDetails.execute();

	        for( testimonial value:usersInfo )
	        {
	        	tableEntry.put( value.getKey().toString(), value );
	        }  
	        
	        status               						   					=   	  new ObjectMapper().writeValueAsString(tableEntry);
	        System.out.println("the statudfsdfsds is this :: "+status);
	   }
	   catch(Exception e)
	   {
		   System.out.println("the entry is this ::"+e);
	   }
	return status;
}
@RequestMapping(value="/checkprofile",method=RequestMethod.POST)
public @ResponseBody String checkprofile(HttpServletRequest request,@RequestParam(value="email",required=false)String email, Model model, HttpSession session) throws JsonGenerationException, JsonMappingException, IOException
{
	PersistenceManager  pm         	   = 	PMF.get().getPersistenceManager();
	Profile 		profile 		   =  	new Profile();
	Query 		queryUserDetails       =  	pm.newQuery(Profile.class,"email == '"+email+"'");
	List<Profile> usersInfo1 		   = 	(List<Profile>)queryUserDetails.execute();
	if(usersInfo1.size()!=0)
	{
	  	return "success";
	}
	else
	{
		return "failure";
	}
}
}

