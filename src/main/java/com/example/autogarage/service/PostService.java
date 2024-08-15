package com.example.autogarage.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autogarage.model.Customer;
import com.example.autogarage.model.Post;
import com.example.autogarage.repository.CustomerRepository;
import com.example.autogarage.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> getPostsByCustomerId(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return postRepository.findByCustomer_Id(customerId);
        } else {
            throw new IllegalArgumentException("Customer with ID " + customerId + " not found");
        }
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            // post.setCustomerId(postDetails.getCustomerId());
            post.setQuestion(postDetails.getQuestion());
            post.setTimestamp(postDetails.getTimestamp());
            return postRepository.save(post);
        }
        return null;
    }
}
