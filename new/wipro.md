React

Propsdrilling
the process of passing data down through multiple levels of nested components via props

contextAPI
// SampleContext.js
import React, { createContext} from 'react'; 

const SampleContext = createContext();
export default SampleContext;

// App.js
import React, { useState } from "react";
import SampleContext from "./SampleContext";

const App = () => {
  const [data, setData] = useState("test");

  return (
    <SampleContext.Provider value={{ data }}>
      	<Page />
    </SampleContext.Provider>
  );
};
export default App;

// Page.js
import React from "react";
import SampleContext from "./SampleContext";

const Page = () => {
  const { data } = React.useContext(SampleContext);

  return (
    <div>
      <h2>Data: {data}</h2>
    </div>
  );
};

export default Page;


splitting context
Splitting context means creating multiple smaller contexts instead of one big context that holds a lot of unrelated data.
Why - any time a context value changes, all components consuming that context will re-render — even if they only care about a small piece of the context.


Component Composition - It’s all about building UI from smaller, reusable pieces
Basic const Card = ({ children }) => {
  return <div className="card">{children}</div>;
};

const App = () => (
  <Card>
    <h2>Hello!</h2>
    <p>This is inside a reusable Card.</p>
  </Card>
);


With props const Dialog = ({ title, message }) => (
  <div className="dialog">
    <h3>{title}</h3>
    <p>{message}</p>
  </div>
);

const WelcomeDialog = () => (
  <Dialog title="Welcome" message="Thanks for visiting!" />
);


HOC - Its is basically a function which returns a component

a HOC is indeed a function that accepts another function (which is a component in React) as one of its arguments.
the HOC, after processing the input component, returns a new function, and this new function is the enhanced component.

Js example:

function HOC(passedFunction) {
  return function(…args) {
    console.log(`args:`, args);
    return passedFunction(...args);
  };
}

Here you can see HOC is a function to which we are passing another function.
Then how arguments are passed


Once you declare HOC in above format to a variable.
function Page(age) {
  return `My age is ${age}.`;
}

const ReusedComponent = HOC(Page);

Think that variable becomes like
function ReusedComponent(…args){
    console.log(`args:`, …args);
    return passedFunction(...args);
} 

Eg:
//HOC.js

const HOC = (WrappedComponent) =>{
	return (props) => {
		<WrappedComponent {…props} newProp="hello" />
	}
}

const Page = (props) ={
	return (<div> {props.extraProps}, {props.name} </div>);
}

const App = () =>{
	const EnhancedComponent = HOC(Page)
	return (<EnhancedComponent name={'test'}/> )
}

Here HOC is reused… u can page some other component like page to HOC again





Java

SAM interface - Single Abstract method

Why Hashmap is not ordered - The key is hashed for fast operation.. based on that hash value it is stored in different buckets... so it ordered can not be preserved

Pattern matching in switch Before:
static double getDoubleUsingIf(Object o) {
    double result;
    if (o instanceof Integer) {
        result = ((Integer) o).doubleValue();
    }
return result;
}

Now:
static double getDoubleUsingSwitch(Object o) {
    return switch (o) {
        case Integer i -> i.doubleValue();
	      default -> 0d;
    };
}

Guarded matching in switch => Pattern with when
static double getDoubleValueUsingGuardedPatterns(Object o) {
    return switch (o) {
        case String s when s.length() > 0 -> Double.parseDouble(s);
        default -> 0d;
    };
}