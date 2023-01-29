## What are the common operations you would expect for a dynamic set?
- search
- insert
- delete
- maximum
- minimum
- successor
- predecessor

## What is the principle for a stack?
- first in last out (FILO)

## What are the key operations for a stack? And how are they implemented with an array?
- push
  - increase S.top by 1 and then set S[S.top] to x
  - stack overflow if S.top == n
- pop
  - decrease S.top by 1
  - stack underflow if S.top == 0
- empty
  - check if S.top is 0

## What does S.top stand for?
- S.top
  - the index of the lateset inserted element in the stack S.

## When will you come cross stack underflow and when across stack overflow?
- underflow
  - S is empty and S.pop is called
- overflow
  - S is full and S.push is called

## What are the time complexity measures for the stack operations in big-oh notation?
- push
  - O(1)
- pop
  - O(1)
- empty
  - O(1)

## Pseudocode
PUSH(S, x)
```
if S.top == S.length
    error "stack overflow"
else
    S.top = S.top + 1
    S[S.top] = x
```

POP(S)
```
if S.top == 0
    error "stack underflow"
else
    S.top = S.top - 1
    return S[S.top + 1]
```

STACK-EMPTY(S)
```
if S.top == 0
    return true
else
    return false
```