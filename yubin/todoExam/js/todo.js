document.addEventListener("DOMContentLoaded", function() {
    const todoForm = document.getElementById("todo-form");
    const todoInput = document.getElementById("todo-title");
    const ul = document.querySelector("ul");

    let nextId = 1; //다음 할일항목의 고유id를 위한 변수

    let basicDatas = [
        {id: nextId++, title: "Todo 1", done: false},
        {id: nextId++, title: "Todo 2", done: true},
    ];

    function printTodo() { //basicDatas 출력
        ul.innerHTML = ''; //초기화

        basicDatas.forEach(todo => {
            const li = document.createElement("li");
            li.classList.add("todo-item");

            const container = document.createElement('div');
            container.classList.add("todo-container");

            const text = document.createElement('span');
            text.textContent = todo.title;
            container.appendChild(text);

            if (todo.done) {
                li.classList.add('done');
            }

            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'X';
            deleteButton.classList.add('delete-button');
            deleteButton.addEventListener('click', () => {
                deleteTodo(todo.id);
            });
            container.appendChild(deleteButton);

            li.addEventListener('click', () => {
                todo.done = !todo.done; //토글!
                printTodo(); //상태 변경 후 다시 렌더링
            });

            li.appendChild(container);
            ul.appendChild(li);
        })
    }

    window.addEventListener('load', printTodo);

    function addTodo() {
        const todo = todoInput.value.trim(); //입력값 앞 뒤 공백제거
        if (todo !== '') {
            basicDatas.push({ id: nextId++, title: todo, done: false});
            printTodo();
            todoInput.value = '';
        }
    }

    function deleteTodo(id) {
        basicDatas = basicDatas.filter(todo => todo.id !== id);
        printTodo();
    }

    todoForm.addEventListener('submit', (event) => {
        event.preventDefault(); //폼 제출 기본동작 방지
        addTodo();
    });

    todoInput.addEventListener('keydown', (event) => {
        if(event.key === "Enter") {
            event.preventDefault();
            addTodo();
        }
    });
    
    const submitBtn = document.getElementById("submitBtn");
    submitBtn.addEventListener('click', (event) => {
        event.preventDefault();
        addTodo();
    })
});