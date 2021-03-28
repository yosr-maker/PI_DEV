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
//import com.esprit.spring.entites.Publication;
//import com.esprit.spring.services.PublicationServiceI;
//
//
//
//@RestController
//public class PublicationController {
//
//@Autowired
//PublicationServiceI publicationService;
//
//@GetMapping("/retrieve-all-publications")
//@ResponseBody
//public List<Publication> getPublications() {
//List<Publication> list = publicationService.retrieveAllPublications();
//return list;
//}
//
//@GetMapping("/retrieve-publication/{publication-id}")
//@ResponseBody
//public Publication retirevePublication(@PathVariable("publication-id") String idPublication) {
//	return publicationService.retrievePublication(idPublication) ; 
//}
//
//@PostMapping("/add-publication")
//@ResponseBody
//public Publication addPublication(@RequestBody Publication p ) {
//	Publication publication = publicationService.addPublication(p);
//    return publication ; 
//
//}
//
//@DeleteMapping("/remove-publication/{publication-id}")
//@ResponseBody
//public void removePublication(@PathVariable("publication-id") String idPublication) {
//publicationService.deletePublication(idPublication);
//}
//
//@PutMapping("/modify-publication")
//@ResponseBody
//public Publication modifyClaim(@RequestBody Publication publication) {
//return publicationService.updatePublication(publication);
//}
//}
