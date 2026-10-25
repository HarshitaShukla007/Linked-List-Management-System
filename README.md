# Linked List Management System

## Project Overview & Objective
This project is a console-based Data Structures and Algorithms (DSA) application developed in Java for practicing and demonstrating linear data structures[cite: 1]. It features custom implementations of both **Singly Linked Lists** and **Doubly Linked Lists**, built using pure Java object references, class constructors, and automatic garbage collection without relying on built-in Java collection libraries (`java.util.LinkedList`)[cite: 1, 6].

The primary objective is to provide an interactive, menu-driven command-line interface via `Scanner` for performing operations, testing memory pointers, verifying asymptotic edge cases, and comparing performance trade-offs[cite: 1, 4, 6].

## Key Features

### 1. Singly Linked List Implementation
* **Insertion**: At beginning $\mathcal{O}(1)$, end $\mathcal{O}(n)$, specified 1-based position, after a target node value, and before a target node value[cite: 2, 4].
* **Deletion**: From beginning $\mathcal{O}(1)$, end $\mathcal{O}(n)$, specified 1-based position, and by matching node value[cite: 2, 4].
* **Search & Update**: Linear search by value returning position, and value updating[cite: 2].
* **Traversals & Analytics**: Display list, count node length, compute maximum and minimum values, and find the middle element using slow and fast pointer references[cite: 2].
* **Advanced Operations**: In-place link reversal in $\mathcal{O}(1)$ auxiliary space, ascending Bubble Sort via node data swapping, and duplicate node elimination[cite: 2, 4].

### 2. Doubly Linked List Implementation
* **Bi-Directional Traversal**: Forward display via `next` links and backward display via `prev` and `tail` references[cite: 3].
* **Optimized End Operations**: $\mathcal{O}(1)$ insertion and deletion at the end using a dedicated `tail` reference[cite: 3, 4].
* **Structural Manipulations**: Double-link rewiring for middle insertions, deletions by position or value, in-place reference reversal, sorting, and duplicate removal[cite: 3].

### 3. Built-In Structural Comparison
* Direct terminal view comparing Singly vs. Doubly Linked Lists across reference overhead per node, traversal capabilities, time complexities, and memory usage[cite: 1, 4].
