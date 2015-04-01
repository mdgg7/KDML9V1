package com.ibm.cloudoe.samples;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Main1
 */
@WebServlet("/Main1")
public class Main1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UPLOAD_DIRECTORY = "E:\\";
		if(ServletFileUpload.isMultipartContent(request)){
			             try {
			                 List<FileItem> multiparts = new ServletFileUpload(
			                                          new DiskFileItemFactory()).parseRequest( request);
			                 for(FileItem item : multiparts){
			                     if(!item.isFormField()){
			                         String name = new File(item.getName()).getName();
			                         item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
			                    	 System.out.println(item.toString());
			                     }
			                 }
			             
			                request.setAttribute("message", "File Uploaded Successfully");
			             } catch (Exception ex) {
			                request.setAttribute("message", "File Upload Failed due to " + ex);
			                System.out.println(ex.getMessage());
			             }         
			           
			         }else{
			             request.setAttribute("message",
			                                  "Sorry this Servlet only handles file upload request");
			             System.out.println("in else loop");
			         }
	}

}
