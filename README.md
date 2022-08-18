# Hardest

1. Subarray sum equals k
2. Subarray product equals K
3. Continuous subarray sum
4. Longest increasing subsequence
5. Longest common subsequence

# Ideas

- Prefix sum
- Quickselect Hoare's selection algorithm
- Union find
- Next permutation algorithm
- Transpose a matrix: Transposition is an operation that flips the matrix over its diagonal
- Rotate image
    - Transpose and Reflect!
- Convert 2D matrix in 1D array
    - There is a formula for converting 2D matrices into 1D arrays and vice versa -- n * m matrix convert to an array
      => `matrix[x][y] => a[x * m + y]`, m = #columns -- an array convert to n * m matrix
      => `a[x] =>matrix[x / m][x % m];`
- Power set algorithm (subsets in leetcode)
- GCD on strings
- Binary search into answer space (balls in boxes problem)
- Binary search between 1 and max of array
- Binary search between max of array and min of array
- Precompute/preprocess and binary search on sorted array
- Two pointers / sliding window
- DFS/BFS
- Tree traversals (in order/pre order/post order)
    - level order
    - in order
    - post order
    - pre order
    - Morris in order tree traversal
- Kadene's algorithm for maximum product
- Kadene's algorithm for maximum sum
- PreSum problems
- Floyd hare and tortoise algorithm - cycle detection
- Backtracking problems
    - sudoku solver
    - word search
    - n queens
    - ...
- All DPs - Reduce problem to other solvable problem + memoization
- Priority queue
- K way merge
- Longest palindromic substring problem methods
- Longest increasing subsequence after deleting at most one number
- Reversing linked lists
- Merge sort on linked lists
- fast/slow pointer problems
- Binary search templates
- Merge technique from mergesort
- Find pivot element technique from quicksort
- Minimum spanning trees
- Topological sort
- Longest common subsequence and maximum length of repeated subarray algorithm
- Convert 2D matrix into 1D array
- Traversing and accessing elements in rotated/circular array
- Bit manipulation techniques
    - XOR to find single number
    - Bitwise right shift to efficiently find the middle in BS
    - https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
    - Powers of 2 : `1 << 0 = 2`,`1 << 1 = 2`,`1 << 2 = 4`
- Boyer-Moore Voting Algorithm
- Rotate array using reverse
- Knuth Morris Pratt for string pattern matching
- Number of structurally unique BST - Catalan number computation
- Idea for removing Nth element from the end of list in one pass. Keep two pointers N nodes apart from each other. Then
  start advancing both of them in parallel
- Construct BT from inorder and preorder traversal
- Wiggle sort
- Counting sort
- Cycle sort?
- Largest number: A simple comparator might be there to save the day!
- Centroids algorithm - MinimumHeightTrees
- Remove k digits !!!
- House robber done the right way. Unfortunately you have to use tabulation to get rid of the extra stack space.
- Tails algorithm for longest increasing subsequence - patience sorting
    - https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
    - https://en.wikipedia.org/wiki/Patience_sorting
- Find first missing positive
    - I do not really get the O(n) solution with the continuous swapping of indexes
    - Ignore negatives
    - Ignore numbers greater than the length of the array
    - swap elements until i=A[i-1]
- Sliding window maximum technique
- You should check the ideas behind ALL hard problems you've solved or tried to solve.
- Skyline problem (!!!!!!!!!!!!!!!!)
- Split Array Largest Sum.... Greedy with BS.... mind - fucking - blowing

## Arrays
This is a list of ideas coming from array problems
- [Find minimum length of unsorted subarray which makes entire array storted if it gets sorted](https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/)
  - Find first pair from start that should be swapped
  - Find first pair from end that should be swapped
  - Find min and max between start and end
  - Find first element between (0,start-1) which is greater than min. This is the new start
  - Find first element between (end+1,n-1) which is smaller than max. This is the new end
- Two sum
  - Create a map of diffs
  - Iterate over the array
  - If the map contains the element then for `r[i], r[i]=target-otherelement => target = otherelement+r[i]`
- 3 sum
  - Sort the array
  - for each index i
    - define `start = i+1`
    - define `end = n-1`
    - evaluate `sum=r[i]+r[start]+r[end]`
    - if `sum=r[i]+r[start]+r[end] == 0` add to result
    - if `sum=r[i]+r[start]+r[end] > 0` we have to make the result smaller so `end--`
    - if `sum=r[i]+r[start]+r[end] < 0` we have to make the result smaller so `start++`
- 4 sum
  - the same process as 3 sum with the only difference that we have two nested for loops in the beginning
- Minimum size subarray
  1. left = 0
  2. right = 0
  3. total = 0
  4. start adding elements from right till total >= target
  5. once total >= 0 start removing elements till total < target
  6. Do 4 and 5 till you're out of elements love
- Find K Pairs with Smallest Sums
  - Define a class Pair(a,b) 
  - Create a priority queue with a comparator based on the sum of the members of the pair
  - Now we have to take into account that the arrays are SORTED!
  - Based on the fact that arrays as sorted we can create all pairs using the first elements from the first array and all elements from the second array
  - This will guarantee that we will be creating the k smaller sums
  - we put all these in the priority queue
  - then we start polling
  - as we are polling we start incrementing the index of the first array and pushing these elements in the queue. Of course,
  only if the index of the first array is smaller than the length of the array. 
  - we stop if we reach k elements in the result
- Container with most water
  - two pointers
  - start = 0, end = n
  - since we are looking for the container with the most water, we want to move the pointer that points to the lowest bar so we 
  increment/decrement the pointer that points to the lowest bar by simultaneously updating the max area
- Merge intervals
  - add to the result all intervals ending before the new interval starts
  - now we will process all intervals intersecting with the current interval
    - the new start is the min of starts of the current newInterval and the interval under process
    - the new end is the max of ends of the current newInterval and the interval under process
    - we do that until there are no intersecting intervals anymore
  - Add the rest of the intervals into the result
    
- 

## Graphs

- Traversals
    - BFS/DFS
- Find paths from s to e
    - using the `edgeTo[x]` table from Sedgewick and Wayne
- Connected components
    - Count connected components
    - Identify if there is a path between two nodes of a graph through comparing their connected component ids
- Bipartite graph / The two colors theorem
- Eulerian paths and circuits (Reconstruct the itinerary leetcode): A trail/path that visits all the vertices of the
  graph exactly once.
- Identify cycles in a graph
- Is a graph strongly connected
- Topological sort
-

## Dynamic Programming

- https://leetcode.com/discuss/general-discussion/1050391/Must-do-Dynamic-programming-Problems-Category-wise
- Coin change
- Perfect squares
- Maximum increasing subsequence
- Decode ways
- Maximal square
- Minimum path sum
- Daily temperatures
- Target sum
- Best time to buy and sell stocks with cooldown
- Partition equals subset sum
- Partition palindromes
- Longest palindromic subsequence
- Different ways to add parentheses

## Recap
- Monotonic stack
- Dynamic programming
- As many array problems/techniques as possible
- The hardest problems section

## Useful formulas

1. Permutations
1. With repetition: a lock where digits can be repeated
2. without repetition: first three people in a race of 10. One cannot be first AND second

2. Combinations
1. with repetition: coins in my pocket
2. without repetition: lottery numbers


3. Arithmetic progression
1. sum `n(a(1) + a(n))/2`
2. nth term = `a(n) = a(1) + (n-1)d` where d is the difference between the terms of the progression and `a(1)` is the
   first term.
3. nth term based on m term = `a(n) = a(m) + (n-m)d`

4. Geometric progression
    1. a(n)=a^r^(n-1)
    2. `(a(1-r^n))/(1-r)`, where a is the first term, n is the number of terms and r is the multiplication factor

4. Travelling salesman => n! time
5.
  
