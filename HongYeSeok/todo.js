const form = document.querySelector('form');
const input = document.querySelector('input');
const ul = document.querySelector('ul');

let basicDatas = [
  { id: 1, title: "Todo 1", done: false },
  { id: 2, title: "Todo 2", done: true },
];

document.addEventListener('DOMContentLoaded', () => {
  basicDatas.forEach(todo => {
    const li = document.createElement('li');
    const text = document.createTextNode(todo.title);
    li.classList.add("todo-item");
    li.appendChild(text);
    if(todo.done){
      // li.style.textDecoration = 'line-through';
      li.classList.add("done");
    }
    ul.appendChild(li)
  })
})

form.addEventListener('submit', (event) => {
  event.preventDefault();
  addNewTodo();
  const li = document.createElement('li');
  const text = document.createTextNode(input.value);
  li.appendChild(text);
  li.classList.add("todo-item");
  ul.appendChild(li);
  input.value = '';
})

form.addEventListener('keydown', (event) => {
  event.preventDefault();
  if (event.key === "ENTER") {
    input.click();
  }
})

// ul.addEventListener("click", (e) => {

// });

function addNewTodo(){
  const newTodo = {
    id : basicDatas.length + 1,
    title : input.value,
    done : false
  };
  basicDatas.push(newTodo);
}

function addRemoveButton(li){
  const removeButton = document.createElement("span");
  removeButton.textContent = 'x';
  removeButton.classList.add("remove");
  li.appendChild(removeButton);
}