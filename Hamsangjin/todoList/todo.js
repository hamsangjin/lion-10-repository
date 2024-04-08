let basicDatas = [
    { id: 1, title: "Todo 1", done: false },
    { id: 2, title: "Todo 2", done: true }
];
  
const todoList = document.getElementById('todoList');
const todoInput = document.getElementById('todoInput');
const addButton = document.getElementById('addButton');
  
// 할 일의 상태를 토글하는 함수
function toggleTodoStatus(id) {
    for (let i = 0; i < basicDatas.length; i++) {
        if (basicDatas[i].id === id) {
            basicDatas[i].done = !basicDatas[i].done;
            renderTodos();
            break;
        }
    }
}

// 할 일을 삭제하는 함수
function deleteTodo(id) {
    const newTodos = [];
    for (let i = 0; i < basicDatas.length; i++) {
            if (basicDatas[i].id !== id) {
                newTodos.push(basicDatas[i]);
            }
    }
    basicDatas = newTodos;
    renderTodos();
}
  
// 새로운 할 일을 추가하는 함수
function addTodo() {
    const newTodoTitle = todoInput.value;

    // 할 일 제목이 비어 있지 않은 경우에만 처리하기
    if (newTodoTitle !== '') {
    
        // id 설정
        let newId;
        if (basicDatas.length > 0) {
            let maxId = 0;
            for (let i = 0; i < basicDatas.length; i++) {
                if (basicDatas[i].id > maxId) {
                    maxId = basicDatas[i].id;
                }
            }
            newId = maxId + 1;
        } else {
            newId = 1;
        }

    const newTodo = { id: newId, title: newTodoTitle, done: false };
    basicDatas.push(newTodo);
    renderTodos();
    todoInput.value = '';
    }
}

addButton.addEventListener('click', addTodo);

todoInput.addEventListener('keydown', (event) => {
    if (event.key === 'Enter') {
        addTodo();
    }
});

// 할 일 목록을 UI에 렌더링하는 함수
function renderTodos() {
    todoList.innerHTML = '';
  
    basicDatas.forEach(todo => {
        // li 생성해서 내용 반영해주기
        const listItem = document.createElement('li');
        listItem.textContent = todo.title;
        if (todo.done) {
            listItem.classList.add('done');
        }
        listItem.addEventListener('click', () => toggleTodoStatus(todo.id));
  
        // 삭제 버튼 추가
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('delete-button');
        deleteButton.textContent = '❌';
        deleteButton.addEventListener('click', () => {
            deleteTodo(todo.id);
        });
        
        // 전체 리스트에 추가해주기
        listItem.appendChild(deleteButton);
        todoList.appendChild(listItem);
    });
}

renderTodos();
