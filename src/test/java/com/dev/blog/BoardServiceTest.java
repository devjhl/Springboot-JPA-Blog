package com.dev.blog;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dev.blog.model.Board;
import com.dev.blog.model.User;
import com.dev.blog.repository.BoardRepository;
import com.dev.blog.service.BoardService;



@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class BoardServiceTest {
	
	@Autowired EntityManager em;
    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;
    
    @Test
    public void 投稿() throws Exception {
    	//given
    	User user = createUser();
    	Board board = create("てすと", "てすとしています。");
    	
    	boardRepository.save(Board.builder()
    			.title(board.getTitle())
    			.content(board.getContent())
    			.user(user)
    			.build());
    	//when
    	List<Board> boardList = boardRepository.findAll(); 
    	//then
    	
    	Board boards = boardList.get(0);
    	assertThat(boards.getTitle()).isEqualTo(board.getTitle());
    	assertThat(boards.getContent()).isEqualTo(board.getContent());
    }
    
    private Board create(String title,String content) {
    	Board board = new Board();
    	board.setTitle(title);
    	board.setContent(content);
    	board.setCount(0);
    	em.persist(board);
    	return board;
    }
    
    private User createUser() {
    	User user = new User();
    	user.setUsername("kimura");
    	user.setPassword("1234");
    	user.setEmail("aaa@gmail.com");
    	em.persist(user);
    	return user;
    }

}
