# multimodule

https://youtu.be/LCltftLZ_W0
| Propagation Type   | Description                                                                                                                              |
| ------------------ | ---------------------------------------------------------------------------------------------------------------------------------------- |
| **REQUIRED**       | **(Default)**. Joins the current transaction if one exists; otherwise, starts a new one.                                                 |
| **REQUIRES\_NEW**  | Suspends the current transaction (if any) and starts a new one.                                                                          |
| **NESTED**         | Runs within a nested transaction if a current one exists; otherwise, behaves like `REQUIRED`. Needs a JDBC savepoint-capable DataSource. |
| **SUPPORTS**       | Runs inside a transaction if one exists; otherwise, runs non-transactionally.                                                            |
| **NOT\_SUPPORTED** | Suspends the current transaction (if any) and runs **non-transactionally**.                                                              |
| **NEVER**          | Throws an exception if a transaction exists; runs only if **no** transaction is active.                                                  |
| **MANDATORY**      | Must run within an existing transaction; throws an exception if none exists.                                                             |
