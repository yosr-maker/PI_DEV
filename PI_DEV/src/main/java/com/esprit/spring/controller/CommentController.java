//package com.esprit.spring.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.esprit.spring.entites.Comment;
//
//import com.esprit.spring.services.CommentServiceI;
//
//@RestController
//
//public class CommentController {
//	
//	@Autowired
//	CommentServiceI commentService;
//	
//	//http://localhost:8092/SpringMVC/servlet/retrieve-all-comments
//	
//	@GetMapping("/retieve-all-comments")
//	@ResponseBody
//	public List<Comment> getComments() {
//		List<Comment> list = commentService.retrieveAllComments();
//		return list;
//	}
//
//		
//	//http://localhost:8092/SpringMVC/servlet/add-comment
//	
//	@PostMapping("/add-comment")
//	@ResponseBody
//	public  Comment addComment(@RequestBody Comment c) {
//		Comment comment = commentService.addComment(c);
//		return comment;
//	}
//	
//	@DeleteMapping("/remove-comment/{comment-id}")
//	@ResponseBody
//	public void removeComment(@PathVariable("comment-id") String commentId) {
//		commentService.deleteComment(commentId);
//	}
//
//	@PutMapping("/modify-comment")
//	@ResponseBody
//	public Comment modifyClaim(@RequestBody Comment comment) {
//	return commentService.updateComment(comment);
//	}
//	
//	
//	
//	@GetMapping("/retrieve-comment/{comment-id}")
//	@ResponseBody
//	public Comment retrieveComment(@PathVariable("comment-id")String commentId){
//		return commentService.retrieveComment(commentId);
//	}
//	
//	
//}
//
//
//	
//	
//	
//		
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
