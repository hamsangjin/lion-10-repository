document.addEventListener("DOMContentLoaded", () => {
  // 초기 데이터
  let basicDatas = [
    { id: 1, title: "Todo 1", done: false },
    { id: 2, title: "Todo 2", done: true },
  ];

  // 변수 설정
  const todoList = document.getElementById("todo-item-list");
  const addButton = document.querySelector(".add-button");
  const todoInput = document.getElementById("todo-value");

  // basicDatas를 화면에 표시하는 함수
  function addTodoItem(todo) {
    const todoItem = document.createElement("li");
    todoItem.classList.add("todo-item");

    const todoText = document.createElement("p");
    todoText.classList.add("todo-text");
    todoText.textContent = todo.title;
    todoItem.appendChild(todoText);

    const removeButton = document.createElement("button");
    removeButton.classList.add("remove");
    removeButton.textContent = "x";
    todoItem.appendChild(removeButton);

    // 할 일 항목을 클릭했을 때 done 상태를 토글
    // 취소선을 표시하는 이벤트
    todoItem.addEventListener("click", () => {
      todo.done = !todo.done;
      updateTodoItem(todoItem, todo);
    });

    // 할 일 삭제 버튼에 이벤트 등록
    removeButton.addEventListener("click", () => {
      todoList.removeChild(todoItem);
      basicDatas = basicDatas.filter((item) => item.id !== todo.id); // 데이터에서도 항목 제거
    });

    todoList.appendChild(todoItem);
  }

  // 할 일 추가 함수
  function addTodo() {
    const newTodoTitle = todoInput.value;
    if (newTodoTitle !== "") {
      const newTodo = {
        id: basicDatas.length + 1,
        title: newTodoTitle,
        done: false,
      };
      basicDatas.push(newTodo);
      addTodoItem(newTodo);
      todoInput.value = ""; // 입력 필드 초기화
    }
  }

  // 할 일 상태 업데이트 함수
  function updateTodoItem(todoItem, todo) {
    const todoText = todoItem.querySelector(".todo-text");
    if (todo.done) {
      todoText.style.textDecoration = "line-through"; // done: true - 취소선 표시
    } else {
      todoText.style.textDecoration = "none";
    }
  }

  // 초기 데이터에 있는 할 일 목록을 화면에 표시
  basicDatas.forEach((todo) => {
    addTodoItem(todo);
  });

  // add-button 클릭 시 동작
  addButton.addEventListener("click", function (event) {
    event.preventDefault();
    addTodo();
  });

  // Enter 키 입력 시 동작
  todoInput.addEventListener("keydown", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();
      addTodo();
    }
  });
});
