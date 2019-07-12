package com.codegym.data.controller;


import com.codegym.data.model.Blog;
import com.codegym.data.model.Category;
import com.codegym.data.service.BlogService;
import com.codegym.data.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@RestController
public class BlogControllernew {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Page<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @RequestMapping(value = "/blognew/", method = RequestMethod.GET)
    public ResponseEntity<Page<Blog>> listAllBlog(@ModelAttribute Blog blog1, Pageable pageable) {
        if (blog1.getDate() == null) {
            blog1.setDate(new Date());
        }
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs == null) {
            return new ResponseEntity<Page<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Page<Blog>>(blogs, HttpStatus.OK);
    }

    @RequestMapping(value = "/blognew/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") long id) {
        System.out.println("Fetching blog with id:" + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("blog with id" + id + "not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    @RequestMapping(value = "/blognew/",method = RequestMethod.POST)
    public ResponseEntity<Void> createBolg(@RequestBody Blog blog, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Blog " + blog.getDescrible());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blognew/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }


}
