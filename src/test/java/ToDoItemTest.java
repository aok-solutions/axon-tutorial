import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class ToDoItemTest {
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(ToDoItem.class);
    }

    @Test
    public void testCreateToDoItem() throws Exception {
        fixture.given()
                .when(new CreateToDoItemCommand("todo-1", "need to implement the aggregate"))
                .expectEvents(new ToDoItemCreatedEvent("todo-1", "need to implement the aggregate"));
    }

    @Test
    public void testMarkToDoItemAsCompleted() throws Exception {
        fixture.given(new ToDoItemCreatedEvent("todo-1", "need to implement the aggregate"))
                .when(new MarkCompletedCommand("todo-1"))
                .expectEvents(new ToDoItemCompletedEvent("todo-1"));
    }
}
