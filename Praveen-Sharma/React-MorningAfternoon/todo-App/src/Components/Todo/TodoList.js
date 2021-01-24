import React from "react";
import PropTypes from "prop-types";
import 'bootstrap/dist/css/bootstrap.min.css';
import "./styles.css";

class Todolist extends React.Component {
  static propTypes = {
    todos: PropTypes.arrayOf(
      PropTypes.shape({
        todo: PropTypes.string,
        marked: PropTypes.bool,
      })
    ),
  };

  todos;


  filterTasks = () =>{
    // todostodos
    if(this.filterBy==="showAll"){
      this.todos = [...this.props.todos]
    }
    if(this.filterBy==="pending"){
      this.todos = this.props.todos.filter((item) => {
        if(item.marked===false){
          return true;
        }
        return false;
      })
    }
    if(this.filterBy==="completed"){
      this.todos = this.props.todos.filter((item) => {
        if(item.marked===true){
          return true;
        }
        return false;
      })
    }

    return this.todos;

  }

  render() {
    const { todos, markTaskAsCompleted,duplicateTask,deleteTask } = this.props;

    return (
      <div>
        <ul className="w3-ul" style={{ listStyle: "none", padding: 0, margin: 0 }}>
          {todos
            ? todos.map((value, index) => {
                return (
                  <li key={index} className="TaskRow hover-blue">
                    <label
                      style={
                        value.marked
                          ? {
                              textDecoration: "line-through",
                            }
                          : {}
                      }
                      className={value.marked ? "checked" : ""}
                    >
                      <input
                        type="checkbox"
                        checked={value.marked}
                        onChange={(event) => markTaskAsCompleted(event, index)}
                      />{' '}
                      {value.todo}
                    </label>

                    <button className="hidden button button2" onClick={() => deleteTask(index)}>Delete</button>
                    <button className="hidden button button3" onClick={() => duplicateTask(index)}>Duplicate</button>
                  </li>
                );
              })
            : null}
        </ul>
      </div>
    );
  }
}

// const Todolist = (props) => {
//     const { todos, title } = props;

//     return (
//       <div>
//         <h3>{title}</h3>
//         <ul>
//           {todos
//             ? todos.map((todo, index) => {
//                 return <li>{todo}</li>;
//               })
//             : null}
//         </ul>
//       </div>
//     );
// }

export default Todolist;
