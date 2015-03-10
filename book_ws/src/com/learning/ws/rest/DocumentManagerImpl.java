package com.learning.ws.rest;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Dec 1, 2011
 * Time: 4:28:48 AM
 */
public class DocumentManagerImpl implements DocumentManager {

    public String getDocument(String id) {
        //GET operation - implement your logic here to get a document
        System.out.println("-------- GET ------" + id);
        return "your document content";
    }

    public void addDocument(String id) {
        //POST operation - implement your logic here to add a new document
        System.out.println("-------- POST ------" + id);
    }

    //Calling delete and replace operations through POST.
    public void deleteOrReplaceDocument(String id) {
        //Implement your logic here to delete or replace document
        System.out.println("-------- DELETE and PUT through POST ------" + id);
    }

    public void deleteDocument(String id) {
        //Implement your logic here to delete a document
        System.out.println("-------- DELETE ------");
    }

    public void replaceDocument(String id) {
        //Implement your logic here to replace a document
        System.out.println("-------- PUT ------");
    }

}
