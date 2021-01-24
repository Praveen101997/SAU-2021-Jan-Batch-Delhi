import React from "react";
import logo from "./logo.svg";

class Header extends React.Component {
  render() {
    const abc = 123;

    console.log("abc", abc);
    return (
      <div>
        <h1>Header Component</h1>
        <img src={logo} alt={`value of abc ${abc}`} />
        <input defaultValue={abc} onChange={() => {}} />
      </div>
    );
  }
}

export default Header;
