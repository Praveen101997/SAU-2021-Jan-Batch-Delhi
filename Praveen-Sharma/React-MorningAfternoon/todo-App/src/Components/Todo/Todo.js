import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      { todo: "first todo", marked: false, delete: false },
      { todo: "second todo", marked: false, delete: false },
      { todo: "third todo", marked: true, delete: false },
      { todo: "fourth todo", marked: false, delete: false },
      { todo: "fifth todo", marked: true, delete: false },
      { todo: "sixth todo", marked: false, delete: false },
      { todo: "seventh todo", marked: true, delete: false },
      { todo: "eighth todo", marked: true, delete: false },
      { todo: "nineth todo", marked: false, delete: false },
    ],
    title: "My tasks",
    filterBy: "showAll",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  // Add a new todo
  addTask = () => {
    const { todo, todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false,delete:false });
      this.setState({ todos: newTodos, todo: "" });
    }
  };


  // Mark tasks as Complete
  markTaskAsCompleted = (event, index) => {
    const { todos } = this.state;

    const newTodos = [...todos];

    newTodos[index] = {
      ...newTodos[index],
      marked: event.target.checked,
    };

    this.setState({ todos: newTodos });
  };

  //Delete tasks
  deleteTask = (index) => {
    const { todos } = this.state;

    var newTodos = [...todos];

    newTodos[index] = {
      ...newTodos[index],
      delete: true,
    };

    newTodos = newTodos.filter((item) => {
      if(item.delete===true){
        return false;
      }
      return true;
    })

    this.setState({ todos: newTodos });
  };

  //Duplicate tasks
  duplicateTask = (index) => {
    const { todos } = this.state;

    const newTodos = [...todos];

    newTodos.push({
      ...newTodos[index],
      marked:false,
    })

    this.setState({ todos: newTodos });
  };

  // Set state for pending tasks
  onPending = () => {
      this.setState({filterBy:"pending"});
  }

  //Set state for complete tasks
  onCompleted = () => {
    this.setState({filterBy:"completed"});
  }

  //Set state for showing all tasks
  onShowAll = () => {
    this.setState({filterBy:"showAll"});
  }


  //Function for Filter tasks
  filterTasks = () =>{
    var newTodos=[]

    //Show all
    if(this.state.filterBy==="showAll"){
      newTodos = [...this.state.todos]
    }
    //Pending tasks
    if(this.state.filterBy==="pending"){
      newTodos = this.state.todos.filter((item) => {
        if(item.marked===false){
          return true;
        }
        return false;
      })
    }
    //Compete Tasks
    if(this.state.filterBy==="completed"){
      newTodos = this.state.todos.filter((item) => {
        if(item.marked===true){
          return true;
        }
        return false;
      })
    }

    console.log(newTodos);

    return newTodos;

  }

  render() {

    return (
      <div className="TodoContainer">
        <h1 className="Header Header-Main">{this.props.title}</h1>
        <div className="inputbar">
          <TodoInput
            taskPlaceholder="Add new Task"
            value={this.state.todo}
            onChange={this.handleOnChange}
          />{' '}
          <button className="button button1" onClick={this.addTask}>Add Task</button>{' '}
          <button className="button button1" onClick={this.onShowAll}>Show all</button>{' '}
          <button className="button button1" onClick={this.onCompleted}>Completed</button>{' '}
          <button className="button button1" onClick={this.onPending}>Pending</button>
        </div>
        <Todolist
          title={this.state.title}
          todos={this.filterTasks()}
          filterBy={this.state.filterBy}
          markTaskAsCompleted={this.markTaskAsCompleted}
          duplicateTask={this.duplicateTask}
          deleteTask = {this.deleteTask}
        />
      </div>
    );
  }
}

export default Todo;
