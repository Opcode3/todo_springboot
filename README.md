## Todo application using springboot
<p>This application is designed to implement and get stated with the basic and foundamental toipcs of backened development with springboot.</p>

## Endpoints
<ul>
    <li> Get all todos using : <em> localhost:9000/api/v1/todos</em> </li>
    <li> Get a todo by Id using : <em> localhost:9000/api/v1/todo/{id}</em> </li>
    <li> Update a todo by Id and a JSON body using : <em> localhost:9000/api/v1/todo/{id}</em> </li>
    <li> Mark a todo as complete using : <em> localhost:9000/api/v1/todo/{id}</em> </li>
    <li> Delete a todo by Id using : <em> localhost:9000/api/v1/todo/{id}</em> </li>
</ul>

### Request body
<code>
    
        {
            "todo_title": "Watch Jesus is King today",
            "todo_desc": "I will be calling watching Jesus is King movie today by exactly 10pm!"
        }
    
</code>