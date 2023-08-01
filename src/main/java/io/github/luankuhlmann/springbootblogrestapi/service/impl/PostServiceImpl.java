package io.github.luankuhlmann.springbootblogrestapi.service.impl;

import io.github.luankuhlmann.springbootblogrestapi.dto.PostDto;
import io.github.luankuhlmann.springbootblogrestapi.entity.Post;
import io.github.luankuhlmann.springbootblogrestapi.repository.PostRepository;
import io.github.luankuhlmann.springbootblogrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // convert entity to DTO
    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // convert DTO to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponce = mapToDTO(newPost);

        return postResponce;
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }
}
