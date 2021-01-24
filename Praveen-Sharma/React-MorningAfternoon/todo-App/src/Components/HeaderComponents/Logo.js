import React from "react";
import logo from "../../assets/images/logo.svg";

const DisplaySum = (props) => {
  const { sum } = props;
  return <div>Sum is: {sum}</div>;
};

const DisplaySumFun = (sum) => {
  return <div>Sum is: {sum}</div>;
};

const Logo = function () {
  const name = "Some Name";

  const sum = 20;

  return (
    <div>
      <img src={logo} className="App-logo" alt="logo" />
      <span>{name}</span>
      {sum === 20 ? DisplaySumFun(sum) : null}
      <DisplaySum sum={sum} />
    </div>
  );
};

export default Logo;
