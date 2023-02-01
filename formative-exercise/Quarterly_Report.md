# Quarterly Sales for Each Department

Assuming that the sales records of each department are stored in an array of 12 elements representing the sale number from January to December, each department's quarterly sales equals the sum of the monthly sales within the range. This is an *O(1)* operation, as the array size is fixed to 12, and the relation between a quarter and the corresponding months will not change. The concept can be written as the following pseudocode, with `DMS` and `DQS` denoting the monthly and quarterly sales array of a department, respectively.

**QUARTERLY-SALES-PER-DEPARTMENT(DMS)**
```
DQS[1] = DMS[1] + DMS[2] + DMS[3]
DQS[2] = DMS[4] + DMS[5] + DMS[6]
DQS[3] = DMS[7] + DMS[8] + DMS[9]
DQS[4] = DMS[10] + DMS[11] + DMS[12]

return DQS
```

To derive the quarterly sales numbers of all departments, the above operation has to be repeated in each department, which is an *O(n)* operation if there are n departments in the company. The corresponding pseudocode is addressed below, with `MS` and `QS` being two-dimensional arrays representing the monthly and quarterly sales of all departments.

**QUARTERLY-SALES(MS)**
```
for q = 1 to MS.length
    QS[q] = QUARTERLY-SALES-PER-DEPARTMENT(MS[q])

return QS
```

<div style="page-break-after: always;"></div>

# Quarterly Best and Worst Departments

With the quarterly sales data, the best-performing department per quarter can be determined by selecting the maximum inter-departmental sales number for each quarter. The pseudocode below demonstrates the idea, with `MAX_V` representing the array of the highest quarterly sales among all departments and `MAX_I` being the array of the corresponding department indices.

**QUARTERLY-BEST(QS)**
```
for q = 1 to 4
    MAX_V[q] = -∞
    MAX_I[q] = 0
    for d = 1 to QS.length
        if QS[d][q] > MAX_V[q]
            MAX_V[q] = QS[d][q]
            MAX_I[q] = d

return MAX_V, MAX_I
```

Similarly, the worst-performing department per quarter can be addressed with the following logic, where `MIN_V` and `MIN_I` are arrays indicating each quarter's lowest sales of all departments and the index of that department.

**QUARTERLY-WORST(QS)**
```
for q = 1 to 4
    MIN_V[q] = ∞
    MIN_I[q] = 0
    for d = 1 to QS.length
        if QS[d][q] < MIN_V[q]
            MIN_V[q] = QS[d][q]
            MIN_I[q] = d

return MIN_V, MIN_I
```

Although the pseudocode of **QUARTERLY-BEST** and **QUARTERLY-WORST** contain nested loops, time complexity depends on the number of departments only since the number of quarters is fixed to 4 within a year. In other words, the two functions are *O(n)* operations.

<div style="page-break-after: always;"></div>

# Quarterly Total Tax

The amount of tax to pay per quarter equals the total sales per quarter multiplied by the tax rate, which requires iterating over the whole two-dimensional array `QS`. However, it is still an *O(n)* operation since the number of quarters is a constant in our case. The pseudocode shows the algorithm, with `QTT` being the tax array containing the amount of tax the company should pay each quarter.

**QUARTERLY-TOTAL-TAX(QS)**
```
tax_rate = 0.17

for q = 1 to 4
    total = 0
    for d = 1 to QS.length
        total = total + QS[d][q]
    QTT[q] = total * tax_rate

return QTT
```