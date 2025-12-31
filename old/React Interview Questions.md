React Inerview Questions
NPM Start : 
Add webpack config files
Updates package.json ( since webpack config files are added)
Check scripts : {} in package.json. It contains start. This will call start.js
start.js will start the webpack-dev-server
webpack-dev-server finds index.js then starts the application.

1) Features of React
JSX
Virtual DOM
One way Binding
Server Side Rendering

2)JSX
JSX - JavaScript XML
Advantage - XML/HTML-like text can co-exist with JavaScript/React code
Working:
class JSXDemo extends React.Component {
  render() {
    const jsx = <h1 id="jsx">This is JSX</h1>;
    console.log(jsx);
    return jsx;
  }
}
Above is a react JSX code. Browser will not understand this code so... Bable is used to convert JSX
Bable converts it into 
React.createElement("h1", { id: "jsx" }, "This is JSX");
Then React.createElement call takes place
{ 
  type: 'h1', 
  props: { 
   id: 'jsx',
   children: 'This is JSX'
  } 
}
Which gets transformed into object. Then used by browser engine as
<h1 id="jsx">This is JSX</h1>

3)Event
An event is an action that a user or system may trigger, such as pressing a key, a mouse click, etc.

4)Server Side Redering
Server-side rendering (SSR) is when content on your webpage is rendered on the server and not on your browser using JavaScript. Server Side rendering is Static UI
React uses both server side and client side redering
Here, the initial render is on the server. Hence, the HTML received by the browser has the UI as it should be. Once the scripts are loaded, the virtual DOM is re-rendered once again to set up your components' event handlers.

5)Component
Components are the building blocks of a React application’s UI. These components split up the entire UI into small independent and reusable pieces. Then it renders each of these components independent of each other without affecting the rest of the UI.

6)Component LifeCycle
Each component in React has a lifecycle which you can monitor and manipulate during its three main phases.
The three phases are: Mounting, Updating, and Unmounting.

7)Mounting
constructor()
getDerivedStateFromProps()
render() - required one, other methods are optional
componentDidMount()

8)Updating
getDerivedStateFromProps()
shouldComponentUpdate()
render()
getSnapshotBeforeUpdate()
componentDidUpdate()

9)Unmounting
componentWillUnmount()

10)render()
Outputs the HTML to DOM

11)React Vs React Native
Major - React native have no CSS and HTML

12)Types of Component
Class Component - statefull
Functional Component - stateless

13) Props
Props provide a way to pass data from one component to another component.
immutable

14)State
The state is a built-in React object that is used to contain data or information about the component

15) Function vs Class
First of all, the clear difference is the syntax. Just like in their names, a functional component is just a plain JavaScript function that returns JSX. A class component is a JavaScript class that extends React.Component which has a render method.
A functional component is written shorter and simpler, which makes it easier to develop, understand, and test.
React team is supporting more React hooks for functional components 

16) Higher Order Components
Hoc takes component as a argument and returns new component
const newComponent = higherOrderComponent(originalComponent)
HOC is an advanced technique for reusing component logic. Higher order component function accepts another function as an argument. 
We can set logic as props and can send to parent... this can be used between all child. But if we need same logic in child of diff parent means?
So we use hoc.

17) Why setState()
Every components has its own state, it should be updated only by setState()

18) Pure Component
Pure Components in React are the components which do not re-renders when the value of state and props has been updated with the same values. If the value of the previous state or props and the new state or props is the same, the component is not re-rendered. Pure Components restricts the re-rendering ensuring the higher performance of the Component

19) When will React component Re-Renders
“setState” is called in Component
“props” values are updated
this.forceUpdate() is called

20) Shallow Comparison ? or why spread operator is used ?
If two objects with same value compared it returns false since js compares the reference.
var userInfo = {
  name: "Mayank Gupta",
  age: 30,
}
var Clone = {
  name: "Mayank Gupta",
  age: 30,
}
var isEqual = (finalData == initialData); // value:false
 If we copied one object to another and then if we compare it returns true 
var userInfo = {
  name: "Mayank Gupta",
  age: 30,
}
var Clone = userInfo
var isEqual = (finalData == initialData); // value:true
But when we modifies a object value and then if we check again it return true beacuse reference is same.
var userInfo = {
  name: "Mayank Gupta",
  age: 30,
}
var Clone = userInfo
clone.age = 31
var isEqual = (finalData == initialData); // value:true
So correct way is copy the object into a new object - we can use spread operator for it
var userInfo = {
  name: "Mayank Gupta",
  age: 30,
}
var Clone = { ...userInfo}
clone.age = 31
var isEqual = (finalData == initialData); // value:false

21) Why component name starts with Capital letter?
JSX considers tags with lower case as HTML

22)Fragments
<React.Fragment>  
      <ChildA />  
      <ChildB />  
      <ChildC />  
    </React.Fragment>  
<React.Fragment> is avoids adding extra node like <div> for closing. Fragment is faster than other tags

23) Conditional Rendering
Rendering based on condition

24) Prop Drilling
 Passing of data from parent to childerns of them

25) Context API
To alternate prop drilling we use context api

26)Hooks
Basic Hooks
useState
useEffect
useContext
Additional Hooks
useReducer
useCallback
useMemo
useRef
useImperativeHandle
useLayoutEffect
useDebugValue

27) Custom Hook
To avoid repetitive logics we use HOC.. But in Functional component we cannot use hoc. So we go for custome hooks

28) UseEffect
In class component,
 componentDidMount() - invokes after initial render , 
componentDidUpdate() - invokes after update render.
componentWillUnmount() - invokes when component removed from DOM to clean up before executing next time
 useEffect() - invokes at both initial update render and when component removed from DOM 

29) UseMemo and UseCallback
const memoizedValue = useMemo(() => computeExpensiveValue(a, b), [a, b]);
useMemo will only recompute the memoized value when one of the dependencies has changed. This optimization helps to avoid expensive calculations on every render.
UseCallBack is same as UseMemo.

30) React Router
It is used to route between different pages used in our application

31) Does React router affect Single page application
Routing in React does not involve replacing the HTML, CSS or JavaScript resources currently being served or reloading the browser content. Instead, using libraries like react-router allows containers to be swapped in and out dynamically based on the current URL location, and this all happens client-side.

32) Types of Router
Memory Router - keeps url change in memory and does not affect url address bar(used in react-native)
Browser Rpouter - Affects URL change in url address bar. (have adv of pushing states to the url)
Hash Router -  Hash router uses client-side hash routing. It uses the hash portion of the URL (i.e. window.location.hash) to keep your UI in sync with the URL. It doesn’t need any configuration in the server to handle routes.(not recommended)

33) Basic tags
<Route>, <Switch> and <Link>

34) <Route>
Route to the component which need to be rendered

35) <Switch>
Helps to swap between the component present in the container

36)<Link>
Clicking on the <Link> will “navigate” to different component

37) Passing State in router
We can pass state in route to use it in different component

38)Prevent Rerender in child
use shouldComponentUpdate() in child to avoid re-rendering
shouldComponentUpdate() {
   console.log("Does not get rendered");
   return false;
 }

39) Controlled and UnControlled ELements
UnControlled - Value is Controlled by browser dom eg: Input field
Controlled - Vlaue controlled by React itself eg:setState()

40) Redux
Redux is a predictable state container for JavaScript apps.

41) Redux Core Components
Store - Holds the state
Action - The Change which is need to be updated in store
Reducer - Carries out change in state depending on the Action

42) How state is updated in Redux
Js Application --(dispacth/emit)--> Action --(handle the action)-->Reducer-->Store
