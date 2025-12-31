Algorithm in reconciliation
    Diffing
        Compares Virtual Dom with Previous Dom
            If Elemnent type differs → replace subtree.
            If type is same → recurse on children. (if className chnages, it will only update it. it will not remove the element)
            When comparing lists, React use key to efficiently handle lists

React fiber
Fiber is the engine — it controls the rendering and scheduling of work.
Inside Fiber’s reconciliation phase, React runs the diffing algorithm to decide which parts of the UI changed.


When does render happen, what will happen after that?
when any change in state or props changes, rerender will get triggered
Trigger -> Fiber reconciliation phase (uses diffing) -> commit phase


How fiber helps?

Before React 16 -> React’s rendering was synchronous. once rendering started, it would block the main thread until completion.

fiber has
    Interruptible Rendering
    Prioritized Updates
    Incremental Rendering
    Error Recovery
    concurrent mode - concurrent rendering, suspense

Side effects
A side effect is anything that interacts/changes something outside the component’s render scope.
Eg:
fetch call
localStorage
intervals
eventlisteners

Pure function
A pure function is one that:
Always returns the same output for the same input.
Does not cause any side effects


How state is preserved on rerendered
React preserves state by storing it outside your component function (in the Fiber tree)

Share data between tabs or windows
LocalStorage, BroadcastChannel, IndexedDB

IndexedDB
large, structured, async

When to use Web workers
Web Workers are background threads in the browser. Ideal for heavy computations

Rendering thousands of rows in a table
Pagination
Infinite Scrolling


Ui optimization
Optimize Images
SSR


Hydration
Hydration is the process where React “attaches” its internal event handlers and state to the HTML

Error boundries
ErrorBoundary component wrapper  -> componentDidCatch

important headers

event Listeners


coding
redux setup
context api
call an api(json place holder) and render a list
eventListner on user click
HOC
useCallback
useMemo
setState compare with previous
promises
