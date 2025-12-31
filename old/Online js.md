Coding question 1- https://leetcode.com/problems/add-two-promises/


Coding question  2 - https://docs.google.com/document/d/1kfpA2N-ruERA728ANG6lZe7Obp5dgJflAUqjg0nDpUg/edit


import { useEffect, useState } from "react";
import "./styles.css";


export default function App() {
const [state, setState] = useState([]);
useEffect(() => {
let arr = [];
fetch(
"https://api.thecatapi.com/v1/images/search?limit=5&page=10&order=Desc"
)
.then((res) => res.json())
.then((data) => {
data.forEach((e) => {
arr.push(e.url);
});
});
setState(arr);
console.log(state);
}, []);


return (
<div className="App">
{
state
}
<h1>Hello CodeSandbox</h1>
<h2>Start editing to see some magic happen!</h2>
</div>
);
}







<div id='1'> 
	<div id='2'>
		<div id='3' style=”display: inline-block; float: center”> 
		</div>
	</div>
</div>



Promise
Join two promise
inheritance in js
prototype in js
Css functions
flex

