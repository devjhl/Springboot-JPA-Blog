package com.dev.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
    
    @Test
    public void 削除() throws Exception {
    	//given
    	User user = createUser();
    	Board board = create("てすと", "てすとしています。");
    	
    	boardRepository.save(Board.builder()
    			.title(board.getTitle())
    			.content(board.getContent())
    			.user(user)
    			.build());
    	
    	boardService.deleteById(board.getId());
    	
    	Optional<Board> boarddetail = boardRepository.findById(board.getId());
    	
    	boarddetail.isPresent();
    	
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
