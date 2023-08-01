package io.github.luankuhlmann.springbootblogrestapi.utils;

import io.github.luankuhlmann.springbootblogrestapi.dto.PostDto;
import io.github.luankuhlmann.springbootblogrestapi.entity.Post;
import io.github.luankuhlmann.springbootblogrestapi.repository.PostRepository;
import io.github.luankuhlmann.springbootblogrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // convert DTO to entity

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newPost = postRepository.save(post);

        // convert entity to DTO

        PostDto postResponce = new PostDto();
        postResponce.setId(newPost.getId());
        postResponce.setTitle(newPost.getTitle());
        postResponce.setDescription(newPost.getDescription());
        postResponce.setContent(newPost.getContent());

        return null;
    }
}
