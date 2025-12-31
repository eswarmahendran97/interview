Photon

Propagation → Propagation defines how a method with a transactional context behaves when it is called inside another transaction.

REQUIRED: If a transaction exists, join it; else, create a new one.
REQUIRES_NEW: Always start a new transaction, suspending the current one.
SUPPORTS: Join existing transaction if available, else run non-transactional(without transaction context).
MANDATORY: Must run inside an existing transaction. If none exists → exception.
NOT_SUPPORTED: Suspend existing transaction, run non-transactionally.

Isolation → Isolation defines how concurrent transactions interact with each other’s data.
we have levels — from weakest (least isolation) to strongest (most isolation). If level is more consistency is more
READ_UNCOMMITTED: You can read uncommitted (dirty) data from another transaction.
READ_COMMITTED: You can only read data that has been committed.
REPEATABLE_READ: Once you read a row, no one else can change it until your transaction ends.
SERIALIZABLE: Transactions are executed one after another (like a queue).

Java
Given a set of distinct integers, find all possible subsets (the power set).
   Sample Input: {1, 2, 3}
   Sample Output: Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

React:
Dark and Light mode using context api