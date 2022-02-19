package com.dev.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
