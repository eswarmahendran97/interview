Optum

When to use query param and when to use path param
Path:
    Typically part of the "hierarchy" of the resource.
    eg: /products/{category}/{product_id}
Query:
    Query parameters are used to modify, filter, sort, or paginate
    eg: /products?category=electronics


Springboot vs spring webflux which has less througput

Spring MVC (Servlet) → Higher throughput for CPU-bound workloads.
Spring WebFlux → Higher throughput for I/O-bound workloads (especially when concurrency is high, like 10k+ requests).


redux:
#Redux configuration

##install:
npm install @reduxjs/toolkit react-redux


##create a slice
using slice we will map reducer with action.

slice contains

name: 'sliceName',
initialState,
reducers: {
    sampleAction: (state) => { // state of this reducer
			state.sample.loading = true;
			state.sample.error = null;
	},
}
you can export this reducer. while configuring the store you need to give reducer, there you can use it.

we also create selector: selector is a function that takes the Redux state as an argument and returns data from that state
sampleSelector = (state) => state.sample

create a store
const store = () => {
	const store = configureStore({
		reducer: rootReducer,
	});
	return store;
};


pass the store to you Component using provider. why? it makes the store available to all components using React’s context API else component will not know the store
<Provider store={store}>{children}</Provider>;


we can dispatch action in Component
dispatch(sampleAction())
dispatch → store sends action → root reducer → slice reducer → exact reducer function → new state → UI re-renders

we can get the selector from that
useSelector(sampleAction())

how its called automatically?
Store saves new state + notifies subscribers
Store replaces the old state with the new state on dispatch call
Components using useSelector see the updated state.

we can also configure saga as middleware