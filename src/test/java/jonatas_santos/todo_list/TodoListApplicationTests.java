package jonatas_santos.todo_list;

import jonatas_santos.todo_list.entity.TodoEntity;
import jonatas_santos.todo_list.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private TodoService todoService;

	@Test
	void testCreateTodo() {
		var todoEntity = new TodoEntity("Aprender Spring Boot", "Estudar como criar APIs RESTful", false, 2);

		webTestClient
				.post()
				.uri("/todos/create")
				.bodyValue(todoEntity)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isNumber();
	}

	@Test
	void testGetTodoById() throws Exception {
		TodoEntity todoEntity = new TodoEntity("Teste Get por ID", "Descrição teste ID", false, 1);
		long createdId = todoService.create(todoEntity);

		webTestClient.get()
				.uri("/todos/get?id={id}", createdId)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.id").isEqualTo(createdId);
	}

	@Test
	void testUpdateTodo() throws Exception {
		TodoEntity todoEntity = new TodoEntity("Aprender Spring Boot", "Estudar como criar APIs RESTful", true, 1);
		long createdId = todoService.create(todoEntity);

		TodoEntity todoToUpdate = todoService.get(createdId).orElseThrow();

		todoToUpdate.setNome("Alterar nome");
		todoToUpdate.setDescricao("Alterar descrição");

		webTestClient
				.put()
				.uri("/todos/update")
				.bodyValue(todoToUpdate)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isEqualTo(createdId);
	}

	@Test
	void testDeleteTodo() throws Exception {
		long idDelete = 1L;

		webTestClient
				.delete()
				.uri("/todos/{id}", idDelete)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isNumber();
	}
}
