import "./assets/styles/App.css";
import Header from "./Components/HeaderComponents/Header";
import Logo from "./Components/HeaderComponents/Logo";
import Body from "./Components/Body";

function App() {
  return (
    <div className="App">
      <ul>
        <li>user1</li>
        <li>user2</li>
        <li>user3</li>
        <li>user4</li>
      </ul>
      <Header></Header>
      <header className="App-header">
        <Logo />
        <Body />
      </header>
    </div>
  );
}

export default App;
