Illustrate the operation of INSERTION-SORT on the array A = <31, 41, 59, 26, 41, 58>.

|        | 1   | 2    | 3    | 4    | 5    | 6    |
| ------ | --- | ---- | ---- | ---- | ---- | ---- |
| Step 1 | 31  | `41` | 59   | 26   | 41   | 58   |
|        |     | ^    |      |      |      |      |
| Step 2 | 31  | 41   | `59` | 26   | 41   | 58   |
|        |     |      | ^    |      |      |      |
| Step 3 | 31  | 41   | 59   | `26` | 41   | 58   |
|        | ^   |      |      |      |      |      |
| Step 4 | 26  | 31   | 41   | 59   | `41` | 58   |
|        |     |      |      | ^    |      |      |
| Step 5 | 26  | 31   | 41   | 41   | 59   | `58` |
|        |     |      |      |      | ^    |      |
| Result | 26  | 31   | 41   | 41   | 58   | 59   |
